package eu.organicity.entities.importers;

import eu.organicity.entities.handler.entities.OrganicityEntity;

import java.util.Arrays;
import java.util.List;

public class TransportApiTestMain {

    public static void main(String[] args) throws Exception {
        TransportAPIImporter tr = new TransportAPIImporter();
        List<OrganicityEntity> x = tr.process(100);
        System.out.println(Arrays.toString(x.toArray()));

    }
}
