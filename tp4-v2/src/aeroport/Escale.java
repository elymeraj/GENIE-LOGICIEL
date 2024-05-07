package aeroport;

import java.time.Duration     ;
import java.time.ZonedDateTime;

public class Escale implements Etape{
    private ZonedDateTime arriveeA ;
    private ZonedDateTime departDe ;
    private Aeroport      aero_esc ;
    private Duration      duree    ;

    // Constructeur d'escale
    public Escale(Aeroport aero_esc, ZonedDateTime arriveeA ,ZonedDateTime departDe){
        this.departDe = departDe                     ;
        this.arriveeA = arriveeA                     ;
        this.duree    = calc_duree(departDe,arriveeA);
        this.aero_esc = aero_esc                     ;
    }
    // Calculer la durée de l'escale
    private Duration calc_duree(ZonedDateTime d1, ZonedDateTime d2){
        return Duration.between(d1, d2);
    }
    @Override
    public Duration getDuree(){
        return this.duree;
    }

    public ZonedDateTime getArriveeA(){
        return arriveeA;
    }
    public ZonedDateTime getDepartDe(){
        return departDe;
    }
    // Afficher les informations de l'escale
    @Override
    public void info(){
        System.out.println("  - Escale à: "+aero_esc.get_code()+" Durée : "+duree+" -----")          ;
        System.out.println("  - Aéroport d'escale : "+aero_esc.get_nom())                            ;
        System.out.println("  - Debut d'escale    : "+arriveeA+"\n  - Fin d'escale      : "+departDe);
    }

}