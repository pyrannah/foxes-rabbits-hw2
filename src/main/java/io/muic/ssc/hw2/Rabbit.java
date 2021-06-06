package io.muic.ssc.hw2;


public class Rabbit extends Animal {





    public Rabbit(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }
    // Characteristics shared by all rabbits (class variables).

    @Override
    protected Location moveToNewLocation() {
        return field.freeAdjacentLocation(getLocation());
    }


    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     */


    @Override
    protected double getBreedingProbability() {
        return AnimalType.RABBIT.getBreedingProbabilty();
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }



}
