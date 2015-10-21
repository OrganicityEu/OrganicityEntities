package eu.organicity.entities.handler.metadata;

import com.amaxilatis.orion.OrionClient;

import java.util.Map;

/**
 * Created by etheodor on 20/10/2015.
 */
public class Metadata {
    String name;
    String value;
    String type;

    public Metadata(String name, String type, String value) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String,String> getMetadata(){
        return OrionClient.createMetadata(name,type,value);
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
