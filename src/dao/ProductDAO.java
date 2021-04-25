package dao;

import vo.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> AllProduct() throws Exception;
    public Product ProductDetail(int product_id) throws Exception;
    public List<Product> selectByCatalogue(String subclass) throws Exception;
    public List<Product> searchByKeyword(String keyword) throws Exception;


}
