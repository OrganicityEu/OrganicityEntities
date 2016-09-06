package eu.organicity.entities.runners;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import eu.organicity.entities.handler.converters.AssetToJsonObject;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.importers.BoroughProfileImporter;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public class BoroughProfileImporterOrionRunner {


    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: BoroughProfileImporter jsonInputFilename AssetDirectoryUrl");
            System.exit(1);
        }

        String jsonInputFilename = args[0];
        String url = args[1];


        BoroughProfileImporter importer = new BoroughProfileImporter();
        List<OrganicityEntity> profiles = importer.process(jsonInputFilename);
        int counter = 0;
        for (OrganicityEntity asset : profiles) {
            asset.setTimestamp(new Date(System.currentTimeMillis()));
            JSONObject object = AssetToJsonObject.entityToJsonObject(asset);
            System.out.println(object.toString(2));

            HttpResponse<JsonNode> jsonResponse = Unirest.delete(url + "/" + asset.getId() + "?type=" + asset.getEntityType().getUrn())
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Fiware-Service", "organicity")
                    .header("Fiware-ServicePath", "/")
                    .asJson();

            if (jsonResponse.getStatus() == HttpStatus.SC_NO_CONTENT) {
                System.out.println("Asset Deleted:" + asset.getId());
            } else {
                System.out.println("Asset Not Deleted:" + asset.getId());
            }

            jsonResponse = Unirest.post(url)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Fiware-Service", "organicity")
                    .header("Fiware-ServicePath", "/")
                    .body(object)
                    .asJson();
            if (jsonResponse.getStatus() == HttpStatus.SC_CREATED) {
                counter++;
                System.out.println("Asset Created:" + asset.getId());
            } else {
                System.out.println(jsonResponse.getBody());
                break;
            }
        }
        System.out.println(counter + " assets created out of " + profiles.size());

    }


}
