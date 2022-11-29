package presenter;

import view_model.ScreenType;
import view_model.Table;
import view_model.UIDataModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;

public interface IViewModel {


    void setFunction(Function[] functions);
    /*
     * Add a new observer to observe the changes to this class.
     * @param observer
     */
    void addObserver(PropertyChangeListener observer);

    void updateFrameName(String newFrameName);

    void updateInfoTitle(String newInfoTitle);

    void updateIntro(String newIntro);

    void updateLeftTable(Table newLeftTable);

    void updateRightTable(Table newRightTable);

    void updateAll(UIDataModel newDataModel);

    PropertyChangeSupport getObservable();

    String getFrameName();

    void setFrameName(String frameName);

    String getInfoTitle();

    void setInfoTitle(String infoTitle);

    String getIntro();

    void setIntro(String intro);

    Table getLeftTable();

    void setLeftTable(Table leftTable);

    Table getRightTable();

    void setRightTable(Table rightTable);

    void propertyChange(PropertyChangeEvent evt);

    ScreenType getScreenType();

    void setScreenType(ScreenType screenType);

    int getVisualLevel();

    void setVisualLevel(int visualLevel);
    Integer getRequesterID();
    void setRequesterID(Integer requesterID);
}
