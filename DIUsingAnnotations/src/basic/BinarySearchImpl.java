package basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	//@Qualifier("bubble")
	SortAlgorithm sortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearch ) {
		
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		
		return 3;
	}
}