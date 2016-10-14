package ru.innopolis.nur.homework;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by nur on 13/10/16.
 */
public class FinalSumTest {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    private FinalSum finalSum = new FinalSum(10,5);


    @Test
    public void FinalSum() {
        assertEquals(10, finalSum.getFinalSum());
        assertEquals(5, finalSum.getActiveThreads());
        log.info("Method test getFinalSum: successful");
    }

    @Test
    public void getFinalSum() {
        assertEquals(10, finalSum.getFinalSum());
        log.info("Method test getFinalSum: successful");
    }

    @Test
    public void setFinalSum() {
        finalSum.setFinalSum(20);
        assertEquals(20, finalSum.getFinalSum());
        log.info("Method test setFinalSum: successful");
    }

    @Test
    public void getActiveThreads() {
        assertEquals(5, finalSum.getActiveThreads());
        log.info("Method test getActiveThreads: successful");
    }

    @Test
    public void setActiveThreads() {
        finalSum.setActiveThreads(10);
        assertEquals(10, finalSum.getActiveThreads());
        log.info("Method test setActiveThreads: successful");

    }

}