import util.JDBCUtil;

import java.sql.Connection;

public class myshop {

    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        if(connection != null){
            System.out.println("DB Connection [ok]");
        }

    }


}
