package eu.organicity.entities.handler.attributes;

import eu.organicity.entities.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Description extends Attribute {

    public Description(String value) {
        super(OrganicityAttributeTypes.Types.DESCRIPTION, value);
        this.setMetadatas(null);
    }
}
