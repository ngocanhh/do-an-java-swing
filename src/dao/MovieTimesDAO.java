/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.util.ArrayList;
import dto.MovieTimesDTO;
/**
 *
 * @author ADMIN
 */
public class MovieTimesDAO extends AbstractDAO<MovieTimesDTO>{
    
    public ArrayList<MovieTimesDTO> findAll(){
        String sql = "SELECT * FROM movietimes";
        return query(sql, MovieTimesDTO.class);
    }
    
    public MovieTimesDTO findByMovieTimesCode(String movieTimesCode){
        String sql = "SELECT * FROM movietimes WHERE movietimescode = ?";
        ArrayList<MovieTimesDTO> listMovieTimeses = query(sql, MovieTimesDTO.class, movieTimesCode);
        return listMovieTimeses.isEmpty()? null : listMovieTimeses.get(0);
    }
    
    public MovieTimesDTO findById(long id){
        String sql = "SELECT * FROM movietimes WHERE id = ?";
        ArrayList<MovieTimesDTO> list = query(sql, MovieTimesDTO.class, id);
        return list.isEmpty()? null : list.get(0);
    }
    
}
