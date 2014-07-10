/*
 * 
 * I Nathanael greene  certify that this material is my original work. No other person's
 * work has been used without suitable acknowledgment and I have not made my work available to anyone else.
 */

package lab3;

/**
 *The Passenger class is used to create Passenger objects and return the seperate
 * variables that make up the Passenger object
 * @author Nathanael Greene 000336422
 */
public class Passenger {
  private double weight;
  private boolean front;
  
  /**
   * The Passenger constructor takes user input from the Cab class and creates a 
   * Passenger object
   * @param weightP is the Passenger's weight inputed by the user 
   * @param frontP is the location of the Passenger, front is TRUE and back is FALSE
   */
  public Passenger(double weightP, boolean frontP) {
    weight = weightP;
    front = frontP;
  }
  /**
   * This method is used to return the weight of the Passenger object
   * @return <code>weight</code> refers to weight in the Passenger object 
   */
  public double getWeight() {
    return weight;
  }
  /**
   * This method is used to return the location (front or back seat) of the Passenger object
   * @return <code>front</code> refers to the location of the Passenger in the cab 
   */
  public boolean getFront() {
    return front;
  }
  
}
