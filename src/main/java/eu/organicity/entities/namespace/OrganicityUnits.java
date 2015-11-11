package eu.organicity.entities.namespace;

public class OrganicityUnits {
    static public enum Units {
        VOLTS("volts", "urn:oc:uom:volts"),
        PPM("ppm", "urn:oc:uom:ppm"),
        METRE("metre", "urn:oc:uom:metre"),
        KGR("kilogram", "urn:oc:uom:kilogram"),
        BAR("bar", "urn:oc:uom:bar"),
        CENTIBAR("centibar", "urn:oc:uom:centibar"),
        DECIBEL("decibel", "urn:oc:uom:decibel"),
        DEGREE_ANGLE("degreeAngle", "urn:oc:uom:degreeAngle"),
        DEGREE_CELSIUS("degreeCelsius", "urn:oc:uom:degreeCelsius"),
        INDEX("index", "urn:oc:uom:index"),
        KILOMETRE("kilometre", "urn:oc:uom:kilometre"),
        KILLOMETRE_PER_HOUR("kilometrePerHour", "urn:oc:uom:kilometrePerHour"),
        LITRE("litre", "urn:oc:uom:litre"),
        LITRE_PER_100_KILOMETERS("litrePer100Kilometers", "urn:oc:uom:litrePer100Kilometers"),
        LUX("lux", "urn:oc:uom:lux"),
        METRE_PER_SECOND("metrePerSecond", "urn:oc:uom:metrePerSecond"),
        MILIGRAM_PER_CUBIC_METRE("miligramPerCubicMetre", "urn:oc:uom:miligramPerCubicMetre"),
        MICROGRAM_PER_CUBIC_METRE("microgramPerCubicMetre", "urn:oc:uom:microgramPerCubicMetre"),
        MILILITER_PER_HOUR("mililiterPerHour", "urn:oc:uom:mililiterPerHour"),
        MILIVOLT_PER_METRE("milivoltPerMetre", "urn:oc:uom:milivoltPerMetre"),
        PERCENT("percent", "urn:oc:uom:percent"),
        REVOLUTION_PER_MINUTE("revolutionPerMinute", "urn:oc:uom:revolutionPerMinute"),
        SCALE("scale", "urn:oc:uom:scale"),
        VEHICLE_PER_MINUTE("vehiclePerMinute", "urn:oc:uom:vehiclePerMinute"),
        WATT_PER_SQUARE_METER("wattPerSquareMeter", "urn:oc:uom:wattPerSquareMeter"),
        LAT_LONG_POSITION("coords", "coords"),
        NOT_APPLIED("NOT APPLIED", "NOT APPLIED");


        private final String name;
        private final String urn;

        private Units(String name, String urn) {
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
