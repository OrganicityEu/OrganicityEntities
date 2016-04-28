package eu.organicity.entities.importers;


import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.namespace.OrganicityAttributeTypes.Types;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class BoroughProfileImporter {

    public static List<BoroughProfile> process(String jsonInputFilename) throws IOException {
        FeatureCollection featureCollection =
                new ObjectMapper().readValue(new FileInputStream(jsonInputFilename), FeatureCollection.class);
        List<BoroughProfile> profiles = new ArrayList<>();
        for (Feature feature : featureCollection.getFeatures()) {
            String id = feature.getProperties().get("id").toString();
            isNull(id);
            BoroughProfile boroughProfile = new BoroughProfile(id);

            // Adding Area-GeoJson
            isNull(feature.getGeometry());
            String area = feature.getGeometry().toString();

            //area = compress(area);
            boroughProfile.setArea(area);

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
                Attribute a = new Attribute(Types.getAttibuteType(attributeAttributes.get("urn")), String.valueOf(attributeValues.get(latestTime)));
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
