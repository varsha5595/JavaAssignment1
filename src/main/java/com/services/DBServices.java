package com.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by varsha.sharma on 12-07-2017.
 */
public interface DBServices {

    public  void registerConnection();

    public Connection connectionEstablish();

    public void create(String query,Connection connection) throws SQLException;

    public void insert(String query,Connection connection) throws SQLException;

    public ResultSet getDetails(String query, Connection connection)throws SQLException;
}
