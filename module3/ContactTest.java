import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Vyshnavi Rayabharapu", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Vyshnavi Rayabharapu", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhoneNumber());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Vyshnavi Rayabharapu", contact.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Vyshnavi Rayabharapu"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }
}