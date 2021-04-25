package vo;

public class OrderItem {
    private String order_item_sn;
    private String order_id;
    private String product_id;
    private String product_name;
    private String product_thumb;
    private String num;
    private String base_price;
    private String total_price;

    public String getOrder_item_sn() {
        return order_item_sn;
    }

    public void setOrder_item_sn(String order_item_sn) {
        this.order_item_sn = order_item_sn;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBase_price() {
        return base_price;
    }

    public void setBase_price(String base_price) {
        this.base_price = base_price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order_item_sn='" + order_item_sn + '\'' +
                ", order_id='" + order_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_thumb='" + product_thumb + '\'' +
                ", num='" + num + '\'' +
                ", base_price='" + base_price + '\'' +
                ", total_price='" + total_price + '\'' +
                '}';
    }
}
