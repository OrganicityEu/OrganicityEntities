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

        assertEquals("idString", entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.BOROUGH, entity.getEntityType());
    }

    @Test
    public void testProcess() throws Exception{
        BoroughProfileImporter importer = new BoroughProfileImporter();

        String jsonFileName = this.getClass().getResource("/entityImport/organicity-borough-profiles.json").getPath();

        List<OrganicityEntity> entities = importer.process(jsonFileName);

        assertEquals(33, entities.size());  // NOTE: This value can change if we update the json file

        // Get Borough E09000033
        OrganicityEntity entity = entities.stream()
                .filter(e -> "urn:oc:entity:london:boroughProfile:uk.gov.london:E09000033".equals(e.getId()))
                .findAny()
                .orElse(null);
        assertNotNull(entity);
        assertEquals("urn:oc:entity:london:boroughProfile:uk.gov.london:E09000033",entity.getId());
        assertEquals(OrganicityEntityTypes.EntityType.BOROUGH, entity.getEntityType());

        // Get Fraction Greenspace
        Attribute attribute = entity.getAttributes().stream()
                .filter(a -> OrganicityAttributeTypes.Types.PROPORTION_GREENSPACE.equals(a.getAttributeType()))
                .findAny()
                .orElse(null);
        assertNotNull(attribute);
        assertEquals("urn:oc:attributeType:boroughProfile:proportionGreenspace", attribute.getAttribute().getType());
        assertEquals("boroughProfile:proportionGreenspace", attribute.getAttribute().getName());
        assertEquals("38.2", attribute.getAttribute().getValue());  // NOTE: This value can change if we update the json file
        Metadata timestamp = attribute.getMetadatas().stream()
                .filter(m -> "TimeInstant".equals(m.getName()))
                .findAny()
                .orElse(null);
        assertEquals("2005-12-31T23:59:59", timestamp.getValue());  // NOTE: This value can change if we update the json file
    }
}