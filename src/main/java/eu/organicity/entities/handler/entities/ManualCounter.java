package eu.organicity.entities.handler.entities;

import eu.organicity.entities.namespace.OrganicityEntityTypes;

/**
 * Class for representing manual counters such as the UK's Department of Transport traffic counters
 */
public class ManualCounter extends OrganicityEntity {

    public ManualCounter() {
        super(OrganicityEntityTypes.EntityType.MANUAL_COUNTER);
    }

    public ManualCounter(String id) {
        super(id, OrganicityEntityTypes.EntityType.MANUAL_COUNTER);
    }
}
