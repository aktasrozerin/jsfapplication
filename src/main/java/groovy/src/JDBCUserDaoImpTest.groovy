import org.springframework.util.DigestUtils
import radius.Adapters.UserAdapter
import radius.DAO.DaoImp.JDBCUserDaoImp


/**
 * Created by rozerin on 01.09.2015.
 */
class JDBCUserDaoImpTest extends GroovyTestCase {



    void testInsert() {
    try{
       UserAdapter user = new UserAdapter(null,"rozerin","att","op",DigestUtils.md5Hex("pass"));
        JDBCUserDaoImp dao= new JDBCUserDaoImp();

        boolean Result = dao.insert(user);

        //assertTrue(bResult);

    }catch(Exception excp){
        throw new AssertionError() ;

    }

    }

    void testFindById() {

        UserAdapter user = JDBCUserDaoImp.findById(1);

       assertEquals("rozerin", user.getUsername());
       assertEquals("MD5", user.getAttribute());
       assertEquals(":=", user.getOp());

    }



}
