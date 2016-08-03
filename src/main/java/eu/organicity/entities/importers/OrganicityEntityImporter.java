package eu.organicity.entities.importers;

import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.OrganicityEntity;

import java.util.List;

/**
 * Created by bsigurbjornsson on 13/05/2016.
 */
public interface OrganicityEntityImporter {

    /**
     * Processes a filebased resource and extracts a list of OrganicityEntities
     *
     * @param resourceFileName is the location of the file-based resource
     * @return a list of OrganicityEntities listed in the resource
     */
    List<OrganicityEntity> process(String resourceFileName) throws Exception;

    OrganicityEntity initialiseEntity(String label);

    Origin getOrigin();
}
