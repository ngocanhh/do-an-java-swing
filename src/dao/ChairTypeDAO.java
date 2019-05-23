/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.ChairTypeDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChairTypeDAO extends AbstractDAO<ChairTypeDTO>{
    
    public ArrayList<ChairTypeDTO> findAll(){
        String sql = "SELECT * FROM chairtype";
        return query(sql, ChairTypeDTO.class);
    }
    
    public ChairTypeDTO findByCode(String chairTypeCode){
        String sql = "SELECT * FROM chairtype WHERE chairtypecode = ?";
        ArrayList<ChairTypeDTO> listChairType = query(sql, ChairTypeDTO.class, chairTypeCode);
        return listChairType.isEmpty()? null : listChairType.get(0);
    }
}
