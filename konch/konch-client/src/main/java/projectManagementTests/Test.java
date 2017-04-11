package projectManagementTests;

import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;

public class Test {

	public static void main(String[] args) throws NamingException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 30);
		System.out.println(calendar.getTime());

	}

}
