package eu.organicity.entities.handler.converters;

import com.amaxilatis.orion.model.Attribute;
import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import org.geojson.GeoJsonObject;
import org.geojson.LngLatAlt;
import org.geojson.MultiPolygon;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by etheodor on 09/08/2016.
 */
public class AssetToJsonObject {
    public static JSONObject entityToJsonObject(OrganicityEntity a) {
        JSONObject assetObject = new JSONObject();
        assetObject.put("id", a.getId());
        assetObject.put("type", a.getEntityType().getUrn().toString());
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
        if (a.getLatitude() != null && a.getLongitude() != null) {
            JSONObject attributeObject = new JSONObject();
            attributeObject.put("value", a.getLongitude() + "," + a.getLatitude());
            attributeObject.put("type", "geo:point");
            assetObject.put("location", attributeObject);
        }

        if (a.getAreaObject() != null) {
            GeoJsonObject geoJson = a.getAreaObject();
            if (geoJson instanceof MultiPolygon) {
                JSONObject attributeObject = new JSONObject();
                LngLatAlt p = null;
                List<LngLatAlt> points = new ArrayList<>();
                for (Object c : ((MultiPolygon) geoJson).getCoordinates().get(0).get(0).toArray()) {
                    LngLatAlt l = (LngLatAlt) c;
                    if (p != null) {
                        if (p.getLongitude() == ((LngLatAlt) c).getLongitude() && p.getLatitude() == ((LngLatAlt) c).getLatitude()) {
                            //System.out.println("\t"+l.toString());
                            continue;
                        }
                    }
                    //System.out.println(l.toString());
                    points.add(l);
                    p = l;
                }
                List<List<LngLatAlt>> polygons = polygonToComponentPolygon(points);
                JSONArray multipolygon = new JSONArray();
                for (List<LngLatAlt> poly : polygons) {
                    JSONArray coordPackaging = new JSONArray();
                    JSONArray coords = new JSONArray();
                    for (LngLatAlt point : poly) {
                        JSONArray coord = new JSONArray();
                        coord.put(point.getLongitude());
                        coord.put(point.getLatitude());
                        coords.put(coord);
                    }
                    coordPackaging.put(coords);
                    multipolygon.put(coordPackaging);
                }
                JSONObject multiPolygon = new JSONObject();
                multiPolygon.put("type", "MultiPolygon");
                multiPolygon.put("coordinates", multipolygon);
                attributeObject.put("value", multiPolygon);
                attributeObject.put("type", "oc:geo:json");
                assetObject.put("geometry", attributeObject);
            }
        }
        return assetObject;
    }


    public static List<List<LngLatAlt>> polygonToComponentPolygon(List<LngLatAlt> polygon) {
        List<List<LngLatAlt>> polygons = new ArrayList<>();
        HashMap<String, String> memory = new HashMap<>();
        Stack<LngLatAlt> stack = new Stack<>();
        for (LngLatAlt point : polygon) {
            if (memory.get(point.toString()) == null) {
                stack.push(point);
                memory.put(point.toString(), "1");
            } else {
                if (stack.peek().toString().equals(point.toString())) { //consecutive points ignore the new one
                    continue;
                } else {
                    List<LngLatAlt> newRing = new ArrayList<>();
                    newRing.add(point);
                    while (stack.peek().toString().equals(point.toString()) == false) {
                        LngLatAlt point2 = stack.pop();
                        newRing.add(point2);
                        memory.remove(point2.toString());
                    }
                    if (stack.peek() != null)
                        newRing.add(stack.peek());
                    polygons.add(newRing);
                }
            }
        }
        return polygons;
    }
}
