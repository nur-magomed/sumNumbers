package ru.innopolis.nur.homework;

/**
 * Created by nur on 13/10/16
 * This class
 */
public class FinalSum {

    /**
     * The "Box" variable finalSum contains the value of sum
     */
    private long finalSum;

    /**
     * This variable holds the number of active threads
     */
    private int activeThreads;

    /**
     * This constructor takes finalSum
     * @param finalSum
     */
    public FinalSum(long finalSum, int activeThreads) {
        this.activeThreads = activeThreads;
        this.finalSum = finalSum;
    }

    /**
     * Returns the value of finalSum
     * @return
     */
    public long getFinalSum() {
        return finalSum;
    }

    /**
     * Sets the value to finalSum
     * @param finalSum
     */
    public void setFinalSum(long finalSum) {
        this.finalSum = finalSum;
    }


    /**
     * This method returns the number of active threads
     * @return
     */
    public int getActiveThreads() {
        return activeThreads;
    }

    /**
     * This method allows to set the number of active threads
     * @param activeThreads
     */
    public void setActiveThreads(int activeThreads) {
        this.activeThreads = activeThreads;
    }
}
