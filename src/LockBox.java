
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Lock Box
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
import java.util.Random;

/*
 * This class defines the lockbox object and it's characters.
 */
public class LockBox {
	protected static Random randGen;
	private String password;
	private boolean isOpen;
	/*
	 * This method generates set of random digits, the length of digits is defined
	 * by passwordLength.
	 * 
	 * @param passwordLength is the length of the digits.
	 */

	public LockBox(int passwordLength) {
		if (randGen == null) {
			randGen = new Random();
		}
		if (passwordLength <= 0) {
			throw new IllegalArgumentException(
					"Hello there, I'm really sorry but the length shouldn't be negative or zero");
		} else {
			password = "";
			for (int i = 0; i < passwordLength; ++i) {
				password += Integer.toString(randGen.nextInt(10));
			}
		}
	}
	/*
	 * This method compares the guess to the password and sets isOpen to true if
	 * they are same.
	 * 
	 * @param guess is the value that gets compared with the password.
	 */

	public void authenticate(String guess) {
		if (password.equals(guess)) {
			isOpen = true;

		}

	}
	/*
	 * This method returns the password. return password.
	 * 
	 * @return password.
	 */

	public String hackMe() {
		return password;
	}

	/*
	 * This method returns the isOpen. return isOpen. return isOpen.
	 */
	public boolean isOpen() {
		return isOpen;
	}
	/*
	 * This method resets isOpen to false.
	 */

	public void reset() {
		isOpen = false;
	}

}
