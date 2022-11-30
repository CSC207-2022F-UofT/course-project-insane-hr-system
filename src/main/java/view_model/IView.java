package view_model;

import presenter.IViewModel;
import ui.Integration;
import view_model.Table;
import view_model.ViewModel;

import javax.swing.*;

public interface IView {
    JFrame view();
    void initialization();

    String setIntro();

    String setInfoTitle();

    String setFrameName();

    Table setLeftTable();

    Table setRightTable();

    String setLeftButtonLabel();

    void customizeLeftButton();

    String setRightButtonLabel();

    void customizeRightButton();

    JPanel customizeLeftPanel();

    JPanel customizeRightPanel();

    Integration getView();

    Integration getIntroOnly();

    Integration getIntroAndTable();

    Integration getIntroTableAndButton();

    IViewModel getDataModel();

    JFrame getNotVisible();
}
