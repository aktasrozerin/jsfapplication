package radius.Adapters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rozerin on 28.08.2015.
 */

public class UserAdapter {
    private static int tempId = 0;
    private int id;
    private String username;
    private String value;
    private String attribute;
    private String op;
    private List<RoleAdapter> roles;
    private String company;


    public UserAdapter() {
        // id = 99;
    }

    public UserAdapter(String username, String att, String operator, String password,String company ,List<RoleAdapter> role) {
       // this.id=-1;
        tempId++;
        this.id = tempId;
        this.username = username;
        this.attribute=att;
        this.op=operator;
        this.value = password;
        this.company=company;

        if(role == null){
            this.roles= new ArrayList<RoleAdapter>();
        } else {
            this.roles = role;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return value;
    }

    public void setPassword(String password) {
        this.value = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List<RoleAdapter> getRoles() {
        return roles;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setRoles(List<RoleAdapter> roles) {
        this.roles = roles;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addRoleToUser(RoleAdapter role) {

        roles.add(role);
    }

}
