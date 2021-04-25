package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
    private final String DBURL = "jdbc:mysql://39.108.151.202/eins_platform" ;
    private final String DBUSER = "xushulue2020" ;
    private final String DBPASSWORD = "1iPi#3P.U>CD" ;
    private Connection conn = null ;

    public DBConnect()   {
        try{
            Class.forName(DBDRIVER) ;
            this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // 获取数据库链接
    public Connection getConnection(){
        return this.conn ;
    }

    // 关闭数据库连接
    public void close(){
        try{
            this.conn.close() ;
        }catch (Exception e){ }
    }




}
