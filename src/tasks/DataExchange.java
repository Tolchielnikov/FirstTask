package tasks;


/**
 * will change their values without third variable (the array) and no special functions or operators
 *
 * @author Nikolai Tolchelnikov
 */
public class DataExchange {
    /**
     * will change their values without third variable and no special functions or operators
     *
     * @param arrTwoVal incoming array with 2 cells.
     * @return an array with the changed data.
     * @throws IllegalArgumentException if the value is not equal to 2
     */
    public int[] dataExchange(int arrTwoVal[]) {
        if (arrTwoVal == null) {
            throw new IllegalArgumentException("incoming values cannot be empty");
        }

        if (arrTwoVal.length != 2) {
            throw new IllegalArgumentException("Only two values. Your values =  " + arrTwoVal.length);
        }

        arrTwoVal[0] = arrTwoVal[0] + arrTwoVal[1];
        arrTwoVal[1] = arrTwoVal[0] - arrTwoVal[1];
        arrTwoVal[0] = arrTwoVal[0] - arrTwoVal[1];

        return arrTwoVal;
    }
}

