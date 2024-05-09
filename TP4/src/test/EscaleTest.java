package test;

import        aeroport.Aeroport                 ;
import        aeroport.Escale                   ;
import        aeroport.Ville                    ;
import        org.junit.jupiter.api.BeforeEach  ;
import        org.junit.jupiter.api.Test        ;
import static org.junit.jupiter.api.Assertions.*;
import        java.time.Duration                ;
import        java.time.ZonedDateTime           ;



class EscaleTest {
    private Aeroport      tiranaInternational;
    private Aeroport      jfk    ;
    private ZonedDateTime arrivee;
    private ZonedDateTime depart ;
    private Escale        escale ;

    @BeforeEach
    void setUp() {
        Ville tirana  = new Ville("Tirana")  ;
        Ville newYork = new Ville("New York");

        tiranaInternational  = new Aeroport("Tirana International Airport", "TIA", tirana);
        jfk = new Aeroport("John F. Kennedy International Airport", "JFK", newYork);

        arrivee = ZonedDateTime.parse("2024-05-10T12:00:00Z");
        depart  = ZonedDateTime.parse("2024-05-10T14:00:00Z");

        escale = new Escale(tiranaInternational, arrivee, depart);
    }

    @Test
    void testEscaleCreationSuccess() {
        assertNotNull(escale);
        assertEquals(tiranaInternational, escale.getAeroport());
        assertEquals(arrivee, escale.getArriveeA());
        assertEquals(depart, escale.getDepartDe());
        assertEquals(Duration.ofHours(2), escale.getDuree());
    }

    @Test
    void testInvalidDepartureBeforeArrival() {
        ZonedDateTime invalidDepart = ZonedDateTime.parse("2024-05-10T10:00:00Z");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Escale(tiranaInternational, arrivee, invalidDepart));
        assertEquals("La date de départ de l'escale doit être après la date d'arrivée à l'escale", exception.getMessage());
    }

    @Test
    void testEscaleExceeds24Hours() {
        ZonedDateTime arriveeLong = ZonedDateTime.parse("2024-05-10T12:00:00Z");
        ZonedDateTime departLong = ZonedDateTime.parse("2024-05-11T14:00:00Z");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Escale(tiranaInternational, arriveeLong, departLong));
        assertEquals("La durée de l'escale ne doit pas excéder 24 heures !", exception.getMessage());
    }

    @Test
    void testInfoOutput() {
        String expectedInfo =
                "\n***************** Détails d'escale: *****************\n" +
                "  - Escale à          : TIA\n" +
                "  - Durée  d'escale   : PT2H\n" +
                "  - Aéroport d'escale : Tirana International Airport\n" +
                "  - Debut d'escale    : 2024-05-10T12:00:00+0000\n" +
                "  - Fin d'escale      : 2024-05-10T14:00:00+0000\n" +
                "*****************************************************\n";
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));

        escale.info();

        System.setOut(originalOut);

        assertEquals(expectedInfo.trim(), outContent.toString().trim());
    }
}
