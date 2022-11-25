package review_request;

public class ReviewRequestResponseModel {
    private boolean result;

    public ReviewRequestResponseModel(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
