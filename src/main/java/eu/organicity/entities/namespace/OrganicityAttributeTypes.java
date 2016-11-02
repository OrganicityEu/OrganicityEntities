package eu.organicity.entities.namespace;

public class OrganicityAttributeTypes {
    static public enum Types {

        //SENSING TYPES
        TEMPERATURE("temperature:ambient", "urn:oc:attributeType:temperature:ambient", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
        ATMOSPHERIC_PRESSURE("atmosphericPressure", "urn:oc:attributeType:atmosphericPressure", OrganicityUnits.Units.MBAR, OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_DIRECTION("windDirection", "urn:oc:attributeType:windDirection", OrganicityUnits.Units.DEGREE_ANGLE, OrganicityDatatypes.DATATYPES.NUMERIC),
        SOUND_PRESSURE_LEVEL("soundPressureLevel:ambient", "urn:oc:attributeType:soundPressureLevel:ambient", OrganicityUnits.Units.DECIBEL, OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_SPEED("windSpeed", "urn:oc:attributeType:windSpeed", OrganicityUnits.Units.KILLOMETRE_PER_HOUR, OrganicityDatatypes.DATATYPES.NUMERIC),
        RELATIVE_HUMIDITY("relativeHumidity", "urn:oc:attributeType:relativeHumidity", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        SOLAR_RADIATION("solarRadiation", "urn:oc:attributeType:solarRadiation", OrganicityUnits.Units.WATT_PER_SQUARE_METER, OrganicityDatatypes.DATATYPES.NUMERIC),
        RAINFALL("rainfall", "urn:oc:attributeType:rainfall", OrganicityUnits.Units.MILILITER_PER_HOUR, OrganicityDatatypes.DATATYPES.NUMERIC),
        BATTERY_LEVEL("batteryLevel", "urn:oc:attributeType:batteryLevel", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        BATTERY_VOLTAGE("batteryVoltage", "urn:oc:attributeType:batteryVoltage", OrganicityUnits.Units.VOLTS, OrganicityDatatypes.DATATYPES.NUMERIC),
        ILLUMINANCE("illuminance", "urn:oc:attributeType:illuminance", OrganicityUnits.Units.LUX, OrganicityDatatypes.DATATYPES.NUMERIC),
        DIRECTION_AZIMUTH("direction:azimuth", "urn:oc:attributeType:direction:azimuth", OrganicityUnits.Units.DEGREE_ANGLE, OrganicityDatatypes.DATATYPES.NUMERIC),
        CARBON_MONOXIDE("chemicalAgentAtmosphericConcentration:CO", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:CO", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        NITROGEN_DIOXIDE("chemicalAgentAtmosphericConcentration:NO2", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:NO2", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        SULPHUR_DIOXIDE("chemicalAgentAtmosphericConcentration:SO2", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:SO2", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        OXYGEN_CONCENTRATION("chemicalAgentAtmosphericConcentration:O3", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:O3", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        NITROGEN_OXIDE("chemicalAgentAtmosphericConcentration:NO", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:NO", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        METHANE("chemicalAgentAtmosphericConcentration:CH4", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:CH4", OrganicityUnits.Units.PPM, OrganicityDatatypes.DATATYPES.NUMERIC),
        LPG("chemicalAgentAtmosphericConcentration:LPG", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:LPG", OrganicityUnits.Units.PPM, OrganicityDatatypes.DATATYPES.NUMERIC),
        DEVICE_TEMPERATURE("temperature:device", "urn:oc:attributeType:temperature:device", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
        PARTICLES("chemicalAgentAtmosphericConcentration:airParticles", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:airParticles", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        PARTICLES10("chemicalAgentAtmosphericConcentration:airParticlesPM10", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:airParticlesPM10", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        PARTICLES25("chemicalAgentAtmosphericConcentration:airParticlesPM25", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:airParticlesPM25", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        ELECTRICAL_CURRENT("electricalCurrent", "urn:oc:attributeType:electricalCurrent", OrganicityUnits.Units.AMPERE, OrganicityDatatypes.DATATYPES.NUMERIC),
        POWER_CONSUMPTION("powerConsumption", "urn:oc:attributeType:powerConsumption", OrganicityUnits.Units.KWH, OrganicityDatatypes.DATATYPES.NUMERIC),
        FREE_BIKES("freeBikes", "urn:oc:attributeType:freeBikes", OrganicityUnits.Units.BIKE, OrganicityDatatypes.DATATYPES.NUMERIC),
        FREE_SPACES("freeSpaces", "urn:oc:attributeType:freeSpaces", OrganicityUnits.Units.BIKE, OrganicityDatatypes.DATATYPES.NUMERIC),

        // Boroughs
        POPULATION_DENSITY("populationDensity", "urn:oc:attributeType:populationDensity", OrganicityUnits.Units.PEOPLE_PER_HECTARE, OrganicityDatatypes.DATATYPES.NUMERIC),
        HOUSEHOLD_INCOME("householdIncome", "urn:oc:attributeType:householdIncome", OrganicityUnits.Units.MONETARY_VALUE_POUNDS, OrganicityDatatypes.DATATYPES.NUMERIC),
        MEDIAN_HOUSE_PRICE("housePrice", "urn:oc:attributeType:housePrice", OrganicityUnits.Units.MONETARY_VALUE_POUNDS, OrganicityDatatypes.DATATYPES.NUMERIC),
        PROPORTION_GREENSPACE("greenspace", "urn:oc:attributeType:greenspace", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        CARBON_EMISSION("carbonEmission", "urn:oc:attributeType:carbonEmission", OrganicityUnits.Units.KILOTONNE, OrganicityDatatypes.DATATYPES.NUMERIC),
        CARS_PER_HOUSEHOLD("householdCarOwnership", "urn:oc:attributeType:householdCarOwnership", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        WALK_5X_WEEK("walkingFrequency", "urn:oc:attributeType:walkingFrequency", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        CYCLE_1X_WEEK("cyclingFrequency", "urn:oc:attributeType:cyclingFrequency", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        PROPORTION_OBESE("obesity", "urn:oc:attributeType:obesity", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),

        // Manual traffic counts
        TRAFFIC_INTENSITY_BICYCLE("trafficIntensity:bicycle", "urn:oc:attributeType:trafficIntensity:bicycle", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),
        TRAFFIC_INTENSITY_MOTORCYCLE("trafficIntensity:motorcycle", "urn:oc:attributeType:trafficIntensity:motorcycle", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),
        TRAFFIC_INTENSITY_CAR("trafficIntensity:car", "urn:oc:attributeType:trafficIntensity:car", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),
        TRAFFIC_INTENSITY_BUS("trafficIntensity:bus", "urn:oc:attributeType:trafficIntensity:bus", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),
        TRAFFIC_INTENSITY_LGV("trafficIntensity:lightGoodsVehicle", "urn:oc:attributeType:trafficIntensity:lightGoodsVehicle", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),
        TRAFFIC_INTENSITY_HGV("trafficIntensity:heavyGoodsVehicle", "urn:oc:attributeType:trafficIntensity:heavyGoodsVehicle", OrganicityUnits.Units.VEHICLE_PER_DAY, OrganicityDatatypes.DATATYPES.NUMERIC),

        // Transport stations
        TRANSPORT_SERVICE_PERFORMANCE("transportServicePerformance", "urn:oc:attributeType:transportServicePerformance", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),

        //Other Attributes
        DESCRIPTION("description", "urn:oc:attributeType:description", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING),
        AREA("area", "urn:oc:attributeType:area", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING),
        POSITION("position", "urn:oc:attributeType:position", OrganicityUnits.Units.LAT_LONG_POSITION, OrganicityDatatypes.DATATYPES.STRING),
        LOCATION("location", "geo:point", OrganicityUnits.Units.LONG_LAT_POSITION, OrganicityDatatypes.DATATYPES.STRING),
        COMMENTS("comments", "urn:oc:attributeType:comments", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.URL),
        RANKING("ranking", "urn:oc:attributeType:ranking", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.NUMERIC),
        ORIGIN("origin", "urn:oc:attributeType:origin", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING),
        DATASOURCE("datasource", "urn:oc:attributeType:datasource", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.URL),;

        private final String name;
        private final String urn;
        OrganicityUnits.Units uom;
        OrganicityDatatypes.DATATYPES type;

        private Types(String name, String urn, OrganicityUnits.Units uom, OrganicityDatatypes.DATATYPES type) {
            this.name = name;
            this.urn = urn;
            this.uom = uom;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getUrn() {
            return urn;
        }

        public OrganicityUnits.Units getUom() {
            return uom;
        }

        public OrganicityDatatypes.DATATYPES getType() {
            return type;
        }

        public static Types getAttibuteType(String urn) {
            for (Types entry : Types.values()) {
                if (entry.getUrn().equals(urn)) return entry;
            }
            return null;
        }
    }
}
