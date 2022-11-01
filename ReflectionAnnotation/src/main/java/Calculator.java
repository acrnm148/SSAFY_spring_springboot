

import org.springframework.stereotype.Component;

/*
 * 이것이 POJO
 * */

@Component
public class Calculator {

	public int add(int n1, int n2) {
		return n1 + n2;
	}
}