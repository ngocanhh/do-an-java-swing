package dto;

import java.sql.Date;
// lịch chiếu
public class ShowtimesDTO {
    private long id;
    private String showTimesCode; // mã lịch chiếu
    private Date projectionDate;  // ngày chiếu
    private long movieTimesId;
    private long roomId;
    private long movieId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShowTimesCode() {
        return showTimesCode;
    }

    public void setShowTimesCode(String showTimesCode) {
        this.showTimesCode = showTimesCode;
    }

    public Date getProjectionDate() {
        return projectionDate;
    }

    public void setProjectionDate(Date projectionDate) {
        this.projectionDate = projectionDate;
    }

    public long getMovieTimesId() {
        return movieTimesId;
    }

    public void setMovieTimesId(long movieTimesId) {
        this.movieTimesId = movieTimesId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    
}