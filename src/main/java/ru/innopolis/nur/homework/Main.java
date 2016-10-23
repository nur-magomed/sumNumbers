package ru.innopolis.nur.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nur on 13/10/16.
 */
public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        log.info("Program has started");
        System.out.println("The program has started!");
        String currentDir= System.getProperty("user.dir")+"/";
        String urlPrefix = "http://";


        if(args.length==0){
            /*некорректно использовать System.out, нужно настраивать логгер*/
            System.out.println("No arguments were passed");
            System.out.println("Please enter the sources");
            {
                try (InputStreamReader isr = new InputStreamReader(System.in);){
                    /*Ресурс тоже должен быть закрыт*/
                    BufferedReader br=new BufferedReader(isr);
                    args=br.readLine().split(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if((args.length==0) || args[0].equals("")) {
            System.out.println("The program has finished!");
            log.info("The program has finished!");
        }else {
            FinalSum finSum = new FinalSum(0, args.length);
            Thread[] threads = new Thread[args.length];
            for (int i = 0; i < threads.length; i++) {

                if((args[i].length()>6) && urlPrefix.equals(args[i].substring(0, 7))){
                    threads[i] = new Thread(new UrlInput(args[i], finSum));
                }
                else {
                    threads[i] = new Thread(new FIleInput(currentDir+args[i], finSum));
                }
                threads[i].start();
            }
        }

    }
}
