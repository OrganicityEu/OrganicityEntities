package eu.organicity.entities.namespace;

public class OrganicityEntityTypes {
    static public enum EntityType {
        IOT_DEVICE("IotDevice", "urn:oc:entityType:iotdevice"),
        BUS_STOP("BusStop", "urn:oc:entityType:busStop"),
        SMARTPHONE("smartphone", "urn:oc:entityType:smartphone"),
        BIKE_STATION("bikeStation", "urn:oc:entitytype:bikeStation"),
        BOROUGH("borough", "urn:oc:entityType:borough"),
        MANUAL_COUNTER("ManualCounter", "urn:oc:entityType:manualCounter"),
        DISTRICT_PROFILE("districtProfile", "urn:oc:entityType:districtProfile"),
        WEATHER_STATION("Weatherstation", "urn:oc:entityType:weatherstation"),
        // Transport
        TRAFFIC_STATS("trafficStats", "urn:oc:entityType:trafficstats"),
        TRANSPORT_STATION("TransportStation", "urn:oc:entityType:transportStation");

        private final String name;
        private final String urn;

          EntityType(String name, String urn) {
            this.name = name;
            this.urn = urn;
        }

        public String getName() {
            return name;
        }

        public String getUrn() {
            return urn;
        }

        static public EntityType byUrn(String urn) {
            for (EntityType i : EntityType.values()) {
                if (i.getUrn().equals(urn)) return i;
            }
            return null;
        }
    }
}
