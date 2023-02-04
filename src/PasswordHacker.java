//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Password Hacker
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
 * This class contains a method where it sets a new password and
 *  two methods where it can open the lockbox.
 */
public class PasswordHacker {
	private LockBox toPick;
	private int passwordLength;

	/*
	 * This method stores the provided passwordLength and sets a new lockbox with
	 * the provided passwordLength.
	 * 
	 * @param passwordLength is the length of the password which is set as the same
	 *        variable provided outside the method.
	 */
	public PasswordHacker(int passwordLength) {
		this.passwordLength = passwordLength;
		toPick = new LockBox(passwordLength);
	}

	/*
	 * This method uses hackMe method and authenticate method to unlock the reset
	 * lockbox.
	 */
	/** Complexity: O(1) */
	public void hack() {
		toPick.reset();
		toPick.authenticate(toPick.hackMe());
	}

	/*
	 * This method uses the generateGuess method to guess the password until it is
	 * unlocked.
	 */
	/** Complexity: O(10^N) */
	public void bruteForce() {
		toPick.reset();
		for (int i = 0; !(toPick.isOpen()); i++) {
			toPick.authenticate(generateGuess(i));
		}
	}
	/*
	 * This method provides a loop that generates numbers that is the same length as
	 * the passwordLength and gets incremented everytime this method is called.
	 * 
	 * @param count goes up everytime generateGuess is called.
	 * 
	 * @return guess is the number this method is guessing.
	 */

	public String generateGuess(int count) {
		String guess = "";
		for (int i = 0; i < passwordLength; i++) {
			guess = (count % 10) + guess;
			count = count / 10;
		}
		return guess;
	}
}
