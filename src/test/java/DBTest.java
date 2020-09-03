import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;

public class DBTest {

    @Test
    public void test1(){
        Connection connection = JDBCUtil.getConnection();
        if(connection != null){
            System.out.println("DB Connection [ok]");
        }
    }
}
