package dao.impl;

import dao.UserDAO;
import db.DBConnect;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public int queryByUsername(User user) throws Exception {
        int flag = 0;
        String sql = "select * from customer where login_name=?";
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect = null;


        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("password").equals(user.getPassword())){
                    flag = 1;
                }

            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return flag;
    }

    //注册操作
    public int registerByUsername(User user) throws Exception {

        int flag = 0;
        int i = 0; //判断是否重名的标志
        String sql = "INSERT into customer (login_name,password) VALUES (?,?)";
        //String sql_username = "select * from user where username=?";
        PreparedStatement pstmt = null ;
        //PreparedStatement pstmt_username = null;
        DBConnect dbc = null;
        DBConnect dbc_username = null;

        //先查询username是否重名
        try {
            dbc_username = new DBConnect() ;
            String sql_username = "select * from customer where login_name=?";
            PreparedStatement pstmt_username = null;
            pstmt_username = dbc_username.getConnection().prepareStatement(sql_username);
            pstmt_username.setString(1,user.getUsername());
            ResultSet resultSet = pstmt_username.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString("username").equals(user.getUsername())){
                    i = 1;//重名标志
                }else {
                    i = 0;
                }
            }
            resultSet.close();
            pstmt_username.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc_username.close();
        }

        //注册的数据库操作
        try{
            //链接数据库
            dbc = new DBConnect() ;
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());


            if (i == 1){
                System.out.println("无法写入数据");
                flag = 2;  //这个是指的 重名了 重新加载注册页面
            }
            else {
                int rs = pstmt.executeUpdate();
                flag = rs;
                pstmt.close() ;
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            // 关闭数据库连接
            dbc.close() ;
        }


        return flag;
    }

    //展示个人主页
    @Override
    public List<User> selectByUsername(String Login_name){
        List<User> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        DBConnect dbConnect =null;
        String sql = "select * from customer where login_name =?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,Login_name);
            User  user = new User();

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String username = resultSet.getString(10);
                String password = resultSet.getString(11);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(5);
                String birthday = resultSet.getString(8);
                String phone = resultSet.getString(3);
                String email = resultSet.getString(4);
                String address = resultSet.getString(6);



                user.setUsername(resultSet.getString("login_name"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("customer_name"));
                user.setGender(resultSet.getString("gender"));
                user.setBirthday(resultSet.getString("birthday"));
                user.setPhone(resultSet.getString("mobile_phone"));
                user.setEmail(resultSet.getString("customer_email"));
                user.setAddress(resultSet.getString("address"));

                list.add(user);
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbConnect.close();
        }
        return list;
    }

    //修改个人信息
    @Override
    public int modifyByUsername(User user) throws Exception{
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect =null;
        String sql = "UPDATE customer set password=?, customer_name=?, gender=?, birthday=?,mobile_phone=?,customer_email=?,address=? where login_name=?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);

            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getGender());
            preparedStatement.setString(4,user.getBirthday());
            preparedStatement.setString(5,user.getPhone());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setString(7,user.getAddress());
            preparedStatement.setString(8,user.getUsername());

            if (!user.getEmail().matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")){
                System.out.println("邮箱输入不对");
                i = 2;
            }
            else {
                int resultSet = preparedStatement.executeUpdate();
                i = resultSet;
                preparedStatement.close() ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return i;
    }

    //充值
    @Override
    public int chargeByUsername(String money, String Login_name, String balance) throws Exception{

        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect =null;
        String sql = "UPDATE user set balance=? where login_name=?";

        int subbalance = Integer.parseInt(balance);
        int Money = Integer.parseInt(money);
        int allbalance = Money + subbalance;

        if (Money >= 0){
            try {
                dbConnect = new DBConnect();
                preparedStatement = dbConnect.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1,allbalance);
                preparedStatement.setString(2,Login_name);
                int resultSet = preparedStatement.executeUpdate();
                i = resultSet;
                preparedStatement.close();
                //resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dbConnect.close();
            }

        }else {
            i = 0;
        }


        return i;
    }


}
