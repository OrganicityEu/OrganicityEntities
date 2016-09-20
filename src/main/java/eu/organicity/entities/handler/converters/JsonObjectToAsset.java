package eu.organicity.entities.handler.converters;


import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.json.JSONObject;

/**
 * Created by etheodor on 09/08/2016.
 */
public class JsonObjectToAsset {
    public static OrganicityEntity jsonToAsset(JSONObject a) {
        OrganicityEntity assetObject = new OrganicityEntity();
        assetObject.setId(a.get("id").toString());
        assetObject.setEntityType(a.get("type").toString());

        for (String attribute : a.keySet()) {
            if (attribute.equals("id")) {
                continue;
            } else   if (attribute.equals("type")) {
                continue;
            } else {

                JSONObject o = a.getJSONObject(attribute);
                String type = o.get("type").toString();
                String value = o.get("value").toString();
                Attribute att = new Attribute(OrganicityAttributeTypes.Types.getAttibuteType(type), value);
                assetObject.addAttribute(att);
            }


        }
        return assetObject;

    }


}
