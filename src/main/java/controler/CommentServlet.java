package controler;

import dao.CommentDao;
import dao.UserDao;
import model.Comment;
import model.Post;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "commentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CommentDao commentDao = new CommentDao();
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {

                case "edit":
                    updatePost(request, response);
                    break;

            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        try {
            switch (action) {

                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    searchByContent(request, response);
                    break;
                case "view":
                    viewComment(request, response);
                    break;
                case "list":
                    listComment(request, response);
                    break;
                default:
                    listComment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listComment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Comment> listComment = commentDao.getAll();
        request.setAttribute("listComment", listComment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listComment.jsp");
        dispatcher.forward(request, response);
    }

    private void viewComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Comment existingComment = commentDao.findById(id);
        List<User> listUser = userDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("showComment.jsp");
        request.setAttribute("post", existingComment);
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }

    private void searchByContent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String content = request.getParameter("content");
        if (content != null) {
            List<Comment> listNote = commentDao.findByKeyword(content);
            request.setAttribute("listNote", listNote);
            request.setAttribute("mess", "User of content: " + content);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("listComment.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        commentDao.delete(id);
        List<Comment> listComment = commentDao.getAll();
        request.setAttribute("listComment", listComment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listComment.jsp");
        dispatcher.forward(request, response);
    }


    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Comment existingComment = commentDao.findById(id);
        List<Comment> listComment = commentDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("editComment.jsp");
        request.setAttribute("comment", existingComment);
        request.setAttribute("listComment", listComment);
        dispatcher.forward(request, response);
    }



    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String content = request.getParameter("content");
//        String email = request.getParameter("email");
        int postId = Integer.parseInt(request.getParameter("post_id"));
        Post post = new Post( postId);
//        Comment comment = new Comment(content,email,post);
        Comment comment = new Comment(content);
        commentDao.update(comment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addComment.jsp");
        dispatcher.forward(request, response);
    }
}
