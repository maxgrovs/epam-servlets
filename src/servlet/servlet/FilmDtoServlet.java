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

@WebServlet("/filmDto")
public class FilmDtoServlet extends HttpServlet {
    FilmService filmService = FilmService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Film film = filmService.getByFilmId(Long.valueOf(id)).get();

        req.setAttribute("film", film);

        req.getServletContext()
                .getRequestDispatcher(JspPath.get("film"))
                .forward(req, resp);

    }


}
