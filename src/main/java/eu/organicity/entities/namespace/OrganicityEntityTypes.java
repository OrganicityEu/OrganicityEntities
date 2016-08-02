package eu.organicity.entities.namespace;

public class OrganicityEntityTypes {
    static public enum EntityType {
        IOT_DEVICE("IotDevice", "urn:oc:entityType:iotdevice"),
        SMARTPHONE("smartphone", "urn:oc:entityType:smartphone"),
        DISTRICT_PROFILE("districtProfile", "urn:oc:entityType:districtProfile"),
        WEATHER_STATION("Weatherstation", "urn:oc:entityType:weatherstation"),
        // Transport
        TRAFFIC_STATS("trafficStats", "urn:oc:entityType:trafficstats"),
        TRANSPORT_STATION("TransportStation", "urn:oc:entityType:transportStation")
        ;

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
