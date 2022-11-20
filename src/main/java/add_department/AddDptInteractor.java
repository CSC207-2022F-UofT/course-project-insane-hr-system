package add_department;

import entity.DepartmentFactory;

public class AddDptInteractor implements AddDptInputBoundary{
    final AddDptInputBoundary inputBoundary;
    final AddDptPresenter presenter;
    final DepartmentFactory factory;

    public AddDptInteractor(AddDptInputBoundary inputBoundary, AddDptPresenter presenter, DepartmentFactory factory) {
        this.inputBoundary = inputBoundary;
        this.presenter = presenter;
        this.factory = factory;
    }
}
