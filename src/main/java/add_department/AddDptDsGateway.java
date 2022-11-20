package add_department;

public interface AddDptDsGateway {
    void save(AddDptDsRequestModel requestModel); //requestModel contains a Department entity
    boolean existByName(String name); //return if the database exist the department name already
}
