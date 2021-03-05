package dao;

import model.Comment;
import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

public class CommentDao extends BaseDao implements iCRUDdao<Comment> {
    final String SQL_GET_ALL ="SELECT `comment`.*,post.title FROM `comment` JOIN post ON post_id = post.id";
    final String SQL_FIND = "SELECT `comment`.*,post.title FROM `comment` JOIN post ON post_id = post.id WHERE content LIKE (?)";
    final String SQL_FIND_ID = "SELECT `comment`.*,post.title FROM `comment` JOIN post ON post_id = post.id WHERE id = ?";
    final String SQL_ADD = "INSERT INTO comment(content,email,post_id) VALUE (?,?,?)";
    final String SQL_UPDATE = "UPDATE comment SET content = ? WHERE id = ?";
    final String SQL_DELETE = "DELETE FROM comment WHERE (id=?)";
    final String SQL_FIND_BY_POST_ID = "SELECT * FROM newblogs.comment WHERE post_id = ?";


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
    public List<Comment> getAll() {
        List<Comment> comments = new ArrayList<>();
        try (
                Connection connection = getConnection();
            PreparedStatement st = connection.prepareStatement(SQL_GET_ALL)
        ) {
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String email = resultSet.getString("email");
                Date createDate = resultSet.getDate("create_date");
                int postId = resultSet.getInt("post_id");
                String title = resultSet.getString("title");
                Post post = new Post(postId,title);
                comments.add(new Comment(id, content, email, createDate, post,postId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }


    @Override
    public List<Comment> findByKeyword(String keyword) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND)
        ) {
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String email = resultSet.getString("email");
                Date createDate = resultSet.getDate("create_date");
                int postId = resultSet.getInt("post_id");
                String title = resultSet.getString("title");
                Post post = new Post(postId,title);
                comments.add(new Comment(id, content, email, createDate,post, postId));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public Comment findById(int id) {
        Comment comment = new Comment();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_FIND_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String content = resultSet.getString("content");
                String email = resultSet.getString("email");
                Date createDate = resultSet.getDate("create_date");
                int postId = resultSet.getInt("post_id");
                String title = resultSet.getString("title");
                Post post = new Post(postId,title);
                comment = new Comment(id, content, email, createDate,post, postId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;

    }

    @Override
    public boolean add(Comment comment) {
        boolean isAdded = false;
        try (
                Connection connection = getConnection();
                PreparedStatement st = connection.prepareStatement(SQL_ADD)
        ) {
            st.setString(1, comment.getContent());
            st.setString(2, comment.getEmail());
            st.setInt(3, comment.getPostId());
            isAdded = st.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isAdded;
    }

    @Override
    public boolean update(Comment comment) {
        boolean rowEdit = false;
        try (Connection connection = getConnection();
             PreparedStatement st = connection.prepareStatement(SQL_UPDATE)
        ) {
            st.setString(1, comment.getContent());

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

    public List<Comment> getPostComments(int postId) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_POST_ID)) {
            statement.setInt(1, postId);
            ResultSet rs = statement.executeQuery();
            // id, content, email, create_date, post_id
            List<Comment> comments = new ArrayList<>();
            while (rs.next()) {
                Comment cmt = new Comment();
                cmt.setId(rs.getInt("id"));
                cmt.setContent(rs.getString("content"));
                cmt.setCreateDate(rs.getTimestamp("create_date"));
                cmt.setEmail(rs.getString("email"));
                cmt.setPostId(postId);

                comments.add(cmt);
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
