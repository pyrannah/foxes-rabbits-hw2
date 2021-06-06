package io.muic.ssc.hw2;

import io.muic.ssc.hw2.Observer.Observerable;
import io.muic.ssc.hw2.Observer.SimulatorViewChange;
import io.muic.ssc.hw2.view.SimulatorView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Simulator extends Observerable {

    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;


    // The probability that a rabbit will be created in any given position.
    // Lists of animals in the field.
    private List<Animal> animals;

    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    private static final Random RANDOM = new Random();


    public Simulator() {

        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    public Simulator(int depth, int width) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be >= zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        animals = new ArrayList<>();
        field = new Field(depth, width);

        view = new SimulatorView(depth, width);

//        AnimalType[] animalTypes = AnimalType.values();
        view.setColor(Rabbit.class, Color.yellow);
        view.setColor(Fox.class, Color.green);
        view.setColor(Tiger.class, Color.red);
        view.setColor(Hunter.class, Color.BLUE);

        SimulatorViewChange start = new SimulatorViewChange(view);
        addObserver2(start);






        // Setup a valid starting point.
        reset();
    }


    public void runLongSimulation() {

        simulate(4000);

    }

    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
            // delay(60);   // uncomment this to run more slowly
        }
    }


    public void simulateOneStep() {
        step++;

        // Provide space for newborn animals.
        List<Animal> newAnimals = new ArrayList<>();
        // Let all animal act
        for (Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if (!animal.isAlive()) {
                it.remove();
            }
        }


        // Add the newly born foxes and rabbits to the main lists.
        animals.addAll(newAnimals);

        view.showStatus(step, field);
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        step = 0;
        animals.clear();

        populate();
        // Show the starting state in the view.
        view.showStatus(step, field);



    }


    /**
     * Pause for a given time.
     *
     * @param millisec The time to pause for, in milliseconds
     */
    private void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ie) {
            // wake up
        }
    }

    private void populate() {
        FieldPopulator a = new FieldPopulator();
        a.populate(field,animals);



    }

}




