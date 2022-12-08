package use_case.create_new_project;

import data_access.NewProjectDataAccess;
import entity.Project;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewProjectInteractorTest {
    public static NewProjectInputBoundary ProjectInput;
    private final NewProjectGateway newgateway = new NewProjectDataAccess();

    @Test
    void testProjectInteracter(){
        NewProjectRequestModel requestModel = new NewProjectRequestModel(1, 100,
                "testProj", "test", "First Department");
        Project p1 = ProjectInput.create(requestModel).getProject();
        newgateway.save(ProjectInput.create(requestModel));
        Project p2 = newgateway.getProject(p1.getOid());
        assertSame(p1, p2);
    }
}