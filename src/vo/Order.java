package vo;

public class Order {
    private String order_id;
    private String login_name;
    private String order_original_price;
    private String order_total_price;
    private String discount;
    private String delivery_address;
    private String receiver_phone;
    private String receiver_name;
    private String create_time;
    private String modified_time;
    private String status;


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getOrder_original_price() {
        return order_original_price;
    }

    public void setOrder_original_price(String order_original_price) {
        this.order_original_price = order_original_price;
    }

    public String getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(String order_total_price) {
        this.order_total_price = order_total_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", login_name='" + login_name + '\'' +
                ", order_original_price='" + order_original_price + '\'' +
                ", order_total_price='" + order_total_price + '\'' +
                ", discount='" + discount + '\'' +
                ", delivery_address='" + delivery_address + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", receiver_name='" + receiver_name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modified_time='" + modified_time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
