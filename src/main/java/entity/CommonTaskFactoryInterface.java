package entity;

public interface CommonTaskFactoryInterface {

    CommonTask createTask(String taskName, String description, CommonUser employee, CommonProject project);
}
