package eu.organicity.entities.handler.converters;

import com.amaxilatis.orion.model.Attribute;
import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import org.json.JSONObject;

/**
 * Created by etheodor on 09/08/2016.
 */
public class AssetToJsonObject {
    public static JSONObject entityToJsonObject(OrganicityEntity a) {
        JSONObject assetObject = new JSONObject();
        assetObject.put("id", a.getId());
        assetObject.put("type", a.getEntityType().toString());
        for (Attribute attribute : a.getAttributes()) {
            JSONObject attributeObject = new JSONObject();
            attributeObject.put("value", attribute.getValue());
            attributeObject.put("type", attribute.getType());
            JSONObject metadata = new JSONObject();
            if (attribute.getMetadatas() != null) {
                for (Metadata m : attribute.getMetadatas()) {
                    JSONObject metadataObject = new JSONObject();
                    metadataObject.put("value", m.getValue());
                    metadataObject.put("type", m.getType());
                    metadata.put(m.getName(), metadataObject);
                }
                attributeObject.put("metadata", metadata);
            }
            assetObject.put(attribute.getName(), attributeObject);

        }
        return assetObject;
    }


}
