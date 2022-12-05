package complete_task;

import entity.Task;

import java.util.UUID;

public class CompleteTaskResponseModel {
    private UUID oid;
    private String response;

    public CompleteTaskResponseModel(UUID oid, String response) {
        this.oid = oid;
        this.response = response;
    }

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
