package testPackage.configure;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import testPackage.configure.security.SecurityConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Вместо Web xml
 */
public class WebAppInitializer extends AbstractSecurityWebApplicationInitializer {

  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

  @Override
  protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.getEnvironment().setActiveProfiles("dev"); //FIXME Временное решение, до внедрения промышленного профиля
    ctx.register(AppWebConfig.class/*, SecurityConfig.class*/);
    ctx.setServletContext(servletContext);

    ServletRegistration.Dynamic dynamic = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
    dynamic.addMapping("/");
    dynamic.setLoadOnStartup(1);
    dynamic.setAsyncSupported(true);

    FilterRegistration characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
    characterEncodingFilter.setInitParameter("encoding", "UTF-8");
    characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
  }
}
