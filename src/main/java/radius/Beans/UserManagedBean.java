package radius.Beans;

import radius.Adapters.UserAdapter;
import radius.Service.RadiusService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rozerin on 28.08.2015.
 */
@ManagedBean
@ViewScoped
public class UserManagedBean {

    @ManagedProperty("#{radiusService}")
    private RadiusService service;


    private List<UserAdapter> users;
    private UserAdapter user;

    @PostConstruct
    public void init() {

        this.users=service.constructUsersList();
    }
    public RadiusService getService() {
        return service;
    }

    public void setService(RadiusService service) {
        this.service = service;
    }

    public List<UserAdapter> getUsers() {
        return users;
    }

    public void setUsers(List<UserAdapter> users) {
        this.users = users;
    }

    public UserAdapter getUser() {
        return user;
    }

    public void setUser(UserAdapter user) {
        this.user = user;
    }

}
