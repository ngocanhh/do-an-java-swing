/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.RoleDTO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class RoleDAO extends AbstractDAO<RoleDTO>{
    
    public RoleDTO findById(long id){
        String sql = "SELECT * FROM role WHERE id = ?";
        ArrayList<RoleDTO> listRole = query(sql, RoleDTO.class, id);
        return listRole.isEmpty()? null : listRole.get(0);
    }
}
