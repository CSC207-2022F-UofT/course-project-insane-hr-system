package check_profile_validation;

public interface CheckProfileInputBoundary {
    CheckProfileResponseModel checkUserProfile(CheckUserFileRequestModel requestModel);
    CheckProfileResponseModel checkOrgProfile(CheckOrgFileRequestModel requestModel);

    void update();

    CheckProfileOutputBoundary getOutputBoundary();
}
