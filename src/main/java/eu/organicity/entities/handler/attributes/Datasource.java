package eu.organicity.entities.handler.attributes;

import eu.organicity.entities.handler.metadata.DatasourceExternal;
import eu.organicity.entities.handler.metadata.DatasourceInternal;
import eu.organicity.entities.handler.metadata.Mediatype;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Datasource extends Attribute {

    public Datasource(String value, Boolean internal, String type) {
        super(OrganicityAttributeTypes.Types.DATASOURCE, value);
        this.getMetadatas().clear();
        if (internal) {
            this.addMetadata(new DatasourceInternal());
        } else {
            this.addMetadata(new DatasourceExternal());
            this.addMetadata(new Mediatype(type));
        }
    }
}
