/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class RowMapper<T> {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<T> mapRow(ResultSet resultSet, Class tClass){
        ArrayList<T> listT = new ArrayList<>();
        try{
            ResultSetMetaData rsmd = resultSet.getMetaData();
            Field[] fields = tClass.getDeclaredFields();
        while(resultSet.next()){
            T object = (T) tClass.newInstance();
            for(int i = 0; i < rsmd.getColumnCount(); i++){
                String columnName = rsmd.getColumnName(i + 1);
                Object columnValue = resultSet.getObject(i + 1);
                for(Field field : fields){
                    if(field.getName().toLowerCase().equals(columnName) && columnValue != null){
                        BeanUtils.setProperty(object, field.getName(), columnValue);
                        break;
                    }
                }
            }
            listT.add(object);
        }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listT;
    }
}
