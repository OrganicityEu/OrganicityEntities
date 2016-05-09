package eu.organicity.entities.handler.metadata;

import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.namespace.OrganicityUnits;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Unit extends Metadata {
    public Unit(OrganicityUnits.Units unit) {
        super(unit.getName(), unit.getUrn(), "");
    }
}
