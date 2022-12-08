package use_case.unused_delete_employee;

import java.time.LocalDateTime;

public class DeleteResponseModel {
    private int id;
    private String name;

    LocalDateTime deleteTime;

    public DeleteResponseModel(int id, String name, LocalDateTime time) {
        this.id = id;
        this.name = name;
        this.deleteTime = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }
}
