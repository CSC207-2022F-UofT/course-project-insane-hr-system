package unused_add_department;



public interface AddDptPresenter {
    AddDptResponseModel prepareSuccessView(AddDptResponseModel dpt);
    AddDptResponseModel prepareFailView (String error);
}
