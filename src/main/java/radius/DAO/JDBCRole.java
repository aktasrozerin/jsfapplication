package radius.DAO;

import radius.Adapters.RoleAdapter;

import java.util.List;

/**
 * Created by rozerin on 13.09.2015.
 */
public interface JDBCRole {

    public void insert(RoleAdapter role);
    public List<RoleAdapter> printAll();
    public RoleAdapter findById(int id);
    public void delete(int id);
}
