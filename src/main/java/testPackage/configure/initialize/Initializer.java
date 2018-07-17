package testPackage.configure.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testPackage.service.PersonManager;
import testPackage.vo.PersonRole;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    @Autowired
    private PersonManager personManager;

    private static final String ADMIN = "admin";
    private static final String ADMIN_DESCR = "Админ тех поддержки проекта";

    @PostConstruct
    protected void initialize() {
        if (personManager.getPerson(ADMIN) == null) {
            personManager.appendPerson(ADMIN_DESCR, ADMIN_DESCR, null, null, ADMIN, PersonRole.ROLE_ADMIN.name());
        }
    }
}