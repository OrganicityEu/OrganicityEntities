import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.importers.BoroughProfileImporter;
import eu.organicity.entities.namespace.OrganicityAttributeTypes.Types;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPOutputStream;

public class BoroughProfileImporterTest {


    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: BoroughProfileImporter jsonInputFilename OrionSeverUrl");
            System.exit(1);
        }
        String serverUrl = args[1];  //"http://orion.lab.fi-ware.org:1026/";
        String jsonInputFilename = args[0];
        Boolean performPost = Boolean.parseBoolean(args[2]);

        List<BoroughProfile> profiles = BoroughProfileImporter.process(jsonInputFilename);

        for (BoroughProfile boroughProfile : profiles) {
            String payload = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(boroughProfile.getContextElement());
            System.out.println(payload);
            if (performPost) {
                try {
                    post(serverUrl, payload);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Borough Asset Failed to post:" + boroughProfile.getContextElement().getId());
                    break;
                }
            }
        }
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
