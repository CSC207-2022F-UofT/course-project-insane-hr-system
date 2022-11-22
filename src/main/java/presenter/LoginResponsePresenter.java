package Presenter;

import entity.User;

// Use case layer

public interface LoginResponsePresenter {

    void prepareSuccessView(User user);

    void prepareFailView(String error);

}