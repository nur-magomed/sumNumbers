package ru.innopolis.nur.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nur on 13/10/16.
 *
 */
public class FIleInput extends Input implements Runnable {
    private static Logger log = LoggerFactory.getLogger(Main.class);
    /**
     * String: fileName - name of the input file
     */
    private String fileName;

    /**
     *  Sharing variable that contains the sum of the numbers
     */
    FinalSum fSum;

    /**
     * Reads character-based text from input
     */
    private BufferedReader reader;

    /**
     * Constructor for File input class that takes two parameters: file name, sum of numbers (shared)
     * @param fileName
     * @param fSum
     */
    public FIleInput(String fileName, FinalSum fSum) {
        this.fileName = fileName;
        this.fSum = fSum;
    }

    /**
     * Method get file name
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Method set file name
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     * This method traverses the data from the source and line by line passes it to the "sum" method
     * Sum method is implemented in the parent class Input
     * It sums the possitive even numbers from the sources.
     */
    @Override
    public void run() {
        try(FileReader fileReader = new FileReader(fileName)){

        reader = new BufferedReader(fileReader);
        String line = null;


        while ((!Thread.currentThread().isInterrupted()) && ((line  = reader.readLine()) != null)){
            sum(line, this.fSum);
        }

        fileReader.close();
    } catch (FileNotFoundException fnfE){

            //interapts all threads
            for (Thread t : Thread.getAllStackTraces().keySet())
            {  if (t.getState()==Thread.State.RUNNABLE)
                t.interrupt();
            }

            log.info("File is not found. Wrong source: "+this.getResourceName());
        fnfE.printStackTrace();
    }catch (IOException ioE){
        ioE.printStackTrace();
    }
        // Informing parent class of finishing the thread
        trackActiveThreads(this.fSum);
    }


    /**
     * This method returns the name of the source
     * @return
     */
    @Override
    protected String getResourceName(){
        return this.getFileName();
    }


}
