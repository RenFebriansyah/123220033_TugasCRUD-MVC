/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatafilm.datafilmDAO;
import DAOimplement.datafilmimplement;
import model.datafilm;
import model.modeltabeldatafilm;
import view.MainView;
/**
 *
 * @author ACER
 */
public class datafilmcontroller {
    MainView frame;
    datafilmimplement impldatafilm;
    List<datafilm> dm;
    
    public datafilmcontroller(MainView frame) {
      this.frame = frame;
      this.impldatafilm = new datafilmDAO();
      this.dm = this.impldatafilm.getAll();
   }

   public void isitabel() {
      this.dm = this.impldatafilm.getAll();
      modeltabeldatafilm mp = new modeltabeldatafilm(this.dm);
      this.frame.getTabelDatafilm().setModel(mp);
   }
       public void insert() {
      datafilm dm = new datafilm();
      dm.setJudul(this.frame.getJTxtjudul().getText());
      double alur = Double.parseDouble(this.frame.getJtxtalur().getText());
      dm.setAlur(alur);
      double penokohan = Double.parseDouble(this.frame.getJtxtpenokohan().getText());
      dm.setPenokohan(penokohan);
      double akting = Double.parseDouble(this.frame.getJtxtakting().getText());
      dm.setAkting(akting);
  
      this.impldatafilm.insert(dm);
   }
       
        public void update() {
      datafilm dm = new datafilm();
      dm.setJudul(this.frame.getJTxtjudul().getText());
      double alur = Double.parseDouble(this.frame.getJtxtalur().getText());
      dm.setAlur(alur);
      double penokohan = Double.parseDouble(this.frame.getJtxtpenokohan().getText());
      dm.setPenokohan(penokohan);
      double akting = Double.parseDouble(this.frame.getJtxtakting().getText());
      dm.setAkting(akting);
      double nilai = (alur + penokohan + akting) / 3.0;
      dm.setNilai(nilai);
      this.impldatafilm.update(dm);
   }
        
      public void delete() {
      String judul = this.frame.getJTxtjudul().getText();
      this.impldatafilm.delete(judul);
      this.isitabel();
   }

}
  