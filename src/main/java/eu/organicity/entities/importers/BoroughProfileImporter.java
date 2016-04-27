package eu.organicity.entities.importers;


import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.namespace.OrganicityAttributeTypes.Types;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPOutputStream;

public class BoroughProfileImporter {

    public static List<BoroughProfile> process(String jsonInputFilename) throws IOException {
        FeatureCollection featureCollection =
                new ObjectMapper().readValue(new FileInputStream(jsonInputFilename), FeatureCollection.class);
        HashMap ids = new HashMap();
        List<BoroughProfile> profiles = new ArrayList<>();
        HashMap idsError = new HashMap();
        for (Feature feature : featureCollection.getFeatures()) {
            String id = feature.getProperties().get("id").toString();
            isNull(id);
            BoroughProfile boroughProfile = new BoroughProfile(id);

            // Adding Area-GeoJson
            isNull(feature.getGeometry());
            String area = feature.getGeometry().toString();
            area = compress(area);
            boroughProfile.setArea(area);

            // Adding Origin
            Origin origin = new Origin("http://organicity.eu/cities/london/");
            boroughProfile.addAttribute(origin);

            // Adding last update
            boroughProfile.setTimestamp(new Date());


            // FIXME: Loop through attributes
            Map<String, Object> attributes = (Map<String, Object>) feature.getProperties().get("attributes");
            for (String attributeKey : attributes.keySet()) {
                Map<String, Object> attribute = (Map<String, Object>) attributes.get(attributeKey);
                Map<String, String> attributeAttributes = (Map<String, String>) attribute.get("attributes");
                Map<String, Double> attributeValues = (Map<String, Double>) attribute.get("values");

                // Find the latest timed value
                TreeSet<String> valueTimes = new TreeSet<String>(attributeValues.keySet());
                String latestTime = valueTimes.last();

                // Adding classic attributes

               /* isNull(latestTime);
                isNull(attributeAttributes.get("urn"));
                isNull(Types.getAttibuteType(attributeAttributes.get("urn")));*/

                Attribute a = new Attribute(Types.getAttibuteType(attributeAttributes.get("urn")), String.valueOf(attributeValues.get(latestTime)));
                Metadata m = new Metadata("TimeInstant", "ISO8601", latestTime);
                a.addMetadata(m);
                boroughProfile.addAttribute(a);
            }
            profiles.add(boroughProfile);

        }
        return profiles;
    }


    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: BoroughProfileImporter jsonInputFilename OrionSeverUrl");
            System.exit(1);
        }
        String serverUrl = args[1];  //"http://orion.lab.fi-ware.org:1026/";
        String jsonInputFilename = args[0];
        List<BoroughProfile> profiles = process(jsonInputFilename);

        for (BoroughProfile boroughProfile : profiles) {
            String payload = new com.fasterxml.jackson.databind.ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(boroughProfile.getContextElement());
            try {
                post(serverUrl, payload);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(payload);
                break;
            }
        }
    }


    static void isNull(Object x) {
        if (x == null)
            throw new NullPointerException();
    }


    public static void post(String server, String entity) throws UnirestException, IOException {

        entity = "{\n" +
                "    \"contextElements\": [" + entity +
                "    ],\n" +
                "    \"updateAction\": \"APPEND\"\n" +
                "\n}\n\n\n\n\n\r";

        System.out.println(entity);
        HttpResponse<String> response = Unirest.post(server)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(entity)
                .asString();

        if (response.getStatus() != 200 || response.getBody().contains("errorCode")) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus() + response.getBody());
        }
    }

    private String wrap(String s, Integer l) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % l == 0) {
                a = a + "\n";
            }
            a = a + s.charAt(i);
        }
        return a;
    }

    private static String wrap(String s, String l) {
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i).startsWith(l)) {
                a = a + "\n";
            }
            a = a + s.charAt(i);
        }
        return a;
    }

    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        String outStr = out.toString("UTF-8");
        return outStr;
    }
}
