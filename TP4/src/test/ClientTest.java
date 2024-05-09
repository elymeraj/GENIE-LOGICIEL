package test;

import aeroport.Aeroport               ;
import aeroport.Compagnie              ;
import aeroport.NumVol                 ;
import aeroport.Ville                  ;
import aeroport.Vol                    ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test      ;
import reservation.Client              ;
import reservation.Reservation         ;

import java.time.ZoneId       ;
import java.time.ZonedDateTime;
import java.util.List         ;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*              ;
import static org.junit.jupiter.api.Assertions.*   ;

public class ClientTest {
    private Client        client         ;
    private Compagnie     compagnie      ;
    private Aeroport      parisAirport   ;
    private Aeroport      londonAirport  ;
    private Vol           vol            ;
    private ZonedDateTime reservationDate;

    @BeforeEach
    public void setUp() {
        client = new Client("Rita Ora", "cl001", "Credit Card", "0745125409");

        Ville paris   = new Ville("Paris");
        Ville london  = new Ville("London");
        parisAirport  = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
        londonAirport = new Aeroport("London Heathrow", "LHR", london);

        compagnie     = new Compagnie("Air France");
        NumVol numVol = new NumVol("10AF02");
        reservationDate = ZonedDateTime.of(2024, 6, 1, 10, 0, 0, 0, ZoneId.of("GMT+2"));
        ZonedDateTime departureDate = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, ZoneId.of("GMT+2"));
        ZonedDateTime arrivalDate = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, ZoneId.of("GMT+2"));

        vol = new Vol(numVol, departureDate, arrivalDate, parisAirport, londonAirport);
        compagnie.ajouterVol(vol);
    }

    @Test
    public void testClientReservation() {
        Reservation reservation = client.effectue("ABC12D", reservationDate, "Rita Ora", vol);

        assertNotNull(reservation);
        assertThat(reservation.getReservationNumber(), equalTo("ABC12D"));
        assertThat(reservation.getReservationDate(), equalTo(reservationDate));
        assertThat(reservation.getPassenger().getNom(), equalTo("Rita Ora"));
        assertThat(reservation.getClient(), equalTo(client));
        assertThat(reservation.getFlight(), equalTo(vol));
    }

    @Test
    public void testRemoveReservation() {
        Reservation reservation = client.effectue("DEF34G", reservationDate, "Rita Ora", vol);

        List<Reservation> reservationsAvantSuppression = client.getClientReservations();
        assertThat(reservationsAvantSuppression, hasItem(reservation));

        client.removeReservation(reservation);

        List<Reservation> reservationsApresSuppression = client.getClientReservations();
        assertThat(reservationsApresSuppression, not(hasItem(reservation)));
    }

    @Test
    public void testGetters() {
        assertThat(client.getNom(), equalTo("Rita Ora"));
        assertThat(client.getClientReference(), equalTo("cl001"));
        assertThat(client.getPaymentMethod(), equalTo("Credit Card"));
        assertThat(client.getContactDetails(), equalTo("0745125409"));
    }

    @Test
    public void testToString() {
        String expectedString = "Client{Nom='Rita Ora', Référence='cl001', Méthode de paiement='Credit Card', Détails du contact='0745125409'}";
        assertThat(client.toString(), equalTo(expectedString));
    }

    @Test
    public void testInvalidReservationNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                  client.effectue("INVALID", reservationDate, "Rita Ora", vol));
        assertThat(exception.getMessage(), containsString("Format du numéro de réservation invalide"));
    }

    @Test
    public void testReservationDateAfterFlightDeparture() {
        ZonedDateTime invalidReservationDate = ZonedDateTime.of(2024, 6, 2, 10, 0, 0, 0, ZoneId.of("GMT+2"));

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                  client.effectue("GHI56J", invalidReservationDate, "Rita Ora", vol));
        assertThat(exception.getMessage(), containsString("La date de réservation ne peut pas être postérieure à la date de départ du vol"));
    }
}
