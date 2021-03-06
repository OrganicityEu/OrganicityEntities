package eu.organicity.entities.importers;

import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.ManualCounter;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityEntityTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Importer for London manual traffic counts.
 */
public class ManualCounterImporter extends GeoJsonImporter implements OrganicityEntityImporter{

    @Override
    public OrganicityEntity initialiseEntity(String label) {
        return new ManualCounter("urn:oc:entity:london:trafficCount:uk.gov.dft:"+label);
    }

    @Override
    public Origin getOrigin() {
        List<String> urls = new ArrayList<>();
        urls.add("http://www.dft.gov.uk/traffic-counts/");
        return new Origin("Street-level traffic count data from UK Department for Transport.",
                urls);
    }
}
