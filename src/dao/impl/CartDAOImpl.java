package dao.impl;
import dao.CartDAO;
import dao.impl.ProductDAOImpl;
import db.DBConnect;
import vo.CartItem;
import vo.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartDAOImpl implements CartDAO{

    @Override
    public List<CartItem> AllCartItem(String Login_name) throws Exception {
        List<CartItem> cartItemList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        DBConnect dbConnect =null;

        String sql;
        //sql = "select * from cart WHERE login_name EQUALS +\'" + Login_name +"\'";
        sql = "select * from cart WHERE login_name =?";
        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            CartItem cartItem = new CartItem();
            preparedStatement.setString(1, Login_name);

            resultSet = preparedStatement.executeQuery();

            // OUTSTANDING: sequence of columns needs revising
            while (resultSet.next()){
                cartItem.setCart_item_id(resultSet.getString("cart_item_id"));
                cartItem.setLogin_name(resultSet.getString("login_name"));
                cartItem.setProduct_id(resultSet.getString("product_id"));
                cartItem.setProduct_name(resultSet.getString("product_name"));
                cartItem.setProduct_thumb(resultSet.getString("product_thumb"));
                cartItem.setBase_price(resultSet.getString("base_price"));
                cartItem.setNum(resultSet.getString("num"));
                cartItem.setTotal_price(resultSet.getString("total_price"));
                cartItem.setUpdate_time(resultSet.getString("update_time"));
                cartItemList.add(cartItem);
                cartItem = new CartItem();
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return cartItemList;
    }

    @Override
    public int addToCart(String login_name, String product_id, int num) throws Exception {

        String sql = "INSERT into cart (product_id, login_name, num, base_price, total_price, product_name, product_thumb) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null ;
        //PreparedStatement pstmt_username = null;
        DBConnect dbc = null;
        DBConnect dbc_username = null;
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();

        int flag =0;
        Product product = productDAOImpl.getProductByProductID(product_id);
        double base_price = Double.parseDouble(product.getPrice());
        double total_price = base_price * num;
        String product_name = product.getProduct_name();
        String product_thumb = product.getProduct_thumb();

        try {
            //链接数据库
            dbc = new DBConnect();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, product_id);
            pstmt.setString(2, login_name);
            pstmt.setString(3, Integer.toString(num));
            pstmt.setString(4, Double.toString(base_price));
            pstmt.setString(5, Double.toString(total_price));
            pstmt.setString(6, product_name);
            pstmt.setString(7, product_thumb);

            int rs = pstmt.executeUpdate();
            flag = rs;
            pstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            // 关闭数据库连接
            dbc.close() ;
        }
        return flag;
    }

    @Override
    public int addNumCart(int base_price, String cart_item_id, int num) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect =null;
        String sql = "UPDATE cart set num=? where cart_item_id=?";


        dbConnect = new DBConnect();
        preparedStatement = dbConnect.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(num));
        preparedStatement.setString(2,cart_item_id);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnect.close();


        Connection connection1 = null;
        PreparedStatement preparedStatement1 = null;
        DBConnect dbConnect1 =null;


        String sql1 = "UPDATE cart set total_price = ? where cart_item_id = ?";
        dbConnect = new DBConnect();
        int total_price = (int) (num * base_price);
        preparedStatement = dbConnect.getConnection().prepareStatement(sql1);
        preparedStatement.setString(1, String.valueOf(total_price));
        preparedStatement.setString(2,cart_item_id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        dbConnect.close();


        return 0;
    }

    @Override
    public int deleteCart(String cart_item_id) throws SQLException {

        Connection connection =null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect = null;
        String sql = "DELETE from cart where cart_item_id = ?";
        
        dbConnect = new DBConnect();
        preparedStatement = dbConnect.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,cart_item_id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        dbConnect.close();


        return 0;
    }


}
