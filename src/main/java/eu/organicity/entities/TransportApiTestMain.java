package eu.organicity.entities;

import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.importers.TransportAPIImporter;

import java.util.List;

public class TransportApiTestMain {

    public static void main(String[] args) throws Exception {
        int counterSize = 0;
        TransportAPIImporter tr = new TransportAPIImporter();
        for (int i = 1; i < 200; i++) {
            List<OrganicityEntity> stations = tr.process(i);
            counterSize += stations.size();
            if (stations.size() == 0) break;
            System.out.println(stations.size());

        }
        System.out.println("Final:" + counterSize);
    }
}