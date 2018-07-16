package testPackage.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Сущность "Человек"
 */
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "entity_id_gen", sequenceName = "PERSON_SEQ", allocationSize = 1)
public class Person extends AbstractEntity {

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "firstName", nullable = false)
  private String firstName;

  @Column(name = "middleName")
  private String middleName;

  @Column(name = "subdivision")
  private String subdivision;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "password_default")
  private Boolean passwordDefault;

  @Column(name = "role", nullable = false)
  @Enumerated(EnumType.STRING)
  private PersonRole role;

  public Person() {

  }

  public Person(String lastName, String firstName, String middleName, String subdivision, String email, String password, Boolean passwordDefault, PersonRole role) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.subdivision = subdivision;
    this.email = email;
    this.password = password;
    this.passwordDefault = passwordDefault;
    this.role = role;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getSubdivision() {
    return subdivision;
  }

  public void setSubdivision(String subdivision) {
    this.subdivision = subdivision;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getPasswordDefault() {
    return passwordDefault;
  }

  public void setPasswordDefault(Boolean passwordDefault) {
    this.passwordDefault = passwordDefault;
  }

  public PersonRole getRole() {
    return role;
  }

  public void setRole(PersonRole role) {
    this.role = role;
  }
}
