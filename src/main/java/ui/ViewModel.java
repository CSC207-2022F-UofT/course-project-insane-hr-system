package ui;

import javax.swing.*;
import java.util.List;

public class ViewModel implements ViewIModel {
    private List<DynamicView> views;
    private String frameName;
    private String title;
    private String intro;
    private JList<String> leftList;
    private JList<String> rightList;
    private JPanel leftPanel;
    private JPanel rightPanel;

    @Override
    public JList<String> getLeftList() {
        return leftList;
    }
    @Override
    public void setLeftList(JList<String> leftList) {
        this.leftList = leftList;
    }
    @Override
    public JList<String> getRightList() {
        return rightList;
    }
    @Override
    public void setRightList(JList<String> rightList) {
        this.rightList = rightList;
    }

    @Override
    public List<DynamicView> getViews() {
        return views;
    }

    @Override
    public void setViews(List<DynamicView> views) {
        this.views = views;
    }

    @Override
    public String getFrameName() {
        return frameName;
    }

    @Override
    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getIntro() {
        return intro;
    }

    @Override
    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public JPanel getLeftPanel() {
        return leftPanel;
    }

    @Override
    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    @Override
    public JPanel getRightPanel() {
        return rightPanel;
    }

    @Override
    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    @Override
    public void notify(DynamicView view) {
        view.update(this);
    }

}
