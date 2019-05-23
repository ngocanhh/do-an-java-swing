/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.TicketDAO;
import dto.TicketDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TicketBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private TicketDAO ticketDAO;
    
    public TicketBUS(){
        ticketDAO = new TicketDAO();
    }
    
    public TicketDTO save(TicketDTO ticketDTO){
        long id = ticketDAO.save(ticketDTO);
        return ticketDAO.findById(id);
    }
    
    public ArrayList<TicketDTO> findAll(){
        return ticketDAO.findAll();
    }
}
