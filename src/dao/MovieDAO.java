package dao;
import dto.MovieDTO;
import java.util.ArrayList;

public class MovieDAO extends AbstractDAO<MovieDTO>{
    
    public MovieDTO findById(long id){
        String sql = "SELECT * FROM movie WHERE id = ?";
        ArrayList<MovieDTO> listMovie = query(sql, MovieDTO.class, id);
        return listMovie.isEmpty()? null : listMovie.get(0);
    }
    
    public long save(MovieDTO movie){
        String sql = "INSERT INTO movie VALUES(?,?,?,?,?,?)";
        return insert(sql, movie.getMovieCode(),movie.getMovieName(),movie.getTime(),
                movie.getProducer(),movie.getCategory(),movie.getShortDescription());
    }
    
    public ArrayList<MovieDTO> findAll(){
        String sql = "SELECT * FROM movie";
        return query(sql, MovieDTO.class);
    }
    
    public MovieDTO findByMovieCode(String moviecode){
        String sql = "SELECT * FROM movie WHERE moviecode = ?";
        ArrayList<MovieDTO> listMovie = query(sql, MovieDTO.class, moviecode);
        return listMovie.isEmpty()? null : listMovie.get(0);
    }
    
    public void update(MovieDTO movie){
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE movie SET moviecode = ?, moviename = ?, time = ?,");
        sql.append("producer = ?, category = ?, shortdescription = ? WHERE id = ?");
        update(sql.toString(), movie.getMovieCode(), movie.getMovieName(), movie.getTime(),
                movie.getProducer(), movie.getCategory(), movie.getShortDescription(), movie.getId());
    }
    
    public void delete(long id){
        String sql = "DELETE FROM movie WHERE id = ?";
        update(sql, id);
    }
}
