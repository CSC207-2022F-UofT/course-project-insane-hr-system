package LeaveRequest;

public interface LeaveRequestInputBoundary {
    LeaveRequestResponseModel create(LeaveRequestRequestModel requestModel);
}
