package use_case.rank_employees;
import entity.CommonUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import rank_employees.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class RankEmployeesDomainTest {

    @Test
    public void testRankEmployees_case1(){

        // test a department with 1 employee, the head
        RankRequestModel requestModel = new RankEmployeesSampleTestObjects().emptyDepartment();
        RankGateway mockGateway = mock(RankGateway.class);
        RankOutputBoundary mockOutputBoundary = mock(RankOutputBoundary.class);

        // the response model we want to generate given the input :
        RankResponseModel response = new RankResponseModel(new ArrayList<>());

        // if the output boundary displays the response model, we want to return true.
        when(mockOutputBoundary.displayRanking(response)).thenReturn(true);

        when(mockGateway.getDepartmentMembers(requestModel)).thenReturn(new ArrayList<>());
        RankInputBoundary interactor = new RankInteractor(mockGateway, mockOutputBoundary);
        List<CommonUser> sortedSubordinates = interactor.rankEmployees(requestModel).getRankedEmployees();

        assertEquals(response,sortedSubordinates);








    }


    public void testRankEmployees_case2(){
        // test with 1 employee
    }


    public void testRankEmployees_case3(){
        // test with 4 employees
    }

    public void testRankEmployees_case4(){
        // test with 4 employees where 2 of them have the same
    }


}
