package radius.DAO;

import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;

import java.util.List;

/**
 * Created by rozerin on 12.09.2015.
 */
public interface JDBCUserRole {

    public void insert(final UserAdapter user);
    public List<RoleAdapter> findRoles(UserAdapter paket);
    public void update(UserAdapter user);
}
