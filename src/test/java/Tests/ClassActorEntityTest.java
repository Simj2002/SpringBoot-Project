package Tests;

import com.example.demo.entities.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassActorEntityTest {

    @Test
    public void testActorEntity() {
        Actor actor = new Actor();
        actor.setId((short)1);
        actor.setFirstName("PENELOPE");
        actor.setLastName("GUINESS");

        Assertions.assertEquals((short)1, actor.getId(), "Wrong actor ID");
        Assertions.assertEquals("PENELOPE", actor.getFirstName(), "Wrong first name");
        Assertions.assertEquals("GUINESS", actor.getLastName(), "Wrong last name");
    }
}
