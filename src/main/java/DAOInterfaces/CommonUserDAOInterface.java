package DAOInterfaces;

import entity.CommonRole;
import entity.CommonUser;
import entity.CommonUserFace;

import java.util.List;
import java.util.UUID;

public interface CommonUserDAOInterface {

    // create a CommonUser
    public void createCommonUser(CommonUser user);

    // update a CommonUser
    public void updateCommonUser(CommonUser user);

    // get all CommonUsers
    public List<CommonUser> getAllCommonUsers();

    // get one CommonUser
    public CommonUser getCommonUser(int id);
}
