import java.util.Scanner; //Command used to import Scanner


/**
 * @author 6368950
 * Title: Assignment 2
 * Description: This is the Driver class that is used to run the program which is a seat Plane program
 *
 */

public class Driver {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // Defines the Scanner Object

        System.out.println("You will be selecting seats for this airplane.");

        int occupied =  0;
        int row = 0, col = 0;

        char[][] seats = {
                {'1','A','B','C','D'},
                {'2','A','B','C','D'},
                {'3','A','B','C','D'},
                {'4','A','B','C','D'},
                {'5','A','B','C','D'},
                {'6','A','B','C','D'},
                {'7','A','B','C','D'}
        }; // Creates a multidimensional array of type char

        printArray(seats); // Calls the printArray method that is used to print the multidimensional array
        System.out.println();
        System.out.println("You will input the seat selection using the row number and then the seat letter (ex - 3B)");
        System.out.println("Please enter the seat number or Q to quit."); // Asks the user to enter a seat number or Q to quit
        String userInput = keyboard.next();


        // While loop that runs as long as the user doesn't enter Q and as long as the plane is not full
        while (!(userInput.equalsIgnoreCase("Q")) && occupied != 28) {

            row = findRow(userInput); // Calls the findRow method that gets the row from the user and assigns it to a row variable
            col = findColumn(userInput); // Calls the findColumn method that gets the column from the user and assigns it to a column variable

            // While loop that validates the userInput and makes sure it's in the range of the seats in plane
            while (row > 6 || row < 0 || col < 1 || col > 7) {
                System.out.println("Invalid seat number.");
                printArray(seats); // Calls the printArray method that is used to print the multidimensional array
                System.out.println();
                System.out.println("Please enter the seat number or Q to quit."); // Asks the user again to enter a seat number
                userInput = keyboard.next();

                // If statement that checks if the user inputs Q to quit the program
                if (userInput.equals("Q")) {
                    System.exit(0); // Command that ends the program
                }
                row = findRow(userInput); // Calls the findRow method that gets the row from the user and assigns it to a row variable
                col = findColumn(userInput); // Calls the findColumn method that gets the column from the user and assigns it to a column variable
            }

            // If statement that checks if the valid seat number entered by the user is already occupied
            if (seats[row][col] == 'X') {
                System.out.println("Seat already occupied.");
            }
            // Else if it's not occupied then the program will put X on the seat number
            else {
                seats[row][col] = 'X';
                occupied++;
            }


            // If statement that checks if the number of occupied seats reaches 28 to print the final seat assignments and end the program
            if(occupied == 28) {
                System.out.println("Plane is Full");
                System.out.println("Final seat assignments: ");
                printArray(seats); // Calls the printArray method that is used to print the multidimensional array
                System.exit(0); // Command that ends the program
            }

            printArray(seats); // Calls the printArray method that is used to print the multidimensional array
            System.out.println();
            System.out.println("Please enter the seat number or Q to quit."); // Asks the user again to enter a seat number
            userInput = keyboard.next();

        }
        System.out.println("Final seat assignments: ");
        printArray(seats); // Calls the printArray method that is used to print the multidimensional array
    }

    /**
     * This is the printArray method that receives the multidimensional array seats and prints the array
     * @param seats char[][]
     */
    public static void printArray(char[][] seats) {

        // For loop that loops through the row and columns of the multidimensional array and prints it
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This is the findColumn method that receives the userInput and finds the column entered by the user
     * and then returns it as an int
     * @param userInput String
     * @return int
     */
    public static int findColumn(String userInput) {

        // If user enters A then the program assigns it to 1 and returns the int 1
        if (userInput.charAt(1) == 'A') {
            return 1;
        }
        // Else if user enters B then the program assigns it to 2 and returns int 2
        else if (userInput.charAt(1) == 'B') {
            return 2;
        }
        // Else if user enters C then the program assigns it to 3 and returns int 3
        else if (userInput.charAt(1) == 'C') {
            return 3;
        }
        // Else if user enters D then the program assigns it to 4 and returns int 4
        else if (userInput.charAt(1) == 'D') {
            return 4;
        }
        else {
            return -1;
        }
    }

    /**
     * This is the findRow method that receives the userInput and finds the row entered by the user
     * and then returns it as an int
     * @param userInput String
     * @return int
     */
    public static int findRow(String userInput) {
        // If user enters 1 then the program assigns it to 0 and returns int 0
        if (userInput.charAt(0) == '1') {
            return 0;
        }
        // Else if user enters 2 then the program assigns it to 1 and returns int 1
        else if (userInput.charAt(0) == '2') {
            return 1;
        }
        // Else if user enters 3 then the program assigns it to 2 and returns int 2
        else if (userInput.charAt(0) == '3') {
            return 2;
        }
        // Else if user enters 4 then the program assigns it to 3 and returns int 3
        else if (userInput.charAt(0) == '4') {
            return 3;
        }
        // Else if user enters 5 then the program assigns it to 4 and returns int 4
        else if (userInput.charAt(0) == '5') {
            return 4;
        }
        // Else if user enters 6 then the program assigns it to 5 and returns int 5
        else if (userInput.charAt(0) == '6') {
            return 5;
        }
        // Else if user enters 7 then the program assigns it to 6 and returns int 6
        else if (userInput.charAt(0) == '7') {
            return 6;
        }
        else {
            return -1;
        }
    }
}
