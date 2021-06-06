package io.muic.ssc.hw2;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal {
    // Characteristics shared by all foxes (class variables).
    private static final int RABBIT_FOOD_VALUE = 9;
    private static final Random RANDOM = new Random();



    // The Tiger's food level, which is increased by eating Fox.
    private int foodLevel;

    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *  @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Tiger(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
        foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE);
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;

    }

    @Override
    public void act(List<Animal> newAnimals) {

        incrementHunger();
        super.act(newAnimals);
    }
    /**
     * Make this Tiger more hungry. This could result in the Tiger's death.
     */
    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit. setDead();
                    foodLevel = AnimalType.RABBIT.getFoodLevel();;
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = AnimalType.FOX.getFoodLevel();
                    return where;
                }
            }
        }
        return null;

        }



    @Override
    public int getMaxAge() {
        return 200;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.TIGER.getBreedingProbabilty();
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 30;
    }


}