package com;
import com.implementation.DBImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by varsha.sharma on 13-07-2017.
 */
public class MyMainClass {

    public static void main(String args[]) throws SQLException {

        DBImplementation impleObj= new DBImplementation();

        Connection connection;
        String createQuery= "CREATE TABLE VarshaSharma("+
                "ID INTEGER NOT NULL,"+
                "NAME VARCHAR(30));";
        String insertQuery= "insert into VarshaSharma values"+
                                                        "(1,'Varsha');";

        String selectQuery="SELECT * FROM VarshaSharma";

        impleObj.registerConnection();

        connection = impleObj.connectionEstablish();
        impleObj.create(createQuery, connection);


        connection = impleObj.connectionEstablish();
        impleObj.insert(insertQuery, connection);


        connection = impleObj.connectionEstablish();
        impleObj.getDetails(selectQuery, connection);
    }
}
