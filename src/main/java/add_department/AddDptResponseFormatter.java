package add_department;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddDptResponseFormatter implements AddDptPresenter{


    @Override
    public AddDptResponseModel prepareSuccessView(AddDptResponseModel dpt) {
        LocalDateTime responseTime = LocalDateTime.now();
        dpt.setCreationTime(LocalDateTime.from(responseTime));
        return dpt;
    }

    @Override
    public AddDptResponseModel prepareFailView(String error)  {throw new CreationFailed(error);}
}
