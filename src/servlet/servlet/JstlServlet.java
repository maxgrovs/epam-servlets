package servlet.servlet;


import servlet.entity.Film;
import servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("film", Film.builder()
                .name("TEST")
                .build());

        req.setAttribute("films", Arrays.asList(

                Film.builder()
                        .id(1L)
                        .name("TEST1")
                        .build(),

                Film.builder()
                        .id(2L)
                        .name("TEST2")
                        .build()

        ));

        getServletContext()
                .getRequestDispatcher(JspPath.get("jstl"))
                .forward(req, resp);

    }
}
