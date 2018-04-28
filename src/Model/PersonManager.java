package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SauravSaha on 4/5/18.
 */
public class PersonManager {

    private static PersonManager instance;

    private Map<String, Person> personMap;

    private PersonManager() { this.personMap = new HashMap<>();}

    public static PersonManager getInstance() {

        if(instance == null) {
            instance = new PersonManager();
        }

        return instance;
    }

    public void addPerson(String name) {

        Person p = new Person(name);
        personMap.put(name, p);
    }

    public void removePerson(String name) {

        personMap.remove(name);
    }

    public Person getPerson(String name) {

        return personMap.get(name);
    }

    public void clearPersons() {

        personMap.clear();
    }

    public Map<String, Person> getPersonMap () {
        return personMap;
    }

    public int numPersons() {
        return personMap.size();
    }







}
