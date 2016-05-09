package eu.organicity.entities.handler.metadata;

import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.namespace.OrganicityDatatypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Datetime extends Metadata {
    public Datetime(String value) {
        super("datatime", OrganicityDatatypes.DATATYPES.DATETIME.getUrn(), value);
    }
}
