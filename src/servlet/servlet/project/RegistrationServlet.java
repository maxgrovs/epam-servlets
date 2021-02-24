package servlet.servlet.project;


import servlet.entity.User;
import servlet.service.UserService;
import servlet.util.JspPath;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher(JspPath.get("project/registration"))
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.builder()
                .name(req.getParameter("username"))
                .password(req.getParameter("password"))
                .build();

        User save = userService.save(user);

        resp.sendRedirect("project");

    }
}
