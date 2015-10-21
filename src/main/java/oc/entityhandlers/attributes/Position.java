package oc.entityhandlers.attributes;

import oc.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Position extends Attribute    {

    public Position(  String value ) {
        super(OrganicityAttributeTypes.Types.POSITION, value);
    }
}
