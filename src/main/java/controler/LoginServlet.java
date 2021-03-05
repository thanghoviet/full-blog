package controler;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = userDao.login(email, password);

            if (user != null) {
                session.setAttribute("account", user);

                if (email.equals("admin@gmail.com")) {
                    response.sendRedirect("/user?action=listUser");
                } else {
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
