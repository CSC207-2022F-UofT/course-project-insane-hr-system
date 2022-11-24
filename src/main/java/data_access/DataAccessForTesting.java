package data_access;

import com.google.gson.Gson;
import entity.User;
import initialize_company.Initialization;
import initialize_company.InitializationRequestModel;
import initialize_company.InitializationResponseModel;
import initialize_company.initializationInteractor;
import ui.DynamicView;
import ui.ViewIModel;

import java.util.ArrayList;
import java.util.List;

public class DataAccessForTesting implements Observable<DynamicView, ViewIModel> {
    private List<DynamicView> observers = new ArrayList<>();
    private ViewIModel viewIModel;

    @Override
    public void addObserver(DynamicView observer) {
        this.observers.add(observer);
        observer.addObservable(this);
    }

    @Override
    public void removeObserver(DynamicView observer) {
        this.observers.remove(observer);
        observer.removeObservable(this);
    }
    @Override
    public List<DynamicView> getObservers() {
        return observers;
    }

    @Override
    public void setObservers(List<DynamicView> observers) {
        this.observers = observers;
        for (DynamicView observer : observers) {
            observer.addObservable(this);
        }
    }

    @Override
    public void notifyObserver(DynamicView observer) {
        observer.update(viewIModel);
    }

    public static void saveUser(User user) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));

    }

    public static void main(String[] args) {
        Initialization initialization = new initializationInteractor();
        InitializationRequestModel requestModel = new InitializationRequestModel();
        InitializationResponseModel responseModel = initialization.initializeCompany(requestModel);
        saveUser(responseModel.getCeo());
    }
}
