package oc.entityhandlers.entities;

import com.amaxilatis.orion.model.OrionContextElement;
import oc.entityhandlers.attributes.Attribute;
import oc.namespace.OrganicityEntityTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etheodor on 20/10/2015.
 */
public class OrganicityEntity {

    List<Attribute> attributes = new ArrayList<Attribute>();
    String id;
    OrganicityEntityTypes.EntityType entityType;

    public OrganicityEntity(String id, OrganicityEntityTypes.EntityType entityType) {
        this.id = id;
        this.entityType = entityType;
    }

    public OrionContextElement getContextElement() {
        OrionContextElement element = new OrionContextElement();
        for (Attribute attribute : attributes) {
            element.getAttributes().add(attribute.getAttribute());
        }
        return element;
    }

    public void addAttribute(Attribute a){
        attributes.add(a);
    }

    @Override
    public String toString() {
        return "OrganicityEntity{" +
                "attributes=" + attributes +
                ", id='" + id + '\'' +
                ", entityType=" + entityType +
                '}';
    }
}
