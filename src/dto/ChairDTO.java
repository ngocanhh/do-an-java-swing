package dto;

public class ChairDTO {
    private long id;
    private String chairCode; // mã ghế
    private String status; // trạng thái
    private long chairTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChairCode() {
        return chairCode;
    }

    public void setChairCode(String chairCode) {
        this.chairCode = chairCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getChairTypeId() {
        return chairTypeId;
    }

    public void setChairTypeId(long chairTypeId) {
        this.chairTypeId = chairTypeId;
    }
    
}
