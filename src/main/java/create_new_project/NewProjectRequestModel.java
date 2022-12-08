package create_new_project;

public class NewProjectRequestModel {
    Integer ProjectManagerID;
    Integer funds;
    String name;
    String description;
    String dpt;

    public NewProjectRequestModel(int pmid, int funds, String name, String descrip, String dpt) {
        this.ProjectManagerID = pmid;
        this.funds = funds;
        this.name = name;
        this.description = descrip;
        this.dpt = dpt;
    }

    public Integer getProjectManagerID() {
        return ProjectManagerID;
    }

    public Integer getFunds() {
        return funds;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDpt() {
        return dpt;
    }
}
