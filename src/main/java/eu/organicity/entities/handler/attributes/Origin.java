package eu.organicity.entities.handler.attributes;

import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import eu.organicity.entities.namespace.OrganicityDatatypes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Origin of an OrganiCity Asset is a text description about the origin of the asset or data exposed in the asset.
 * The origin can contain zero or more urls as metadata pointing to sources where the data originated.
 */
public class Origin extends Attribute {

    public Origin(String description, List<String> urls) {
        super(OrganicityAttributeTypes.Types.ORIGIN, description);
        if (urls != null) {
            String urlsString = urls.stream().collect(Collectors.joining(","));
            this.addMetadata(new Metadata("urls",OrganicityDatatypes.DATATYPES.URL.getName(),urlsString));
        }
    }
}
