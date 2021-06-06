package io.muic.ssc.hw2.Observer;

import io.muic.ssc.hw2.Field;
import io.muic.ssc.hw2.view.SimulatorView;

public class SimulatorViewChange implements Observer{

    private SimulatorView simulatorView;

    public SimulatorViewChange(SimulatorView simulatorView) {
        this.simulatorView = simulatorView;
    }

    @Override
    public void update(int step, Field field) {
        simulatorView.showStatus(step, field);
    }
}

