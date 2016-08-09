package eu.organicity.entities.importers;

import com.amaxilatis.orion.model.Metadata;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import eu.organicity.entities.namespace.OrganicityEntityTypes;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bsigurbjornsson on 13/05/2016.
 */
public class BoroughProfileImporterTest {

    @Test
    public void testInitialiseEntity() throws Exception {
        BoroughProfileImporter importer = new BoroughProfileImporter();

        OrganicityEntity entity = importer.initialiseEntity("idString");

        assertEquals("urn:oc:entity:london:districtProfile:uk.gov.london:idString", entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.DISTRICT_PROFILE, entity.getEntityType());
    }

    @Test
    public void testProcess() throws Exception{
        BoroughProfileImporter importer = new BoroughProfileImporter();

        String jsonFileName = this.getClass().getResource("/entityImport/organicity-borough-profiles-test.json").getPath();

        List<OrganicityEntity> entities = importer.process(jsonFileName);

        assertEquals(2, entities.size());

        // Get Borough E09000033
        OrganicityEntity entity = entities.stream()
                .filter(e -> "urn:oc:entity:london:districtProfile:uk.gov.london:E09000001".equals(e.getId()))
                .findAny()
                .orElse(null);
        assertNotNull(entity);
        assertEquals("urn:oc:entity:london:districtProfile:uk.gov.london:E09000001",entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.DISTRICT_PROFILE, entity.getEntityType());

        // Get Fraction Greenspace
        Attribute attribute = entity.getAttributes().stream()
                .filter(a -> OrganicityAttributeTypes.Types.PROPORTION_GREENSPACE.equals(a.getAttributeType()))
                .findAny()
                .orElse(null);
        assertNotNull(attribute);
        assertEquals("urn:oc:attributeType:greenspace", attribute.getAttribute().getType());
        assertEquals("greenspace", attribute.getAttribute().getName());
        assertEquals("4.8", attribute.getAttribute().getValue());
        Metadata timestamp = attribute.getMetadatas().stream()
                .filter(m -> "TimeInstant".equals(m.getName()))
                .findAny()
                .orElse(null);
        assertEquals("2005-12-31T23:59:59", timestamp.getValue());
    }
}