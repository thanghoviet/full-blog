package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminLoginFilter" , urlPatterns = {"/user"})
public class AdminLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        User account = (User) session.getAttribute("account");

        if (account == null || !account.getEmail().equals("admin@gmail.com")) {
            res.sendRedirect(req.getContextPath() + "/home?action=home");
        } else {
            chain.doFilter(request, response);
        }
    }
}
