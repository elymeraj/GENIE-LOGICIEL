package reservation;

import aeroport.Vol            ;
import java.time.ZonedDateTime ;
import java.util.ArrayList;
import java.util.List;

public class Passager implements Personne {
    private String nom ;
    private List<Reservation> passagerReservations = new ArrayList<>();

    public Passager(String nom){
        this.nom = nom;
    }
    public List<Reservation> getPassagerReservations() {
        return passagerReservations;
    }

    @Override
    public Reservation effectue(String numero, ZonedDateTime date, String nom, Vol vol) {
        Reservation resr = new Reservation(numero, date, nom, vol, null);
        resr.setPassenger(this); // Utilisation du setter pour la double navigabilité
        passagerReservations.add(resr);
        return resr;
    }

    public void removeReservation(Reservation reservation) {
        passagerReservations.remove(reservation);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "Nom='" + nom + '\'' +
                '}';
    }
}
