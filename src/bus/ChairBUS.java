/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.ChairDAO;
import dto.ChairDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChairBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private ChairDAO chairDAO;
    
    public ChairBUS(){
        chairDAO = new ChairDAO();
    }
    
    public ChairDTO save(ChairDTO chairDTO){
        long id = chairDAO.save(chairDTO);
        return chairDAO.findById(id);
    }
    
    public ArrayList<ChairDTO> findAll(){
        return chairDAO.findAll();
    }
    
    public ChairDTO findByCode(ChairDTO chairDTO){
        return chairDAO.findByCode(chairDTO.getChairCode());
    }
    
    public ChairDTO findById(long id){
        return chairDAO.findById(id);
    }
    
}
