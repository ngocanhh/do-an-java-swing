/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.TicketDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TicketDAO extends AbstractDAO<TicketDTO>{
    
    public TicketDTO findById(long id){
        String sql = "SELECT * FROM ticket WHERE id = ?";
        ArrayList<TicketDTO> listTicket = query(sql, TicketDTO.class, id);
        return listTicket.isEmpty()? null : listTicket.get(0);
    }
    
    public long save(TicketDTO ticketDTO){
        String sql = "INSERT INTO ticket VALUES(?,?,?,?)";
        return insert(sql, ticketDTO.getChairId(), ticketDTO.getShowtimesId(),
               ticketDTO.getUserId() , ticketDTO.getDateOfSale());
    }
    
    public ArrayList<TicketDTO> findAll(){
        String sql = "SELECT * FROM ticket";
        return query(sql, TicketDTO.class);
    }
    
    public TicketDTO findByChairIdAndShowtimesId(long chairId, long showtimesId){
        String sql = "SELECT * FROM ticket WHERE chairid = ? AND showtimesid = ?";
        ArrayList<TicketDTO> tickets = query(sql, TicketDTO.class, chairId, showtimesId);
        return tickets.isEmpty()? null : tickets.get(0);
    }
    
}
