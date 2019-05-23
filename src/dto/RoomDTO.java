package dto;
// phòng
public class RoomDTO {
    private long id;
    private String roomCode; // mã phòng
    private String roomName;  // tên phòng
    private int numberOfChair1Row;  // số ghế của 1 dãy
    private int numberOfRow;  // Số lượng dãy

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfChair1Row() {
        return numberOfChair1Row;
    }

    public void setNumberOfChair1Row(int numberOfChair1Row) {
        this.numberOfChair1Row = numberOfChair1Row;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    
}
