package ru.innopolis.nur.homework;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by nur on 13/10/16.
 */
public class FIleInputTest {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private FinalSum finalSum = new FinalSum(0, 5);
    private FIleInput fIleInput=new FIleInput("/home/nur/IdeaProjects/JavaOct13", finalSum);
    private String line = "1 201 -4 0 2 333 45331 8 -134 4 6";

    @Test
    public void getFileName() {
        assertEquals("/home/nur/IdeaProjects/JavaOct13", fIleInput.getFileName());
        log.info("Method test getFileName: successful");
    }

    @Test
    public void setFileName() {
        fIleInput.setFileName("/home/nur/IdeaProjects/Gradle");
        assertEquals( "/home/nur/IdeaProjects/Gradle" , fIleInput.getFileName());
        log.info("Method test setFileName: successful");
    }


    @Test
    public void getResourceName() throws Exception {
        assertEquals("/home/nur/IdeaProjects/JavaOct13", fIleInput.getFileName());
        log.info("Method test getFileName: successful");
    }

    @Test
    public void sum() throws Exception {
        fIleInput.sum(line, finalSum);
        assertEquals(20, finalSum.getFinalSum());
        log.info("Method test sum: successful");
    }

}