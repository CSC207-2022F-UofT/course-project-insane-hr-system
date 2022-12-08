package use_case.check_profile_validation;

public class CheckUserFileRequestModel extends CheckProfileRequestModel{
    private final Integer uid;

    public CheckUserFileRequestModel(Integer requester, Integer uid) {
        super(requester);
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

}
