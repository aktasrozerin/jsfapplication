package radius.DAO.DaoImp;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;
import radius.DAO.JDBCUserDao;
import radius.DAO.JDBCUserRole;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rozerin on 28.08.2015.
 */


public class JDBCUserDaoImp implements JDBCUserDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private JDBCUserRole jdbcUserRole;

    @PostConstruct
    public void aftePropertiesSet() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("radcheck").usingGeneratedKeyColumns("id");

    }

    public void insert(UserAdapter user){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", null);
        parameters.put("username", user.getUsername());
        parameters.put("attribute",user.getAttribute());
        parameters.put("op",user.getOp());
        parameters.put("value",DigestUtils.md5Hex(user.getPassword()));
        parameters.put("company",user.getCompany());

        jdbcUserRole.insert(user);

        Number lastInsertId = this.simpleJdbcInsert.executeAndReturnKey(parameters);
        user.setId(lastInsertId.intValue());

    }

    public UserAdapter findById(int id) {


        String sql32 = "SELECT * FROM radcheck " +
                "WHERE id = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        UserAdapter user = (UserAdapter) jdbcTemplate.queryForObject(
                sql32, new Object[]{id},
                new BeanPropertyRowMapper(UserAdapter.class));

        user.setRoles(jdbcUserRole.findRoles(user));

        return user;

    }

    public List<UserAdapter> printAll(){

        String sql55 ="SELECT * FROM radcheck,Roles,UserRoles " +
                "WHERE radcheck.id=UserRoles.userId AND Roles.roleId=UserRoles.roleId";


        return (List<UserAdapter>) jdbcTemplate.query(sql55, new UserListExtractor());
    }

    private class UserListExtractor implements ResultSetExtractor {

        public List<UserAdapter> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Integer, UserAdapter> map = new HashMap<Integer, UserAdapter>();
            UserAdapter user = null;

            while (rs.next()) {

                Integer userId = rs.getInt("id");
                user = map.get(userId);

                if(user == null){
                String username = rs.getString("username");
                String attribute = rs.getString("attribute");
                String op = rs.getString("op");
                String password = rs.getString("value");
                String company = rs.getString("company");

                    user = new UserAdapter(username,attribute,op,password,company,null);
                    user.setId(userId);
                    map.put(userId,user);
                }

                int roleId = rs.getInt("roleId");
                String roleName = rs.getString("roleName");
                RoleAdapter role = new RoleAdapter(roleName);
                role.setRoleId(roleId);

                user.addRoleToUser(role);


            }
            return new ArrayList<UserAdapter>(map.values());
        }
    }
    public JDBCUserRole getJdbcUserRole() {
        return jdbcUserRole;
    }

    public void setJdbcUserRole(JDBCUserRole jdbcUserRole) {
        this.jdbcUserRole = jdbcUserRole;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleJdbcInsert getSimpleJdbcInsert() {
        return simpleJdbcInsert;
    }

    public void setSimpleJdbcInsert(SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

}
