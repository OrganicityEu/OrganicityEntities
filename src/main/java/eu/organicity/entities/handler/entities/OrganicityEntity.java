package eu.organicity.entities.handler.entities;

import com.amaxilatis.orion.OrionClient;
import com.amaxilatis.orion.model.OrionContextElement;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.namespace.OrganicityEntityTypes;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by etheodor on 20/10/2015.
 */
public class OrganicityEntity {

    final List<Attribute> attributes = new ArrayList<>();
    String id;
    OrganicityEntityTypes.EntityType entityType;
    private Date date;
    private Double latitude; // Encoded in WGS84
    private Double longitude; // Encoded in WGS84
    private String area; //Encoded in GeoJSON
    private String datasourceUrl;
    private Boolean datasourceInternal;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public OrganicityEntity(OrganicityEntityTypes.EntityType entityType) {
        this.id = null;
        this.entityType = entityType;
        this.date = null;
        this.latitude = null;
        this.longitude = null;
        this.area = null;

    }

    public OrganicityEntity(String id, OrganicityEntityTypes.EntityType entityType) {
        this.id = id;
        this.entityType = entityType;
        this.date = null;
        this.latitude = null;
        this.longitude = null;
        this.area = null;
        this.datasourceUrl = null;
        this.datasourceInternal = null;
    }

    public OrionContextElement getContextElement() throws Exception {
        OrionContextElement element = new OrionContextElement();
        element.setId(id);
        element.setType(entityType.getUrn());

        for (Attribute attribute : attributes) {
            element.getAttributes().add(attribute.getAttribute());
        }
        if (date != null) {
            element.getAttributes().add(OrionClient.createAttribute("TimeInstant", "ISO8601", df.format(date)));
        }
        if (latitude != null && longitude != null) {
            element.getAttributes().add(OrionClient.createAttribute("location", "geo:point", latitude + ", " + longitude));
        }
        if (datasourceUrl != null && datasourceInternal != null) {
            element.getAttributes().add(OrionClient.createAttributeWithMetadata("datasource", "urn:oc:attributeType:datasource", datasourceUrl
                    , "datasourceInternal", "urn:oc:datatype:boolean", String.valueOf(datasourceInternal).toLowerCase()));
        }

        if (area != null) {
            area = URLEncoder.encode(area);
            com.amaxilatis.orion.model.Attribute a = OrionClient.createAttribute("area", "string", area);
//            if (a.getMetadatas() == null) {
//                a.setMetadatas(new ArrayList<>());
//            }
//            List<String> parts = split(area, 512);
//            int i = 0;
//            for (String part : parts) {
//                com.amaxilatis.orion.model.Metadata m = new com.amaxilatis.orion.model.Metadata("area" + i, "part" + i++, part);
//                a.getMetadatas().add(m);
//            }

            element.getAttributes().add(a);
        }

        return element;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setTimestamp(final Date date) {
        this.date = date;
    }

    public void setPosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setDatasource(final boolean internal, final String url) {
        this.datasourceUrl = url;
        this.datasourceInternal = internal;
    }

    public void setArea(String area) {
        this.area = area; //todo: possible add GeoJson Validations
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

    public static List<String> split(String text, int size) {
        List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);
        for (int start = 0; start < text.length(); start += size) {
            ret.add(text.substring(start, Math.min(text.length(), start + size)));
        }
        return ret;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getArea() {
        return area;
    }

    public String getId() {
        return id;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public OrganicityEntityTypes.EntityType getEntityType() {
        return entityType;
    }
}
