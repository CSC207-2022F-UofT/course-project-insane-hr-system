package view_model;

import check_profile_validation.VisualLevel;
import presenter.Function;
import presenter.IViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    private Function[] functions;
    private UUID oid;
    private Integer uid;
    private Integer currUid;



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
        this.currUid = currUid;
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
    public void setFunction(Function[] functions) {
        this.functions = functions;
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
    public Function[] getFunctions() {
        return functions;
    }
    public void show(JFrame frame) {
        JFrame app = new JFrame(this.getFrameName());
        app.setContentPane(frame);
        app.pack();
        app.setVisible(true);
    }

    @Override
    public void setFunctions(Function[] functions) {
        this.functions = functions;
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
    public Integer getCurrUid() {
        return uid;
    }

    @Override
    public void setCurrUid(Integer currUid) {
        this.currUid = currUid;
    }
}
