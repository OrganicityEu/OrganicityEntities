package eu.organicity.entities.handler.attributes;

import eu.organicity.entities.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Origin extends Attribute {

    public Origin(String value) {
        super(OrganicityAttributeTypes.Types.ORIGIN, value);
        this.setMetadatas(null);
    }
}
