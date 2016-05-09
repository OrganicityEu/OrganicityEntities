package eu.organicity.entities.handler.attributes;

import com.amaxilatis.orion.OrionClient;
import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;

import java.util.ArrayList;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Attribute extends com.amaxilatis.orion.model.Attribute {

    OrganicityAttributeTypes.Types attributeType;

    public Attribute(OrganicityAttributeTypes.Types attributeType, String value) {
        this.attributeType = attributeType;
        setName(attributeType.getName());
        setType(attributeType.getUrn());
        setValue(value);
        Metadata metadata = new Metadata("unit", attributeType.getUom().getUrn(), attributeType.getUom().getName());
        this.setMetadatas(new ArrayList<>());
        this.getMetadatas().add(metadata);
    }

    public Attribute(String name, String type, String value) {
        super(name, type, value);
    }


    public com.amaxilatis.orion.model.Attribute getAttribute() {
        if (this.attributeType != null)
            return OrionClient.createAttributeWithMetadata(this.attributeType.getName(), this.attributeType.getUrn(), getValue(), getMetadatas());
        else
            return OrionClient.createAttributeWithMetadata(this.getName(), this.getType(), getValue(), getMetadatas());
    }

    public void addMetadata(final Metadata m) {
        if (getMetadatas() == null) {
            setMetadatas(new ArrayList<>());
        }
        getMetadatas().add(m);
    }

    @Override
    public String toString() {
        if (this.attributeType != null)
            return "Attribute{" +
                    "name='" + this.attributeType.getName() + '\'' +
                    ", value='" + getValue() + '\'' +
                    ", type='" + this.attributeType.getUrn() + '\'' +
                    ", metadata=" + getMetadatas() +
                    '}';
        else
            return "Attribute{" +
                    "name='" + this.getName() + '\'' +
                    ", value='" + getValue() + '\'' +
                    ", type='" + this.getType() + '\'' +
                    ", metadata=" + getMetadatas() +
                    '}';
    }
}
