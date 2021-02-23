package servlet.filtr;

import servlet.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (isLoginPage(servletRequest) || isUserAuthenticated(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }
    }

    private boolean isUserAuthenticated(ServletRequest servletRequest) {

        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");

        return Objects.nonNull(user);
    }

    private boolean isLoginPage(ServletRequest servletRequest) {

        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();

        return requestURI.startsWith("/login");
    }
}
