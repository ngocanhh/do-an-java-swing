/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import dto.ShowtimesDTO;

/**
 *
 * @author ADMIN
 */
public class ShowtimesDAO extends AbstractDAO<ShowtimesDTO>{
    
    public long insert(ShowtimesDTO showtimes){
        String sql = "INSERT INTO showtimes VALUES(?,?,?,?,?)";
        return insert(sql, showtimes.getShowTimesCode(), showtimes.getProjectionDate(),
                showtimes.getMovieTimesId(), showtimes.getRoomId(), showtimes.getMovieId());
    }
    
    public ShowtimesDTO findById(long id){
        String sql = "SELECT * FROM showtimes WHERE id = ?";
        ArrayList<ShowtimesDTO> listShowtimeses = query(sql, ShowtimesDTO.class, id);
        return listShowtimeses.isEmpty()? null : listShowtimeses.get(0);
    }
    
    public ArrayList<ShowtimesDTO> findAll(){
        String sql = "SELECT * FROM showtimes";
        return query(sql, ShowtimesDTO.class);
    }
    
    public ShowtimesDTO findByCode(String showtimesCode){
        String sql = "SELECT * FROM showtimes WHERE showtimescode = ?";
        ArrayList<ShowtimesDTO> list = query(sql, ShowtimesDTO.class, showtimesCode);
        return list.isEmpty()? null : list.get(0);
    }
    
}
