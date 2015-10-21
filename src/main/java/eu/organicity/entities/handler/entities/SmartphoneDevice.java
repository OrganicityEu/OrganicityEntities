package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class SmartphoneDevice extends OrganicityEntity {

    public SmartphoneDevice(String id) {
        super(id, OrganicityEntityTypes.EntityType.SMARTPHONE);
    }
}
