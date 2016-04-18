package eu.organicity.entities.handler.attributes;

import eu.organicity.entities.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Comments extends Attribute {

    public Comments(String value) {
        super(OrganicityAttributeTypes.Types.COMMENTS, value);
        this.setMetadatas(null);
    }
}
