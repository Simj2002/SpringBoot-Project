package Tests;

import com.example.demo.controllers.ActorController;
import com.example.demo.controllers.FilmController;
import com.example.demo.entities.*;
import com.example.demo.services.ActorService;
import com.example.demo.services.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassFilmTest {
    @InjectMocks
    private FilmController filmController;
    @Mock
    private FilmService filmService;

    @Test
    public void testFindFilmById() {
        Short filmId = 1;
        Film film = new Film();
        film.setId(filmId);
        film.setTitle("ACADEMY DINOSAUR");

        Language language = new Language();
        language.setId((byte)1);
        language.setName("English");
        film.setLanguage(language);

        PartialFilmResponse mockResponse = new PartialFilmResponse(film);
        Mockito.when(filmService.getFilmById(filmId)).thenReturn(mockResponse);

        PartialFilmResponse output = filmController.findFilm(filmId);

        Assertions.assertEquals(filmId, output.getId(), "Wrong film id");
        Assertions.assertEquals("ACADEMY DINOSAUR", output.getTitle(), "Wrong film title");
        Assertions.assertEquals("English", output.getLanguage(), "Wrong film language");
    }
}
