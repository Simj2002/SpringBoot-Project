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
    //Inject mocks into actorService
    @InjectMocks
    private ActorService actorService;
    //Create a mock of the actorRepository
    @Mock
    private ActorRepository actorRepository;

    @Test
    public void testActorService() {
        //Create test data
        Short actorId = 1;
        Actor actor = new Actor();
        actor.setId(actorId);
        actor.setFirstName("PENELOPE");
        actor.setLastName("GUINESS");

        //Mock repository call to return mock actor
        Mockito.when(actorRepository.findById(actorId)).thenReturn(Optional.of(actor));

        //Call service method
        Actor result = actorService.getActorById(actorId);

        //Verify the returned actor is same as expected values
        Assertions.assertEquals("PENELOPE", result.getFirstName(), "wrong first name");
        Assertions.assertEquals("GUINESS", result.getLastName(), "wrong last name");
    }
}
