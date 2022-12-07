package check_profile_validation;

public interface CheckProfileOutputBoundary {

    void prepareUserFrame(CheckProfileResponseModel responseModel);

    void prepareOrgFrame(CheckProfileResponseModel responseModel);

    void showFrame();

    void update();

}
