package vo;

public class CartItem {
    private String cart_item_id;
    private String login_name;
    private String product_id;
    private String product_name;
    private String product_thumb;
    private String base_price;
    private String num;
    private String total_price;
    private String update_time;

    public String getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(String cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_thumb() {
        return product_thumb;
    }

    public void setProduct_thumb(String product_thumb) {
        this.product_thumb = product_thumb;
    }

    public String getBase_price() {
        return base_price;
    }

    public void setBase_price(String base_price) {
        this.base_price = base_price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cart_item_id='" + cart_item_id + '\'' +
                ", login_name='" + login_name + '\'' +
                ", product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_thumb='" + product_thumb + '\'' +
                ", base_price='" + base_price + '\'' +
                ", num='" + num + '\'' +
                ", total_price='" + total_price + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
