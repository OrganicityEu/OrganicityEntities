package eu.organicity.entities.importers;

import com.amaxilatis.orion.model.Metadata;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import eu.organicity.entities.handler.attributes.Attribute;
import eu.organicity.entities.handler.attributes.Origin;
import eu.organicity.entities.handler.entities.OrganicityEntity;
import eu.organicity.entities.handler.entities.TransportStation;
import eu.organicity.entities.namespace.OrganicityAttributeTypes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Created by bsigurbjornsson on 13/06/2016.
 */
public class TransportAPIImporter implements OrganicityEntityImporter {

    private static final String STATION_FEED_URL_PREFIX = "http://fcc.transportapi.com/v3/uk/train/station/";
    private static final String STATION_FEED_URL_POSTFIX = "/live.json";
    private static final String STATION_FEED_PAGE="http://fcc.transportapi.com/v3/uk/train/stations/near.json?lat=51.507222&lon=-0.1275&page=";

    @Override
    public List<OrganicityEntity> process(String resourceFileName) throws Exception {
        JSONParser parser = new JSONParser();

        JSONObject stationsObject = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(resourceFileName)));
        JSONArray stations = (JSONArray) stationsObject.get("stations");

        List<OrganicityEntity> entities = new ArrayList<OrganicityEntity>();
        Iterator<JSONObject> stationIterator = stations.iterator();
        while (stationIterator.hasNext()) {

            JSONObject stationObject = stationIterator.next();
            String stationCode = (String) stationObject.get("station_code");

            // We interpret resourceFileName to be a station code
            String stationURI = STATION_FEED_URL_PREFIX + stationCode + STATION_FEED_URL_POSTFIX;

            URL stationURL = new URL(stationURI);

            JSONObject stationLiveObject = (JSONObject) parser.parse(new InputStreamReader(stationURL.openStream()));

            entities.addAll(process(stationObject, stationLiveObject));
        }
        return entities;
    }


    public List<OrganicityEntity> process(Integer page) throws Exception {

        HttpResponse<String> jsonResponse = Unirest.get(STATION_FEED_PAGE+page)
                .header("accept", "application/json")
                .asString();
        JSONParser parser = new JSONParser();

        JSONObject stationsObject = (JSONObject) parser.parse(jsonResponse.getBody());
        JSONArray stations = (JSONArray) stationsObject.get("stations");

        List<OrganicityEntity> entities = new ArrayList<OrganicityEntity>();
        Iterator<JSONObject> stationIterator = stations.iterator();
        while (stationIterator.hasNext()) {

            JSONObject stationObject = stationIterator.next();
            String stationCode = (String) stationObject.get("station_code");

            // We interpret resourceFileName to be a station code
            String stationURI = STATION_FEED_URL_PREFIX + stationCode + STATION_FEED_URL_POSTFIX;

            URL stationURL = new URL(stationURI);
            try {
                JSONObject stationLiveObject = (JSONObject) parser.parse(new InputStreamReader(stationURL.openStream()));
                entities.addAll(process(stationObject, stationLiveObject));
            }catch (Exception e){
                e.printStackTrace();

            }
        }
        return entities;
    }





    protected List<OrganicityEntity> process(JSONObject stationObject, JSONObject stationLiveObject) throws Exception {
        //System.err.println(stationObject.toJSONString());
        List<OrganicityEntity> entities = new ArrayList<OrganicityEntity>();

        int stationTotal = 0;   // Total departures for station
        int stationLate = 0;    // Number of late departures from station

        Map<String, Integer> serviceTotal = new HashMap<String,Integer>();  // Total number of departures for service
        Map<String, Integer> serviceLate = new HashMap<String,Integer>();   // Number of late departures for service

        JSONArray departures = (JSONArray)((JSONObject) stationLiveObject.get("departures")).get("all");
        Iterator<JSONObject> departureIterator = departures.iterator();
        while(departureIterator.hasNext()){
            JSONObject departure = departureIterator.next();

            //System.err.println(departure.toJSONString());

            String serviceId = (String) departure.get("service");
            String serviceDestination = (String) departure.get("destination_name");
            String serviceOperator = (String) departure.get("operator");
            String status = (String) departure.get("status");
            String serviceKey = serviceOperator + " train to " + serviceDestination; //+ " ("+serviceId+")";

            // Initialise service counters if needed
            if (!serviceLate.containsKey(serviceKey))
                serviceLate.put(serviceKey,0);
            if (!serviceTotal.containsKey(serviceKey))
                serviceTotal.put(serviceKey,0);

            // Update totals
            stationTotal++;
            serviceTotal.put(serviceKey, serviceTotal.get(serviceKey)+1);

            // Update lates
            if (status.equals("LATE")
                    || status.equals("OFF_ROUTE")
                    || status.equals("CANCELLED")){
                stationLate++;
                serviceLate.put(serviceKey, serviceLate.get(serviceKey)+1);
            }
        }

        String stationCode = (String) stationObject.get("station_code");
        String stationName = (String) stationObject.get("station_name");

        OrganicityEntity stationEntity = new TransportStation("urn:oc:entity:london:transport:TransportAPI:"+stationCode);
        Double latitude = (Double) stationObject.get("latitude");
        Double longitude = (Double) stationObject.get("longitude");
        stationEntity.setPosition(latitude, longitude);

        stationEntity.addAttribute(getOrigin());

        // Adding last update
        stationEntity.setTimestamp(new Date());

        // Add station status
        Attribute performanceIndicator = new Attribute(
                OrganicityAttributeTypes.Types.PERFORMANCE_INDICATOR,
                String.valueOf(getStatus(stationLate, stationTotal))
        );
        Metadata time = new Metadata("TimeInstant", "ISO8601", (String) stationLiveObject.get("request_time"));
        performanceIndicator.addMetadata(time);
        stationEntity.addAttribute(performanceIndicator);

        entities.add(stationEntity);


        // Add service status
        // FIXME: Maybe implement this at some point
        /*
        for (String serviceId: serviceTotal.keySet()){
            System.err.println(
                    "Service status: "
                            + serviceId
                            + " "
                            + getStatus(serviceLate.get(serviceId), serviceTotal.get(serviceId))
                            + " "
                            + serviceLate.get(serviceId)
                            + " "
                            + serviceTotal.get(serviceId)
            );
        }
        */

        return entities;
    }

    @Override
    public OrganicityEntity initialiseEntity(String id) {
        return null;
    }

    @Override
    public Origin getOrigin() {
        List<String> urls = new ArrayList<>();
        urls.add("http://fcc.transportapi.com/");
        return new Origin("Train station performance indicators from the TransportAPI",
                urls);
    }

    public double getStatus(int late, int total){
        return (double)(total - late)/(double)total;
    }
}
