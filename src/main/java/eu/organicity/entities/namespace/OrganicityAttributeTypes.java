package eu.organicity.entities.namespace;

public class OrganicityAttributeTypes {
    static public enum Types {

        //SENSING TYPES
        TEMPERATURE("temperature:ambient", "urn:oc:atributeType:temperature:ambient", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
        ATMOSPHERIC_PRESSURE("atmosphericPressure", "urn:oc:atributeType:atmosphericPressure", OrganicityUnits.Units.BAR, OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_DIRECTION("windDirection", "urn:oc:atributeType:windDirection", OrganicityUnits.Units.DEGREE_CELSIUS, OrganicityDatatypes.DATATYPES.NUMERIC),
        SOUND_PRESSURE_LEVEL("soundPressureLevel:ambient", "urn:oc:atributeType:soundPressureLevel:ambient", OrganicityUnits.Units.DECIBEL, OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_SPEED("windSpeed", "urn:oc:attributeType:windSpeed", OrganicityUnits.Units.KILLOMETRE_PER_HOUR, OrganicityDatatypes.DATATYPES.NUMERIC),
        RELATIVE_HUMIDITY("relativeHumidity", "urn:oc:attributeType:relativeHumidity", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        SOLAR_RADIATION("solarRadiation", "urn:oc:attributeType:solarRadiation", OrganicityUnits.Units.WATT_PER_SQUARE_METER, OrganicityDatatypes.DATATYPES.NUMERIC),
        RAINFALL("rainfall", "urn:oc:attributeType:rainfall", OrganicityUnits.Units.MILILITER_PER_HOUR, OrganicityDatatypes.DATATYPES.NUMERIC),
        BATTERY_LEVEL("batteryLevel", "urn:oc:attributeType:batteryLevel", OrganicityUnits.Units.PERCENT, OrganicityDatatypes.DATATYPES.NUMERIC),
        ILLUMINANCE("illuminance", "urn:oc:attributeType:illuminance", OrganicityUnits.Units.LUX, OrganicityDatatypes.DATATYPES.NUMERIC),
        DIRECTION_AZIMUTH("direction:azimuth", "urn:oc:attributeType:direction:azimuth", OrganicityUnits.Units.DEGREE_ANGLE, OrganicityDatatypes.DATATYPES.NUMERIC),
        POSITION("position", "urn:oc:attributeType:position", OrganicityUnits.Units.LAT_LONG_POSITION, OrganicityDatatypes.DATATYPES.STRING),
        CARBON_MONOXIDE("chemicalAgentAtmosphericConcentration:CO", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:CO", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        NITROGEN_DIOXIDE("chemicalAgentAtmosphericConcentration:NO2", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:NO2", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        SULPHUR_DIOXIDE("chemicalAgentAtmosphericConcentration:SO2", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:SO2", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        OXYGEN_CONCENTRATION("chemicalAgentAtmosphericConcentration:O3", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:O3", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        NITROGEN_OXIDE("chemicalAgentAtmosphericConcentration:NO", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:NO", OrganicityUnits.Units.MICROGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),

        PARTICLES("chemicalAgentAtmosphericConcentration:airParticles", "urn:oc:attributeType:chemicalAgentAtmosphericConcentration:airParticles", OrganicityUnits.Units.MILIGRAM_PER_CUBIC_METRE, OrganicityDatatypes.DATATYPES.NUMERIC),
        DESCRIPTION("description", "urn:oc:attributeType:description", OrganicityUnits.Units.NOT_APPLIED, OrganicityDatatypes.DATATYPES.STRING);

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
    }
}
