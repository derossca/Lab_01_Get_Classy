import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    //***NEED HELP TESTING CONSTRUCTOR***//

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
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int expectedAge = currentYear - 1990;
        assertEquals(String.valueOf(expectedAge), p1.getAge());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("00000A,John,Doe,Mr.,1990", p1.toCSVDataRecord());
    }

    @Test
    void toJSONRecord() {
        String expectedJSON = "{\"IDNum\":\"00000A\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Mr.\",\"YOB\":\"1990\"}";
        assertEquals(expectedJSON, p1.toJSONRecord());
    }

    @Test
    void toXMLRecord() {
        String expectedXML = "<person><IDNum>00000A</IDNum><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1990</YOB></person>";
        assertEquals(expectedXML, p1.toXMLRecord());
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