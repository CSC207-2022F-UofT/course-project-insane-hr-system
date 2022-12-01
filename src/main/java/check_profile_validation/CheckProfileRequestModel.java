package check_profile_validation;

public abstract class CheckProfileRequestModel {
    private final Integer requester;

    public CheckProfileRequestModel(Integer requester) {
        this.requester = requester;
    }

    public Integer getRequester() {
        return requester;
    }

}
