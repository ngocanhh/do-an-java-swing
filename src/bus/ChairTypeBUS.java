/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.ChairTypeDAO;
import dto.ChairTypeDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChairTypeBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private ChairTypeDAO chairTypeDAO;
    
    public ChairTypeBUS(){
        chairTypeDAO = new ChairTypeDAO();
    }
    
     public ChairTypeDTO findById(long id){
        return chairTypeDAO.findById(id);
    }
    
    public ArrayList<ChairTypeDTO> findAll(){
        return chairTypeDAO.findAll();
    }
    
    public long findIdByCode(String chairTypeCode){
        return chairTypeDAO.findByCode(chairTypeCode).getId();
    }
}
