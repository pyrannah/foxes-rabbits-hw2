package io.muic.ssc.hw2;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {

    private static Map<AnimalType, Class<? extends Animal>> animalClassMap = new HashMap<>() {{
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getAnimalClass());
        }
    }};


    public static Animal createAnimal(Class<? extends Animal> animalClass, Field field, Location location) {

//        Class<? extends Animal> animalClass = animalClassMap.get(animalType);
        if (animalClass != null) {
            try {
                Animal animal = animalClass.getConstructor(boolean.class,Field.class,Location.class).newInstance(true, field, location);

                return animal;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

