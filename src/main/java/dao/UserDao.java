package dao;

import model.Category;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao implements iCRUDdao<User> {
    final String SQL_LOGIN = "SELECT * FROM User WHERE email = ? and password = ?";

    final String SQL_GET_ALL = "SELECT * FROM User";
    final String SQL_FIND = "SELECT * FROM User WHERE alias LIKE (?)";
    final String SQL_FIND_ID = "SELECT * FROM User WHERE id = ?";
    final String SQL_ADD = "INSERT INTO `newblogs`.`user`" +
            " ( `email`, `password`, `fullname`, `alias`, `role`, `aboutme`, `image`, `yearofbirth`)" +
            "VALUES (? , ? , ? , ? , ? , ? , ? , ? );";
    final String SQL_UPDATE = "UPDATE `newblogs`.`user` SET `email` = ?, " +
            " `fullname` = ?, `alias` = ?, `aboutme` = ?, `image` = ?,`yearofbirth` = ? WHERE (`id` = ?);";
    final String SQL_DELETE = "DELETE FROM User WHERE (id=?)";


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
    public List<User> getAll()  {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = getConnection();
        PreparedStatement st = connection.prepareStatement(SQL_GET_ALL);
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String alias = resultSet.getString("alias");
                boolean role = resultSet.getBoolean("role");
                String aboutMe = resultSet.getString("aboutMe");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("createDate");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                users.add(new User(id, email, password, fullName, alias, role, aboutMe, image, createDate, yearOfBirth));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findByKeyword(String keyword) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND)
        ) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String alias = resultSet.getString("alias");
                boolean role = resultSet.getBoolean("role");
                String aboutMe = resultSet.getString("aboutMe");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("createDate");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                users.add(new User(id, email, password, fullName, alias, role, aboutMe, image, createDate, yearOfBirth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String alias = resultSet.getString("alias");
                boolean role = resultSet.getBoolean("role");
                String aboutMe = resultSet.getString("aboutMe");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("createDate");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                user = new User(id,  email, password, fullName, alias, role, aboutMe, image, createDate, yearOfBirth);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;

    }

    @Override
    public boolean add(User user) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
            PreparedStatement st = connection.prepareStatement(SQL_ADD);
        ) {
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getFullName());
            st.setString(4, user.getAlias());
            st.setBoolean(5, user.getRole());
            st.setString(6, user.getAboutMe());
            st.setString(7, user.getImage());
            st.setInt(8, user.getYearOfBirth());
            rowDeleted = st.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User user) {
        boolean rowEdit = false;
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(SQL_UPDATE)
        ) {

            st.setString(1, user.getEmail());
            st.setString(2, user.getFullName());
            st.setString(3, user.getAlias());
            st.setString(4, user.getAboutMe());
            st.setString(5, user.getImage());
            st.setInt(6, user.getYearOfBirth());
            st.setInt(7,user.getId());
            rowEdit = st.executeUpdate() > 0;
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

    public User login(String email, String password) {
        User user = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_LOGIN)
        ) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String alias = resultSet.getString("alias");
                boolean role = resultSet.getBoolean("role");
                String aboutMe = resultSet.getString("aboutMe");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("createDate");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                user = new User(id, email, password, fullName, alias, role, aboutMe, image, createDate, yearOfBirth);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public boolean checkUser(String email,String pass) throws SQLException {
        List<User> userList = getAll();
        for (User user : userList) {
            if (email.equals(user.getEmail())&& pass.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
