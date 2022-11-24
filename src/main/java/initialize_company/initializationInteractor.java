package initialize_company;

import entity.CommonUser;
import entity.Department;
import entity.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class initializationInteractor implements Initialization {
    @Override
    public InitializationResponseModel initializeCompany(InitializationRequestModel initializationRequestModel) {
        User ceo = new CommonUser(100000);
        Set<Integer> member  = new HashSet<>();
        member.add(ceo.getId());
        Department firstDpt = new Department(UUID.randomUUID(), "First Department", ceo.getId(), member,"This is the first department of our company", LocalDateTime.now());
        ceo.setDpt(firstDpt);
        return new InitializationResponseModel(ceo, firstDpt);
    }
}
