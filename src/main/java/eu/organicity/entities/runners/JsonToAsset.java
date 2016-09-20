package eu.organicity.entities.runners;

import eu.organicity.entities.handler.attributes.*;
import eu.organicity.entities.handler.converters.AssetToJsonObject;
import eu.organicity.entities.handler.converters.JsonObjectToAsset;
import eu.organicity.entities.handler.entities.IoTDevice;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.geojson.Point;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonToAsset {

    public static void main(String[] args) throws Exception {
        String jSONObjectAsString = "{id: 'urn:oc:entity:london:trafficCount:uk.gov.dft:DfT-TrafficCounter-6000',type: 'urn:oc:entityType:trafficstats',location: {type: 'geo:point',value: '-0.23795282516501054,51.587519079277754',metadata: { }},origin: {type: 'urn:oc:attributeType:origin',value: 'Street-level traffic count data from UK Department for Transport.',metadata: {unit: {type: 'NOT_APPLIED',value: 'NOT_APPLIED'},originurl1: {type: 'url',value: 'http://www.dft.gov.uk/traffic-counts/'}}} }";
        JSONObject jsonObject=new JSONObject(jSONObjectAsString);
        OrganicityEntity asset = JsonObjectToAsset.jsonToAsset(jsonObject);
        JSONObject object = AssetToJsonObject.entityToJsonObject(asset);
        System.out.println(object.toString(2));
    }
}
