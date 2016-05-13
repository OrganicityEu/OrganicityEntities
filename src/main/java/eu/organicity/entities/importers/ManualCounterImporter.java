package eu.organicity.entities.importers;

import eu.organicity.entities.handler.entities.ManualCounter;
import eu.organicity.entities.handler.entities.OrganicityEntity;

/**
 * Created by bsigurbjornsson on 13/05/2016.
 */
public class ManualCounterImporter extends GeoJsonImporter implements OrganicityEntityImporter{

    @Override
    public OrganicityEntity initialiseEntity(String id) {
        return new ManualCounter(id);
    }
}
