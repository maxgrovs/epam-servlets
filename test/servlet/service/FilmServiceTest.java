package servlet.service;

import org.junit.Test;
import servlet.entity.Film;

import java.util.List;

import static org.junit.Assert.*;

public class FilmServiceTest {

    FilmService service = FilmService.getInstance();

    @Test
    public void getByFilmId() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {

        System.out.println(service.findAll());

    }
}