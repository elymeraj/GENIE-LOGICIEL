package aeroport;

import java.time.Duration                ;
import java.time.ZonedDateTime           ;
import java.time.format.DateTimeFormatter;

public class Escale implements Etape {
    private final ZonedDateTime arriveeA;
    private final ZonedDateTime departDe;
    private final Aeroport      aero_esc;
    private final Duration      duree   ;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

    public Escale(Aeroport aero_esc, ZonedDateTime arriveeA, ZonedDateTime departDe) {

        if (departDe.isBefore(arriveeA)) {
            throw new IllegalArgumentException("La date de départ de l'escale doit être après la date d'arrivée à l'escale");
        }

        this.arriveeA = arriveeA;
        this.departDe = departDe;
        this.duree    = calc_duree(arriveeA, departDe);

        if (duree.compareTo(Duration.ofHours(24)) > 0) {
            throw new IllegalArgumentException("La durée de l'escale ne doit pas excéder 24 heures !");
        }

        this.aero_esc = aero_esc;
    }

    private Duration calc_duree(ZonedDateTime d1, ZonedDateTime d2) {
        return Duration.between(d1, d2);
    }

    public ZonedDateTime getArriveeA() {
        return arriveeA;
    }

    public ZonedDateTime getDepartDe() {
        return departDe;
    }

    public Aeroport getAeroport() {
        return aero_esc;
    }

    @Override
    public Duration getDuree() {
        return this.duree;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format(
                "\n***************** Détails d'escale: *****************\n" +
                "  - Escale à          : %s\n" +
                "  - Durée  d'escale   : %s\n" +
                "  - Aéroport d'escale : %s\n" +
                "  - Debut d'escale    : %s\n" +
                "  - Fin d'escale      : %s\n" +
                "*****************************************************\n",
                aero_esc.get_code(),
                duree,
                aero_esc.get_nom(),
                arriveeA.format(formatter),
                departDe.format(formatter));
    }
}
