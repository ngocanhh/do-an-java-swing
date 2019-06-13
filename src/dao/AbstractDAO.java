package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mapper.RowMapper;



/**
 * Chứa các câu lệnh query, insert, update, delete
 * dùng chung cho các đối tượng của hệ thống
 * Sử dụng generic
 * @author ADMIN
 * @param <T> Các class con khi kế thừa phải chỉ rõ đối tượng T 
 */

public class AbstractDAO<T> {
    
    /**
     * Kết nối CSDL
     * @return Connection
     */
    public Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "na";
            String password = "na";
            String url = "jdbc:sqlserver://localhost;databaseName=QLBANVEXEMPHIM";
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * Set giá trị cho các tham số
     * @param statement
     * @param parameters 
     */
    public void setParameter(PreparedStatement statement, Object... parameters){
        try{
        int index;
        for(int i = 0; i < parameters.length; i++){
            index = i +1;
            Object parameter = parameters[i];
            statement.setObject(index, parameter);
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Phương thức query dùng chung cho tất cả các đối tượng,
     * sử dụng generic 
     * @param sql 
     *        Câu sql dùng để truy vấn
     * @param tClass
     *        Class cần trả về
     * @param parameters
     *        Danh sách các tham số của câu sql
     * @return 
     */
    public ArrayList<T> query(String sql, Class<T> tClass, Object... parameters){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            RowMapper<T> rowMapper = new RowMapper<>();
            return rowMapper.mapRow(resultSet, tClass);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Phương thức thêm dữ liệu sử dụng chung cho tất cả các đối tượng
     * @param sql
     *        Câu sql dùng để thêm dữ liệu
     * @param parameters
     *        Danh sách tham số
     * @return 
     */
    @SuppressWarnings({"static-access", "null"})
    public long insert(String sql, Object... parameters){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        long id = 0;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }finally{
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Vừa update vừa delete
     * Dùng chung cho tất cả các đối tượng
     * @param sql
     * @param parameters 
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public void update(String sql, Object... parameters){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    
}
