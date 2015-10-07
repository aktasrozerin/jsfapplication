package radius.Beans;

import radius.Adapters.RoleAdapter;
import radius.Adapters.UserAdapter;
import radius.Service.RadiusService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by rozerin on 28.08.2015.
 */
@ManagedBean
@ViewScoped
public class AddUserManagedBean {

    @ManagedProperty("#{radiusService}")
    private RadiusService service;

    private int id;
    private String username;
    private String value;
    private String attribute;
    private String op;
    private List<UserAdapter> users;
    private UserAdapter user;
    private List<RoleAdapter> selectedRoles;
    private List<RoleAdapter> roles;
    private String company;



    @PostConstruct
    public void init() {
        this.users = service.constructUsersList();
        this.roles = service.constructRolesList();

    }

    public void addUser() {

        UserAdapter tmpuser = new UserAdapter(username,attribute,op,value,company,selectedRoles);

        FacesContext context = FacesContext.getCurrentInstance();
        if(tmpuser.getUsername().isEmpty())
        {
            context.addMessage(null, new FacesMessage("No addition was configured!"));
        }
        else {

            service.addUser(tmpuser);
            context.addMessage(null, new FacesMessage("User is added!"));

        }
        service.constructUsersList();
    }
    public String goToPrintUsersPage() throws IOException{

        return "printUsers.xhtml";
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public List<UserAdapter> getUsers() {
        return users;
    }
    public void setUsers(List<UserAdapter> users) {
        this.users = users;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public RadiusService getService() {
        return service;
    }

    public void setService(RadiusService service) {
        this.service = service;
    }
    public UserAdapter getUser() {
        return user;
    }

    public void setUser(UserAdapter user) {
        this.user = user;
    }

    public List<RoleAdapter> getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(List<RoleAdapter> selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

    public List<RoleAdapter> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleAdapter> roles) {
        this.roles = roles;
    }

    public String returnAddition() throws IOException {
        return "additionpage.xhtml";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddUserManagedBean that = (AddUserManagedBean) o;

        if (id != that.id) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (op != null ? !op.equals(that.op) : that.op != null) return false;
        return !(users != null ? !users.equals(that.users) : that.users != null);

    }

    @Override
    public int hashCode() {
        int result = service != null ? service.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (op != null ? op.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
