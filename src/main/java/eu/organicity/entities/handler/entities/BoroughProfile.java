package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Created by borkur on 19/4/2016.
 */
public class BoroughProfile extends OrganicityEntity {

    public BoroughProfile() {
        super(OrganicityEntityTypes.EntityType.BOROUGH);
    }

    public BoroughProfile(String id) {
        super(id, OrganicityEntityTypes.EntityType.BOROUGH);
    }
}
