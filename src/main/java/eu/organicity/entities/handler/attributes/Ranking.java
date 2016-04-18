package eu.organicity.entities.handler.attributes;

import eu.organicity.entities.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Ranking extends Attribute {

    public Ranking(String value) {
        super(OrganicityAttributeTypes.Types.RANKING, value);
        this.setMetadata(null);
    }
}
