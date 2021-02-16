package servlet.servlet;

import servlet.entity.Film;
import servlet.service.FilmService;
import servlet.util.JspPath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/all-films")
public class FindAllServlet extends HttpServlet {

    FilmService filmService = FilmService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("films", filmService.findAll());

        getServletContext()
                .getRequestDispatcher(JspPath.get("all-films"))
                .forward(req, resp);

    }
}
