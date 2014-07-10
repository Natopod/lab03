/*
 * 
 * I Nathanael greene  certify that this material is my original work. No other person's
 * work has been used without suitable acknowledgment and I have not made my work available to anyone else.
 */
package lab3;

/**
 * The Cab class holds the methods that are used to create Cab objects and
 * perform various tracking and accounting related procedures on them
 *
 * @author Nathanael Greene 000336422
 */
public class Cab {

  private static double companyTotalFare = 0.0;
  private double rate = 1.95;
  private double taxiTotalFare = 0.0;
  private double tripFare;
  private int tripCounter;
  private int cabID;
  private Passenger rider;

  /**
   * This constructor is used to create Cab objects that can be used throughout
   * the Cab class and main method.
   *
   * @param ID refers to the identification number of the cab
   */
  public Cab(int ID) {
    cabID = ID;
  }

  /**
   * This method is used to create Passenger objects through the Passenger
   * class, inform the system about the status of the airbag and tally the total
   * number of trips for the given cab object
   *
   * @param weight refers to the user inputed weight of the passenger
   * @param front refers to the user inputed location of the passenger
   */
  public void pickUp(double weight, boolean front) {
    rider = new Passenger(weight, front);

    if (rider.getWeight() < 40 && rider.getFront() == true) {
      System.out.println("PASSENGER SEAT AIRBAG IS OFF IN CAB " + cabID);
    }

    tripCounter++;
  }

  /**
   * this method is used to calculate the tripFare and taxiTotalFare variables
   * it also returns the Passenger object rider back to null to control the use
   * of memory by the program
   *
   * @param minutes is the user inputed number of minutes that the rider was in
   * the cab
   */
  public void dropOff(int minutes) {
    rider = null;
    tripFare = minutes * rate;
    taxiTotalFare = taxiTotalFare + tripFare;
  }

  /**
   * this method is used to combine the taxiTotalFare values of each Cab object
   * in order to show the amount of money taken in by the company that day
   */
  public void endOfShift() {
    companyTotalFare += taxiTotalFare;
  }

  /**
   * this method is used to print the statistics of the given cab object for
   * that day to the console
   */
  public void displayStats() {
    String isTripPlural = "trips";

    if (tripCounter == 1) {
      isTripPlural = "trip";
    }

    System.out.println("cab " + cabID + " had " + tripCounter + " " + isTripPlural
            + " and brought in $" + taxiTotalFare + " from the days $" + companyTotalFare);
  }
}
