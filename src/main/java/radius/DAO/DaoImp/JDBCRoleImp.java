package radius.DAO.DaoImp;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import radius.Adapters.RoleAdapter;
import radius.DAO.JDBCRole;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rozerin on 13.09.2015.
 */
public class JDBCRoleImp implements JDBCRole{



    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(RoleAdapter role) {
        String sql = "INSERT INTO Roles" + "(roleId,roleName) VALUES" +
                " (?, ?)";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[] {
                null,role.getRoleName()
        });

    }
    public List<RoleAdapter> printAll(){

        List<RoleAdapter> roles = new ArrayList<RoleAdapter>();

        String sql = "SELECT * FROM Roles";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

        for( Map row : result)
        {
            RoleAdapter role = new RoleAdapter();
            role.setRoleId(Integer.parseInt(String.valueOf(row.get("roleId"))));
            role.setRoleName(String.valueOf(row.get("roleName")));

            roles.add(role);
        }

        return roles;
    }
    public RoleAdapter findById(int id) {

        String sql = "SELECT * FROM Roles " +
                "WHERE roleId = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        RoleAdapter role = (RoleAdapter) jdbcTemplate.queryForObject(
                sql, new Object[] { id },
                new BeanPropertyRowMapper(RoleAdapter.class));
        return role;
    }
    public void delete(int id){

        getJdbcTemplate().
                update("DELETE FROM Roles WHERE roleId = ?",
                        new Object[]{id});

    }

    public DataSource getDataSource() {
        return dataSource;
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
}
