package testPackage.configure.security.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testPackage.configure.security.LoggedPersonGetter;
import testPackage.configure.security.LoggedPersonJsonGetter;
import testPackage.configure.security.dto.PersonWrapperDto;
import testPackage.vo.Person;

@Component
public class LoggedPersonJsonGetterImpl implements LoggedPersonJsonGetter {

    @Autowired
    protected LoggedPersonGetter loggedPersonGetter;

    @Override
    public String getLoggedPersonJson() throws JsonProcessingException {
        Person loggedPerson = loggedPersonGetter.getLoggedPerson();
        PersonWrapperDto personWrapperDto = new PersonWrapperDto(loggedPerson);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(personWrapperDto);
    }
}