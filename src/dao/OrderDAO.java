package dao;

import vo.Order;
import vo.OrderItem;
import vo.CartItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

     public List<Order> selectOrderByUsername(String login_name);
     public List<OrderItem> selectOrderItemByOrderId(String order_id);
     public int createOrder(List<CartItem> cart, String login_name);

     public int refundByOrderId(String order_id) throws SQLException;
     public int receiveByOrderId(String order_id) throws SQLException;


}
