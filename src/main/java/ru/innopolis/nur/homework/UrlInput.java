package ru.innopolis.nur.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by nur on 13/10/16.
 */
public class UrlInput extends Input implements Runnable{

    private static Logger log = LoggerFactory.getLogger(Main.class);
    /**
     *  Sharing variable that contains the sum of the numbers
     */
    FinalSum fSum;

    /**
     *  The url address of the source
     */
    private String strUrl;

    /**
     * Constuctor for URL-sourced input with two parameters: url-address and sum of number (shared)
     * @param strUrl
     * @param fSum
     */
    public UrlInput(String strUrl, FinalSum fSum) {
        this.strUrl = strUrl;
        this.fSum = fSum;
    }

    /**
     * This method traverses the data from the source and line by line passes it to the "sum" method
     * Sum method is implemented in the parent class Input
     * It sums the possitive even numbers from the sources.
     */
    @Override
    public void run() {

        try ( BufferedReader in = new BufferedReader (new InputStreamReader(new URL(this.getStrUrl()).openStream()))){

            String line=null;

            while ((!Thread.currentThread().isInterrupted()) && ((line =  in.readLine()) != null)){

                 //Passes the string line to the sum method
                sum(line, this.fSum);
            }

            in.close();
        }
        catch (MalformedURLException e) {

            e.printStackTrace();
        } catch(UnknownHostException ex){
            //interapts all threads
            for (Thread t : Thread.getAllStackTraces().keySet())
            {  if (t.getState()==Thread.State.RUNNABLE)
                t.interrupt();
            }

            log.error("Wrong source input: " + this.getResourceName());
            System.out.println("Wrong source input: " + this.getResourceName());
            ex.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        // Informing parent class of finishing the thread
        trackActiveThreads(this.fSum);
    }

    /**
     * This method returns the string URL
     * @return
     */
    public String getStrUrl() {
        return strUrl;
    }

    /**
     * This method sets the string of the URL
     * @param strUrl
     */
    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    /**
     * This method returns the name of the source
     * @return
     */
    @Override
    protected String getResourceName(){
        return this.getStrUrl();
    }
}
