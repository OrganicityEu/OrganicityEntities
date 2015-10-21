package oc.namespace;

public class OrganicityEntityTypes {
    static public enum EntityType {
        IOT_DEVICE("IotDevice", "urn:oc:entitytype:iotdevice"),
        SMARTPHONE("smartphone", "urn:oc:entitytype:smartphone");

        private final String name;
        private final String urn;
        private EntityType(String name, String urn) {
            this.name = name;
            this.urn = urn;
        }
        public String getName() {
            return name;
        }
        public String getUrn() {
            return urn;
        }
    }


}
