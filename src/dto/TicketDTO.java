package dto;

import java.sql.Timestamp;
// vé
public class TicketDTO {
    private long id;
    private long chairId;
    private long showtimesId;
    private long userId;
    private Timestamp dateOfSale;  // ngày bán

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Timestamp dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public long getChairId() {
        return chairId;
    }

    public void setChairId(long chairId) {
        this.chairId = chairId;
    }

    public long getShowtimesId() {
        return showtimesId;
    }

    public void setShowtimesId(long showtimesId) {
        this.showtimesId = showtimesId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
}