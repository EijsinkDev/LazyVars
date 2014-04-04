package exercise.attempt;

import java.util.stream.Stream;

import exercise.ExcerciseInterface;
import exercise.ExcerciseSet;

public class Attempt implements ExcerciseInterface {

	private ExcerciseSet<Integer> set;
	
	@Override
	public void addListenerToSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEvenNumberValidator() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSmallerThanValidator(int min) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stream<Integer> getAllNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Integer> getNumbersSmallerThan(int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Integer> getNumbersSmallerThanAndMultipliedBy(int max,
			int multiple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMultiplesTotal(int max, int factor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCollection(ExcerciseSet<Integer> set) {
		this.set = set;
	}
}
