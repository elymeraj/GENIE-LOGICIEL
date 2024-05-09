package test;

import        aeroport.Aeroport                    ;
import        aeroport.Ville                       ;
import        org.junit.jupiter.api.BeforeAll      ;
import        org.junit.jupiter.api.Test           ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*              ;

public class AeroportTest {
    private static Ville    paris   ;
    private static Ville    london  ;
    private static Aeroport parisCdG;

    @BeforeAll
    public static void setUp() {
        paris    = new Ville("Paris")  ;
        london   = new Ville("Londres");
        parisCdG = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
    }

    @Test
    public void testGetNom() {
        assertThat(parisCdG.get_nom(), is("Paris Charles de Gaulle"));
    }

    @Test
    public void testGetCode() {
        assertThat(parisCdG.get_code(), is("CDG"));
    }

    @Test
    public void testGetVille() {
        assertThat(parisCdG.getVille(), is(paris));
    }

    @Test
    public void testSetVille() {
        parisCdG.setVille(london);
        assertThat(parisCdG.getVille(), is(london));
        assertThat(parisCdG.getVille(), not(paris));
    }

    @Test
    public void testToString() {
        parisCdG.setVille(london);
        String expected = "Aeroport{nom='Paris Charles de Gaulle', code='CDG', ville=Londres}";
        assertThat(parisCdG.toString(), is(expected));
    }
}
