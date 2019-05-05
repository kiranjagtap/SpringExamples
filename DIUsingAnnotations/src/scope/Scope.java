package scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import basic.Main;

@Configuration
@ComponentScan
public class Scope {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Scope.class);
		PersonDao personDao = applicationContext.getBean(PersonDao.class);
		System.out.println(personDao);
		System.out.println(personDao.getJdbcConnection());
		
		PersonDao personDao2 = applicationContext.getBean(PersonDao.class);
		System.out.println(personDao2);
		System.out.println(personDao2.getJdbcConnection());

	}
}
