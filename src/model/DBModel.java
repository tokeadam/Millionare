package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBModel implements IModel {

    private Connection conn;
    private PreparedStatement getAllKerdesPstmt;
    private PreparedStatement addKerdespstmt;
    private PreparedStatement updateKerdesPstmt;
    private PreparedStatement deleteKerdesPstmt;
   
    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        getAllKerdesPstmt = conn.prepareStatement("SELECT * FROM kerdes");        
        addKerdespstmt = conn.prepareStatement("INSERT INTO kerdes (kerdes,valasz0,valasz1,valasz2,valasz3,helyesvalasz) VALUES (?,?,?,?,?,?)");       
        updateKerdesPstmt = conn.prepareStatement("UPDATE kerdes SET id=?, kerdes=?, valasz0=?, valasz1=?, valasz2=?, valasz3=?, helyesvalasz=? WHERE id=?");
        deleteKerdesPstmt = conn.prepareStatement("DELETE from kerdes WHERE id=?");
    }      

    @Override
    public List<Kerdes> getAllKerdesek() throws SQLException {        
        List<Kerdes> kerdesek = new ArrayList<>();

        ResultSet rs = getAllKerdesPstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String kerdes = rs.getString("kerdes");
            String valasz0 = rs.getString("valasz0");
            String valasz1 = rs.getString("valasz1");
            String valasz2 = rs.getString("valasz2");
            String valasz3 = rs.getString("valasz3");
            int helyesValasz = rs.getInt("helyesvalasz");

            Kerdes kerd = new Kerdes(id, kerdes, valasz0, valasz1, valasz2, valasz3, helyesValasz);
            kerdesek.add(kerd);
        }
        rs.close();

        return kerdesek;
    }

    //LEZÁRJUK A CONNECTIONT:
    @Override
    public void close() throws SQLException {
        conn.close();
    }

    @Override
    public int updateKerdes(Kerdes k) throws SQLException {
        updateKerdesPstmt.setInt(1, k.getId());
        updateKerdesPstmt.setString(2, k.getKerdes());
        updateKerdesPstmt.setString(3, k.getValasz0());
        updateKerdesPstmt.setString(4, k.getValasz1());
        updateKerdesPstmt.setString(5, k.getValasz2());
        updateKerdesPstmt.setString(6, k.getValasz3());
        updateKerdesPstmt.setInt(7, k.getHelyesValasz());
        updateKerdesPstmt.setInt(8, k.getId());
        return updateKerdesPstmt.executeUpdate();        
    }

    @Override
    public Map<Integer, Kerdes> getKerdesMap() throws SQLException {
     Map<Integer, Kerdes> kerdesMap = new HashMap<>();

        List<Kerdes> kerdesek = getAllKerdesek();
        for (Kerdes k : kerdesek) {
            kerdesMap.put(k.getId(), k);
        }
        return kerdesMap; 
    }

    @Override
    public int addKerdes(Kerdes k) throws SQLException {
        addKerdespstmt.setString(1, k.getKerdes());
        addKerdespstmt.setString(2, k.getValasz0());
        addKerdespstmt.setString(3, k.getValasz1());
        addKerdespstmt.setString(4, k.getValasz2());
        addKerdespstmt.setString(5, k.getValasz3());
        addKerdespstmt.setInt(6, k.getHelyesValasz());
        
        return addKerdespstmt.executeUpdate();
    }

    @Override
    public int removeKerdes(Kerdes k) throws SQLException {
        deleteKerdesPstmt.setInt(1, k.getId());
        return deleteKerdesPstmt.executeUpdate();
    }
}
