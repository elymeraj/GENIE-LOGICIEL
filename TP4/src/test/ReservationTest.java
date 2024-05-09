package test;

import aeroport.Aeroport              ;
import aeroport.NumVol                ;
import aeroport.Ville                 ;
import aeroport.Vol                   ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test     ;
import reservation.Client             ;
import reservation.Reservation        ;

import java.time.ZoneId       ;
import java.time.ZonedDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo        ;
import static org.junit.jupiter.api.Assertions.*   ;

public class ReservationTest {
    private static final ZoneId        zoneId         = ZoneId.of("Europe/Paris");
    private static final Ville         paris          = new Ville("Paris");
    private static final Ville         london         = new Ville("Londres");
    private static final Aeroport      parisCdG       = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
    private static final Aeroport      londonHeathrow = new Aeroport("London Heathrow", "LHR", london);
    private static final ZonedDateTime departure      = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
    private static final ZonedDateTime arrival        = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, zoneId);
    private static final NumVol        volNum         = new NumVol("12FR34");
    private static final Vol           vol            = new Vol(volNum, departure, arrival, parisCdG, londonHeathrow);
    private static final Client        client         = new Client("Eldis Ymeraj", "cl0001", "CB", "0765448596");

    @BeforeAll
    public static void resetReservationNumbers() {
        Reservation.clearReservationNumbers();
    }

    @Test
    public void testReservationValide() {
        ZonedDateTime reservationDate = ZonedDateTime.of(2024, 5, 31, 10, 0, 0, 0, zoneId);
        Reservation reservation = new Reservation("ABC12D", reservationDate, "Rita Ora", vol, client);

        assertThat(reservation.getReservationNumber(), equalTo("ABC12D"));
        assertThat(reservation.getReservationDate(), equalTo(reservationDate));
        assertThat(reservation.getPassenger().getNom(), equalTo("Rita Ora"));
        assertThat(reservation.getClient(), equalTo(client));
        assertTrue(reservation.isConfirmed());
    }

    @Test
    public void testReservationInvalide() {
        ZonedDateTime invalidReservationDate = ZonedDateTime.of(2024, 6, 2, 10, 0, 0, 0, zoneId);
        try {
            new Reservation("ABC12D", invalidReservationDate, "Rita Ora", vol, client);
            fail("Exception attendue mais non levée!");
        } catch (IllegalArgumentException e) {
            assertEquals("La date de réservation ne peut pas être postérieure à la date de départ du vol !", e.getMessage());
        }
    }

    @Test
    public void testReservationNumberInvalidFormat() {
        ZonedDateTime reservationDate = ZonedDateTime.of(2024, 5, 31, 10, 0, 0, 0, zoneId);
        try {
            new Reservation("INVALID", reservationDate, "Rita Ora", vol, client);
            fail("Exception attendue mais non levée!");
        } catch (IllegalArgumentException e) {
            assertEquals("Format du numéro de réservation invalide !", e.getMessage());
        }
    }
}
