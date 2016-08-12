package tasks;

/**
 * Knowing the number of floors and apartments in the building, to determine storey and stairwell apartments
 *
 * @author Nikolai Tolchelnikov
 */
public class FindFloorAndStaircase {
    /**
     * Knowing the number of floors and apartments in the building, to determine porch and stairwell apartments
     *
     * @param floor      quantity in the building
     * @param apartments quantity  in the porch
     * @param flat       № apartment that  must find
     * @return location of the apartment. stairwell and Porch
     * @throws IllegalArgumentException floors, apartments, flat don't can less 0
     * @throws IllegalArgumentException imposed too great arguments is not enough memory int
     */
    public int[] getPorchesAndStairwell(int floor, int apartments, int flat) {
        if (floor <= 0) {    // check floor
            throw new IllegalArgumentException("floor don't can less 0 or 0. Floor = " + floor);
        }
        if (apartments <= 0) { // check apartments
            throw new IllegalArgumentException("apartments don't can less 0 or 0.  Apt = " + apartments);
        }
        if (flat <= 0) {       // check flat
            throw new IllegalArgumentException("flat don't can less 0 or 0. Flat = " + flat);
        }

        int[] floorStair = new int[2]; // array with numb porches and numb stairwell. Default 1st Apartment

        /**
         * Check if the apartment number less than the number of
         * apartments per floor, it is placed back 1 porch 1 floor
         */
        int numbPorch = 1; //default value
        int stairwell = 1; //default value

        if (flat > apartments) {

            stairwell = roundUp(flat,apartments);  //all stairwell

            if (stairwell > floor) {

                numbPorch = roundUp(stairwell,floor);

                stairwell = (stairwell - floor * (numbPorch - 1));
             }
        }

        floorStair[0] = numbPorch;
        floorStair[1] = stairwell;

        return floorStair;
    }

    /**
     * rounded up if there is a remainder
     *
     * @param dividend 1st
     * @param divisor  2nd
     * @return int
     */

    private static int roundUp (int dividend,  int divisor){
        int num =  dividend / divisor;

        if (dividend % divisor != 0){
          num += 1;
        }

        return num;
    }
}
