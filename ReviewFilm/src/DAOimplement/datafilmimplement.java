/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplement;
import java.util.List;
import model.datafilm;
/**
 *
 * @author ACER
 */
public interface datafilmimplement {
    
    public void insert(datafilm p);
    public void update(datafilm p);
    public void delete(String judul);
    
    List<datafilm> getAll();
}
