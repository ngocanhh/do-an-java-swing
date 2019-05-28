/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.ChairDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChairDAO extends AbstractDAO<ChairDTO>{
    
    public ChairDTO findById(long id){
        String sql = "SELECT * FROM chair WHERE id = ?";
        ArrayList<ChairDTO> listChair = query(sql, ChairDTO.class, id);
        return listChair.isEmpty()? null : listChair.get(0);
    }
    
    public long save(ChairDTO chairDTO){
        String sql = "INSERT INTO chair VALUES(?,?,?)";
        return insert(sql, chairDTO.getChairCode(), chairDTO.getStatus(), chairDTO.getChairTypeId());
    }
    
    public ArrayList<ChairDTO> findAll(){
        String sql = "SELECT * FROM chair";
        return query(sql, ChairDTO.class);
    }
    
    public ChairDTO findByCode(String chairCode){
        String sql = "SELECT * FROM chair WHERE chaircode = ?";
        ArrayList<ChairDTO> listChair = query(sql, ChairDTO.class, chairCode);
        return listChair.isEmpty()? null : listChair.get(0);
    }
    
    
    public void update(ChairDTO chair){
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE chair SET chaircode = ?, status = ?, ");
        sql.append("chairtypeid = ? WHERE id = ?");
        update(sql.toString(), chair.getChairCode(), chair.getStatus(),
                chair.getChairTypeId(), chair.getId());
    }
    
    public void delete(long id){
        String sql = "DELETE FROM chair WHERE id = ?";
        update(sql, id);
    }
    
}