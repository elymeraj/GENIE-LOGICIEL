package test;

import aeroport.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test      ;

import java.time.Duration     ;
import java.time.ZonedDateTime;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class VolTest {

    private Aeroport      aeroportDepart ;
    private Aeroport      aeroportArrivee;
    private Compagnie     compagnie      ;
    private NumVol        numVol         ;
    private Vol           vol            ;
    private ZonedDateTime dateDepart     ;
    private ZonedDateTime dateArrivee    ;

    @BeforeEach
    void setUp() {
        Ville villeParis = new Ville("Paris");
        Ville villeNewYork = new Ville("New York");

        aeroportDepart = new Aeroport("Charles de Gaulle", "CDG", villeParis);
        aeroportArrivee = new Aeroport("JFK", "JFK", villeNewYork);

        compagnie = new Compagnie("Air France");
        numVol = new NumVol("24XC12");

        dateDepart = ZonedDateTime.parse("2024-05-10T10:00:00Z");
        dateArrivee = ZonedDateTime.parse("2024-05-10T16:00:00Z");

        vol = new Vol(numVol, dateDepart, dateArrivee, aeroportDepart, aeroportArrivee);
        vol.setCompagnie(compagnie);
    }

    @Test
    void testGetNumVol() {
        assertEquals("24XC12", vol.getNumVol());
    }

    @Test
    void testGetDuree() {
        Duration expectedDuration = Duration.ofHours(6);
        assertEquals(expectedDuration, vol.getDuree());
    }

    @Test
    void testGetDateDepart() {
        assertEquals(dateDepart, vol.getDateDepart());
    }

    @Test
    void testGetDateArrivee() {
        assertEquals(dateArrivee, vol.getDateArrivee());
    }

    @Test
    void testSetCompagnie() {
        assertEquals(compagnie, vol.getCompagnie());
    }

    @Test
    void testOuvrirEtFermerVol() {
        vol.ouvrir();
        assertTrue(vol.isStatus());

        vol.fermer();
        assertFalse(vol.isStatus());
    }

    @Test
    void testFermerVolNotOpen() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, vol::fermer);
        assertEquals("Le vol n'est pas encore ouvert !", exception.getMessage());
    }

    @Test
    void testAddEscale() {
        Escale escale = new Escale(aeroportArrivee, ZonedDateTime.parse("2024-05-10T12:00:00Z"),
                                                    ZonedDateTime.parse("2024-05-10T13:00:00Z"));
        vol.add_Escale(escale);
        LinkedHashSet<Escale> escales = vol.getEscales();
        assertTrue(escales.contains(escale));
    }

    @Test
    void testAddEscaleInvalidDepartureDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Escale(aeroportArrivee, ZonedDateTime.parse("2024-05-10T14:00:00Z"),
                                            ZonedDateTime.parse("2024-05-10T10:00:00Z")));
        assertEquals("La date de départ de l'escale doit être après la date d'arrivée à l'escale", exception.getMessage());
    }

    @Test
    void testToString() {
        String expected = String.format(
                "Vol avec le numéro [%s]: \n%s -> %s, Départ: %s, Arrivée: %s, Compagnie: %s, Durée: %s",
                "24XC12", "Charles de Gaulle", "JFK", dateDepart, dateArrivee, "Compagnie{nom='Air France'}",
                Duration.ofHours(6));
        assertEquals(expected, vol.toString());
    }
}
