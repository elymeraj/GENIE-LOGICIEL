package test;

import aeroport.Aeroport               ;
import aeroport.NumVol                 ;
import aeroport.Ville                  ;
import aeroport.Vol                    ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test      ;
import reservation.Passager            ;
import reservation.Reservation         ;

import java.time.ZoneId       ;
import java.time.ZonedDateTime;
import java.util.List         ;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem        ;
import static org.hamcrest.Matchers.not            ;
import static org.junit.jupiter.api.Assertions.*   ;

public class PassagerTest {
    private Passager      passager       ;
    private Aeroport      parisAirport   ;
    private Aeroport      londonAirport  ;
    private Vol           vol            ;
    private ZonedDateTime reservationDate;

    @BeforeEach
    public void setUp() {
        Reservation.clearReservationNumbers();

        passager      = new Passager("Rita Ora");
        Ville paris   = new Ville("Paris")      ;
        Ville london  = new Ville("London")     ;
        parisAirport  = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
        londonAirport = new Aeroport("London Heathrow", "LHR", london)       ;

        NumVol numVol = new NumVol("12AB34");
        ZoneId zoneId = ZoneId.of("GMT+2")   ;

        reservationDate = ZonedDateTime.of(2024, 5, 30, 10, 0, 0, 0, zoneId);

        ZonedDateTime departureDate = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
        ZonedDateTime arrivalDate = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, zoneId);

        vol = new Vol(numVol, departureDate, arrivalDate, parisAirport, londonAirport);
    }


    @Test
    public void testPassagerReservation() {
        Reservation reservation = passager.effectue("ABC12D", reservationDate, "Rita Ora", vol);

        assertNotNull(reservation);
        assertEquals("ABC12D", reservation.getReservationNumber());
        assertEquals(reservationDate, reservation.getReservationDate());
        assertEquals("Rita Ora", reservation.getPassenger().getNom());
        assertEquals(passager, reservation.getPassenger());
        assertEquals(vol, reservation.getFlight());
    }

    @Test
    public void testRemoveReservation() {
        Reservation reservation = passager.effectue("DEF34G", reservationDate, "Rita Ora", vol);

        List<Reservation> reservationsAvantSuppression = passager.getPassagerReservations();
        assertThat(reservationsAvantSuppression, hasItem(reservation));

        passager.removeReservation(reservation);

        List<Reservation> reservationsApresSuppression = passager.getPassagerReservations();
        assertThat(reservationsApresSuppression, not(hasItem(reservation)));
    }

    @Test
    public void testGetNom() {
        assertEquals("Rita Ora", passager.getNom());
    }

    @Test
    public void testToString() {
        String expectedString = "Passager{Nom='Rita Ora'}";
        assertEquals(expectedString, passager.toString());
    }

    @Test
    public void testInvalidReservationNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              passager.effectue("INVALID", reservationDate, "Rita Ora", vol));
        assertEquals("Format du numéro de réservation invalide !", exception.getMessage());
    }

    @Test
    public void testReservationDateAfterFlightDeparture() {
        ZonedDateTime invalidReservationDate = ZonedDateTime.of(2024, 6, 2, 10, 0, 0, 0, ZoneId.of("GMT+2"));

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                              passager.effectue("GHI56J", invalidReservationDate, "Rita Ora", vol));
        assertEquals("La date de réservation ne peut pas être postérieure à la date de départ du vol !", exception.getMessage());
    }
}

