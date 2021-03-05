package dao;

import java.sql.SQLException;
import java.util.List;

public interface iCRUDdao <T>{
    List<T> getAll() throws SQLException;
    List<T> findByKeyword(String keyword);

    T findById(int id);
    boolean add(T t) throws SQLException;
    boolean update(T t);
    boolean delete(int id);

}
