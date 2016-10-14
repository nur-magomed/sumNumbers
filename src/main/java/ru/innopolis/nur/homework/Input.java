package ru.innopolis.nur.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nur on 13/10/16.
 */
public abstract class Input {
    private static Logger log = LoggerFactory.getLogger(Main.class);
    /**
     * This variable holds current int in the sum method
     */
    private int currentNumber;

    /**
     * This variable holds the number of interrupted threads
     */
    private static int interruptedThreads=0;

    /**
     * This method takes string from sources parses to find integers
     * and sums positive even numbers
     * @param line
     * @param fSum
     */
    public void sum(String line, FinalSum fSum) {

        //passed string "line" is split into separate strings by space and stored in an array number
        String []  number = line.split(" ");
        String st=null;

        //array number is converted to List for further conversation into Iterator, in order to get Iteratable
        List<String> numberList = Arrays.asList(number);
        Iterator<String> numberIterator = numberList.iterator();

        while((!Thread.currentThread().isInterrupted()) && (numberIterator.hasNext())){

            try {
                st = numberIterator.next();
                currentNumber = Integer.parseInt(st);
            } catch (NumberFormatException e) {

                //interapts all threads
                for (Thread t : Thread.getAllStackTraces().keySet())
                {  if (t.getState()==Thread.State.RUNNABLE)
                    t.interrupt();
                }
                e.printStackTrace();
                log.error(": Error in the text. Source: \"" + getResourceName() + "\": '" + st + "' - is not a number");
                System.out.println( e + ": Error in the text. Source: \"" + getResourceName() + "\": '" + st + "' - is not a number");
            }

            if (currentNumber > 1 && currentNumber % 2 == 0) {
                synchronized (fSum) {
                    fSum.setFinalSum(fSum.getFinalSum() + currentNumber);
                    System.out.println("Sum of even positive numbers = " + fSum.getFinalSum() + "  : " + getResourceName());
                }
            }
        }
    }

    /**
     * abstract method that is implemented by child classes
     * @return
     */
    protected abstract String getResourceName();

    /**
     * Tracks the number of active threads, and after finishing all threads outputs message to user
     * @param finalSum
     */
    protected void trackActiveThreads(FinalSum finalSum){

            interruptedThreads++;

        synchronized (finalSum){
        if (interruptedThreads>=finalSum.getActiveThreads()){

            log.info("The total sum of all even positive numbers is: " + finalSum.getFinalSum());
            log.info("The number of finished threads is: " + interruptedThreads);
            log.info("The program has finished");

            System.out.println("The total sum of all even positive numbers is: " + finalSum.getFinalSum());
            System.out.println("The number of finished threads is: " + interruptedThreads);
            System.out.println("The program has finished");
        }

        }
    }

}