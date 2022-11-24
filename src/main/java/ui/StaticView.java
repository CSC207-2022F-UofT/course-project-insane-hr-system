package ui;

import javax.swing.*;

public class StaticView {
    private String name;
    private JFrame viewFrame;
    private ViewIModel viewModel;

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

    public ViewIModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewIModel viewModel) {
        this.viewModel = viewModel;
    }
}
