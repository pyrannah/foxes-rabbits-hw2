package io.muic.ssc.hw2.Observer;

import io.muic.ssc.hw2.Field;

import java.util.ArrayList;
import java.util.List;

public abstract class Observerable {

    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver2(Observer view){

        observers.add(view);

    }

    public void notifyAllObservers(int step, Field field){
        for (Observer observer : observers) {
            observer.update(step,field);
        }
    }


}
