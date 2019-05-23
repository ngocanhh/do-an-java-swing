package dto;

import java.sql.Time;
// Ca chiếu
public class MovieTimesDTO {
    private long id;
    private String movieTimesCode;  // mã ca chiếu
    private Time projectionTime;  // thời gian bắt đầu

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieTimesCode() {
        return movieTimesCode;
    }

    public void setMovieTimesCode(String movieTimesCode) {
        this.movieTimesCode = movieTimesCode;
    }

    public Time getProjectionTime() {
        return projectionTime;
    }

    public void setProjectionTime(Time projectionTime) {
        this.projectionTime = projectionTime;
    }
    
    
}
