package servlet.servlet.project;

import servlet.dto.UserDto;
import servlet.service.UserService;
import servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher(JspPath.get("project/registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<UserDto> user = userService.login(username, password);

        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            resp.sendRedirect("/project");
        }else {
          //  resp.sendRedirect("/login?username=" + username);
            resp.sendRedirect(String.format("/login?username=%s&error=true", username));
        }

    }
}
