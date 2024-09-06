import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    Person p1;

    @BeforeEach
    void setUp() {
        p1 = new Person("00000A", "John", "Doe", "Mr.", 1990);

    }

    @Test
    void fullName() {
        assertEquals("John Doe", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. John Doe", p1.formalName());
    }

    //***NEED HELP***
    @Test
    void getAge() {
        assertEquals(34, p1.getAge());
    }

    //***NEED HELP***
    @Test
    void testGetAge() {
        assertEquals(34, p1.getAge());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("00000A,John,Doe,Mr.,1990", p1.toCSVDataRecord());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000B");
        assertEquals("00000B", p1.getIDNum());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Joe");
        assertEquals("Joe", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Esq.");
        assertEquals("Esq.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1992);
        assertEquals(1992, p1.getYOB());
    }

    @Test
    void testToString() {
        assertEquals("Person{IDNum='00000A', firstName='John', lastName='Doe', title='Mr.', YOB=1990}", p1.toString());
    }
}