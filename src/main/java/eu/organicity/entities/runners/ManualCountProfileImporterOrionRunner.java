package eu.organicity.entities.runners;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import eu.organicity.entities.handler.converters.AssetToJsonObject;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.importers.BoroughProfileImporter;
import eu.organicity.entities.importers.ManualCounterImporter;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.List;

public class ManualCountProfileImporterOrionRunner {


    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: ManualCountImporter jsonInputFilename");
            System.exit(1);
        }

        String jsonInputFilename = args[0];
        String url = args[1];


        ManualCounterImporter importer = new ManualCounterImporter();
        List<OrganicityEntity> manualCounterAssets = importer.process(jsonInputFilename);
        int counter = 0;
        for (OrganicityEntity manualCountAsset : manualCounterAssets) {
            JSONObject object = AssetToJsonObject.entityToJsonObject(manualCountAsset);
            HttpResponse<JsonNode> jsonResponse = Unirest.delete(url + "/" + manualCountAsset.getId() + "?type=" + manualCountAsset.getEntityType())
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asJson();

            if (jsonResponse.getStatus() == HttpStatus.SC_NO_CONTENT) {
                System.out.println("Asset Deleted:"+manualCountAsset.getId());
            } else {
                System.out.println("Asset Not Deleted:"+manualCountAsset.getId());
            }

            jsonResponse = Unirest.post(url)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(object)
                    .asJson();
            if (jsonResponse.getStatus() == HttpStatus.SC_CREATED) {
                counter++;
                System.out.println("Asset Created:"+manualCountAsset.getId());
            } else {
                System.out.println(jsonResponse.getBody());
                break;
            }
        }
        System.out.println(counter + " assets created out of " + manualCounterAssets.size());

    }


}
