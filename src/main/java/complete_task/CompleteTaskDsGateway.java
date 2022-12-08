package complete_task;
import entity.*;

import java.util.UUID;

public interface CompleteTaskDsGateway {
    void save(CompleteTaskDsRequestModel requestModel);

    Task getTask(UUID oid);
}
