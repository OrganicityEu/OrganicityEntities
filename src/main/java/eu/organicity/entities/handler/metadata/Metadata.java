package eu.organicity.entities.handler.metadata;

import com.amaxilatis.orion.OrionClient;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Metadata extends com.amaxilatis.orion.model.Metadata {


    public Metadata(String name, String type, String value) {
        setName(name);
        setType(type);
        setValue(value);
    }


    public com.amaxilatis.orion.model.Metadata getMetadata() {
        return OrionClient.createMetadata(getName(), getType(), getValue());
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "name='" + getName() + '\'' +
                ", value='" + getValue() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
