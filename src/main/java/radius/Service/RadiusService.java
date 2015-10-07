package radius.Service;

import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;
import java.util.List;

/**
 * Created by rozerin on 28.08.2015.
 */
public interface RadiusService {

    public List<UserAdapter> constructUsersList();
    public void addUser(UserAdapter user);
    public List<UserAdapter> getUserList();
    public void printUserList();
    public List<RoleAdapter> constructRolesList();
    public RoleAdapter getRoleById(int roleId);

}
