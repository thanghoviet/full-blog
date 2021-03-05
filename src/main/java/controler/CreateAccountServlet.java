package controler;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateAccountServlet", value = "/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        List<User> listUser = userDao.getAll();
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String alias = request.getParameter("alias");
        String aboutMe = request.getParameter("aboutMe");
        String image = request.getParameter("image");
        int yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));

        User user = new User(email, password, fullName, alias, false, aboutMe, image, yearOfBirth);
        userDao.add(user);

        List<User> accountList = userDao.getAll();
        request.setAttribute("accountList", accountList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
        dispatcher.forward(request, response);
    }
}
