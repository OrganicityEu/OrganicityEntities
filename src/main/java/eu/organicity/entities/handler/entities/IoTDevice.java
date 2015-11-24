package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class IoTDevice extends OrganicityEntity {

    public IoTDevice() {
        super(OrganicityEntityTypes.EntityType.IOT_DEVICE);
    }

    public IoTDevice(String id) {
        super(id, OrganicityEntityTypes.EntityType.IOT_DEVICE);
    }
}
