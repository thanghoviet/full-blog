package controler;

import dao.CategoryDao;
import dao.PostDao;
import dao.UserDao;
import model.Category;
import model.Post;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PostServlet", value = "/post")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
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
                case "create":
                    insertPost(request, response);
                    break;
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
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    searchByTitle(request, response);
                    break;
                case "view":
                    viewPost(request, response);
                    break;
                default:
                    listPost(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }




    private void listPost(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Post> listPost = postDao.getAll();
        request.setAttribute("listPost", listPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listPost.jsp");
        dispatcher.forward(request, response);
    }

    private void viewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post existingPost = postDao.findById(id);
        List<User> listUser = userDao.getAll();
        List<Category> listCategory = categoryDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("showPost.jsp");
        request.setAttribute("post", existingPost);
        request.setAttribute("listUser", listUser);
        request.setAttribute("listCategory", listCategory);
        dispatcher.forward(request, response);
    }

    private void searchByTitle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        if (title != null) {
            List<Post> listPost = postDao.findByKeyword(title);
            request.setAttribute("listPost", listPost);
            request.setAttribute("mess", "User of title: " + title);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("listPost.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        postDao.delete(id);
        List<Post> listPost = postDao.getAll();
        request.setAttribute("listPost", listPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listPost.jsp");
        dispatcher.forward(request, response);
    }
    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addPost.jsp");
        List<Post> listPost = postDao.getAll();
        request.setAttribute("listPost", listPost);
        List<Category> listCategory = categoryDao.getAll();
        request.setAttribute("listCategory", listCategory);
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post existingPost = postDao.findById(id);
        List<Category> listCategory = categoryDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("editPost.jsp");
        request.setAttribute("post", existingPost);
        request.setAttribute("listCategory", listCategory);
        dispatcher.forward(request, response);
    }



    public void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String sortContent = request.getParameter("sort_content");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        int category_id = Integer.parseInt(request.getParameter("category"));

        Category category = new Category(category_id);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        Post post = new Post(title,sortContent,content,image,user,category);
        postDao.add(post);

        List<Post> listPost = postDao.getAll();
        request.setAttribute("listPost", listPost);
        List<Category> listCategory = categoryDao.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addPost.jsp");
        dispatcher.forward(request, response);
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String sortContent = request.getParameter("sort_content");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        int category_id = Integer.parseInt(request.getParameter("category"));
        Category category = new Category(category_id);

        int id = Integer.parseInt(request.getParameter("id"));
        Post post = new Post( title,sortContent, content,image,category);
        post.setId(id);

        postDao.update(post);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editPost.jsp");
        dispatcher.forward(request, response);
    }

}
