package testPackage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import testPackage.repository.PersonRepository;
import testPackage.service.PersonManager;
import testPackage.vo.Person;
import testPackage.vo.PersonRole;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonManagerImpl implements PersonManager {

    private static final String ERROR_PASS = "Неправильно введен пароль";
    private static final String ERROR_EMAIL = "Неправильно введен email";

    @Value("")
    private String password_user;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> getPersonList(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Page<Person> getPersonList(Pageable pageable, PersonRole role) {
        return personRepository.find(role, pageable);
    }

    @Override
    public Set<Person> getPersonListId(Set<Integer> idList) {
        final Set<Person> result = new HashSet<>();
        if (idList == null)
            return result;
        List<Person> personList = personRepository.findAll();
        for (Person person : personList)
            for (Integer id : idList) {
                if (id.equals(person.getId())) {
                    result.add(person);
                    break;
                }
            }
        return result;
    }

    @Override
    public Person getPerson(Integer id) {
        return id != null ? personRepository.findOne(id) : null;
    }

    @Override
    public Person getPerson(String email) {
        return email != null ? personRepository.findByEmailIgnoreCase(email) : null;
    }

    @Override
    public Person appendPerson(String lastName, String firstName, String middleName,
                               String subdivision, String email, String role) {
        PersonRole personRole = PersonRole.valueOf(role);
        password_user = passwordEncoder.encode(password_user);
        Person person = new Person(lastName, firstName, middleName, subdivision, email, password_user, true, personRole);
        return personRepository.save(person);
    }

    @Override
    public Integer updatePerson(Integer id, String lastName, String firstName, String middleName,
                                String subdivision, String email, String role, Boolean defaultPassword) {
        PersonRole personRole = PersonRole.valueOf(role);

        Person person = personRepository.findOne(id);
        person.setLastName(lastName);
        person.setFirstName(firstName);
        person.setMiddleName(middleName);
        person.setSubdivision(subdivision);
        person.setEmail(email);
        person.setRole(personRole);
        if (defaultPassword != null && defaultPassword) {
            person.setPassword(password_user);
            person.setPasswordDefault(true);
        }
        person = personRepository.save(person);
        return person.getId();
    }

    @Override
    public void dropPerson(Integer id) {
        try {
            personRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Этот пользователь связан с задачей.");
        }
    }

    @Override
    public void updatePassword(Person person, String password, String passwordNew) {
        if (!passwordEncoder.matches(password, person.getPassword())) {
            throw new RuntimeException(ERROR_PASS);
        }
        person.setPassword(passwordEncoder.encode(passwordNew));
        person.setPasswordDefault(null);
        personRepository.save(person);
    }

    @Override
    public void updateEmail(Person person, String password, String email, String emailNew) {
        if (!email.equalsIgnoreCase(person.getEmail())) {
            throw new RuntimeException(ERROR_EMAIL);
        }
        if (!passwordEncoder.matches(password, person.getPassword())) {
            throw new RuntimeException(ERROR_PASS);
        }
        person.setEmail(emailNew);
        personRepository.save(person);
    }
}
