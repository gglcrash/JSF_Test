package com.jsfnetcracker.test;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Pm> getAuthors(){
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection con = getConnection();
        String stm = "Select * from pm";
        List<Pm> records = new ArrayList<Pm>();
        try {
            pst = con.prepareStatement(stm);
            pst.execute();
            rs = pst.getResultSet();

            while(rs.next()){
                Pm tmpPm = new Pm();
                tmpPm.setId(rs.getInt(1));
                tmpPm.setName(rs.getString(2));
                tmpPm.setIp(rs.getString(3));
                tmpPm.setDate(rs.getDate(4));
                tmpPm.setDescription(rs.getString(5));
                records.add(tmpPm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public Connection getConnection(){
        Connection con = null;

        String url = "jdbc:postgresql://localhost:5432/VNF";
        String user = "postgres";
        String password = "";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection completed.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        finally{
        }
        return con;
    }
}
