package primes;

import java.util.LinkedList;
import java.util.List;

public class ArrayOperations {

	public static int[] listToArray(List<Integer> l) {
		int[] a = new int[l.size()];
		
		for(int i = 0; i < l.size(); i++) {
			a[i] = l.get(i);
		}
		
		return a;
	}
	
	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i +", ");
		}
		System.out.println();
	}
	
	public static List<Integer> getPrimeArray(int n) {
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (isPrime(i)) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	public static boolean isPrime(int number) {
	    for (int i = 2; i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static int[] addToArray(int[] a, int p) {
		int[] aNew;
		if(a != null) {
			aNew = extendArray(a, 1);	
		}else {
			aNew = new int[1];
			aNew[aNew.length - 1] = p;	
		}
		
		return aNew;
	}
	
	public static int[] extendArray(int[] a, int toExtend) {
		int[] aNew = new int[a.length + toExtend];
		
		for(int i = 0; i < aNew.length; i++) {
			if(i < a.length) {
				aNew[i] = a[i];
			}else {
				aNew[i] = 0;
			}
		}
		
		return aNew;
	}

	/** Entfernt ein Element aus der ArrayListe.
	 * @param data die Liste.
	 * @param removeIndex der Index.
	 * @return die neue Liste.
	 */
	public static int[] removeArrayElement(int[] data, int removeIndex){
		int[] newArray = new int[data.length - 1];

		for(int i = 0; i < newArray.length; i++) {
			if(i >= removeIndex) {
				newArray[i] = data[i+1];
			}else {
				newArray[i] = data[i];
			}
		}

		return newArray;
	}
}
