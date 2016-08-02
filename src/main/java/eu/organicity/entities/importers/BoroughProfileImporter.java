package eu.organicity.entities.importers;


import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.BoroughProfile;
import eu.organicity.entities.handler.entities.OrganicityEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Importer for London Borough Profiles
 */
public class BoroughProfileImporter extends GeoJsonImporter implements OrganicityEntityImporter {

    @Override
    public OrganicityEntity initialiseEntity(String id) {
        return new BoroughProfile(id);
    }

    @Override
    public Origin getOrigin() {
        // FIXME: Get this urls from file
        List<String> urls = new ArrayList<>();
        urls.add("http://data.london.gov.uk/dataset/london-borough-profiles");
        urls.add("http://data.london.gov.uk/dataset/walking-and-cycling-borough");
        urls.add("http://www.noo.org.uk/visualisation");
        return new Origin(
                "The London Borough profile is a combination of data from " +
                        "the London Datastore "+
                        "and Public Health England.",
                urls
                );
    }
}
