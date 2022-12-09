package use_case.rank_employees;
import org.junit.*;
import org.junit.runner.Request;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RankEmployeesUseCaseTest {

     /*
     * RankEmployees for an empty department with only a head.
     */
    @Test
    public void testCase1(){

        RankRequestModel requestModel = new RankRequestModel(234);
        RankGateway gateway = mock(RankGateway.class);
        // here the department is empty besides the head so the list of subordinates is empty.
        when(gateway.getSubordinates(requestModel)).thenReturn(new ArrayList<>());
        RankOutputBoundary outputBoundary = mock(RankOutputBoundary.class);


        RankInputBoundary interactor = new RankInteractor(gateway, outputBoundary);
        RankResponseModel response = interactor.create(requestModel);

        assertEquals(response.getRankedEmployees(), new ArrayList<>());


    }

    public void testCase2(){

    }

    public void testCase3(){

    }



}
