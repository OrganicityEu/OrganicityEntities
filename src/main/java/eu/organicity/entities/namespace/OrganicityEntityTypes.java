package eu.organicity.entities.namespace;

public class OrganicityEntityTypes {
    static public enum EntityType {
        IOT_DEVICE("IotDevice", "urn:oc:entityType:iotdevice"),
        SMARTPHONE("smartphone", "urn:oc:entityType:smartphone"),
        BOROUGH("borough", "urn:oc:entityType:borough"),
        MANUAL_COUNTER("ManualCounter", "urn:oc:entityType:manualCounter"),
        WEATHER_STATION("Weatherstation", "urn:oc:entityType:weatherstation");

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
