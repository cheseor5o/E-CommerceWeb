package vo;

public class Product {
    private String product_id;
    private String product_name;
    private String price;
    private String descript;
    private String indate;
    private String modified_time;
    private String subclass_id;
    private String product_thumb;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }

    public String getSubclass_id() {
        return subclass_id;
    }

    public void setSubclass_id(String subclass_id) {
        this.subclass_id = subclass_id;
    }

    public String getProduct_thumb() {
        return product_thumb;
    }

    public void setProduct_thumb(String product_thumb) {
        this.product_thumb = product_thumb;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price='" + price + '\'' +
                ", descript='" + descript + '\'' +
                ", indate='" + indate + '\'' +
                ", modified_time='" + modified_time + '\'' +
                ", subclass_id='" + subclass_id + '\'' +
                ", product_thumb='" + product_thumb + '\'' +
                '}';
    }
}
