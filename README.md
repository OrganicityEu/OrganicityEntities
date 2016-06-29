# OrganicityEntities
Java library to handle Organicity Entities and Organicity Namespaces


This library has a dependency on https://github.com/amaxilat/orion-client

## Creating an Entity using the Organcity Ontologies  
Organicity offer two types of entities. The IoT devices using the 'IoTDevice' class and the Smartphone devices using the 'SmartphoneDevice' class.

    final SmartphoneDevice phoneEntity = new SmartphoneDevice(uri);
    final IoTDevice iotEntity = new IoTDevice(uri);
    
## Adding Static Information 
Static information like the location of the device and timestamp of the measurement are set using the 'set*' methods available. For example using the following we set the location and the time of the measurements:

    phoneEntity.setTimestamp(new Date());
    phoneEntity.setPosition(latitude, longitude);

## Adding Sensor Measurements
To add sensor measurements and their required metadata (type, unit of measurement, datatype) we use the following code:

    Attribute a = new Attribute(OrganicityAttributeTypes.Types.SOUND_PRESSURE_LEVEL,String.valueOf(soundMeasurement));
    Datatype dm = new Datatype(OrganicityDatatypes.DATATYPES.NUMERIC);
    a.addMetadata(dm);
    phoneEntity.addAttribute(a);


    Attribute a = new Attribute(OrganicityAttributeTypes.Types.ILLUMINANCE, String.valueOf(illuminanceMeasurement));
    Datatype dm = new Datatype(OrganicityDatatypes.DATATYPES.NUMERIC);
    a.addMetadata(dm);
    phoneEntity.addAttribute(a);

## Publishing an Organicity Entity to an Orion Context Broker
To publish sensor information on an Orion Context Broker you need to generate from the Entity object you created before the OrionContextElement and then post it using an instance of the OrionClient.

    orionClient.postContextEntity(uri, phoneEntity.getContextElement());


## Usage

To use this library you need to include in your maven project the following repository:

    <repositories>
        <repository>
            <id>organicity</id>
            <url>https://maven.organicity.eu/content/repositories/snapshots</url>
        </repository>
    </repositories>

And also the following dependency:

    <dependency>
        <groupId>eu.organicity</groupId>
        <artifactId>entities</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
