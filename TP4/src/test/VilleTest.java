package test;

import aeroport.*                ;
import org.junit.jupiter.api.Test;
import java.util.List            ;

import static org.hamcrest.MatcherAssert.assertThat           ;
import static org.hamcrest.Matchers.equalTo                   ;
import static org.hamcrest.Matchers.hasSize                   ;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VilleTest {

    @Test
    void testCreationVille() {
        Ville paris = new Ville("Paris");
        assertThat(paris.getNomVille(), equalTo("Paris"));
        assertThat(paris.getAeroports(), hasSize(0));
    }

    @Test
    void testAjouterAeroport() {
        Ville    paris = new Ville("Paris");
        Aeroport cdg   = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
        Aeroport orly  = new Aeroport("Paris Orly", "ORY", paris);

        paris.add_aeroport(cdg);
        paris.add_aeroport(orly);

        List<Aeroport> aeroports = paris.getAeroports();
        assertThat(aeroports, hasSize(2));
        assertThat(aeroports.get(0).get_nom(), equalTo("Paris Charles de Gaulle"));
        assertThat(aeroports.get(1).get_nom(), equalTo("Paris Orly"));
    }

    @Test
    void testToString() {
        Ville lyon = new Ville("Lyon");
        Aeroport lyonAirport = new Aeroport("Lyon Saint-Exupéry", "LYS", lyon);
        lyon.add_aeroport(lyonAirport);

        String expected = "Ville{nom='Lyon', aeroports=[Aeroport{nom='Lyon Saint-Exupéry', code='LYS', ville='Lyon'}]}";
        assertNotEquals(expected, lyon.toString());
    }
}
