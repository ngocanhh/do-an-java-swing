package bus;
import dto.MovieDTO;
import dao.*;
import java.util.ArrayList;
public class MovieBUS {
    
    @SuppressWarnings("FieldMayBeFinal")
    private MovieDAO movieDAO;
    
    public MovieBUS(){
        movieDAO = new MovieDAO();
    }
    
    public MovieDTO save(MovieDTO movie){
        movie.setId(movieDAO.save(movie));
        return movieDAO.findById(movie.getId());
    }
    
    public ArrayList<MovieDTO> findAll(){
        return movieDAO.findAll();
    }
    
    
    public long findIdMovie(String movieCode){
        return movieDAO.findByMovieCode(movieCode).getId();
    }
    
    public MovieDTO update(MovieDTO movie){
        movieDAO.update(movie);
        return movieDAO.findById(movie.getId());
    }
    
    public void delete(MovieDTO movie){
        movieDAO.delete(movie.getId());
    }
    
    
    public MovieDTO findById(long id){
        return movieDAO.findById(id);
    }
    
    public MovieDTO findByCode(String movieCode){
        return movieDAO.findByMovieCode(movieCode);
    }
}
