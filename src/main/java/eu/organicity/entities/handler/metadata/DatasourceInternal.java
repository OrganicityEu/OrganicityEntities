package eu.organicity.entities.handler.metadata;

import eu.organicity.entities.namespace.OrganicityDatatypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class DatasourceInternal extends Metadata {
    public DatasourceInternal() {
        super("datasourceInternal", OrganicityDatatypes.DATATYPES.BOOLEAN.getUrn(), "true");
    }
}
