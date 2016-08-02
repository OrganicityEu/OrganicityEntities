package eu.organicity.entities.importers;

import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.entities.OrganicityEntity;

import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bsigurbjornsson on 13/06/2016.
 */
public class TransportAPIImporterTest {

    @Test
    public void process() throws Exception {
        TransportAPIImporter importer = new TransportAPIImporter();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(
                new FileReader(
                        this.getClass().getResource("/entityImport/Farringdon.json").getFile()));

        JSONObject jsonLiveObject = (JSONObject) parser.parse(
                new FileReader(
                        this.getClass().getResource("/entityImport/FarringdonLive.json").getFile()));
        List<OrganicityEntity> entities = importer.process(jsonObject,jsonLiveObject);

        assertEquals(1, entities.size());

        OrganicityEntity entity = entities.get(0);
        Attribute performanceIndicator = entity.getAttributes().stream().filter(w -> w.getAttributeType() == OrganicityAttributeTypes.Types.TRANSPORT_SERVICE_PERFORMANCE).findFirst().get();
        assertEquals("0.24", performanceIndicator.getAttribute().getValue());

        // Station Name: Farringdon
        // Station status: 0.24
        // Service status: TL train to Sevenoaks 0.0 2 2
        // Service status: TL train to Luton 0.0 2 2
        // Service status: TL train to St Albans 0.5 1 2
        // Service status: TL train to Three Bridges 0.0 1 1
        // Service status: TL train to Bedford 0.375 5 8
        // Service status: TL train to Brighton 0.0 2 2
        // Service status: TL train to Beckenham Junction 0.5 1 2
        // Service status: TL train to Sutton (Surrey) 0.16666666666666666 5 6
    }

    @Test
    @Ignore // Since it requires web access
    public void testProcessWeb() throws Exception {
        TransportAPIImporter importer = new TransportAPIImporter();
        List<OrganicityEntity> entities = importer.process(this.getClass().getResource("/entityImport/TransportApiTrainStationsTest.json").getFile());

        assertEquals(2, entities.size());

        // Get Charing Cross Station
        OrganicityEntity entity = entities.stream().filter(w -> w.getId().equals("urn:oc:entity:london:transport:TransportAPI:CHX")).findFirst().get();

        assertEquals(2, entity.getAttributes().size());

        // Make sure that the performance indicator is a double
        Attribute performanceIndicator = entity.getAttributes().stream().filter(w -> w.getAttributeType() == OrganicityAttributeTypes.Types.TRANSPORT_SERVICE_PERFORMANCE).findFirst().get();
        assertTrue(Double.valueOf(performanceIndicator.getAttribute().getValue()) <= 1.0d);

        // Check source
        Attribute importTimeAttribute = entity.getAttributes().stream().filter(w -> w.getName().equals("origin")).findFirst().get();
        assertEquals("http://organicity.eu/cities/london/",importTimeAttribute.getValue());
    }

    @Test
    public void initialiseEntity() throws Exception {

    }

}