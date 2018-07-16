package testPackage.configure.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import testPackage.configure.security.LoggedPersonGetter;
import testPackage.service.PersonManager;
import testPackage.vo.Person;

@Service
public class LoggedPersonGetterImpl implements LoggedPersonGetter {

    @Autowired
    private PersonManager personManager;

    @Override
    public Person getLoggedPerson() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = personManager.getPerson(user.getUsername());
        return person;
    }
}
