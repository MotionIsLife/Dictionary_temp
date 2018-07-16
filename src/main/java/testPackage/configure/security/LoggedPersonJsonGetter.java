package testPackage.configure.security;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoggedPersonJsonGetter {
    String getLoggedPersonJson() throws JsonProcessingException;
}
