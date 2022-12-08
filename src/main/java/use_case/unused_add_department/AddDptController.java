package use_case.unused_add_department;

public class AddDptController {
    final AddDptInputBoundary inputBoundary;

    public AddDptController(AddDptInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    AddDptResponseModel create(String name, String description){
        AddDptRequestModel requestModel = new AddDptRequestModel(name, description);
        return inputBoundary.create(requestModel);
    }
}
