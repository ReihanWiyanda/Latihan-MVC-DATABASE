/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmvcjdbc.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import latihanmvcjdbc.impl.PelangganDaoImp;
import latihanmvcjdbc.service.PelangganDao;

/**
 *
 * @author 
 *  Nama    : Reihan Wiyanda
 *  Kelas   : IF-1
 *  Nim     : 10119011
 */
public class KingBarbershopDatabase {
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection==null) {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/kingsbarbarshop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            
        }
        
        return connection;
    }
    
    public static PelangganDao getPelangganDao() throws SQLException {
        if (pelangganDao==null) {
            pelangganDao = new PelangganDaoImp(getConnection());
        }
        
        return pelangganDao;
    }
}
