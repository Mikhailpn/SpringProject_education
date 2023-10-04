package ru.springcourse.projone.dao;

import org.springframework.stereotype.Component;
import ru.springcourse.projone.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private List<Person> people;
    private static int PEOPLE_CNT;

    //initialization block
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_CNT, "Tom"));
        people.add(new Person(++PEOPLE_CNT, "Mike"));
        people.add(new Person(++PEOPLE_CNT, "Bob"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(x->x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_CNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToUpdate = show(id);
        personToUpdate.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p->p.getId()==id);
    }

}
