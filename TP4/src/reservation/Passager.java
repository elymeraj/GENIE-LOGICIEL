package reservation;

import aeroport.Vol           ;
import java.time.ZonedDateTime;
import java.util.ArrayList    ;
import java.util.List         ;

public class Passager implements Personne {
    private final String            nom ;
    private final List<Reservation> passagerReservations = new ArrayList<>();

    public Passager(String nom){
        this.nom = nom;
    }

    public List<Reservation> getPassagerReservations() {
        return passagerReservations;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public Reservation effectue(String numero, ZonedDateTime date, String nom, Vol vol) {
        Reservation reservation = new Reservation(numero, date, nom, vol, null);
        reservation.setPassenger(this);
        passagerReservations.add(reservation);
        return reservation;
    }

    public void removeReservation(Reservation reservation) {
        passagerReservations.remove(reservation);
        if (reservation.getClient() != null) {
            reservation.getClient().removeReservation(reservation);
        }
        reservation.setPassenger(null);
        reservation.setClient(null);
    }

    @Override
    public String toString() {
        return "Passager{" +
                "Nom='" + nom + '\'' +
                '}';
    }
}
