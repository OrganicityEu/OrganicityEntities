package eu.organicity.entities.namespace;

public class OrganicityAttributeTypes {
    static public enum Types {

        //SENSING TYPES
        TEMPERATURE("temperature:ambient", "urn:oc:atributeType:temperature:ambient",OrganicityUnits.Units.DEGREE_CELSIUS,OrganicityDatatypes.DATATYPES.NUMERIC),
        ATMOSPHERIC_PRESSURE("atmosphericPressure", "urn:oc:atributeType:atmosphericPressure",OrganicityUnits.Units.BAR,OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_DIRECTION("windDirection", "urn:oc:atributeType:windDirection",OrganicityUnits.Units.DEGREE_CELSIUS,OrganicityDatatypes.DATATYPES.NUMERIC),
        SOUND_PRESSURE_LEVEL("soundPressureLevel:ambient", "urn:oc:atributeType:soundPressureLevel:ambient",OrganicityUnits.Units.DECIBEL,OrganicityDatatypes.DATATYPES.NUMERIC),
        WIND_SPEED("windSpeed", "urn:oc:attributeTypes:windSpeed",OrganicityUnits.Units.KILLOMETRE_PER_HOUR,OrganicityDatatypes.DATATYPES.NUMERIC),
        RELATIVE_HUMIDITY("relativeHumidity", "urn:oc:attributeTypes:relativeHumidity",OrganicityUnits.Units.PERCENT,OrganicityDatatypes.DATATYPES.NUMERIC),
        SOLAR_RADIATION("solarRadiation", "urn:oc:attributeTypes:solarRadiation",OrganicityUnits.Units.WATT_PER_SQUARE_METER,OrganicityDatatypes.DATATYPES.NUMERIC),
        RAINFALL("rainfall", "urn:oc:attributeTypes:rainfall",OrganicityUnits.Units.MILILITER_PER_HOUR,OrganicityDatatypes.DATATYPES.NUMERIC),
        BATTERY_LEVEL("batteryLevel", "urn:oc:attributeTypes:batteryLevel",OrganicityUnits.Units.PERCENT,OrganicityDatatypes.DATATYPES.NUMERIC),
        ILLUMINANCE("illuminance", "urn:oc:attributeTypes:illuminance",OrganicityUnits.Units.LUX,OrganicityDatatypes.DATATYPES.NUMERIC),
        DIRECTION_AZIMUTH("direction:azimuth", "urn:oc:attributeTypes:direction:azimuth",OrganicityUnits.Units.DEGREE_ANGLE,OrganicityDatatypes.DATATYPES.NUMERIC),
        POSITION("position", "urn:oc:attributeType:position",OrganicityUnits.Units.LAT_LONG_POSITION,OrganicityDatatypes.DATATYPES.STRING);

        private final String name;
        private final String urn;
        OrganicityUnits.Units uom;
        OrganicityDatatypes.DATATYPES type;

        private Types(String name, String urn, OrganicityUnits.Units uom,OrganicityDatatypes.DATATYPES type ) {
            this.name = name;
            this.urn = urn;
            this.uom = uom;
            this.type=type;
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
