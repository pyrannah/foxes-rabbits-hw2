package io.muic.ssc.hw2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    private static final Random RANDOM = new Random();

    private Map<AnimalType, Double> probabilityMap = new HashMap<>() {{
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0 ; i < animalTypes.length; i++){
            put(animalTypes[i],animalTypes[i].getBreedingProbabilty());
        }

    }};

    public void populate(Field field, List<Animal> animals) {
        field.clear(); //start of simulation clear field
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (AnimalType animalType : AnimalType.values()){
                     if (RANDOM.nextDouble() <= animalType.getBreedingProbabilty()){
                        Location location = new Location(row, col);
                        Animal animal = AnimalFactory.createAnimal(animalType.getAnimalClass(), field, location);
                        animals.add(animal);
                        break;
                    }
                }
            }
        }
    }
}

