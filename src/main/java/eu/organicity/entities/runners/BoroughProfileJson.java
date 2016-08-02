package eu.organicity.entities.runners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.importers.BoroughProfileImporter;

import java.security.SecureRandom;
import java.util.List;

public class BoroughProfileJson {


    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: BoroughProfileImporter jsonInputFilename OrionSeverUrl");
            System.exit(1);
        }
        String serverUrl = args[1];  //"http://orion.lab.fi-ware.org:1026/";
        String jsonInputFilename = args[0];
        Boolean performPost = Boolean.parseBoolean(args[2]);

        BoroughProfileImporter importer = new BoroughProfileImporter();
        List<OrganicityEntity> profiles = importer.process(jsonInputFilename);

        for (OrganicityEntity boroughProfile : profiles) {
            boroughProfile.setArea(randomString(20000));
            String payload = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(boroughProfile.getContextElement());
            jsonPrint(payload);
            boroughProfile.setArea(randomString(80000));
            payload = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(boroughProfile.getContextElement());
            jsonPrint(payload);
            break;

        }
    }


    public static void jsonPrint(String entity) {

        entity = "{\n" +
                "    \"contextElements\": [" + entity +
                "    ],\n" +
                "    \"updateAction\": \"APPEND\"\n" +
                "\n}\n\n\n\n\n\r";

        System.out.println(entity);

        System.out.println("-----------------------------------------------------------------");
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
