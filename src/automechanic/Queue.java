/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automechanic;

import javax.swing.JOptionPane;

/**
 *
 * @author Carmen Dominguez
 * @created 1 September 2016
 * @edited 5 September 2016
 */
public class Queue {
    
    //@param args the command line arguments
    private final int maxSize = 12;
    private String[] queArray;
    private int head = 0;
    private int tail = 0;
    private int nItems = 0;

    //Constructor
    public Queue() {
        queArray = new String[maxSize];
        head = 0;
        tail = -1;
        nItems = 0;
    }

    //put item at the end of a queue
    public void insert(String regNum) {
        if (tail == maxSize - 1) {
            tail = -1;
        }

        //increment the tail and insert into the queue
        queArray[++tail] = regNum;
        nItems++;
    }

    //take item from the front of the queue
    public String remove() {
        //get the value and increase the head
        String temp = queArray[head++];

        if (head == maxSize) {
            head = 0;
        }
        nItems--;
        return temp;
    }

    //Check to see is there is anything in the queue
    public boolean isEmpty() {
        return (nItems == 0);
    }

    //Return the size of the queue
    public int size() {
        return nItems;
    }

    public static void main(String[] args) {
        // The queue is created here
        Queue theQueue = new Queue();
        String entry;
        int count;
        char input = 's';

        while (theQueue.size() < 12) {
            entry = JOptionPane.showInputDialog(null, "Enter the car's registration number.\n"
                    + "Type in STOP when done.\n"
                    + "Number of cars in queue: " + theQueue.size());

            //This ensures the STOP command is not entered into the queue
            if (entry.toLowerCase().equals("stop")) {
                break;
            }

            theQueue.insert(entry);
        }

        JOptionPane.showMessageDialog(null, "Entry/entries successfull. ");

        //The Main UI of the program
        while (input != 'x') {
            input = (JOptionPane.showInputDialog(null, "Current number of cars in queue: " + theQueue.size()
                    + "\n\nTo remove a car from the queue, enter 1"
                    + "\nTo insert a car to the queue, enter 2"
                    + "\nTo empty the queue, enter 3"
                    + "\nTo exit the program, enter the letter X\n")).toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    //First check to make sure there is something to remove
                    if (!theQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Car number " + theQueue.remove() + " has been removed.");
                    } else {
                        JOptionPane.showMessageDialog(null, "There are no cars currently in the queue.");
                    }
                    break;

                case '2':
                    if (theQueue.size() < 12) {

                        entry = JOptionPane.showInputDialog(null, "Enter the car's registration number");

                        theQueue.insert(entry);
                    } else {
                        JOptionPane.showMessageDialog(null, "The queue is full. No cars can be added now.");
                    }
                    break;

                case '3':
                    theQueue = new Queue();

                    JOptionPane.showMessageDialog(null, "The queue is now empty.");
                    break;

                case 'x':
                    JOptionPane.showMessageDialog(null, "The program will now exit.\nHave a nice day.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "An invalid input was detected.\nPlease try again.");
            }
        }
    }
}
