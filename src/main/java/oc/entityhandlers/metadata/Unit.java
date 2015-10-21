package oc.entityhandlers.metadata;

import oc.namespace.OrganicityDatatypes;
import oc.namespace.OrganicityUnits;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Unit extends Metadata {
    public Unit(OrganicityUnits.Units unit) {
        super(unit.getName(), unit.getUrn(), "");
    }
}
