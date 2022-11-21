package add_department;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddDptResponseModel {

    private LocalDateTime creationTime;
    private String name;
    private String description;

    public AddDptResponseModel(LocalDateTime creationTime, String name, String description) {
        this.creationTime = creationTime;
        this.name = name;
        this.description = description;
    }

    public void setCreationTime(LocalDateTime time) {
        this.creationTime = time;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
