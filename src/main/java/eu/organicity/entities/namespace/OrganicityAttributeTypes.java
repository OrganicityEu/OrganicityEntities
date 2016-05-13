package eu.organicity.entities.namespace;

public class OrganicityAttributeTypes {
    static public enum Types {

        //SENSING TYPES
        TEMPERATURE("temperature:ambient", "urn:oc:attributeType:temperature:ambient", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
        ATMOSPHERIC_PRESSURE("atmosphericPressure", "urn:oc:attributeType:atmosphericPressure", OrganicityUnits.Units.MBAR, OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_DIRECTION("windDirection", "urn:oc:attributeType:windDirection", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
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

        // Boroughs
        POPULATION_DENSITY("boroughProfile:populationDensity", "urn:oc:attributeType:boroughProfile:populationDensity", OrganicityUnits.Units.POPULATION_DENSITY, OrganicityDatatypes.DATATYPES.NUMERIC),
        HOUSEHOLD_INCOME("boroughProfile:householdIncome", "urn:oc:attributeType:boroughProfile:householdIncome", OrganicityUnits.Units.MONETARY_VALUE_POUNDS, OrganicityDatatypes.DATATYPES.NUMERIC),
        MEDIAN_HOUSE_PRICE("boroughProfile:medianHousePrice", "urn:oc:attributeType:boroughProfile:medianHousePrice", OrganicityUnits.Units.MONETARY_VALUE_POUNDS, OrganicityDatatypes.DATATYPES.NUMERIC),
        FRACTION_GREENSPACE("boroughProfile:fractionGreenspace", "urn:oc:attributeType:boroughProfile:fractionGreenspace", OrganicityUnits.Units.FRACTION, OrganicityDatatypes.DATATYPES.NUMERIC),
        CARBON_EMISSION("boroughProfile:carbonEmission", "urn:oc:attributeType:boroughProfile:carbonEmission", OrganicityUnits.Units.KILOTONNE, OrganicityDatatypes.DATATYPES.NUMERIC),
        CARS_PER_HOUSEHOLD("boroughProfile:carsPerHousehold", "urn:oc:attributeType:boroughProfile:carsPerHousehold", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        WALK_5X_WEEK("boroughProfile:walk5xWeek", "urn:oc:attributeType:boroughProfile:walk5xWeek", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        CYCLE_1X_WEEK("boroughProfile:cycle1xWeek", "urn:oc:attributeType:boroughProfile:cycle1xWeek", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        FRACTION_OBESE("boroughProfile:fractionObese", "urn:oc:attributeType:boroughProfile:fractionObese", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),

        // Manual traffic counts
        DAILY_PEDAL_CYCLE_COUNT("trafficCount:dailyPedalCycleCount", "urn:oc:attributeType:trafficCount:dailyPedalCycleCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        DAILY_MOTORCYCLE_COUNT("trafficCount:dailyMotorcycleCount", "urn:oc:attributeType:trafficCount:dailyMotorcycleCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        DAILY_CAR_TAXI_COUNT("trafficCount:dailyCarTaxiCount", "urn:oc:attributeType:trafficCount:dailyCarTaxiCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        DAILY_BUS_COACH_COUNT("trafficCount:dailyBusCoachCount", "urn:oc:attributeType:trafficCount:dailyBusCoachCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        DAILY_LIGHT_GOODS_VEHICLE_COUNT("trafficCount:dailyLightGoodsVehicleCount", "urn:oc:attributeType:trafficCount:dailyLightGoodsVehicleCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),
        DAILY_HEAVY_GOODS_VEHICLE_COUNT("trafficCount:dailyHeavyGoodsVehicleCount", "urn:oc:attributeType:trafficCount:dailyHeavyGoodsVehicleCount", OrganicityUnits.Units.COUNT, OrganicityDatatypes.DATATYPES.NUMERIC),

        //Other Attributes
        DESCRIPTION("description", "urn:oc:attributeType:description", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING),
        AREA("area", "urn:oc:attributeType:area", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING),
        POSITION("position", "urn:oc:attributeType:position", OrganicityUnits.Units.LAT_LONG_POSITION, OrganicityDatatypes.DATATYPES.STRING),
        COMMENTS("comments", "urn:oc:attributeType:comments", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.URL),
        RANKING("ranking", "urn:oc:attributeType:ranking", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.NUMERIC),
        ORIGIN("origin", "urn:oc:attributeType:origin", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.URL),
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
