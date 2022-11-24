package ui;

import data_access.DataAccessForTesting;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicView implements Observer<DataAccessForTesting, ViewIModel> {
    private String name;
    private JFrame viewFrame;
    private ViewIModel viewIModel;
    private List<DataAccessForTesting> observables = new ArrayList<>();

    @Override
    public List<DataAccessForTesting> getObservables() {
        return observables;
    }

    @Override
    public void setObservables(List<DataAccessForTesting> observables) {
        this.observables = observables;
        for (DataAccessForTesting observable : observables) {
            observable.addObserver(this);
        }

    }

    public void addObservable(DataAccessForTesting observable) {
        this.observables.add(observable);
        observable.addObserver(this);
    }

    @Override
    public void removeObservable(DataAccessForTesting observable) {
        this.observables.remove(observable);
        observable.removeObserver(this);
    }

    @Override
    public void update(ViewIModel viewModel) {
        this.viewIModel = viewModel;
    }

    public ViewIModel getViewIModel() {
        return viewIModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JFrame getViewFrame() {
        return viewFrame;
    }

    public void setViewFrame(JFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    public void setViewIModel(ViewIModel viewIModel) {
        this.viewIModel = viewIModel;
    }
}
