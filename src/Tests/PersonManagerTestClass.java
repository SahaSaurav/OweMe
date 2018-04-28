package Tests;


import Model.Person;
import Model.PersonManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by SauravSaha on 4/16/18.
 */
public class PersonManagerTestClass {

    @BeforeEach
    public void runBefore() {
        PersonManager.getInstance().clearPersons();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, PersonManager.getInstance().numPersons());
    }

    @Test
    public void testAddPerson() {
        PersonManager.getInstance().addPerson("Jack W.");
        assertTrue(PersonManager.getInstance().getPersonMap().containsKey("Jack W."));
        assertEquals(1, PersonManager.getInstance().numPersons());

        assertTrue(PersonManager.getInstance().getPerson("Jack W.") ==
                PersonManager.getInstance().getPersonMap().get("Jack W."));


    }

    @Test
    public void testRemovePerson() {
        PersonManager.getInstance().addPerson("Jack X.");
        PersonManager.getInstance().addPerson("Jack Y.");
        PersonManager.getInstance().addPerson("Jack Z.");
        assertEquals(3, PersonManager.getInstance().numPersons());

        PersonManager.getInstance().removePerson("Jack X.");
        assertEquals(2, PersonManager.getInstance().numPersons());
        assertEquals(null, PersonManager.getInstance().getPerson("Jack X."));

    }

    @Test
    public void testGetPerson() {
        PersonManager.getInstance().addPerson("Jack X.");
        PersonManager.getInstance().addPerson("Jack Y.");
        PersonManager.getInstance().addPerson("Jack Z.");

        assertTrue(PersonManager.getInstance().getPerson("Jack X.") ==
                PersonManager.getInstance().getPersonMap().get("Jack X."));

        assertTrue(PersonManager.getInstance().getPerson("Jack Y.") ==
                PersonManager.getInstance().getPersonMap().get("Jack Y."));

        assertTrue(PersonManager.getInstance().getPerson("Jack Z.") ==
                PersonManager.getInstance().getPersonMap().get("Jack Z."));


    }



}
