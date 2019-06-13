package dto;
// loại ghế
public class ChairTypeDTO {
    
    private long id;
    private String chairTypeCode; // mã loại ghế
    private int costOfTicket; // giá vé

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChairTypeCode() {
        return chairTypeCode;
    }

    public void setChairTypeCode(String chairTypeCode) {
        this.chairTypeCode = chairTypeCode;
    }

    public int getCostOfTicket() {
        return costOfTicket;
    }

    public void setCostOfTicket(int costOfTicket) {
        this.costOfTicket = costOfTicket;
    }
   
}
