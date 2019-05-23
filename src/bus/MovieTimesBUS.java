/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.MovieTimesDAO;
import dto.MovieTimesDTO;

/**
 *
 * @author ADMIN
 */
public class MovieTimesBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private MovieTimesDAO movieTimesDAO;

    public MovieTimesBUS() {
        movieTimesDAO = new MovieTimesDAO();
    }
    
    public long findIdByMovieTimesCode(String movieTimesCode){
        return movieTimesDAO.findByMovieTimesCode(movieTimesCode).getId();
    }
    
    public MovieTimesDTO findById(long id){
        return movieTimesDAO.findById(id);
    }
    
}
