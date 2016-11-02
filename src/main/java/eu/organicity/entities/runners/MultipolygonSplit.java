package eu.organicity.entities.runners;

import eu.organicity.entities.handler.converters.AssetToJsonObject;
import org.geojson.LngLatAlt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by etheodor on 15/08/2016.
 */
public class MultipolygonSplit {


    public static void main(String[] args){
        List<LngLatAlt> rings=new ArrayList<>();
        rings.add(new LngLatAlt(1,1));
        rings.add(new LngLatAlt(2,2));
        rings.add(new LngLatAlt(3,3));
        rings.add(new LngLatAlt(1,1));
        rings.add(new LngLatAlt(3,3));
        rings.add(new LngLatAlt(4,4));
        rings.add(new LngLatAlt(1,1));
        List<List<LngLatAlt>> l =AssetToJsonObject.polygonToComponentPolygon(rings);
        for (List<LngLatAlt> poly: l){
            System.out.println(Arrays.toString(poly.toArray()));
            System.out.println("---");
        }

    }
}
