package data_access;

import com.google.gson.Gson;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import initialize_company.Initialization;
import initialize_company.InitializationRequestModel;
import initialize_company.InitializationResponseModel;
import initialize_company.initializationInteractor;
import netscape.javascript.JSObject;
import java.util.ArrayList;
import java.util.List;

public class DataAccessForTesting {
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
