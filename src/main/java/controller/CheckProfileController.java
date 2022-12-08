package controller;

import check_profile_validation.*;
import data_access.CheckProfileDataAccess;
import data_access.CheckProfileIMDataAccess;
import presenter.CheckProfilePresenter;
import view_model.ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.UUID;

public class CheckProfileController implements PropertyChangeListener {
    private final CheckProfileInputBoundary interactor;

    public CheckProfileController() {
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
        CheckProfileIGateway gateway = new CheckProfileDataAccess();
        this.interactor = new CheckProfileInteractor(gateway, presenter);
    }
    public CheckProfileController(CheckProfileIGateway gateway) {
        CheckProfileOutputBoundary presenter = new CheckProfilePresenter(new ViewModel());
        this.interactor = new CheckProfileInteractor(gateway, presenter);
    }

    public CheckProfileController(CheckProfileOutputBoundary presenter, CheckProfileIGateway gateway) {
        this.interactor = new CheckProfileInteractor(gateway, presenter);
    }

    public void create(Integer requester, Integer target){
        CheckUserFileRequestModel requestModel = new CheckUserFileRequestModel(requester, target);
        interactor.checkUserProfile(requestModel);
    }

    public void create(Integer requester, UUID target){
        CheckOrgFileRequestModel requestModel = new CheckOrgFileRequestModel(requester, target);
        interactor.checkOrgProfile(requestModel);
    }
    /**
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public CheckProfileInputBoundary getInteractor() {
        return interactor;
    }
}
