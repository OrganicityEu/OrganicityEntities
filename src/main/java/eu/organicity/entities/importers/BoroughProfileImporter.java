package eu.organicity.entities.importers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TreeSet;

import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.namespace.OrganicityAttributeTypes.Types;

public class BoroughProfileImporter {

	public static void main(String[] args) throws IOException {

		if (args.length < 1){
			System.err.println("Error: insufficient argument count!");
			System.err.println("Usage: BoroughProfileImporter jsonInputFilename");
			System.exit(1);
		}
		
		String jsonInputFilename = args[0];
		
		FeatureCollection featureCollection = 
			    new ObjectMapper().readValue(new FileInputStream(jsonInputFilename), FeatureCollection.class);
				
		for(Feature feature : featureCollection.getFeatures()){
		
			BoroughProfile boroughProfile = new BoroughProfile(feature.getId());

			// Adding Area-GeoJson
			boroughProfile.setArea(feature.getGeometry().toString());

			// Adding Origin
			Origin origin = new Origin("http://organicity.eu/cities/london/");
			boroughProfile.addAttribute(origin);

			// Adding last update
			boroughProfile.setTimestamp(new Date());

			
			// FIXME: Loop through attributes
			Map<String,Object> attributes = (Map<String,Object>)feature.getProperties().get("attributes");
			for(String attributeKey : attributes.keySet()){
				Map<String,Object> attribute = (Map<String,Object>)attributes.get(attributeKey);
				
				Map<String,String> attributeAttributes = (Map<String,String>)attribute.get("attributes");
				Map<String,Double> attributeValues = (Map<String,Double>)attribute.get("values");
				
				// Find the latest timed value
				TreeSet<String> valueTimes = new TreeSet<String>(attributeValues.keySet());
				String latestTime = valueTimes.last();
				
				// Adding classic attributes
				Attribute a = new Attribute(Types.getAttibuteType(attributeAttributes.get("urn")), String.valueOf(attributeValues.get(latestTime)));
				Metadata m = new Metadata("TimeInstant", "ISO8601",latestTime);
				a.addMetadata(m);        
				boroughProfile.addAttribute(a);
			}

			// FIXME: Add POST call

			System.out.println(boroughProfile.toString());

			System.out.println(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(boroughProfile.getContextElement()));

		}
	}
}
