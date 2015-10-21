package eu.organicity.entities.namespace;


public class OrganicityDatatypes {
    static public enum DATATYPES {
        NUMERIC("numeric", "urn:oc:datatype:numeric"),
        STRING("string", "urn:oc:datatype:string"),
        BOOLEAN("boolean", "urn:oc:datatype:boolean"),
        COORDINATES("coordinates", "urn:oc:datatype:coordinates"),
        DATETIME("datetime", "urn:oc:datatype:iso8691");

        private final String name;
        private final String urn;

        private DATATYPES(String name, String urn) {
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
