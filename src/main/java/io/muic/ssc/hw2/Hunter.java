package io.muic.ssc.hw2;

import java.util.*;
import java.util.Random;

public class Hunter extends Animal{


    // This character can't die (immortal)
    // This hunter can kill Tiger, Fox, Rabbit

    private static final Random RANDOM = new Random();
    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    public Hunter(boolean bo, Field field, Location location){
        super(bo,field,location);

    }

    @Override
    protected Location moveToNewLocation() {

        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    private Location findFood() {

        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Animal) {
                Animal animal1 = (Animal) animal;
                if (animal1.isAlive()) {
                    animal1.setDead();
                    return where;
                }

                }
        }
        return null;
    }

    @Override
    public void act(List<Animal> newAnimals) {
        Location newLocation = getLocation();
        if (newLocation != null) {
            setLocation(newLocation);
        }
    }

    @Override
    protected int getMaxAge() {
        return 35;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.HUNTER.getBreedingProbabilty();
    }

    @Override
    protected int getMaxLitterSize() {
        return 1; // The number of maximum
    }

    @Override
    protected int getBreedingAge() {
        return Integer.MAX_VALUE; // hunter never die
    }
}
