package dao;

import model.Category;
import model.Comment;
import model.Post;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends BaseDao implements iCRUDdao<Post>{
    final String SQL_GET_ALL = "SELECT * FROM v_postinfo;";
    final String SQL_FIND = "SELECT * FROM v_postinfo WHERE title LIKE (?)";
    final String SQL_FIND_ID = "SELECT * FROM v_postinfo WHERE id = ?";
    final String SQL_ADD = "INSERT INTO `post` (`title`,`sort_content`,`content`,`image`,`user_id`,`category_id`) VALUES (?,?,?,?,?,?)";
    final String SQL_UPDATE = "UPDATE post SET " +
            "title = ?, sort_content = ?, content = ?,image = ?,  category_id = ? " +
            "WHERE id = ?";
    final String SQL_DELETE = "DELETE FROM post WHERE (id=?)";
    final String SQL_TOP_3 = "SELECT * FROM v_postinfo order by id desc limit 0,3;";
    final String SQL_TOP_8 = "SELECT * FROM v_postinfo order by id desc limit 0,8;";
    final String SQL_1_POST_RANDOM ="SELECT * FROM v_postinfo order by rand() limit 1";
    final String SQL_FIND_BY_CATEGORY = "SELECT * FROM v_postinfo WHERE category_id LIKE (?)";

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

    public List<Post> findByCategoryID(int keyword) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_CATEGORY)
        ) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<Post> getPostRandom() {
        List<Post> posts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement st = connection.prepareStatement(SQL_1_POST_RANDOM);
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement st = connection.prepareStatement(SQL_GET_ALL);
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<Post> top3() {
        List<Post> posts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement st = connection.prepareStatement(SQL_TOP_3);
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<Post> top8() {
        List<Post> posts = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement st = connection.prepareStatement(SQL_TOP_8);
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }


    @Override
    public List<Post> findByKeyword(String keyword) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND)
        ) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                posts.add(new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post post = new Post();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String sortContent = resultSet.getString("sort_content");
                String content = resultSet.getString("content");
                String image = resultSet.getString("image");
                Date createDate = resultSet.getDate("create_date");
                Date editDate = resultSet.getDate("edit_date");
                int user_id = resultSet.getInt("user_id");
                String alias =resultSet.getString("alias");
                User user = new User(user_id,alias);
                int categoryId = resultSet.getInt("category_id");
                String titleCategory = resultSet.getString("titled");
                Category category = new Category(categoryId,titleCategory);

                post = new Post(id, title, sortContent,content, image, createDate,editDate,user,user_id,category,categoryId);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    @Override
    public boolean add(Post post) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(SQL_ADD);
        ) {
            st.setString(1, post.getTitle());
            st.setString(2, post.getSortContent());
            st.setString(3, post.getContent());
            st.setString(4, post.getImage());
            st.setInt(5,post.getUse().getId());
            st.setInt(6,post.getCategory().getId());

            rowDeleted = st.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Post post) {
        boolean rowEdit = false;
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(SQL_UPDATE)
        ) {
            st.setString(1, post.getTitle());
            st.setString(2, post.getSortContent());
            st.setString(3, post.getContent());
            st.setString(4, post.getImage());
            st.setInt(5,post.getCategory().getId());
            st.setInt(6, post.getId());

            rowEdit = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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
