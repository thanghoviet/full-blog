package controler;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
//                case "login":
//                    login(request,response);
//                    break;
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
                case  "listUser":
                    listUser(request,response);
                    break;
                case  "search":
                    searchByTitle(request, response);
                    break;
//                case  "login":
//                    loginFrom(request,response);
//                    break;
//                default:
//                    loginFrom(request,response);
////                    listAccount(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByTitle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String alias = request.getParameter("alias");
        if (alias != null) {
            List<User> listUser = userDao.findByKeyword(alias);
            request.setAttribute("listUser", listUser);
            request.setAttribute("mess", "User of title: " + alias);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
        dispatcher.forward(request, response);
    }


    private void listAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDao.getAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
        dispatcher.forward(request, response);
    }
//
//    private void loginFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("loginUser.jsp");
//        dispatcher.forward(request, response);
//    }


    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> listUser = userDao.getAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.delete(id);
//        List<User> accountList = userDao.getAll();
//        request.setAttribute("accountList", accountList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("listUser.jsp");
//        dispatcher.forward(request, response);

        response.sendRedirect("/user?action=listUser");
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findById(id);
        List<User> listUser = userDao.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");

        request.setAttribute("user", user);
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        List<User> listUser = userDao.getAll();
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }

    public void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String alias = request.getParameter("alias");
        String aboutMe = request.getParameter("aboutMe");
        String image = request.getParameter("image");
        int yearOfBirth = Integer.parseInt( request.getParameter("yearOfBirth"));

        User user = new User(email,password,fullName,alias,false,aboutMe,image,yearOfBirth);
        userDao.add(user);

        List<User> accountList = userDao.getAll();
        request.setAttribute("accountList", accountList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        dispatcher.forward(request, response);
    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String alias = request.getParameter("alias");
        String aboutMe = request.getParameter("aboutMe");
        String image = request.getParameter("image");
        int yearOfBirth = Integer.parseInt( request.getParameter("yearOfBirth"));

        User user = new User(id,email,fullName,alias,aboutMe,image,yearOfBirth);
//        user.setId(id);
        userDao.update(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
        dispatcher.forward(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = userDao.login(email, password);
            if (userDao.checkUser(email, password)) {
                if (email.equals("admin@gmail.com") && password.equals("admin")) {
                    session.setAttribute("a_email", user.getEmail());
                    session.setAttribute("account", user);
                    response.sendRedirect("/user?action=listUser");
                } else {
                    session.setAttribute("a_email", user.getEmail());
                    session.setAttribute("account", user);
                    response.sendRedirect("/user");
                }
            } else {
                request.setAttribute("message", "User, password please try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("loginUser.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
