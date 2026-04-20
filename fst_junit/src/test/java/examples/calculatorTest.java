package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class calculatorTest {
	calculator calc;
	@BeforeEach
	public void setUp() {
		calc = new calculator();
	}
@Test
public void testAdd() {

int result = calc.add(10,20);
	
	Assertions.assertEquals(30,result,"the sum must be equal to 30");
}


@Test
public void testMultiply() {

int result = calc.Multiply(10,20);
	
	Assertions.assertEquals(200,result,"the sum must be equal to 30");
}
}