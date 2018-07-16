package testPackage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import testPackage.vo.Person;
import testPackage.vo.PersonRole;

import java.util.List;
import java.util.Set;

public interface PersonManager {
    /**
     * Получить список человек
     * @return
     */
    List<Person> getPersonList();

    /**
     * Получить список человек
     * @return
     */
    Page<Person> getPersonList(Pageable pageable);

    /**
     * Получить список человек
     * @return
     */
    Page<Person> getPersonList(Pageable pageable, PersonRole role);

    /**
     * Получить список id
     * @param idList
     * @return
     */
    Set<Person> getPersonListId(Set<Integer> idList);

    Person getPerson(Integer id);

    /**
     * Получить человека по email
     * @param email
     * @return
     */
    Person getPerson(String email);

    /**
     * Добавить человека
     * @param lastName
     * @param firstName
     * @param middleName
     * @param subdivision
     * @param email
     * @param role
     * @return
     */
    Person appendPerson(String lastName, String firstName, String middleName,
                        String subdivision, String email, String role);

    /**
     * Изменить данные человека
     * @param id
     * @param lastName
     * @param firstName
     * @param middleName
     * @param subdivision
     * @param email
     * @param role
     * @return
     */
    Integer updatePerson(Integer id, String lastName, String firstName, String middleName,
                         String subdivision, String email, String role, Boolean defaultPassword);

    /**
     * Удалить человека
     * @param id
     */
    void dropPerson(Integer id);

    /**
     * Изменение пароля персоны
     * @param person
     * @param password
     * @param passwordNew
     */
    void updatePassword(Person person, String password, String passwordNew);

    /**
     * Изменение email персоны
     * @param person
     * @param password
     * @param email
     * @param emailNew
     */
    void updateEmail(Person person, String password, String email, String emailNew);
}