package Tests;

import com.example.demo.entities.Actor;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.services.ActorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClassActorServiceTest {

    @InjectMocks
    private ActorService actorService;

    @Mock
    private ActorRepository actorRepository;

    @Test
    public void testActorService() {
        Short actorId = 1;
        Actor actor = new Actor();
        actor.setId(actorId);
        actor.setFirstName("PENELOPE");
        actor.setLastName("GUINESS");

        Mockito.when(actorRepository.findById(actorId)).thenReturn(Optional.of(actor));

        Actor result = actorService.getActorById(actorId);

        Assertions.assertEquals("PENELOPE", result.getFirstName(), "wrong first name");
        Assertions.assertEquals("GUINESS", result.getLastName(), "wrong last name");
    }
}
