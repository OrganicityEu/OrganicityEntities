package eu.organicity.entities.runners;

import eu.organicity.entities.handler.attributes.*;
import eu.organicity.entities.handler.converters.AssetToJsonObject;
import eu.organicity.entities.handler.entities.IoTDevice;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.geojson.Point;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IoTDeviceDatasourceInternal {

    public static void main(String[] args) throws Exception {


        IoTDevice iot = new IoTDevice("urn:oc:entity:london:environmental:park1:weatherstation123");

        // Adding classic attributes
        Attribute a = new Attribute(OrganicityAttributeTypes.Types.BATTERY_LEVEL, "0.90");
        iot.addAttribute(a);
        a = new Attribute(OrganicityAttributeTypes.Types.TEMPERATURE, "24");
        iot.addAttribute(a);

        // Adding Position
        iot.setPosition(1.1, 3.1);

        // Adding Area-GeoJson
        Point p = new Point(1.1, 3.1);
        iot.setArea(p.toString());

        // Adding last update
        iot.setTimestamp(new Date());

        // Adding Origin
        List<String> urls = new ArrayList<>();
        urls.add("http://organicity.eu/cities/london/");
        a = new Origin("Weather station ...", urls);
        iot.addAttribute(a);

        // Adding Datasource
        a = new Datasource("http://146.489.16.982:1026/v1/contextEntities/", true, null);
        iot.addAttribute(a);

        // Adding Ranking
        a = new Ranking("0.98");
        iot.addAttribute(a);

        // Adding Comments Url
        a = new Comments("http://organicity.eu/cities/london/comments");
        iot.addAttribute(a);

        System.out.println(iot.toString());
        System.out.println(new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(iot.getContextElement()));
        JSONObject object = AssetToJsonObject.entityToJsonObject(iot);
        System.out.println(object.toString(2));
    }
}
