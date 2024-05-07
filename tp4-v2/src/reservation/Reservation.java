package reservation;

import aeroport.Vol;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Reservation {
    private final String        reservationNumber ;
    private final ZonedDateTime reservationDate   ;
    private       boolean       confirmationStatus;
    private       Passager      passenger         ;
    private       Vol           flight            ;
    private       Client        client            ;

    private static final Pattern RESERVATION_NUMBER_PATTERN = Pattern.compile("^[A-Z]{3}\\d{2}[A-Z]{1}$");
    private static final Set<String> reservationNumbers = new HashSet<>();

    public Reservation(String reservationNumber, ZonedDateTime reservationDate, String passengerName, Vol flight, Client client) {
        if (!RESERVATION_NUMBER_PATTERN.matcher(reservationNumber).matches()) {
            throw new IllegalArgumentException("Format du numéro de réservation invalide !");
        }
        if (reservationDate.isAfter(flight.getDateDepart())) {
            throw new IllegalArgumentException("La date de réservation ne peut pas être postérieure à la date de départ du vol !");
        }
        synchronized (reservationNumbers) {
            if (!reservationNumbers.add(reservationNumber)) {
                throw new IllegalArgumentException("Le numéro de réservation est déjà utilisé !");
            }
        }
        this.reservationNumber  = reservationNumber;
        this.reservationDate    = reservationDate;
        this.confirmationStatus = true;
        this.passenger          = new Passager(passengerName);
        this.flight             = flight;
        setClient(client);

    }

    public void confirm() {
        this.confirmationStatus = true;
    }

    public void cancel() {
        this.confirmationStatus = false;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public ZonedDateTime getReservationDate() {
        return reservationDate;
    }

    public Passager getPassenger() {
        return passenger;
    }

    public void setPassenger(Passager passenger) {
        if (this.passenger != passenger) {
            if (this.passenger != null) {
                this.passenger.removeReservation(this);
            }
            this.passenger = passenger;
            if (passenger != null && !passenger.getPassagerReservations().contains(this)) {
                passenger.getPassagerReservations().add(this);
            }
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (this.client != client) {
            if (this.client != null) {
                this.client.removeReservation(this);
            }
            this.client = client;
            if (client != null && !client.getClientReservations().contains(this)) {
                client.getClientReservations().add(this);
            }
        }
    }

    public boolean isConfirmed() {
        return confirmationStatus;
    }

    public void displayReservationDetails() {
        System.out.println("\nDétails de la réservation:");
        System.out.println("Numéro de réservation: " + reservationNumber);
        System.out.println("Date de réservation: " + reservationDate);
        System.out.println("Passager: " + passenger.getNom());
        System.out.println("Statut de confirmation: " + (confirmationStatus ? "Confirmé" : "Annulé"));
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "Numéro='" + reservationNumber + '\'' +
                ", Date de réservation=" + reservationDate +
                ", Confirmation=" + (confirmationStatus ? "Confirmé" : "Annulé") +
                ", Passager=" + passenger.getNom() +
                ", Vol=" + flight.toString() +
                ", Client=" + (client != null ? client.toString() : "Non assigné") +
                '}';
    }
}
