package use_case.rank_employees;
import entity.Department;
import entity.project.CommonProject;
import entity.task.CommonTask;
import entity.user.CommonUser;
import entity.user.User;
import org.junit.*;
import org.junit.runner.Request;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RankEmployeesUseCaseTest {


    /*
    test 1 single member under a head member in a department.
     */
    @Test
    public void testCase1(){
        RankRequestModel requestModel = new RankRequestModel(234);
        RankGateway gateway = mock(RankGateway.class);

        Set<Integer> memberIDs = new TreeSet<>();
        memberIDs.add(134);
        Department dept = new Department(UUID.randomUUID(), "Security", 157, memberIDs, "Department of product security.", LocalDateTime.now());
        // there is 1 employee that has no tasks.

        CommonUser user = new CommonUser(134, dept, "Howdy.", "Alexis Lee");

        List<CommonUser> singleSubordinate = new ArrayList<>();
        singleSubordinate.add(user);
        when(gateway.getSubordinates(requestModel)).thenReturn(singleSubordinate);
        RankOutputBoundary outputBoundary = mock(RankOutputBoundary.class);
        RankInputBoundary interactor = new RankInteractor(gateway, outputBoundary);
        RankResponseModel response = interactor.create(requestModel);
        when(outputBoundary.displayRanking(response)).thenReturn(response);

        List<String> ranking = new ArrayList<>();
        ranking.add("Alexis Lee");
        assertEquals(outputBoundary.displayRanking(response).getRankedEmployees(), ranking);

    }

    /*
     test 2 members under a department with different task scores.
     */
    @Test
    public void testCase2(){
        RankRequestModel requestModel = new RankRequestModel(234);
        RankGateway gateway = mock(RankGateway.class);

        Set<Integer> memberIDs = new TreeSet<>();
        memberIDs.add(134);
        Department dept = new Department(UUID.randomUUID(), "Security", 157, memberIDs, "Department of product security.", LocalDateTime.now());
        // there is 1 employee that has no tasks.

        CommonProject project = new CommonProject(UUID.randomUUID(), "Project 1", 190, "Test.", LocalDateTime.now(), dept, 20000);
        CommonUser user = new CommonUser(134, dept, "Howdy.", "Alexis Lee");
        CommonUser user2 = new CommonUser(178, dept, "Howdy", "Anna Lee");
        dept.addMember(178);
        CommonUser user3 = new CommonUser(190, dept, "Howdy", "Pierce Black");
        dept.addMember(190);

        List<CommonUser> subordinates = new ArrayList<>();
        subordinates.add(user);
        subordinates.add(user2);
        subordinates.add(user3);

        when(gateway.getSubordinates(requestModel)).thenReturn(subordinates);
        when(gateway.getCompletedTasks());
        RankOutputBoundary outputBoundary = mock(RankOutputBoundary.class);
        RankInputBoundary interactor = new RankInteractor(gateway, outputBoundary);
        RankResponseModel response = interactor.create(requestModel);
        when(outputBoundary.displayRanking(response)).thenReturn(response);

        List<String> ranking = new ArrayList<>();
        ranking.add("Alexis Lee");
        assertEquals(outputBoundary.displayRanking(response).getRankedEmployees(), ranking);

    }




}
