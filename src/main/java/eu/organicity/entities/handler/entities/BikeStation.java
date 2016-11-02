package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class BikeStation extends OrganicityEntity {

    public BikeStation() {
        super(OrganicityEntityTypes.EntityType.BIKE_STATION);
    }

    public BikeStation(String id) {
        super(id, OrganicityEntityTypes.EntityType.BIKE_STATION);
    }
}
