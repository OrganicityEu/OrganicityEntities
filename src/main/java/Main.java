
import com.amaxilatis.orion.OrionClient;
import oc.entityhandlers.attributes.Attribute;
import oc.entityhandlers.attributes.Position;
import oc.entityhandlers.entities.IoTDevice;
import oc.entityhandlers.metadata.Datatype;
import oc.namespace.OrganicityAttributeTypes;
import oc.namespace.OrganicityDatatypes;
import oc.namespace.OrganicityEntityTypes;
import oc.namespace.OrganicityUnits;

public class Main {

    public static void main(String[] args) {
        System.out.println(oc.namespace.OrganicityDatatypes.DATATYPES.NUMERIC.getUrn());
        System.out.println(OrganicityUnits.Units.METRE.getUrn());
        System.out.println(OrganicityAttributeTypes.Types.TEMPERATURE.getUrn());

        System.out.println(OrganicityAttributeTypes.Types.BATTERY_LEVEL.getUrn());
        System.out.println(OrganicityEntityTypes.EntityType.IOT_DEVICE.getUrn());

        IoTDevice iot=new IoTDevice("1123");
        Attribute a=new Attribute(OrganicityAttributeTypes.Types.BATTERY_LEVEL,"90%");
        Datatype dm=new Datatype(OrganicityDatatypes.DATATYPES.NUMERIC);
        a.addMetadata(dm);
        iot.addAttribute(a);
        Position p=new Position("1.1,3.1");
        iot.addAttribute(p);

        System.out.println(iot.toString());


        String serverUrl="http://orion.lab.fi-ware.org:1026/";
        String token="#your token here#";
        OrionClient client = new OrionClient(serverUrl, "");

    }
}
