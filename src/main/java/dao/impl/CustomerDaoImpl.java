package dao.impl;

import dao.RoleDao;
import entity.Customer;
import entity.Role;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements RoleDao {

    /**
     * 登入
     * @param username　傳入　輸入帳戶
     * @param password　傳入　輸入密碼
     * @return　回傳是否有此用戶
     */
    public Role login(String username, String password) {
        String sql = "select * from customers where name=? and password=?";
        Connection connection = JDBCUtil.getConnection("myshop");
        try {
            PreparedStatement pstatem = connection.prepareStatement(sql);
            pstatem.setString(1,username);
            pstatem.setString(2,password);
            ResultSet resultSet = pstatem.executeQuery();

            if(resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPassword(resultSet.getString("password"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setMoney(resultSet.getInt("money"));
                return customer;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public boolean register(Role role) {
        Customer customer = (Customer)role;
        String sql = "insert into customers (name,password,phone,money) values(?,?,?,?)";
        Connection connection = JDBCUtil.getConnection("myshop");

        try {
            PreparedStatement pstatem = connection.prepareStatement(sql);
            pstatem.setString(1,customer.getName());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
