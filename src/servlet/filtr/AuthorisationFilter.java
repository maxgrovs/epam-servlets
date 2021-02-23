package servlet.filtr;

import servlet.dto.UserDto;
import servlet.entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


//@WebFilter(servletNames = "SaveFilmServlet")
@WebFilter("/save-film")
public class AuthorisationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (isUserHasPermissions(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String refererUrl = ((HttpServletRequest) servletRequest).getHeader("referer");
            ((HttpServletResponse) servletResponse).sendRedirect(refererUrl);
        }
    }

    private boolean isUserHasPermissions(ServletRequest servletRequest) {

        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");

        return Objects.nonNull(user) && Role.ADMIN == user.getRole();
    }

}
