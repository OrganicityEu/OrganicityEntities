package eu.organicity.entities.importers;

import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.organicity.entities.handler.attributes.Attribute;
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
            String label = feature.getProperties().get("label").toString();
            isNull(label);
            OrganicityEntity entity = initialiseEntity(label);

            // Adding Area-GeoJson
            isNull(feature.getGeometry());
            String area = feature.getGeometry().toString();


            //area = compress(area);
            entity.setArea(area);

            // FIXME: Add a borough name to the boroughProfile object
            // name can be found in feature.getProperties().get("name").toString();

            // Add centroid to the entity object
            entity.setPosition(
                    Double.parseDouble(feature.getProperties().get("latitude").toString()),
                    Double.parseDouble(feature.getProperties().get("longitude").toString()) );

            // Adding Origin
            entity.addAttribute(getOrigin());

            // Adding last update
            entity.setTimestamp(new Date());

            Map<String, Object> attributes = (Map<String, Object>) feature.getProperties().get("attributes");
            for (String attributeUrn : attributes.keySet()) {
                Map<String, Object> attributeData = (Map<String, Object>) attributes.get(attributeUrn);
                Map<String, Object> attributeValue = (Map<String,Object>) attributeData.get("values");

                String latestTime = (String)attributeValue.get("timestamp");
                Object latestValue = attributeValue.get("value");


                    // Adding classic attributes
                    Attribute a = new Attribute(
                            OrganicityAttributeTypes.Types.getAttibuteType(attributeUrn),
                            String.valueOf(latestValue));
                    Metadata m = new Metadata("TimeInstant", "ISO8601", latestTime);
                    a.addMetadata(m);
                    entity.addAttribute(a);
            }
            profiles.add(entity);
        }
        return profiles;
    }

    static void isNull(Object x) {
        if (x == null)
            throw new NullPointerException();
    }
}
