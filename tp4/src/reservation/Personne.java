package reservation;

import aeroport.Vol            ;
import java.time.ZonedDateTime ;

public interface Personne {
    public String nom = null;
    Reservation effectue(String numero , ZonedDateTime date, String nom, Vol vol);
    String getNom();
}
