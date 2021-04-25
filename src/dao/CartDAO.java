package dao;
import java.sql.SQLException;
import java.util.List;

import vo.CartItem;
import vo.User;
import vo.Product;

public interface CartDAO {
    //public List<Product> selectBySubclass(String subclass);
    public List<CartItem> AllCartItem(String login_name) throws Exception;
    public int addToCart(String login_name, String product_id, int num) throws Exception;
    public int addNumCart(int base_price, String cart_item_id, int num) throws Exception;
    public int deleteCart(String cart_id) throws SQLException;
}
