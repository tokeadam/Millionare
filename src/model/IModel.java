package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IModel {
    List<Kerdes> getAllKerdesek() throws SQLException; 
    int addKerdes(Kerdes k) throws SQLException;
    int updateKerdes(Kerdes k) throws SQLException;
    int removeKerdes(Kerdes k) throws SQLException;
    public Map<Integer, Kerdes> getKerdesMap() throws SQLException;
    //bezárjuk ezzel a kapcsolatot:
    public void close() throws SQLException;
    
}
