package eu.organicity.entities.importers;

import com.amaxilatis.orion.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import eu.organicity.entities.namespace.OrganicityEntityTypes;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class ManualCounterImporterTest {

    @Test
    public void testInitialiseEntity() throws Exception {
        ManualCounterImporter importer = new ManualCounterImporter();

        OrganicityEntity entity = importer.initialiseEntity("idString");

        assertEquals("urn:oc:entity:london:trafficCount:uk.gov.dft:"+"idString", entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.TRAFFIC_STATS, entity.getEntityType());
    }

    @Test
    public void testProcess() throws Exception {
        ManualCounterImporter importer = new ManualCounterImporter();

        String jsonFileName = this.getClass().getResource("/entityImport/organicity-traffic-counts-test.json").getPath();

        List<OrganicityEntity> entities = importer.process(jsonFileName);

        assertEquals(3, entities.size());

        // Get an example traffic counter
        OrganicityEntity entity = entities.stream()
                .filter(e -> "urn:oc:entity:london:trafficCount:uk.gov.dft:DfT-TrafficCounter-6071".equals(e.getId()))
                .findAny()
                .orElse(null);
        assertNotNull(entity);
        assertEquals("urn:oc:entity:london:trafficCount:uk.gov.dft:DfT-TrafficCounter-6071", entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.TRAFFIC_STATS, entity.getEntityType());

        // Get Light goods vehicle count
        Attribute attribute = entity.getAttributes().stream()
                .filter(a -> OrganicityAttributeTypes.Types.TRAFFIC_INTENSITY_LGV.equals(a.getAttributeType()))
                .findAny()
                .orElse(null);
        assertNotNull(attribute);
        assertEquals(OrganicityAttributeTypes.Types.TRAFFIC_INTENSITY_LGV.getUrn(), attribute.getAttribute().getType());
        assertEquals(OrganicityAttributeTypes.Types.TRAFFIC_INTENSITY_LGV.getName(), attribute.getAttribute().getName());
        assertEquals("7788.0", attribute.getAttribute().getValue());  // NOTE: This value can change if we update the json file
        Metadata timestamp = attribute.getMetadatas().stream()
                .filter(m -> "TimeInstant".equals(m.getName()))
                .findAny()
                .orElse(null);
        assertEquals("2015-12-31T23:59:59", timestamp.getValue());  // NOTE: This value can change if we update the json file
    }

    @Test
    @Ignore //This is not a unit test
    public void printAllProcess() throws Exception {
        ManualCounterImporter importer = new ManualCounterImporter();
        String jsonFileName = this.getClass().getResource("/resources/entityImport/organicity-traffic-counts.json").getPath();
        List<OrganicityEntity> entities = importer.process(jsonFileName);


        for (OrganicityEntity boroughProfile : entities) {
            String payload = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(boroughProfile.getContextElement());
            System.out.println(payload);
        }
    }
}