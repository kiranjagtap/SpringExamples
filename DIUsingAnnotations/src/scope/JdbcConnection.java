package scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
//@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS,scopeName="prototype")
public class JdbcConnection {

	public JdbcConnection() {
		System.out.println("JDBC Connection");
	}
}
