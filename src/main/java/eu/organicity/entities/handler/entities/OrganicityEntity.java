package eu.organicity.entities.handler.entities;

import com.amaxilatis.orion.OrionClient;
import com.amaxilatis.orion.model.OrionContextElement;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.namespace.OrganicityEntityTypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by etheodor on 20/10/2015.
 */
public class OrganicityEntity {

    List<Attribute> attributes = new ArrayList<Attribute>();
    String id;
    OrganicityEntityTypes.EntityType entityType;
    private Date date;
    private Double latitude;
    private Double longitude;

    public OrganicityEntity(String id, OrganicityEntityTypes.EntityType entityType) {
        this.id = id;
        this.entityType = entityType;
        this.date = null;
        this.latitude = null;
        this.longitude = null;
    }

    public OrionContextElement getContextElement() {
        OrionContextElement element = new OrionContextElement();
        element.setId(id);
        element.setType(entityType.getUrn());

        for (Attribute attribute : attributes) {
            element.getAttributes().add(attribute.getAttribute());
        }
        if (date != null) {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            df.setTimeZone(tz);
            element.getAttributes().add(OrionClient.createAttribute("TimeInstant", "urn:oc:datatype:ISO8601", df.format(date)));
        }
        if (latitude != null && longitude != null) {
            element.getAttributes().add(OrionClient.createAttributeWithMetadata("position", "coords", latitude + ", " + longitude, "location", "string", "WGS84"));
        }
        return element;
    }

    public void setTimestamp(final Date date) {
        this.date = date;
    }

    public void setPosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void addAttribute(Attribute a) {
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
