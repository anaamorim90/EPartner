package hello;

import static org.junit.Assert.*;
import java.util.List;
import java.util.LinkedList;

public class Test {

	@org.junit.Test
	public void test() {
		List<Professor> professores = new LinkedList<>();
		professores.add(new Professor("Giuliano", "giuliano.bertotti@fatec.com", "123qwe", 12345));
		professores.add(new Professor("Nadalete", "lucas.nadalete@fatec.com", "123qwe", 12346));
		professores.add(new Professor("Sakaue", "eduardo.sakaue@fatec.com", "123qwe", 12347));
		
		String termo = "123";
		
		System.out.println(professores.get(0).toString().contains(termo));
		
		assertEquals(true, professores.get(0).toString().contains(termo));
	}
}
