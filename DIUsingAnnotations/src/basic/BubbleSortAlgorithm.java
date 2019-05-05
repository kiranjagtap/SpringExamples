package basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("bubble")
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {

	@Override
	public int[] sort(int[] numbers) {
		System.out.println("bubbleSortAlgorith");
		return numbers;
	}

}
