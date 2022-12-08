package use_case.evaluate_task;

import java.util.UUID;

public interface EvaluateTaskDsGateway {
    void save(EvaluateTaskRequestModel requestModel);

    Integer getStar(UUID oid);
}
