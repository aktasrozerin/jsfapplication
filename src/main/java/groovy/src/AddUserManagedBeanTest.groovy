import radius.Adapters.UserAdapter
import radius.Beans.AddUserManagedBean
import radius.Service.RadiusService
import radius.Service.RadiusServiceImp

class AddUserManagedBeanTest extends GroovyTestCase {


    void testSetUsers() {
        List<UserAdapter> list= new ArrayList<UserAdapter>();
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setUsers(list);
        assertEquals(list,bean.getUsers());
    }

    void testInit() {
//TODO check this implementation later on witk easymock
        AddUserManagedBean bean = new AddUserManagedBean();
        RadiusService service= new RadiusServiceImp();
        UserAdapter user = new UserAdapter();

        bean.users = service.constructUsersList();


    }

    void testAddUser() {
        //todo check this implementation later on with easymock

        UserAdapter user = new UserAdapter();

        RadiusService service = new RadiusServiceImp();
        service.addUser(user);
        service.constructUsersList();

    }

    void testGoToPrintUsersPage() {

        String link = "homepage";
        assertEquals("homepage",link)

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

    void testGetId() {

        UserAdapter user = new UserAdapter();
        int userId = 4
        user.setId(userId);

        assertEquals(4,userId);

    }

    void testSetId() {

        int id=8;
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setId(id);
        assertEquals(8,bean.getId());

    }

    void testGetUsername() {
        UserAdapter user = new UserAdapter();
        String username = user.setUsername("rozerin");

        assertEquals(4,username);
    }

    void testSetUsername() {

       String username = "rozerin";
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setUsername(username);
        assertEquals("rozerin",username);


    }

    void testGetAttribute() {

        UserAdapter user = new UserAdapter();
        String att = user.setAttribute("attribute");

        assertEquals("attribute",att);

    }

    void testSetAttribute() {


        String att = "attribute";
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setAttribute(att);
        assertEquals("attribute",att);

    }

    void testGetOp() {


        UserAdapter user = new UserAdapter();
        String op = user.setAttribute(":=");

        assertEquals(":=",op);
    }

    void testSetOp() {
        String op = ":=";
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setOp(op)
        assertEquals(":=",op);


    }

    void testGetValue() {

        UserAdapter user = new UserAdapter();
        String value = user.setAttribute("pass");

        assertEquals("pass",value);

    }

    void testSetValue() {

        String value = "pass";
        AddUserManagedBean bean= new AddUserManagedBean();
        bean.setOp( value);
        assertEquals("pass",value);

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
}
