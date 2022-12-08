package view_model;

import check_profile_validation.VisualLevel;
import presenter.Controllers;
import presenter.IViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.UUID;

public class ViewModel implements PropertyChangeListener, IViewModel {
    private String frameName;
    private String infoTitle;
    private String intro;
    private Table leftTable;
    private Table rightTable;
    private ScreenType screenType; // could be deleted
    private VisualLevel visualLevel;
    private Integer requesterID;
    private Controllers[] controllers;
    private UUID oid;
    private Integer uid;
    private UUID dpt;


    private final PropertyChangeSupport observable;


    public ViewModel() {
        this.observable = new PropertyChangeSupport(this);
    }


        public ViewModel(String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        this.frameName = frameName;
        this.infoTitle = infoTitle;
        this.intro = intro;
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.observable = new PropertyChangeSupport(this);
    }

    public ViewModel(Integer currUid, String frameName, String infoTitle, String intro, Table leftTable, Table rightTable) {
        this.frameName = frameName;
        this.infoTitle = infoTitle;
        this.intro = intro;
        this.leftTable = leftTable;
        this.rightTable = rightTable;
        this.observable = new PropertyChangeSupport(this);
        this.requesterID = currUid;
    }

    /*
     * Add a new observer to observe the changes to this class.
     * @param observer
     */
    @Override
    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("FrameNameChange", observer);
        observable.addPropertyChangeListener("TitleChange", observer);
        observable.addPropertyChangeListener("IntroChange", observer);
        observable.addPropertyChangeListener("LeftTableChange", observer);
        observable.addPropertyChangeListener("RightTableChange", observer);
    }


    @Override
    public ScreenType getScreenType() {
        return screenType;
    }
    @Override
    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }
    @Override
    public void setFunction(Controllers[] controllers) {
        this.controllers = controllers;
    }


    @Override
    public void updateFrameName(String newFrameName) {
        String oldFrameName = this.frameName;
        this.frameName = newFrameName;
        observable.firePropertyChange("FrameNameChange", oldFrameName, newFrameName);
    }

    @Override
    public void updateInfoTitle(String newInfoTitle) {
        String oldInfoTitle = this.infoTitle;
        this.infoTitle = newInfoTitle;
        observable.firePropertyChange("TitleChange", oldInfoTitle, newInfoTitle);
    }
    @Override
    public void updateIntro(String newIntro) {
        String oldIntro = this.intro;
        this.intro = newIntro;
        observable.firePropertyChange("IntroChange", oldIntro, newIntro);
    }
    @Override
    public void updateLeftTable(Table newLeftTable) {
        Table oldLeftTable = this.leftTable;
        this.leftTable = newLeftTable;
        observable.firePropertyChange("LeftTableChange", oldLeftTable, newLeftTable);
    }
    @Override
    public void updateRightTable(Table newRightTable) {
        Table oldRightTable = this.rightTable;
        this.rightTable = newRightTable;
        observable.firePropertyChange("RightTableChange", oldRightTable, newRightTable);
    }
    @Override
    public void updateAll(ViewModel newDataModel) {
        ViewModel oldDataModel = this;
        this.updateIntro(newDataModel.getIntro());
        this.updateFrameName(newDataModel.getFrameName());
        this.updateInfoTitle(newDataModel.getInfoTitle());
        this.updateLeftTable(newDataModel.getLeftTable());
        this.updateRightTable(newDataModel.getRightTable());
        observable.firePropertyChange("DataModelChange", oldDataModel, newDataModel);
    }
    @Override
    public PropertyChangeSupport getObservable() {
        return observable;
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
    public String getInfoTitle() {
        return infoTitle;
    }

    @Override
    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
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
    public Table getLeftTable() {
        return leftTable;
    }

    @Override
    public void setLeftTable(Table leftTable) {
        this.leftTable = leftTable;
    }

    @Override
    public Table getRightTable() {
        return rightTable;
    }

    @Override
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

    @Override
    public VisualLevel getVisualLevel() {
        return visualLevel;
    }

    @Override
    public void setVisualLevel(VisualLevel visualLevel) {
        this.visualLevel = visualLevel;
    }

    @Override
    public Integer getRequesterID() {
        return requesterID;
    }
    @Override
    public void setRequesterID(Integer requesterID) {
        this.requesterID = requesterID;
    }

    @Override
    public Controllers[] getUseCases() {
        return controllers;
    }
    public void show(JFrame frame) {
        JFrame app = new JFrame(this.getFrameName());
        app.setContentPane(frame);
        app.pack();
        app.setVisible(true);
    }

    @Override
    public void setControllers(Controllers[] controllers) {
        this.controllers = controllers;
    }

    @Override
    public UUID getOid() {
        return oid;
    }

    @Override
    public void setOid(UUID oid) {
        this.oid = oid;
    }


    @Override
    public Integer getUid() {
        return uid;
    }

    @Override
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public Controllers[] getControllers() {
        return controllers;
    }

    @Override
    public void setDpt(UUID dpt) {
        this.dpt = dpt;
    }

    @Override
    public String toString() {
        return "ViewModel{" + '\n' +
                "frameName='" + frameName + '\'' +'\n' +
                ", infoTitle='" + infoTitle + '\'' +'\n' +
                ", intro='" + intro + '\'' +'\n' +
                ", leftTable=" + leftTable +'\n' +
                ", rightTable=" + rightTable +'\n' +
                ", screenType=" + screenType +'\n' +
                ", visualLevel=" + visualLevel +'\n' +
                ", requesterID=" + requesterID +'\n' +
                ", controllers=" + Arrays.toString(controllers) +'\n' +
                ", oid=" + oid +'\n' +
                ", uid=" + uid +'\n' +
                ", observable=" + observable +'\n' +
                '}';
    }

    @Override
    public UUID getDpt() {
        return dpt;
    }
}
