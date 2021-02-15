package by.epam.grovs.servlet.dao;


import org.junit.Test;
import servlet.dao.FilmDao;
import servlet.entity.Film;

public class FilmDaoTest {

    FilmDao filmDao = FilmDao.getInstance();

    @Test
    public void findOne() {
            System.out.println(filmDao.findOne(1L));
    }

    @Test
    public void save(){

        Film film = Film.builder()
                .name("Dead pool")
                .build();

        System.out.println(filmDao.save(film));

    }

}