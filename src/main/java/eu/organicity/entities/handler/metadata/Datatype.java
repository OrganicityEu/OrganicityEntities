package eu.organicity.entities.handler.metadata;

import eu.organicity.entities.namespace.OrganicityDatatypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Datatype extends Metadata {


    public Datatype(OrganicityDatatypes.DATATYPES type) {
        super("datatype", type.getUrn(), type.getName());
    }
}
