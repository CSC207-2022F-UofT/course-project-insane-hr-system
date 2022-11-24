package ui;

import javax.swing.*;
import java.util.List;

public interface ViewIModel {

    List<DynamicView> getViews();

    void setViews(List<DynamicView> views);

    String getFrameName();

    void setFrameName(String frameName);

    String getTitle();

    void setTitle(String title);

    String getIntro();

    void setIntro(String intro);

    JPanel getLeftPanel();

    void setLeftPanel(JPanel leftPanel);

    JPanel getRightPanel();

    void setRightPanel(JPanel rightPanel);

    void notify(DynamicView view);
}
