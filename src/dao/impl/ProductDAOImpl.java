package dao.impl;

import dao.ProductDAO;
import db.DBConnect;
import vo.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {


    @Override
    public List<Product> AllProduct() throws Exception {
        List<Product> Product = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBConnect dbConnect = null;

        String sql = "select * from product where subclass_id=1 or subclass_id = 2 or subclass_id=3";

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            Product product = new Product();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String product_id = resultSet.getString(1);
                String product_name = resultSet.getString(2);
                String price = resultSet.getString(3);
                String descript = resultSet.getString(4);
                String indate = resultSet.getString(5);
                String modified_time = resultSet.getString(6);
                String subclass_id = resultSet.getString(7);
                String product_thumb = resultSet.getString(8);

                product.setProduct_id(resultSet.getString("product_id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getString("price"));
                product.setDescript(resultSet.getString("descript"));
                product.setIndate(resultSet.getString("indate"));
                product.setModified_time(resultSet.getString("modified_time"));
                product.setSubclass_id(resultSet.getString("subclass_id"));
                product.setProduct_thumb(resultSet.getString("product_thumb"));


                Product.add(product);
                product = new Product();
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return Product;

    }

    @Override
    public Product ProductDetail(int product_id) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBConnect dbConnect = null;
        Product product = new Product();

        String sql = "select * from product where product_id = ?" ;

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(product_id));
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                String product_name = resultSet.getString(2);
                String price = resultSet.getString(3);
                String descript = resultSet.getString(4);
                String indate = resultSet.getString(5);
                String modified_time = resultSet.getString(6);
                String subclass_id = resultSet.getString(7);
                String product_thumb = resultSet.getString(8);

                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getString("price"));
                product.setDescript(resultSet.getString("descript"));
                product.setIndate(resultSet.getString("indate"));
                product.setModified_time(resultSet.getString("modified_time"));
                product.setSubclass_id(resultSet.getString("subclass_id"));
                product.setProduct_thumb(resultSet.getString("product_thumb"));
            }
            preparedStatement.close();
            resultSet.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }

        return product;
    }

    @Override
    public List<Product> selectByCatalogue(String subclass) throws Exception {

        List<Product> Product = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBConnect dbConnect = null;
        String sql = null;


        if (subclass.equals("subclass_id=1")){
            sql = "select * from product where subclass_id =1";
        }else if (subclass.equals("subclass_id=2")){
            sql = "select * from product where subclass_id =2";
        }else if (subclass.equals("subclass_id=3")){
            sql = "select * from product where subclass_id =3";
        }

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);

            Product product = new Product();
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                String product_id = resultSet.getString(1);
                String product_name = resultSet.getString(2);
                String price = resultSet.getString(3);
                String descript = resultSet.getString(4);
                String indate = resultSet.getString(5);
                String modified_time = resultSet.getString(6);
                String subclass_id = resultSet.getString(7);
                String product_thumb = resultSet.getString(8);


                product.setProduct_id(resultSet.getString("product_id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getString("price"));
                product.setDescript(resultSet.getString("descript"));
                product.setIndate(resultSet.getString("indate"));
                product.setModified_time(resultSet.getString("modified_time"));
                product.setSubclass_id(resultSet.getString("subclass_id"));
                product.setProduct_thumb(resultSet.getString("product_thumb"));
                Product.add(product);
                product = new Product();

            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dbConnect.close();
        }

        return Product;
    }

    @Override
    public List<Product> searchByKeyword(String keyword) throws Exception {
        List<Product> Product = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBConnect dbConnect = null;
        String kw = keyword;
        //String sql = "select * from product where product_name like '%'||?||'%'";
        String sql = "select * from product where product_name like ?";

        System.out.println(kw);

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,"%"+kw+"%");
            Product product = new Product();
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String product_id = resultSet.getString(1);
                String product_name = resultSet.getString(2);
                String price = resultSet.getString(3);
                String descript = resultSet.getString(4);
                String indate = resultSet.getString(5);
                String modified_time = resultSet.getString(6);
                String subclass_id = resultSet.getString(7);
                String product_thumb = resultSet.getString(8);


                product.setProduct_id(resultSet.getString("product_id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getString("price"));
                product.setDescript(resultSet.getString("descript"));
                product.setIndate(resultSet.getString("indate"));
                product.setModified_time(resultSet.getString("modified_time"));
                product.setSubclass_id(resultSet.getString("subclass_id"));
                product.setProduct_thumb(resultSet.getString("product_thumb"));
                Product.add(product);
                product = new Product();
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }


        return Product;
    }

    public Product getProductByProductID(String product_id){
        Product product = new Product();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        DBConnect dbConnect =null;
        String sql = null;

        sql = "select * from product where product_id =" + product_id;

        try {
            dbConnect = new DBConnect();
            preparedStatement = dbConnect.getConnection().prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                product.setProduct_id(resultSet.getString("product_id"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getString("price"));
                product.setDescript(resultSet.getString("descript"));
                product.setIndate(resultSet.getString("indate"));
                product.setModified_time(resultSet.getString("modified_time"));
                product.setSubclass_id(resultSet.getString("subclass_id"));
                product.setProduct_thumb(resultSet.getString("product_thumb"));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.close();
        }
        return product;
    }


}
