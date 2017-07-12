package com.implementation;
import com.services.DBServices;

import java.sql.*;


/**
 * Created by varsha.sharma on 12-07-2017.
 */
public class DBImplementation implements DBServices  {
    int columnCount;
    ResultSetMetaData resultSetMetaData;
    ResultSet resultSet;
    Statement statement;
    Connection connection;
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String awsURl = "jdbc:mysql://trainingdb.c4hhsbxtkfor.ap-south-1.rds.amazonaws.com:3306/trainingTable";
    static final String username = "root";
    static final String password = "mypassword";

    public DBImplementation() {
        this.resultSet=null;
        this.statement = null;
        this.connection = null;
    }

    public void registerConnection() {
        try{
            Class.forName(jdbcDriver);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
        }

    }

    public Connection connectionEstablish() {
        try{
            connection = DriverManager.getConnection(awsURl,username,password);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void create(String query, Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            connection.close();
        }

    }

    public void insert(String query, Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Values Inserted");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }

    public ResultSet getDetails(String query, Connection connection) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet=statement.executeQuery(query);
            System.out.println("Details are fetched successfully");
            resultSetMetaData=resultSet.getMetaData();
            columnCount=resultSetMetaData.getColumnCount();
            while (resultSet.next()){
                for (int i = 1; i <= columnCount; i++){
                    if(i>1)
                        System.out.println(", ");
                    String columnVal=resultSet.getString(i);
                    System.out.println(columnVal+" "+resultSetMetaData.getCatalogName(i));
                }

                System.out.println("");

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            connection.close();
        }
        return resultSet;
    }
}
