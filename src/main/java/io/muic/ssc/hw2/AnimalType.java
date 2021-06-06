package io.muic.ssc.hw2;

import java.awt.*;

public enum AnimalType {

    HUNTER(0.01, Hunter.class, Color.pink, 0),
    TIGER(0.02, Tiger.class,Color.red,18),
    FOX(0.08, Fox.class,Color.blue,10),
    RABBIT(0.18, Rabbit.class,Color.yellow,9);

    private double breedingProbabilty;

    private Class<? extends Animal> animalClass;

    private Color color;

    private int foodLevel;


    AnimalType(double breedingProbabilty, Class<? extends Animal> animalClass, Color color, int foodLevel){

        this.breedingProbabilty = breedingProbabilty;
        this.animalClass = animalClass;
        this.color = color;
        this.foodLevel = foodLevel;


    }

    public double getBreedingProbabilty(){

        return breedingProbabilty;
    }

public Class<? extends Animal> getAnimalClass(){

        return animalClass;
}

    public Color getColor() {

        return color;
    }

    public int getFoodLevel(){
        return foodLevel;
    }




}
