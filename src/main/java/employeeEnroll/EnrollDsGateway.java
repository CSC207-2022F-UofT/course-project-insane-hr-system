package employeeEnroll;

public interface EnrollDsGateway {
    String generateUsername(String name); //first four letter of last name + four numbers e.g. zhan0001,zhan0002
    int generateId(); //six digit, which is the number of employees plus one, starting from 100001
    void save(EnrollDsRequestModel requestModel);


}
