import com.jdbc.dao.JdbcdDaoImpl;
import com.jdbc.model.Circle;

public class Main {

	public static void main(String[] args) {
		
		Circle circle= null;
		JdbcdDaoImpl dao = new JdbcdDaoImpl();
		circle = dao.getCircle(1);
		
		System.out.println("ID => "+circle.getId());
		System.out.println("Name => "+circle.getName());
	}

}
