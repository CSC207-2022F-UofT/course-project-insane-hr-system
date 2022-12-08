
import entity.*;

import java.util.UUID;
package use_case.complete_task;

public interface CompleteTaskDsGateway {
    void save(CompleteTaskDsRequestModel requestModel);

    Task getTask(UUID oid);
}
