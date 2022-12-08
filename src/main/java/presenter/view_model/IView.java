package presenter.view_model;

import presenter.IViewModel;

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

//    Integration getView();
//
//    Integration getIntroOnly();
//
//    Integration getIntroAndTable();
//
//    Integration getIntroTableAndButton();

    IViewModel getDataModel();

//    JFrame getNotVisible();
}
