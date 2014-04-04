package exercise;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author David ten Hove
 */
public interface ExcerciseInterface {
	
	/**
	 * Sets the {@link ExcerciseSet} to use for this excercise
	 * @param set the set to use
	 */
	void setCollection(ExcerciseSet<Integer> set);

	/**
	 * Adds a {@link Listener} the set. Should just print the numbers added to the standard outputstream
	 */
	void addListenerToSet();

	/**
	 * Sets a {@link Predicate} to the {@link ExcerciseSet}. Should only accept even values
	 */
	void setEvenNumberValidator();

	/**
	 * Sets a {@link Predicate} to the {@link ExcerciseSet}. Should only accept values smaller than the maximum.
	 * @param max the maximum (exclusive) for values being added to the {@link ExcerciseSet}. 
	 */
	void setSmallerThanValidator(int max);

	/**
	 * Returns a {@link Stream} of all numbers in the {@link ExcerciseSet}.
	 * @return a {@link Stream} of all numbers in the {@link ExcerciseSet}.
	 */
	Stream<Integer> getAllNumbers();
	
	/**
	 * Returns a {@link Stream} of all the numbers in the {@link ExcerciseSet} which are smaller than {@code max}
	 * @param max
	 * @return a {@link Stream} of all the numbers in the {@link ExcerciseSet} which are smaller than {@code max}
	 */
	Stream<Integer> getNumbersSmallerThan(int max);

	/**
	 * Returns a {@link Stream} of all the numbers in the {@link ExcerciseSet} which are smaller than {@code max}, multiplied by {@code factor}.
	 * @return a {@link Stream} of all the numbers in the {@link ExcerciseSet} which are smaller than {@code max}, multiplied by {@code factor}.
	 */
	Stream<Integer> getNumbersSmallerThanAndMultipliedBy(int max, int factor);

	/**
	 * Returns the total of all the numbers in the {@link ExcerciseSet}.
	 * @return the total of all the numbers in the {@link ExcerciseSet}.
	 */
	int getTotal();

	/**
	 * Returns the total of all the numbers smaller than {@code max}, multiplied by {@code factor}.
	 * @param max the maximum
	 * @param factor the value to multiply with
	 * @return the total of all the numbers smaller than {@code max}, multiplied by {@code factor}.
	 */
	int getMultiplesTotal(int max, int factor);
}
