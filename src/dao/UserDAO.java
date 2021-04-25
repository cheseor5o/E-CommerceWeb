package dao;

import vo.User;

import java.util.List;

public interface UserDAO {
    public int queryByUsername(User user) throws Exception;
    public int registerByUsername(User user) throws Exception;

    public List<User> selectByUsername(String Login_name);
    public int modifyByUsername(User user) throws Exception;
    public int chargeByUsername(String money,String Login_name,String balance) throws Exception;



}
