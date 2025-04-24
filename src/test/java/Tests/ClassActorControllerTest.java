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
    //Inject mocks into the actor controller
    @InjectMocks
    private ActorController actorController;
    //Create a mock of actor service
    @Mock
    private ActorService actorService;

    @Test
    public void testActorController() {
        //set up test data
        Short actorId = 1;
        Actor actor = new Actor();
        actor.setId(actorId);
        actor.setFirstName("PENELOPE");
        actor.setLastName("GUINESS");

        //Mock service method to return the predefined actor when calling with actorid
        Mockito.when(actorService.getActorById(actorId)).thenReturn(actor);

        //Call actor controller for test
        TestActorResponse output = actorController.findActor(actorId);

        //Verify controller returns expected data
        Assertions.assertEquals(actorId, output.getId(), "Wrong actor id");
        Assertions.assertEquals("PENELOPE", output.getFirstName(), "Wrong first name");
        Assertions.assertEquals("GUINESS", output.getLastName(), "Wrong last name");
    }
}
