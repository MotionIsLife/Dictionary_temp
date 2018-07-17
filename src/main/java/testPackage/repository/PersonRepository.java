package testPackage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import testPackage.vo.Person;
import testPackage.vo.PersonRole;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmailIgnoreCase(String email);

    @Query(value = "select p from Person p where (:role is null or p.role=:role)")
    public Page<Person> find(
            @Param("role") PersonRole role,
            Pageable pageable
    );

}
