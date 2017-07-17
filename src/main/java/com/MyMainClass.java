package com;
import com.implementation.DBImplementation;
import com.services.DBServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by varsha.sharma on 13-07-2017.
 */
public class MyMainClass {

    private static ApplicationContext context;

    static {
        context=new ClassPathXmlApplicationContext("applicationcontext.xml");
    }

    public void setBean(){

    }
    public static void main(String args[]) throws SQLException {

        DBServices dbServices=(DBServices) context.getBean("DBServices");


        System.out.println(dbServices);

        Connection connection;
        String createQuery= "CREATE TABLE VarshaSharma("+
                "ID INTEGER NOT NULL,"+
                "NAME VARCHAR(30));";
        String insertQuery= "insert into VarshaSharma values"+
                                                        "(1,'Varsha');";

        String selectQuery="SELECT * FROM VarshaSharma";

        dbServices.registerConnection();

        connection = dbServices.connectionEstablish();
        dbServices.create(createQuery, connection);


        connection = dbServices.connectionEstablish();
        dbServices.insert(insertQuery, connection);


        connection = dbServices.connectionEstablish();
        dbServices.getDetails(selectQuery, connection);
    }
}





