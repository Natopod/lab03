/*
 * 
 * I Nathanael greene  certify that this material is my original work. No other person's
 * work has been used without suitable acknowledgment and I have not made my work available to anyone else.
 */
package lab3;

import java.util.Scanner;

import java.util.InputMismatchException;

/**
 * This program is used to track Cab statistics for a taxi company and the Lab03
 * class holds the main method of the program
 *
 * @author Nathanael Greene 000336422
 */
public class Lab3 {

  /**
   * The main method of Lab03 creates the Cab objects and then runs a while loop
   * to continually take user input about the cab statistics. It then calls two
   * functions to tally the days earnings and print the information to console
   *
   * @param args
   */
  public static void main(String[] args) {
    Cab cabOne;
    Cab cabTwo;
    Scanner input;
    int cabInputID = 0;
    double riderWeight;
    int riderSeat;
    int riderMinutes;
    boolean riderSeatFront = true;

    //create two new Cab objects based on their seperate ID numbers
    cabOne = new Cab(1111);
    cabTwo = new Cab(2222);

    input = new Scanner(System.in);

    System.out.print("Cab ID (1111 or 2222): ");
    try {
      cabInputID = input.nextInt();
    } catch (InputMismatchException a) {
      
    }
    //loop will run as long as the user continues to input a valid ID number
    while (cabInputID == 1111 || cabInputID == 2222) {

      System.out.print("Passenger weight: ");
      try {
        riderWeight = input.nextDouble();
      } catch (InputMismatchException a) {
        System.out.println("Please Enter a Integer(with or without a decimal)!");
        System.out.print("Passenger weight: ");
        input.nextLine();
        riderWeight = input.nextDouble();
      }
      System.out.print("Sitting in front seat (1 = YES, 0 = NO): ");
      try {
        riderSeat = input.nextInt();
      } catch (InputMismatchException a) {
        System.out.println("Please Enter a Integer!");
        System.out.print("Sitting in front seat (1 = YES, 0 = NO): ");
        input.nextLine();
        riderSeat = input.nextInt();
      }
      System.out.print("How many minutes: ");
      try {
        riderMinutes = input.nextInt();
      } catch (InputMismatchException a) {
        System.out.println("Please Enter a Integer!");
        System.out.print("How many minutes: ");
        input.nextLine();
        riderMinutes = input.nextInt();
      }
      //if the user selects the option that the rider is in the back seat it will
      //change the default value of the riderSeatFront variable
      if (riderSeat == 0) {
        riderSeatFront = false;
      }

      //if else statement that places the user input into the correct Cab object
      if (cabInputID == 1111) {
        cabOne.pickUp(riderWeight, riderSeatFront);
        cabOne.dropOff(riderMinutes);
      } else {
        cabTwo.pickUp(riderWeight, riderSeatFront);
        cabTwo.dropOff(riderMinutes);
      }
      //resets the value of riderSeatFront to default
      riderSeatFront = true;

      //asks for new ID number to see if the loop will continue
      System.out.print("Cab ID (1111 or 2222): ");
      try {
        cabInputID = input.nextInt();
      } catch (InputMismatchException a) {
        break;
      }

    }

    //calls the endOfShift() and displayStats() methods on each cab object
    cabOne.endOfShift();
    cabTwo.endOfShift();

    cabOne.displayStats();
    cabTwo.displayStats();

  }
}
