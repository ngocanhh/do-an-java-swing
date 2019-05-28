/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.ShowtimesDAO;
import dto.ShowtimesDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ShowtimesBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private ShowtimesDAO showtimesDAO;
    
    public ShowtimesBUS(){
        showtimesDAO = new ShowtimesDAO();
    }
    
    public ShowtimesDTO save(ShowtimesDTO showtimes){
        showtimes.setId(showtimesDAO.insert(showtimes));
        return showtimesDAO.findById(showtimes.getId());
    }
    
    public ArrayList<ShowtimesDTO> findAll(){
        return showtimesDAO.findAll();
    }
    
    public ShowtimesDTO findByCode(ShowtimesDTO showtimesDTO){
        return showtimesDAO.findByCode(showtimesDTO.getShowTimesCode());
    }
    
    public ShowtimesDTO findById(long id){
        return showtimesDAO.findById(id);
    }
    
}
