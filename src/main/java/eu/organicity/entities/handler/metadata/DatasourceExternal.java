package eu.organicity.entities.handler.metadata;

import eu.organicity.entities.namespace.OrganicityDatatypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class DatasourceExternal extends Metadata {
    public DatasourceExternal() {
        super("datasource", OrganicityDatatypes.DATATYPES.BOOLEAN.getUrn(), "false");
    }
}
