package employeeEnroll;

public interface EnrollDsGateway {
    String generateUsername(String name);
    String generatePassword();
    int generateId();
    void save(EnrollDsRequestModel requestModel);
}
