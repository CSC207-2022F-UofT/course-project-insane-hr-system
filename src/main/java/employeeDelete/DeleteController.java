package employeeDelete;

public class DeleteController {
    final DeleteInputBoundary inputBoundary;


    public DeleteController(DeleteInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    DeleteResponseModel create(int id) {
        return inputBoundary.create(id);
    }
}
