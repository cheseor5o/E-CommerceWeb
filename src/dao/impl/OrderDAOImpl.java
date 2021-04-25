package dao.impl;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.impl.UserDAOImpl;
import db.DBConnect;
import vo.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<Order> selectOrderByUsername(String Login_name){
        List<Order> orderList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        DBConnect dbConnect =null;
        String sql = "select * from order_main where login_name = ?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,Login_name);

            Order order = new Order();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                order.setOrder_id(resultSet.getString("order_id"));
                order.setLogin_name(resultSet.getString("login_name"));
                order.setOrder_original_price(resultSet.getString("original_price"));
                order.setDiscount(resultSet.getString("discount"));
                order.setOrder_total_price(resultSet.getString("total_price"));
                order.setDelivery_address(resultSet.getString("delivery_address"));
                order.setReceiver_phone(resultSet.getString("receiver_phone"));
                order.setReceiver_name(resultSet.getString("receiver_name"));
                order.setCreate_time(resultSet.getString("create_time"));
                order.setStatus(resultSet.getString("status"));




                //order.setModified_time(resultSet.getString("modified_time"));
                //order.setCreate_time("create_time");

                orderList.add(order);
                order = new Order();
            }
            preparedStatement.close();
            resultSet.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }


        return orderList;

    }

    @Override
    public List<OrderItem> selectOrderItemByOrderId(String order_id) {
        List<OrderItem> orderItemList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        DBConnect dbConnect =null;
        String sql = "select * from order_detail where order_id = ?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,order_id);

            OrderItem orderItem = new OrderItem();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                orderItem.setOrder_item_sn(resultSet.getString("order_item_sn"));
                orderItem.setOrder_id(resultSet.getString("order_id"));
                orderItem.setProduct_id(resultSet.getString("product_id"));
                orderItem.setProduct_name(resultSet.getString("product_name"));
                orderItem.setProduct_thumb(resultSet.getString("product_thumb"));
                orderItem.setBase_price(resultSet.getString("base_price"));
                orderItem.setNum(resultSet.getString("num"));
                orderItem.setTotal_price(resultSet.getString("total_price"));


                orderItemList.add(orderItem);
                orderItem = new OrderItem();
            }
            preparedStatement.close();
            resultSet.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }


        return orderItemList;
    }

    @Override
    public int createOrder(List<CartItem> cart, String login_name) {
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        DBConnect dbConnect =null;
        //String sql_insert_order = "insert into order_main (login_name, original_price, discount, total_price, delivery_address, receiver_phone, receiver_name, status, postcode) output  inserted.order_id values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql_insert_order = "insert into order_main (order_id,login_name, original_price, discount, total_price, delivery_address, receiver_phone, receiver_name, status, postcode)  values(?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

        double original_price = 0;
        int num = 0;
        double total_price = 0;
        double discount = 0;
        double base_price = 0;

        String product_name;
        String product_id;
        String product_thumb;

        String order_id = System.currentTimeMillis() + login_name;
        String address;
        String receiver_phone;
        String receiver_name;
        String post_code;
        String status;

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql_insert_order);

            CartItem cartItem;
            for(int i = 0; i < cart.size(); i++) {
                cartItem = cart.get(i);
                base_price = Double.parseDouble(cartItem.getBase_price());
                num = Integer.parseInt(cartItem.getNum());
                original_price = original_price + base_price * num;
                total_price = total_price + Double.parseDouble(cartItem.getTotal_price());
            }

            discount = original_price - total_price;

            UserDAOImpl userDAOImpl = new UserDAOImpl();
            List<User> userList = userDAOImpl.selectByUsername(login_name);
            User user = userList.get(0);
            address = user.getAddress();
            receiver_phone = user.getPhone();
            receiver_name = user.getName();
            post_code = user.getPostcode();
            status = "Paid";



            preparedStatement.setString(1, order_id);
            preparedStatement.setString(2, login_name);
            preparedStatement.setString(3, Double.toString(original_price));
            preparedStatement.setString(4, Double.toString(discount));
            preparedStatement.setString(5, Double.toString(total_price));
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, receiver_phone);
            preparedStatement.setString(8, receiver_name);
            preparedStatement.setString(10, post_code);
            preparedStatement.setString(9, status);
            preparedStatement.executeUpdate();



            int resultSet1 = 0;
            String sql_insert_order_detail = "insert into order_detail (order_id, product_id, product_name, product_thumb, num, base_price, total_price) values(?, ?, ?, ?, ?, ?, ?)";
            for(int i = 0; i < cart.size(); i++) {
                preparedStatement = dbConnect.getConnection().prepareStatement(sql_insert_order_detail);
                cartItem = cart.get(i);
                base_price = Double.parseDouble(cartItem.getBase_price());
                num = Integer.parseInt(cartItem.getNum());
                total_price = base_price * num;
                product_id = cartItem.getProduct_id();
                product_name = cartItem.getProduct_name();
                product_thumb = cartItem.getProduct_thumb();

                preparedStatement.setString(1, order_id);
                preparedStatement.setString(2, product_id);
                preparedStatement.setString(3, product_name);
                preparedStatement.setString(4, product_thumb);
                preparedStatement.setString(5, Integer.toString(num));
                preparedStatement.setString(6, Double.toString(base_price));
                preparedStatement.setString(7, Double.toString(total_price));

                resultSet1 = preparedStatement.executeUpdate();

            }


            int resultSet2 = 0;
            String sql = "delete  from cart where login_name = ? ";
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,login_name );
            resultSet = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return 0;
    }

    @Override
    public int refundByOrderId(String order_id) throws SQLException {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect = null;
        String sql = "UPDATE order_main set status = ? where order_id = ?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(2,order_id);
            preparedStatement.setString(1,"Refunded");
            int  resultSet = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            dbConnect.close();
        }

        return 0;
    }

    @Override
    public int receiveByOrderId(String order_id) throws SQLException {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        DBConnect dbConnect = null;
        String sql = "UPDATE order_main set status = ? where order_id = ?";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(2,order_id);
            preparedStatement.setString(1,"Received");
            int  resultSet = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            dbConnect.close();
        }

        return 0;
    }


}
