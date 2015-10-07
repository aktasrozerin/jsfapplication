package radius.Adapters;

/**
 * Created by rozerin on 12.09.2015.
 */
public class RoleAdapter {


    private int roleId;
    private String roleName;

    public RoleAdapter(String roleName) {

        this.roleName = roleName;
    }

    public RoleAdapter() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
