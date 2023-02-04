//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Benchmarker
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
/*
 * This class measures how much time it took for BruteForce and Hack to unlock
 * the lockbox object and compares them.
 */
public class Benchmarker {
	/*
	 * This method measures the time it took for the bruteForce method to unlock the
	 * generated Passwordhacker object.
	 * 
	 * @param ph is the random generated PasswordHacker object.
	 * 
	 * @return (System.currentTimeMillis() - startTime) is the time it took to
	 *         unlock in ms.
	 */
	public static long timeBruteForce(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.bruteForce();
		return (System.currentTimeMillis() - startTime);
	}

	/*
	 * This method measures the time it took for the hack method to unlock the
	 * generated Passwordhacker object.
	 * 
	 * @param ph is the random generated PasswordHacker object.
	 * 
	 * @return (System.currentTimeMillis() - startTime) is the time it took to
	 *         unlock in ms.
	 */
	public static long timeHack(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.hack();
		return (System.currentTimeMillis() - startTime);
	}
	/*
	 * This method calls both timeHack and timeBruteForce method and compares the
	 * amount of time it took for them to unlock the random generated PasswordHacker
	 * object. The race can be done a multiple times and be averaged out for more
	 * accuracy.
	 * 
	 * @param passwordLength is the length of the password of the provided
	 *         PasswordHacker objects.
	 * 
	 * @param numRuns is the number of times this race will be played.
	 * 
	 * @return the passwordLength and the average time it took for both methods to
	 *         unlock the lockbox.
	 */

	public static String race(int passwordLength, int numRuns) {
		// time it took for bruteForce method to figure out the password.
		long bruteForceTime = 0;
		// time it took for hack method to figure out the password.
		long hackTime = 0;

		for (int i = 0; i < numRuns; i++) {
			PasswordHacker lockBox = new PasswordHacker(passwordLength);
			bruteForceTime += timeBruteForce(lockBox);
			hackTime += timeHack(lockBox);
		}
		return "Brute force " + passwordLength + ": " + bruteForceTime / numRuns + "\nHack " + passwordLength + ": "
				+ hackTime / numRuns;
	}

	public static void main(String[] args) {

		System.out.println(race(8, 1));
	}

}
