package dto;
// loại ghế
public class ChairTypeDTO {
    private long id;
    private String chairTypeCode; // mã loại ghế
    private double costOfTicket; // giá vé

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

    public double getCostOfTicket() {
        return costOfTicket;
    }

    public void setCostOfTicket(double costOfTicket) {
        this.costOfTicket = costOfTicket;
    }
    
    
}
