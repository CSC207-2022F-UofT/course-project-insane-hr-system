package review_request;

public class ReviewRequestResponseModel {
    private String result;

    public ReviewRequestResponseModel(boolean approval) {
        if (approval) {
            this.result = "Approved";
        } else {
            this.result = "Denied";
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
