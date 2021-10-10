package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static ConnectionUtil cu = null;
    private static Properties props;

    //private constructor so we can control the creation
    private ConnectionUtil(){
        props = new Properties();

        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");

        try{
            props.load(dbProps);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionUtil getConnectionUtil(){
        if(cu==null){
            cu = new ConnectionUtil();
            return cu;
        }
        else return cu;
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(props.getProperty("driver"));
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        try {
            con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
/*
    public static void main(String []args){
        Connection con = ConnectionUtil.getConnectionUtil().getConnection();
        if(con == null){
            System.out.println("something went wrong.");
        }
        else System.out.println("connection successful.");
    }
*/
}