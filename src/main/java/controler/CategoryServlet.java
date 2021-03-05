package controler;

import dao.CategoryDao;
import model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryDao categoryDao = new CategoryDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                case "list":
                    listCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listCategory = categoryDao.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByTitle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        if (title != null) {
            List<Category> listCategory = categoryDao.findByKeyword(title);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("mess", "User of title: " + title);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCategory.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        categoryDao.delete(id);
        List<Category> listCategory = categoryDao.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCategory.jsp");
        dispatcher.forward(request, response);
    }
    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCategory.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryDao.findById(id);
        List<Category> listCategory = categoryDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCategory.jsp");
        request.setAttribute("category", existingCategory);
        request.setAttribute("listCategory", listCategory);
        dispatcher.forward(request, response);
    }


    public void insertPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Category category = new Category(title,description);
        categoryDao.add(category);
        List<Category> listCategory = categoryDao.getAll();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCategory.jsp");
        dispatcher.forward(request, response);
    }

    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Category category = new Category( title,description);

        int id = Integer.parseInt(request.getParameter("id"));
        category.setId(id);
        categoryDao.update(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCategory.jsp");
        dispatcher.forward(request, response);
    }
}
