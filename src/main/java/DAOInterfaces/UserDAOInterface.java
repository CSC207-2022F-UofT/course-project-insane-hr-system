package DAOInterfaces;

import entity.CommonUser;

import java.util.List;

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
