

import radius.Adapters.UserAdapter


class UserAdapterTest extends GroovyTestCase {

    void testConstructor(){
        UserAdapter user = new UserAdapter("username","att","op","pass");
        user.setId(9);
        assertEquals(9,user.getId());
        GroovyTestCase.assertEquals("username",user.getUsername());
        GroovyTestCase.assertEquals("att",user.getAttribute());
        GroovyTestCase.assertEquals("op",user.getOp());
        GroovyTestCase.assertEquals("pass",user.getPassword());

    }
}
