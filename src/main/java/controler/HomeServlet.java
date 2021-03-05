package controler;

import dao.CategoryDao;
import dao.CommentDao;
import dao.PostDao;
import dao.UserDao;
import model.Category;
import model.Comment;
import model.Post;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
    UserDao userDao = new UserDao();
    CommentDao commentDao = new CommentDao();

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
                case "create":
                    insertComment(request, response);
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
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showNewForm(request, response);
                break;
            case "home":
                homePage(request,response);
                break;
            case "blogSingle":
                showBlogSingle(request, response);
                break;
            case "listByCategoryId":
                searchByCategoryId(request, response);
                break;
        }
    }


    public void insertComment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String content = request.getParameter("content");
        String email = request.getParameter("email");
        int postId = Integer.parseInt(request.getParameter("post_id"));

        Comment comment = new Comment();
        comment.setEmail(email);
        comment.setContent(content);
        comment.setPostId(postId);

        commentDao.add(comment);
        response.sendRedirect(request.getContextPath() + "/home?action=blogSingle&id=" + postId);
    }

    private void searchByCategoryId(HttpServletRequest request, HttpServletResponse response)
            {
        try{
        int CategoryId = Integer.parseInt(request.getParameter("id"));
        if (CategoryId !=0 ) {
            List<Post> listPostByCategory = postDao.findByCategoryID(CategoryId);
            request.setAttribute("listPostByCategory", listPostByCategory);
            request.setAttribute("mess", "User of title: " + CategoryId);

            List<Category> categoryList = categoryDao.getAll();
            request.setAttribute("categoryList",categoryList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("homePage/category.jsp");
        dispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showBlogSingle(HttpServletRequest request, HttpServletResponse response){
        try {

        int postId = Integer.parseInt(request.getParameter("id"));
        Post post = postDao.findById(postId);
        request.setAttribute("post", post);

        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);

        List<Comment> comments = commentDao.getPostComments(postId);
        request.setAttribute("comments", comments );


        request.getRequestDispatcher("homePage/blog-single.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> top3Post = postDao.top3();
        request.setAttribute("top3Post",top3Post);
        List<Post> top8Post = postDao.top8();
        request.setAttribute("top8Post",top8Post);
        List<Post> PostRandom = postDao.getPostRandom();
        request.setAttribute("PostRandom",PostRandom);
        try {
            List<User> userList = userDao.getAll();
            request.setAttribute("userList",userList);
            List<Category> categoryList = categoryDao.getAll();
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("homePage/index.jsp");
        dispatcher.forward(request,response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("homePage/blog-single.jsp");
        List<Comment> listComment = commentDao.getAll();
        request.setAttribute("listComment", listComment);
        dispatcher.forward(request, response);
    }


}
