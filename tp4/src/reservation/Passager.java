package reservation;

import aeroport.Vol            ;
import java.time.ZonedDateTime ;

public class Passager implements Personne {
    private String nom ;

    // Constructeur
    public Passager(String nom){
        this.nom = nom;
    }

    @Override
    public Reservation effectue(String numero , ZonedDateTime date, String nom, Vol vol) {
        Reservation resr = new Reservation(numero,date,nom,vol);
        return resr;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
