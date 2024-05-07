package aeroport;

import java.time.ZonedDateTime ;
import java.util.ArrayList     ;
import java.util.List          ;

public class Compagnie {
    private String nom ;
  
    private List<Vol> vols = new ArrayList<>();
        
    public Compagnie(String nom){
        this.nom = nom ;
    }
   
    public List<Vol> getVolListe() {
        return vols ;
    }

    public void propose(NumVol num,ZonedDateTime dep, ZonedDateTime ar,Aeroport aeroA , Aeroport aeroD){
        if (aeroA.get_code().equals(aeroD.get_code()))
            throw new IllegalArgumentException("Les aéroports de départ et d'arrivée doivent être différents pour chaque vol!");
        else if(ar.compareTo(dep) <= 0){
            throw new IllegalArgumentException("La date de départ doit être antérieure à la date d'arrivée !!! ")              ;
        }
        else{
            Vol vol = new Vol(num,dep,ar,aeroA,aeroD);
            vols.add(vol)                            ;
        }
    }

    public void info(){
        System.out.println("********** Compagnie: "+nom+" ***********");
        System.out.println("Liste des vols : ")                      ;
        for(Vol x:vols){
            x.info();
        }
    }

}
