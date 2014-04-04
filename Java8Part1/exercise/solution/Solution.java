package exercise.solution;

import java.util.stream.Stream;

import exercise.ExcerciseInterface;
import exercise.ExcerciseSet;

public class Solution implements ExcerciseInterface {

	private ExcerciseSet<Integer> set;
	
	@Override
	public void addListenerToSet() {
		// Not actually implemented because it would mess up the standard output when doing it twice
		// set.addListener(number -> System.out.println(number));
	}
	
	@Override
	public void setEvenNumberValidator() {
		set.setValidator(number -> number % 2 == 0);
	}
	
	@Override
	public void setSmallerThanValidator(int min) {
		set.setValidator(number -> number >= min);
	}

	@Override
	public Stream<Integer> getAllNumbers() {
		return set.stream();
	}

	@Override
	public Stream<Integer> getNumbersSmallerThan(int max) {
		return set.stream().filter(number -> number < max);
	}

	@Override
	public Stream<Integer> getNumbersSmallerThanAndMultipliedBy(int max,
			int factor) {
		return getNumbersSmallerThan(max).map(number -> number * factor);
	}

	@Override
	public int getTotal() {
		return set.stream().reduce((number, total) -> total += number).get();
	}

	@Override
	public int getMultiplesTotal(int max, int factor) {
		return set.
				stream().
				filter(number -> number < max).
				reduce((filteredNumber, total) -> total += filteredNumber * factor).
				get();
	}

	@Override
	public void setCollection(ExcerciseSet<Integer> set) {
		this.set = set;
	}
}
