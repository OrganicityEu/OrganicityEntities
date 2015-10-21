package oc.entityhandlers.metadata;

import oc.namespace.OrganicityDatatypes;
import oc.namespace.OrganicityUnits;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Datetime extends Metadata {
    public Datetime(String value) {
        super("datatime", OrganicityDatatypes.DATATYPES.DATETIME.getUrn(), value);
    }
}
