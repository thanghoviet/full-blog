package dao;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BaseDao implements iCRUDdao<Category> {
    final String SQL_GET_ALL = "SELECT * FROM Category";
    final String SQL_FIND = "SELECT * FROM Category WHERE title LIKE (?)";
    final String SQL_FIND_ID = "SELECT * FROM category WHERE id = ?";
    final String SQL_ADD = "INSERT INTO Category(title,description) VALUE (?,?)";
    final String SQL_UPDATE = "UPDATE Category SET title = ?,description = ? WHERE id = ?";
    final String SQL_DELETE = "DELETE FROM Category WHERE (id=?)";

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        setConnection();
        PreparedStatement st = connection.prepareStatement(SQL_GET_ALL);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            categoryList.add(new Category(id, title, description));
        }
        disConnection();
        return categoryList;
    }

    @Override
    public List<Category> findByKeyword(String keyword) {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection=getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND)
        ) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                categoryList.add(new Category(id,title,description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(int id) {
        Category category=new Category();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                category = new Category(id, title, description);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;

    }

    @Override
    public boolean add(Category category) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD)
        ) {
            PreparedStatement st = connection.prepareStatement(SQL_ADD);
            st.setString(1, category.getTitle());
            st.setString(2, category.getDescription());
            st.executeUpdate();
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Category category) {
        boolean rowEdit = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)
        ) {
            statement.setString(1, category.getTitle());
            statement.setString(2, category.getDescription());
            statement.setInt(3,category.getId());
            rowEdit = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowEdit;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }
}
