package Tests;

import Model.Exception.DeductionTooLargeException;
import Model.Exception.IncorrectDateFormatException;
import Model.Exception.NegativeAmountException;
import Model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by SauravSaha on 4/16/18.
 */
public class PersonTestClass  {

    private Person testPerson;

    @BeforeEach
    public void runBefore() {
        testPerson = new Person("Caleb");
    }

    @Test
    public void testConstructor() {
        assertEquals("Caleb", testPerson.getName());
        assertEquals(0, testPerson.getTotalAmount());
    }

    @Test
    public void testAddToTotalAmount() {
        try {
            testPerson.addToTotalAmount(0);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(0, testPerson.getTotalAmount());

        try {
            testPerson.addToTotalAmount(300);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(300, testPerson.getTotalAmount());

        try {
            testPerson.addToTotalAmount(0.75);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(300.75, testPerson.getTotalAmount());

    }

    @Test
    public void testNegativeAmountException(){

        Executable exceptionThrown = () -> testPerson.addToTotalAmount(-100);
        assertThrows(NegativeAmountException.class, exceptionThrown);

        Executable exception1 = () -> testPerson.deductFromTotalAmount(-100);
        assertThrows(NegativeAmountException.class, exception1);

        Executable exception = () -> testPerson.addDate("11-01-2018", "concert tickets", -60);
        assertThrows(NegativeAmountException.class, exception);


    }

    @Test
    public void testDeductFromTotalAmount() {
        try {
            testPerson.deductFromTotalAmount(0);
        } catch (DeductionTooLargeException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(0, testPerson.getTotalAmount());

        try {
            testPerson.addToTotalAmount(300);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }

        try {
            testPerson.deductFromTotalAmount(100);
        } catch (DeductionTooLargeException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(200, testPerson.getTotalAmount());

    }

    @Test
    public void testDeductionTooLargeException(){

        Executable exceptionThrown = () -> testPerson.deductFromTotalAmount(100);
        assertThrows(DeductionTooLargeException.class, exceptionThrown);

        try {
            testPerson.addToTotalAmount(300);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }

        Executable exceptionThrown1 = () -> testPerson.deductFromTotalAmount(301);
        assertThrows(DeductionTooLargeException.class, exceptionThrown1);
    }

    @Test
    public void testAddDate() {
        try {
            testPerson.addDate("01-26-2018", "concert tickets", 60);
        } catch (IncorrectDateFormatException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(1, testPerson.getDates().size());

        try {
            testPerson.addDate("03-30-2018", "Groceries", 100);
        } catch (IncorrectDateFormatException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(2, testPerson.getDates().size());
    }

    @Test
    public void testIncorrectDateFormatException() {
        Executable exception = () -> testPerson.addDate("Jan 01 2018", "concert tickets", 60);
        assertThrows(IncorrectDateFormatException.class, exception);

        try {
            testPerson.addDate("03-30-2018", "Groceries", 100);
        } catch (IncorrectDateFormatException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(1, testPerson.getDates().size());
    }

    @Test
    public void testRemoveDate() {
        try {
            testPerson.addDate("01-26-2018", "concert tickets", 60);
        } catch (IncorrectDateFormatException e) {
            e.printStackTrace();
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        assertEquals(1, testPerson.getDates().size());

        testPerson.removeDate(testPerson.getDates().get(0));
        assertEquals(0, testPerson.getDates().size());
    }







}
