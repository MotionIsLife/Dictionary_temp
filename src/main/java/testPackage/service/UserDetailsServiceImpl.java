package testPackage.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import testPackage.vo.Person;

import java.util.ArrayList;

/**
 * Для получения человека модулем авторизации
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonManager personManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personManager.getPerson(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(person.getRole().name()));

        return new User(username, person.getPassword(), authorities);
    }
}
