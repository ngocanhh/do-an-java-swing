/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.UserDTO;
import java.util.ArrayList;

/**
 * Chứa các câu query, insert, update, delete
 * của đối tượng UserDTO
 * @author ADMIN
 */
public class UserDAO extends AbstractDAO<UserDTO>{
    
    /**
     * 
     * @param id User cần tìm
     * @return User
     */
    public UserDTO findById(long id){
        String sql = "SELECT * FROM users WHERE id = ?";
        ArrayList<UserDTO> listUser = query(sql, UserDTO.class, id);
        return listUser.isEmpty()? null : listUser.get(0);
    }
    
    /**
     * Xác thực tài khoản
     * @param userName
     * @param password
     * @return UserDTO 
     */
    public UserDTO findByUserNameAndPassword(String userName, String password){
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        ArrayList<UserDTO> listUser = query(sql, UserDTO.class, userName, password);
        return listUser.isEmpty()? null : listUser.get(0);
    }
    
    /**
     * Thêm nhân viên
     * @param userDTO
     * @return id
     */
    public long save(UserDTO userDTO){
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";
        return insert(sql, userDTO.getRoleId(), userDTO.getUserName(), userDTO.getPassword(),
                userDTO.getFullName(), userDTO.getDateOfBirth(), userDTO.getSex(), 
                userDTO.getAddress(), userDTO.getPhoneNumber(), userDTO.getUserCode());
    }
    
    /**
     * Truy vấn tất cả các User
     * @return danh sách User của hệ thống
     */
    public ArrayList<UserDTO> findAll(){
        String sql = "SELECT * FROM users";
        return query(sql, UserDTO.class);
    }
    
    
    /**
     * Cập nhật thông tin User
     * @param user 
     */
    public void update(UserDTO user){
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE users SET usercode = ?, fullname = ?, dateofbirth = ?, ");
        sql.append("sex = ?, address = ?, phonenumber = ? WHERE id = ?");
        update(sql.toString(), user.getUserCode(), user.getFullName(), user.getDateOfBirth(),
                user.getSex(), user.getAddress(), user.getPhoneNumber(), user.getId());
    }
    
    /**
     * Xóa một User theo id
     * @param id 
     */
    public void delete(long id){
        String sql = "DELETE FROM users WHERE id = ?";
        update(sql, id);
    }
}
