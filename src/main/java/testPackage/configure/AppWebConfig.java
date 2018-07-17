package testPackage.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring App Config
 */
@Configuration
@EnableWebMvc
@ComponentScan({"testPackage"})
@EnableJpaRepositories(basePackages = {"testPackage.repository"})
@Import({DataSourceConfig.class, JpaConfig.class})
public class AppWebConfig extends AbstractWebConfig {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
      registry.addRedirectViewController("/", "/client/modules/");
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/META-INF/resources/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    registry.viewResolver(viewResolver);
  }
}
