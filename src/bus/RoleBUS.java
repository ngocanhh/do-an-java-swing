/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus;

import dao.RoleDAO;
import dto.RoleDTO;

/**
 *
 * @author ADMIN
 */
public class RoleBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private RoleDAO roleDAO;
    
    public RoleBUS(){
        roleDAO = new RoleDAO();
    }
    
    public RoleDTO findById(long id){
        return roleDAO.findById(id);
    }
}
