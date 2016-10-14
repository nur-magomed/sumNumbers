package ru.innopolis.nur.homework;

import org.slf4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by nur on 13/10/16.
 */
public class UrlInputTest {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private FinalSum finalSum = new FinalSum(0, 5);
    private UrlInput urlInput=new UrlInput("http://google.com", finalSum);
    private String line = "1 201 -4 0 2 333 45331 8 -134 4 6";


    @Test
    public void getStrUrl() {
        assertEquals("http://google.com", urlInput.getStrUrl());
        log.info("Method test getStrUrl: successful");
    }

    @Test
    public void setStrUrl() {
        urlInput.setStrUrl("https://university.innopolis.ru");
        assertEquals( "https://university.innopolis.ru" , urlInput.getStrUrl());
        log.info("Method test setStrUrl: successful");
    }

    @Test
    public void getResourceName()  {
        assertEquals( "http://google.com" , urlInput.getStrUrl());
        log.info("Method test getResourceName: successful");
    }

    @Test
    public void sum() {
        urlInput.sum(line, finalSum);
        assertEquals(20, finalSum.getFinalSum());
        log.info("Method test sum: successful");
    }

}