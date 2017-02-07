package testsApp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.GreetingsRemote;

public class TestGreetings {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "konch-ear/konch-ejb/Greetings!services.GreetingsRemote";
			GreetingsRemote proxy = (GreetingsRemote) context.lookup(jndiName);

			System.out.println(proxy.sellem("salah"));

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
