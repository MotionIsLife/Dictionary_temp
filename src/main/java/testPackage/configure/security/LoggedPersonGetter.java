package testPackage.configure.security;


import testPackage.vo.Person;

/**
 * Для получения авторизованного человека
 */
public interface LoggedPersonGetter {
  Person getLoggedPerson();
}
