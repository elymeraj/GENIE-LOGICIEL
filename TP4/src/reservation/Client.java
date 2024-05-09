package reservation;

import aeroport.Vol            ;
import java.time.ZonedDateTime ;
import java.util.ArrayList     ;
import java.util.List          ;

public class Client implements Personne {
    private final String            clientName         ;
    private final String            clientReference    ;
    private final String            paymentMethod      ;
    private final String            contactDetails     ;
    private final List<Reservation> clientReservations ;

    public Client(String name, String reference, String payment, String contact) {
        this.clientName         = name              ;
        this.clientReference    = reference         ;
        this.paymentMethod      = payment           ;
        this.contactDetails     = contact           ;
        this.clientReservations = new ArrayList<>() ;
    }

    public Reservation effectue(String reservationNumber, ZonedDateTime reservationDate, String passengerName, Vol flight) {
        Reservation reservation = new Reservation(reservationNumber, reservationDate, passengerName, flight, this);
        reservation.setClient(this); 
        clientReservations.add(reservation);
        return reservation;
    }

    public void removeReservation(Reservation reservation) {
        if (clientReservations.remove(reservation)) {
            if (reservation.getPassenger() != null) {
                reservation.getPassenger().removeReservation(reservation);
            }
            reservation.setClient(null);
        }
    }

    public List<Reservation> getClientReservations() {
        return clientReservations;
    }

    public String getNom() {
        return clientName;
    }

    public String getClientReference() {
        return clientReference;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + clientName + '\'' +
                ", Référence='" + clientReference + '\'' +
                ", Méthode de paiement='" + paymentMethod + '\'' +
                ", Détails du contact='" + contactDetails + '\'' +
                '}';
    }
}