package eu.organicity.entities.runners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.importers.ManualCounterImporter;

import java.util.List;

public class ManualCountProfileImporterRunner {


    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.err.println("Error: insufficient argument count!");
            System.err.println("Usage: TrafficCount+ProfileImporter jsonInputFilename");
            System.exit(1);
        }

        String jsonInputFilename = args[0];

        ManualCounterImporter importer = new ManualCounterImporter();
        List<OrganicityEntity> manualCounters = importer.process(jsonInputFilename);

        for (OrganicityEntity entity : manualCounters) {

            String payload = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(entity.getContextElement());
            System.out.println(payload);
        }
    }


}
