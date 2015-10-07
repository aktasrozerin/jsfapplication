

import radius.Adapters.UserAdapter
import radius.Beans.AddUserManagedBean;
import radius.Service.RadiusService
import radius.Service.RadiusServiceImp


class UserManagedBeanTest extends GroovyTestCase {
    void testInit() {

    }

    void testGetService() {

        RadiusService service  = new RadiusServiceImp();
        AddUserManagedBean bean = new AddUserManagedBean();
        bean.setService(service);
        assertEquals(service,bean.getService());

    }

    void testSetService() {

        RadiusService service  = new RadiusServiceImp();
        AddUserManagedBean bean = new AddUserManagedBean();
        bean.setService(service);
        assertEquals(service,bean.getService());
    }

    void testGetUsers() {

        UserAdapter user1 = new UserAdapter();
        UserAdapter user2 = new UserAdapter();
        UserAdapter user3 = new UserAdapter();
        List<UserAdapter> list = new ArrayList<UserAdapter>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List synchronizedList =Collections.synchronizedList(list);
        assertEquals(list,synchronizedList);

    }

    void testSetUsers() {

        List<UserAdapter> list= new ArrayList<UserAdapter>();
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setUsers(list);
        assertEquals(list,bean.getUsers());
    }

    void testGetUser() {

        UserAdapter user = new UserAdapter();
        user.setUsername("rozerin");
        AddUserManagedBean bean = new AddUserManagedBean();
        bean.setUser(user);
        GroovyTestCase.assertEquals("rozerin",bean.getUser().getUsername());
    }

    void testSetUser() {

        UserAdapter user = new UserAdapter();
        AddUserManagedBean bean = new AddUserManagedBean();
        bean.setUser(user);
        assertEquals(user,bean.getUser());


    }
}
