
import com.amaxilatis.orion.OrionClient;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Position;
import eu.organicity.entities.handler.entities.IoTDevice;
import eu.organicity.entities.handler.metadata.Datatype;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import eu.organicity.entities.namespace.OrganicityDatatypes;
import eu.organicity.entities.namespace.OrganicityEntityTypes;
import eu.organicity.entities.namespace.OrganicityUnits;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(OrganicityDatatypes.DATATYPES.NUMERIC.getUrn());
        System.out.println(OrganicityUnits.Units.METRE.getUrn());
        System.out.println(OrganicityAttributeTypes.Types.TEMPERATURE.getUrn());

        System.out.println(OrganicityAttributeTypes.Types.BATTERY_LEVEL.getUrn());
        System.out.println(OrganicityEntityTypes.EntityType.IOT_DEVICE.getUrn());

        IoTDevice iot = new IoTDevice("1123");
        Attribute a = new Attribute(OrganicityAttributeTypes.Types.BATTERY_LEVEL, "90%");
        Datatype dm = new Datatype(OrganicityDatatypes.DATATYPES.NUMERIC);
        a.addMetadata(dm);
        iot.addAttribute(a);
        Position p = new Position("1.1, 3.1");
        iot.addAttribute(p);


        iot.setTimestamp(new Date());


        System.out.println(iot.toString());


        String serverUrl = "http://orion.lab.fi-ware.org:1026/";
        String token = "#your token here#";
        OrionClient client = new OrionClient(serverUrl, "");

    }
}
