package use_case.evaluate_task;
import entity.task.CommonTask;
import entity.user.User;

public class EvaluateTaskRequestModel {
    private CommonTask commontask;
    private User user;
    private Integer star;
    private String message;

    public EvaluateTaskRequestModel(CommonTask commontask, User user, Integer star, String message) {
        this.commontask = commontask;
        this.user = user;
        this.star = star;
        this.message = message;
    }

    public CommonTask getCommonTask() {
        return commontask;
    }

    public void setCommontask(CommonTask commontask) {
        this.commontask = commontask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
