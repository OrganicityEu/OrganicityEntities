package eu.organicity.entities.handler.attributes;

import com.amaxilatis.orion.OrionClient;
import eu.organicity.entities.handler.metadata.Metadata;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Attribute {

    String value;
    OrganicityAttributeTypes.Types attributeType;
    List<Metadata> metadata = new ArrayList<Metadata>();

    public Attribute(OrganicityAttributeTypes.Types attributeType, String value) {
        this.attributeType = attributeType;
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getAttribute() {
        List<Map<String, String>> metadatas = new ArrayList<Map<String, String>>();
        for (Metadata m : metadata) {
            metadatas.add(m.getMetadata());
        }
        return OrionClient.createAttributeWithMetadata(this.attributeType.getName(), this.attributeType.getUrn(), value, metadatas);
    }

    public void addMetadata(Metadata m) {
        metadata.add(m);
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + this.attributeType.getName() + '\'' +
                ", value='" + value + '\'' +
                ", type='" + this.attributeType.getUrn() + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
