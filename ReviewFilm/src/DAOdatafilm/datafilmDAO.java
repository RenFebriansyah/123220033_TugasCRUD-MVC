/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatafilm;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.datafilmimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAOimplement.datafilmimplement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import model.datafilm;
/**
 *
 * @author ACER
 */
public class datafilmDAO implements datafilmimplement {
     Connection connection = connector.connection();
   final String select = "select * from datafilm;";
   final String insert = "INSERT INTO datafilm (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
   final String update = "update datafilm set alur=?, penokohan=?, akting=?, nilai=? where judul=?";
   final String delete = "delete from datahp where judul=?";

    @Override
    public void insert(datafilm p) {
        PreparedStatement statement = null;

      try {
         double nilai = (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3.0;
         statement = this.connection.prepareStatement("INSERT INTO `movie`(`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES (?, ?, ?, ?, ?);", 1);
         statement.setString(1, p.getJudul());
         statement.setDouble(2, p.getAlur());
         statement.setDouble(3, p.getPenokohan());
         statement.setDouble(4, p.getAkting());
         statement.setDouble(5, nilai);
         statement.executeUpdate();
         ResultSet rs = statement.getGeneratedKeys();

         while(rs.next()) {
            p.setJudul(rs.getString(1));
         }
      } catch (SQLException var12) {
         var12.printStackTrace();
      } finally {
         try {
            statement.close();
         } catch (SQLException var11) {
            var11.printStackTrace();
         }

      }
    }

    @Override
    public void update(datafilm p) {
         PreparedStatement statement = null;

      try {
         statement = this.connection.prepareStatement("UPDATE movie SET alur=?, penokohan=?, akting=?, nilai=? WHERE judul=?");
         statement.setDouble(1, p.getAlur());
         statement.setDouble(2, p.getPenokohan());
         statement.setDouble(3, p.getAkting());
         statement.setDouble(4, (p.getAlur() + p.getPenokohan() + p.getAkting()) / 3.0);
         statement.setString(5, p.getJudul());
         statement.executeUpdate();
      } catch (SQLException var12) {
         var12.printStackTrace();
      } finally {
         try {
            if (statement != null) {
               statement.close();
            }
         } catch (SQLException var11) {
            var11.printStackTrace();
         }
      }
    }
    
   // @Override
    public void delete(String judul) {
        
      PreparedStatement statement = null;

      try {
         String deleteQuery = "DELETE FROM movie WHERE judul=?";
         statement = this.connection.prepareStatement(deleteQuery);
         statement.setString(1, judul);
         statement.executeUpdate();
      } catch (SQLException var12) {
         var12.printStackTrace();
      } finally {
         try {
            if (statement != null) {
               statement.close();
            }
         } catch (SQLException var11) {
            var11.printStackTrace();
         }

      }

   }
    

    @Override
    public List<datafilm> getAll() {
        List<datafilm> dm = null;

      try {
         dm = new ArrayList();
         Statement st = this.connection.createStatement();
         ResultSet rs = st.executeQuery("select * from movie;");

         while(rs.next()) {
            datafilm film = new datafilm();
            film.setJudul(rs.getString("judul"));
            film.setAlur(rs.getDouble("alur"));
            film.setPenokohan(rs.getDouble("penokohan"));
            film.setAkting(rs.getDouble("akting"));
            film.setNilai
        (rs.getDouble("nilai"));
            dm.add(film);
         }
      } catch (SQLException var5) {
         Logger.getLogger(datafilmDAO.class.getName()).log(Level.SEVERE, (String)null, var5);
      }

      return dm;
    }

   
   
   
}
