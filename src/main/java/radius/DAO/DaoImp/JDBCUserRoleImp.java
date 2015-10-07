package radius.DAO.DaoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;
import radius.DAO.JDBCRole;
import radius.DAO.JDBCUserRole;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rozerin on 12.09.2015.
 */


public class JDBCUserRoleImp implements JDBCUserRole {


    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    private JDBCRole jdbcRole;

    public void update(UserAdapter user) {

        String sql1 = "DELETE FROM UserRoles WHERE userId = ?";

        jdbcTemplate.update(sql1, new Object[]{user.getId()});
        this.insert(user);
    }

    public void insert(final UserAdapter user) {

        this.jdbcTemplate =new JdbcTemplate(dataSource);
        final String sql4 = "INSERT INTO UserRoles (userId,roleId) " +
                " VALUES (?, ?)";

        int[] ints = getJdbcTemplate().batchUpdate(sql4, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int roleId = user.getRoles().get(i).getRoleId();
                int userId = user.getId();
                ps.setInt(1, userId);
                System.out.println("user id:" + userId);
                ps.setInt(2, roleId);

            }

            public int getBatchSize() {
                return user.getRoles().size();
            }
        });
        System.out.println("in the insert function");

    }
    public List<RoleAdapter> findRoles(UserAdapter user) {

        String sql2 = "SELECT * FROM UserRoles WHERE userId = " + user.getId();
        jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql2);

        List<RoleAdapter> roles = new ArrayList<RoleAdapter>();

        for(Map row: result)
        {
            RoleAdapter role;
            role = jdbcRole.findById(Integer.parseInt(String.valueOf(row.get("roleId"))));
            roles.add(role);
        }

        return roles;

    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JDBCRole getJdbcRole() {
        return jdbcRole;
    }

    public void setJdbcRole(JDBCRole jdbcRole) {
        this.jdbcRole = jdbcRole;
    }

}
