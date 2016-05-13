package eu.organicity.entities.importers;


import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.handler.entities.OrganicityEntity;

public class BoroughProfileImporter extends GeoJsonImporter implements OrganicityEntityImporter {

    @Override
    public OrganicityEntity initialiseEntity(String id) {
        return new BoroughProfile(id);
    }
}
