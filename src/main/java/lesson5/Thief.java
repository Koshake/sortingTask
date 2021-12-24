package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Thief {

    private List<Thing> things;

    private double maxWeight;

    private double maxPrice;

    public Thief(double weight) {
        maxWeight = weight;
    }

    public List<Thing> getThings(List<Thing> thingsList) {
        canTake(thingsList);
        return things;
    }

    private void canTake(List<Thing> thingsList) {
        if (thingsList.size() > 0) {
            checkBest(thingsList);
        }

        for (int i = 0; i < thingsList.size(); i++) {
            List<Thing> newSet = new ArrayList<Thing>(thingsList);

            newSet.remove(i);

            //System.out.println(thingsList);
            canTake(newSet);
        }
    }

    private double sumWeight(List<Thing> thingsList) {
        double sumWeight = 0;
        for (Thing thing : thingsList) {
            sumWeight += thing.weight;
        }
        return sumWeight;
    }

    private double sumPrice(List<Thing> thingsList) {
        double sum = 0;
        for (Thing thing : thingsList) {
            sum += thing.price;
        }
        return sum;
    }

    private void checkBest(List<Thing> thingsList) {
        if (things == null) {
            if (sumWeight(thingsList) <= maxWeight) {
                things = thingsList;
                maxPrice = sumPrice(thingsList);
            }
        } else if (
                sumWeight(thingsList) <= maxWeight
                        && sumPrice(thingsList) > maxPrice) {
            things = thingsList;
            maxPrice = sumPrice(thingsList);
        }
    }
}
