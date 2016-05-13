package eu.organicity.entities.importers;

import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by bsigurbjornsson on 13/05/2016.
 */
public abstract class GeoJsonImporter implements OrganicityEntityImporter {



    public List<OrganicityEntity> process(String jsonInputFilename) throws IOException {
        FeatureCollection featureCollection =
                new ObjectMapper().readValue(new FileInputStream(jsonInputFilename), FeatureCollection.class);
        List<OrganicityEntity> profiles = new ArrayList<>();
        for (Feature feature : featureCollection.getFeatures()) {
            String id = feature.getProperties().get("id").toString();
            isNull(id);
            OrganicityEntity boroughProfile = initialiseEntity(id);

            // Adding Area-GeoJson
            isNull(feature.getGeometry());
            String area = feature.getGeometry().toString();


            //area = compress(area);
            boroughProfile.setArea(area);

            // FIXME: Add a borough name to the boroughProfile object
            // name can be found in feature.getProperties().get("name").toString();

            // FIXME: Add centroid to the boroughProfile object ... the lat/long can be found in
            // latitude can be found in feature.getProperties().get("latitude");
            // longitude can be found in feature.getProperties().get("longitude");
            boroughProfile.setPosition(Double.parseDouble(feature.getProperties().get("latitude").toString()), Double.parseDouble(feature.getProperties().get("longitude").toString()) );

            // Adding Origin
            Origin origin = new Origin("http://organicity.eu/cities/london/");
            boroughProfile.addAttribute(origin);

            // Adding last update
            boroughProfile.setTimestamp(new Date());

            Map<String, Object> attributes = (Map<String, Object>) feature.getProperties().get("attributes");
            for (String attributeKey : attributes.keySet()) {
                Map<String, Object> attribute = (Map<String, Object>) attributes.get(attributeKey);
                Map<String, String> attributeAttributes = (Map<String, String>) attribute.get("attributes");
                Map<String, Double> attributeValues = (Map<String, Double>) attribute.get("values");

                // Find the latest timed value
                TreeSet<String> valueTimes = new TreeSet<String>(attributeValues.keySet());
                String latestTime = valueTimes.last();

                // Adding classic attributes
                Attribute a = new Attribute(OrganicityAttributeTypes.Types.getAttibuteType(attributeAttributes.get("urn")), String.valueOf(attributeValues.get(latestTime)));
                Metadata m = new Metadata("TimeInstant", "ISO8601", latestTime);
                a.addMetadata(m);
                boroughProfile.addAttribute(a);
            }
            profiles.add(boroughProfile);
        }
        return profiles;
    }

    static void isNull(Object x) {
        if (x == null)
            throw new NullPointerException();
    }
}
