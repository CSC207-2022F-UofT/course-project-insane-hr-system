package ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UIDataModel implements PropertyChangeListener {
    private String frameName;
    private String infoTitle;
    private String intro;
    private Table leftTable;
    private Table rightTable;




    private final PropertyChangeSupport observable;


    public UIDataModel(String frameName, String infoTitle, String intro) {
        this.frameName = frameName;
        this.infoTitle = infoTitle;
        this.intro = intro;
        this.observable = new PropertyChangeSupport(this);
    }

    public UIDataModel(String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        this.frameName = frameName;
        this.infoTitle = infoTitle;
        this.intro = intro;
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.observable = new PropertyChangeSupport(this);
    }

    /*
     * Add a new observer to observe the changes to this class.
     * @param observer
     */
    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("FrameNameChange", observer);
        observable.addPropertyChangeListener("TitleChange", observer);
        observable.addPropertyChangeListener("IntroChange", observer);
        observable.addPropertyChangeListener("LeftTableChange", observer);
        observable.addPropertyChangeListener("RightTableChange", observer);
    }


    public void updateFrameName(String newFrameName) {
        String oldFrameName = this.frameName;
        this.frameName = newFrameName;
        observable.firePropertyChange("FrameNameChange", oldFrameName, newFrameName);
    }

    public void updateInfoTitle(String newInfoTitle) {
        String oldInfoTitle = this.infoTitle;
        this.infoTitle = newInfoTitle;
        observable.firePropertyChange("TitleChange", oldInfoTitle, newInfoTitle);
    }
    public void updateIntro(String newIntro) {
        String oldIntro = this.intro;
        this.intro = newIntro;
        observable.firePropertyChange("IntroChange", oldIntro, newIntro);
    }
    public void updateLeftTable(Table newLeftTable) {
        Table oldLeftTable = this.leftTable;
        this.leftTable = newLeftTable;
        observable.firePropertyChange("LeftTableChange", oldLeftTable, newLeftTable);
    }
    public void updateRightTable(Table newRightTable) {
        Table oldRightTable = this.rightTable;
        this.rightTable = newRightTable;
        observable.firePropertyChange("RightTableChange", oldRightTable, newRightTable);
    }
    public PropertyChangeSupport getObservable() {
        return observable;
    }


    public String getFrameName() {
        return frameName;
    }

    public void setFrameName(String frameName) {
        this.frameName = frameName;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Table getLeftTable() {
        return leftTable;
    }

    public void setLeftTable(Table leftTable) {
        this.leftTable = leftTable;
    }

    public Table getRightTable() {
        return rightTable;
    }

    public void setRightTable(Table rightTable) {
        this.rightTable = rightTable;
    }




    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

}
