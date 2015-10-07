package radius.Service;

/**
 * Created by rozerin on 28.08.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;
import radius.DAO.JDBCRole;
import radius.DAO.JDBCUserDao;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value="radiusService")

public class RadiusServiceImp implements RadiusService{

    private List<UserAdapter> users;
    private List<RoleAdapter> roleList;

    @Autowired
    private JDBCUserDao jdbcUserDao;
    @Autowired
    private JDBCRole jdbcRole;
    @PostConstruct
    public void init(){

        this.users = constructUsersList();
        this.roleList=constructRolesList();
    }
    public List<UserAdapter> constructUsersList(){
        return jdbcUserDao.printAll();

    }
    public List<RoleAdapter> constructRolesList(){

        this.roleList = jdbcRole.printAll();
        return this.roleList;
    }
    public void addUser(UserAdapter user) {
        jdbcUserDao.insert(user);
        this.users = constructUsersList();
    }

    public RoleAdapter getRoleById(int roleId) {
        for (RoleAdapter role : this.roleList) {
            if (role.getRoleId()== roleId) {
                return role;
            }
        }
        return null;
    }
    public List<UserAdapter> getUserList() {
        return constructUsersList();
    }
    public void printUserList() {
        for (UserAdapter user : this.users) {
            System.out.print(user.getUsername() + ", ");
        }
    }

}
