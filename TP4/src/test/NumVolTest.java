package test;

import aeroport.NumVol                 ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test      ;

import static org.junit.jupiter.api.Assertions.*;

public class NumVolTest {
    private NumVol numVol;

    @BeforeEach
    public void setUp() {
        numVol = new NumVol("24XC12");
    }

    @Test
    public void testNumVolValid() {
        assertEquals("24XC12", numVol.getNumVol());
    }

    @Test
    public void testNumVolInvalidFormatTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              new NumVol("24XC1"));
        assertEquals("Le numéro de vol ne respecte pas le format requis !", exception.getMessage());
    }

    @Test
    public void testNumVolInvalidFormatTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              new NumVol("24XC123"));
        assertEquals("Le numéro de vol ne respecte pas le format requis !", exception.getMessage());
    }

    @Test
    public void testNumVolInvalidCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              new NumVol("24X_12"));
        assertEquals("Le numéro de vol ne respecte pas le format requis !", exception.getMessage());
    }

    @Test
    public void testNumVolInvalidStructure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              new NumVol("2A4X12"));
        assertEquals("Le numéro de vol ne respecte pas le format requis !", exception.getMessage());
    }

    @Test
    public void testEqualsAndHashCode() {
        NumVol sameNumVol      = new NumVol("24XC12");
        NumVol differentNumVol = new NumVol("32XC13");

        assertEquals(numVol, sameNumVol);
        assertNotEquals(numVol, differentNumVol);

        assertEquals(numVol.hashCode(), sameNumVol.hashCode());
        assertNotEquals(numVol.hashCode(), differentNumVol.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("NumVol{numero='24XC12'}", numVol.toString());
    }
}
