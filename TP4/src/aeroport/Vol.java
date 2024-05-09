package aeroport;

import java.time.Duration      ;
import java.time.ZonedDateTime ;
import java.util.LinkedHashSet ;

public class Vol implements Etape {

    private final NumVol        numerovol   ;
    private final ZonedDateTime dateDepart  ;
    private final ZonedDateTime dateArrivee ;
    private final Duration      duree       ;
    private final Aeroport      aeroDep     ;
    private final Aeroport      aeroArr     ;
    private       Compagnie     compagnie   ;
    private boolean             status      ;
    
    private LinkedHashSet<Escale> escales = new LinkedHashSet<>();

    public Vol(NumVol numerovol, ZonedDateTime dateDepart, ZonedDateTime dateArrivee, Aeroport aeroDep, Aeroport aeroArr){
        this.numerovol   = numerovol                           ;
        this.dateDepart  = dateDepart                          ;
        this.dateArrivee = dateArrivee                         ;
        this.aeroDep     = aeroDep                             ;
        this.aeroArr     = aeroArr                             ;
        this.duree       = calc_duree(dateDepart, dateArrivee) ;
    }

    private Duration calc_duree(ZonedDateTime d1, ZonedDateTime d2){
        return Duration.between(d1, d2);
    }

    public void setCompagnie(Compagnie compagnie) {
        if (this.compagnie != compagnie) {
            this.compagnie = compagnie;
            if (compagnie != null && !compagnie.getVolListe().contains(this)) {
                compagnie.ajouterVol(this); 
            }
        }
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public String getNumVol(){
        return numerovol.getNumVol();
    }
    
    @Override
    public Duration getDuree(){
        return duree;
    }

    public ZonedDateTime getDateDepart() {
        return dateDepart;
    }

    public ZonedDateTime getDateArrivee() {
        return dateArrivee;
    }

    public void ouvrir(){
        this.status = true ;
    }

    public void fermer(){
        if(this.status == false){
            throw new IllegalArgumentException("Le vol n'est pas encore ouvert !");
        }
        else{
            this.status = false;
        }
    }

    public void add_Escale(Escale escale) {
        if (escale.getDepartDe().isBefore(escale.getArriveeA())) {
            throw new IllegalArgumentException("La date de départ de l'escale doit être après la date d'arrivée à l'escale");
        }
        Duration dureeEscale = Duration.between(escale.getArriveeA(), escale.getDepartDe());
        if (dureeEscale.compareTo(Duration.ofHours(24)) > 0) {
            throw new IllegalArgumentException("La durée de l'escale ne doit pas excéder 24 heures !");
        }
        this.escales.add(escale);
    }

    @Override
    public void info(){
        String destination = aeroArr.getVille().getNomVille();  
        System.out.println("\n------------------Vol :" + numerovol.getNumVol() + " - à destination de " + destination + " ------------------\n");
        System.out.println("- Date de départ :"+ dateDepart)                                                                                ;
        System.out.println("- Date d'arrivée :"+ dateArrivee)                                                                               ;
        System.out.println("- Durée :"+ duree)                                                                                              ;
        
        for(Escale x : escales)
            x.info();
        if(status)
            System.out.println("- Status du vol : Ouvert !");
        else
            System.out.println("- Status du vol : Fermé !") ;
    }

    public boolean isStatus() {
        return status;
    }

    public LinkedHashSet<Escale> getEscales() {
        return escales;
    }

    @Override
    public String toString() {
        return String.format(
                "Vol avec le numéro [%s]: \n%s -> %s, Départ: %s, Arrivée: %s, Compagnie: %s, Durée: %s",
                numerovol.getNumVol(),
                aeroDep.get_nom(),
                aeroArr.get_nom(),
                dateDepart,
                dateArrivee,
                (compagnie != null ? compagnie.toString() : "Non assignée"),
                duree
        );
    }
}
