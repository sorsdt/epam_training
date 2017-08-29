package ua.epam.training.task5.exercise1_4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void compareResults() throws Exception {
        int ints[] = Main.generateArray();
        int sum = 0;
        for (int element : ints) {
            sum += element;
        }
        assertEquals(sum, Main.getArraySum(ints));
    }
}