package oc.entityhandlers.metadata;

import oc.namespace.OrganicityDatatypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Datatype extends Metadata {



    public Datatype(OrganicityDatatypes.DATATYPES type) {
        super(type.getName(), type.getUrn(), "");
    }
}
