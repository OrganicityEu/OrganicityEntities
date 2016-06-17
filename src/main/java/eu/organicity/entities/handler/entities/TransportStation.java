package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Created by bsigurbjornsson on 13/06/2016.
 */
public class TransportStation extends OrganicityEntity {

    public TransportStation(){
        super(OrganicityEntityTypes.EntityType.TRANSPORT_STATION);
    }

    public TransportStation(String id){
        super(id, OrganicityEntityTypes.EntityType.TRANSPORT_STATION);
    }
}
