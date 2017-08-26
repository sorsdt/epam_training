package ua.epam.training.task6.exercise1_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();
    private final static double DELTA = 0.01;

    @Test
    public void convertCtoF() throws Exception {
        assertEquals(32.0, converter.convertCtoF(0.0), DELTA);
        assertEquals(0, converter.convertCtoF(-17.78), DELTA);
    }

    @Test
    public void convertCtoK() throws Exception {
        assertEquals(273.2, converter.convertCtoK(0.0), DELTA);
        assertEquals(0, converter.convertCtoK(-273.2), DELTA);
    }

    @Test
    public void convertKtoC() throws Exception {
        assertEquals(-273.2, converter.convertKtoC(0.0), DELTA);
    }

    @Test
    public void convertKtoF() throws Exception {
        assertEquals(-459.7, converter.convertKtoF(0.0), DELTA);
    }

    @Test
    public void convertFtoC() throws Exception {
        assertEquals(-17.78, converter.convertFtoC(0.0), DELTA);
    }

    @Test
    public void convertFtoK() throws Exception {
        assertEquals(255.39, converter.convertFtoK(0.0), DELTA);
    }

    @Test
    public void convertKtoCEx() throws Exception {
        boolean thrown = false;
        try {
            converter.convertKtoC(-1.0);
        } catch (IllegalArgumentException E) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertKtoFEx() throws Exception {
        converter.convertKtoF(-1.0);
    }
}