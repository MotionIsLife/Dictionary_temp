package testPackage.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import testPackage.service.PersonManager;
import testPackage.vo.Person;
import testPackage.vo.PersonRole;

import java.util.List;
import java.util.Set;

@Service
public class PersonManagerImpl implements PersonManager {

    @Override
    public List<Person> getPersonList() {
        return null;
    }

    @Override
    public Page<Person> getPersonList(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Person> getPersonList(Pageable pageable, PersonRole role) {
        return null;
    }

    @Override
    public Set<Person> getPersonListId(Set<Integer> idList) {
        return null;
    }

    @Override
    public Person getPerson(Integer id) {
        return null;
    }

    @Override
    public Person getPerson(String email) {
        return null;
    }

    @Override
    public Person appendPerson(String lastName, String firstName, String middleName, String subdivision, String email, String role) {
        return null;
    }

    @Override
    public Integer updatePerson(Integer id, String lastName, String firstName, String middleName, String subdivision, String email, String role, Boolean defaultPassword) {
        return null;
    }

    @Override
    public void dropPerson(Integer id) {

    }

    @Override
    public void updatePassword(Person person, String password, String passwordNew) {

    }

    @Override
    public void updateEmail(Person person, String password, String email, String emailNew) {

    }
}
