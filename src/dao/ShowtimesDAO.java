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
    
    public long save(ShowtimesDTO showtimes){
        String sql = "INSERT INTO showtimes VALUES(?,?,?,?,?)";
        return insert(sql, showtimes.getShowTimesCode(), showtimes.getProjectionDate(),
                showtimes.getMovieTimesId(), showtimes.getRoomId(), showtimes.getMovieId());
    }
    
    public ArrayList<ShowtimesDTO> findById(long id){
        String sql = "SELECT * FROM showtimes WHERE id = ?";
        return query(sql, ShowtimesDTO.class, id);
    }
    
    public ArrayList<ShowtimesDTO> findAll(){
        String sql = "SELECT * FROM showtimes";
        return query(sql, ShowtimesDTO.class);
    }
    
    public ArrayList<ShowtimesDTO> findByMovieId(long movieId){
        String sql = "SELECT * FROM showtimes WHERE movieid = ?";
        return query(sql, ShowtimesDTO.class, movieId);
    }
    
    public ShowtimesDTO findByCode(String showtimesCode){
        String sql = "SELECT * FROM showtimes WHERE showtimescode = ?";
        ArrayList<ShowtimesDTO> list = query(sql, ShowtimesDTO.class, showtimesCode);
        return list.isEmpty()? null : list.get(0);
    }
    
    public void update(ShowtimesDTO showtimes){
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE showtimes SET showtimescode = ?, projectiondate = ?,");
        sql.append("movietimesid = ?, roomid = ?, movieid = ? WHERE id = ?");
        update(sql.toString(), showtimes.getShowTimesCode(), showtimes.getProjectionDate(),
               showtimes.getMovieTimesId(),showtimes.getRoomId(),showtimes.getMovieId(),showtimes.getId());
    }
    
    public void delete(long id){
        String sql = "DELETE FROM showtimes WHERE id = ?";
        update(sql, id);
    }
    
}
