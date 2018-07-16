package testPackage.configure.security.dto;

import testPackage.vo.Person;

public class PersonWrapperDto {
  private Person person;

  public PersonWrapperDto(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
