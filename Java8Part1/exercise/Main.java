package exercise;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import exercise.attempt.Attempt;
import exercise.solution.Solution;

public class Main {

	public static void main(String[] args) {
		
		//Create set
		ExcerciseSet<Integer> solutionCollection = new ExcerciseSet<>();
		ExcerciseSet<Integer> attemptCollection = new ExcerciseSet<>();

		//Create interface
		ExcerciseInterface solution = new Solution();
		ExcerciseInterface attempt = new Attempt();
		solution.setCollection(solutionCollection);
		attempt.setCollection(attemptCollection);

		//Add listener
		//solution.addListenerToSet();
		attempt.addListenerToSet();

		//Add 10 numbers
		System.out.println("Adding 10 random numbers");
		addRandoms(solutionCollection, attemptCollection, 10);
		validateEquals(solutionCollection, attemptCollection);
		System.out.println("Validated initial 10 numbers");
		System.out.println();
		
		//Set even numbers validator
		solution.setEvenNumberValidator();
		attempt.setEvenNumberValidator();
		//Add 10 random numbers
		System.out.println("Adding 10 random numbers (only even numbers should be accepted)");
		addRandoms(solutionCollection, attemptCollection, 10);
		validateEquals(solutionCollection, attemptCollection);
		System.out.println("Validated added 10 even numbers");
		System.out.println();

		//Set bigger than X validator
		solution.setSmallerThanValidator(30);
		attempt.setSmallerThanValidator(30);
		//Add 10 random numbers
		System.out.println("Adding 10 random numbers (should be smaller than 30)");
		addRandoms(solutionCollection, attemptCollection, 10);
		validateEquals(solutionCollection, attemptCollection);
		System.out.println("Validatedadding 10 numbers smaller than 30");
		System.out.println();

		//Print all numbers
		System.out.println("Getting all numbers");
		Collection<Integer> attemptAllNumbers = attempt.getAllNumbers().collect(Collectors.toSet());
		Collection<Integer> solutionAllNumbers = solution.getAllNumbers().collect(Collectors.toSet());
		validateEquals(solutionAllNumbers, attemptAllNumbers);
		System.out.println("Validated getting all numbers");
		System.out.println();

		//Print numbers smaller than X
		System.out.println("Getting all numbers smaller than 50");
		Collection<Integer> solutionNumbersSmallerThan = solution.getNumbersSmallerThan(50).collect(Collectors.toSet());
		Collection<Integer> attemptNumbersSmallerThan = attempt.getNumbersSmallerThan(50).collect(Collectors.toSet());
		validateEquals(solutionNumbersSmallerThan, attemptNumbersSmallerThan);
		System.out.println("Validated getting numbers smaller than 50");
		System.out.println();

		//Print numbers smaller than X, multiplied by Y
		System.out.println("Getting all numbers smaller than 50, multiplied by 2");
		Collection<Integer> solutionMultiples = solution.getNumbersSmallerThanAndMultipliedBy(50, 2).collect(Collectors.toSet());
		Collection<Integer> attemptMultiples = attempt.getNumbersSmallerThanAndMultipliedBy(50, 2).collect(Collectors.toSet());
		validateEquals(solutionMultiples, attemptMultiples);
		System.out.println("Validated getting numbers smaller than 50, multiplied by 2");
		System.out.println();

		//Print total
		System.out.println("Getting total");
		int solutionTotal = solution.getTotal();
		int attemptTotal = attempt.getTotal();
		validate(solutionTotal, attemptTotal);
		System.out.println("Validated totals");
		System.out.println();

		System.out.println("Getting total of numbers smaller than 50, multiplied by 2");
		int solutionMultipleTotal = solution.getMultiplesTotal(50, 2);
		int attemptMultipleTotal = attempt.getMultiplesTotal(50, 2);
		validate(solutionMultipleTotal, attemptMultipleTotal);
		System.out.println("Validated getting total of numbers smaller than 50, multiplied by 2");
		System.out.println();

		System.out.println("--- All tests succeeded. Good job! ---");
	}
	
	private static void addRandoms(Set<Integer> set1, Set<Integer> set2, int amount) {
		Random r = new Random();
		int added = 0;
		while (added < amount) {
			int nextInt = r.nextInt(100);
			if (set1.add(nextInt)) {
				added++;
			}
			set2.add(nextInt);
		}
	}

	private static void validate(int solutionTotal, int attemptTotal) {
		if (solutionTotal != attemptTotal) {
			System.out.println("Inconsistency detected");
			System.out.println("Solution total: " + solutionTotal);
			System.out.println("Attempt total: " + attemptTotal);
		}
	}
	
	private static void validateEquals(Collection<Integer> solutionCol, Collection<Integer> attemptCol) {
		if (!solutionCol.equals(attemptCol)) {
			System.out.println("Inconsistency detected");
			System.out.print("ints in solution, but not in attempt: ");
			solutionCol.stream().filter(t -> !attemptCol.contains(t)).forEach(t -> System.out.print(t + " "));
			System.out.println();
			System.out.print("ints in attempt, but not in solution: ");
			attemptCol.stream().filter(t -> !solutionCol.contains(t)).forEach(t -> System.out.print(t + " "));
			System.exit(0);
		}
	}
}
