/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import dto.RoomDTO;

/**
 *
 * @author ADMIN
 */
public class RoomDAO extends AbstractDAO<RoomDTO>{
    
    /**
     * Truy vấn tất cả phòng trong hệ thống
     * @return danh sách RoomDTO
     */
    public ArrayList<RoomDTO> findAll(){
        String sql = "SELECT * FROM room";
        return query(sql, RoomDTO.class);
    }
    
    /**
     * Tìm kiếm theo mã phòng
     * @param roomCode
     * @return 
     */
    public RoomDTO findByCode(String roomCode){
        String sql = "SELECT * FROM room WHERE roomcode = ?";
        ArrayList<RoomDTO> listRoom = query(sql, RoomDTO.class, roomCode);
        return listRoom.isEmpty()? null : listRoom.get(0);
    }
    
    /**
     * Tìm kiếm theo id
     * @param id
     * @return RoomDTO 
     */
    public RoomDTO findById(long id){
        String sql = "SELECT * FROM room WHERE id = ?";
        ArrayList<RoomDTO> listRooms = query(sql, RoomDTO.class, id);
        return listRooms.isEmpty()? null : listRooms.get(0);
    }
}
