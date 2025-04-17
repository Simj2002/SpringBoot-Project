package Tests;
import com.example.demo.controllers.ActorController;
import com.example.demo.entities.Actor;
import com.example.demo.entities.TestActorResponse;
import com.example.demo.services.ActorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassActorControllerTest {
    @InjectMocks
    private ActorController actorController;
    @Mock
    private ActorService actorService;

    @Test
    public void testActorController() {
        Short actorId = 1;
        Actor actor = new Actor();
        actor.setId(actorId);
        actor.setFirstName("PENELOPE");
        actor.setLastName("GUINESS");

        Mockito.when(actorService.getActorById(actorId)).thenReturn(actor);

        TestActorResponse output = actorController.findActor(actorId);

        Assertions.assertEquals(actorId, output.getId(), "Wrong actor id");
        Assertions.assertEquals("PENELOPE", output.getFirstName(), "Wrong first name");
        Assertions.assertEquals("GUINESS", output.getLastName(), "Wrong last name");
    }
}
