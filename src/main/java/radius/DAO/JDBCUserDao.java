package radius.DAO;

import radius.Adapters.UserAdapter;
import java.util.List;

/**
 * Created by rozerin on 28.08.2015.
 */
public interface JDBCUserDao {

    public void insert(UserAdapter paket);
    public List<UserAdapter> printAll();
    public UserAdapter findById(int id);

}
