// Student Name Rudy Valdez
// Date 2/16
// CSCI 3302 Section 001
// 
// Files:   Ticket.java
// 
// Description: This program is supposed to read in a string of length 10 
/* consisting of 7 characters (either F or B) signifying front or back out 
 * of the 128 plane rows, and 3 more characters (either L or R) defining 
 * left or right of the 8 columns in the plane. Depending on the string
 * that is given, the program should return a int telling us what the 
 * row the person is seated in and which column, as well as the seat ID.
 */


public class Ticket  {
   
    /* findSeatID method takes in input of type string. Based on the string
     * that is given, this method will return the row, column, and seat ID
     * given the characters in the string.
     */
    public static int findSeatID(String partition) {
        int row = findSeatRow(partition, 0, 127, 0);
        int column = findSeatColumn(partition, 0, 7, 7);
        return row * 8 + column;
    }

    /* This is a recursive helper method that is supposed to do a binary search. 
     * Through binary search, it should find the location
     * of the seat in the row based on the range given in the parameters from 0 
     * to 127
     */ 
    public static int findSeatRow(String key, int left, int right, int index) {
        if((right == left)&&(index <= 7)) {
            return right;
        } else if(right < left) {
            return -1;
        } else {
            int middle = (left + right)/2;

            if(key.charAt(index) == 'F') {
                right = middle;
            } else if(key.charAt(index) == 'B') {
                left = middle + 1;
            }
            return findSeatRow(key, left, right, index + 1);
        }
    }

    /* This is a recursive helper method that does a binary search based on
     * the last three characters of the partition string. It should find the location
     * of the column based on the parameters from 0 to 7.
     */
    public static int findSeatColumn(String key, int left, int right, int index) {
        if((right == left)) {
            return right;
        } else if(right < left) {
            return -1;
        } else {
            int middle = (left + right)/2;

            if(key.charAt(index) == 'R') {
                left = middle + 1;
            } else if(key.charAt(index) == 'L'){
                right = middle;
            }
            return findSeatColumn(key, left, right, index + 1);
        }
    }

}  // end class 