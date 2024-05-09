package aeroport;

import java.util.ArrayList ;
import java.util.List      ;

public class Ville {
    private final String         nom ;
    private final List<Aeroport> aeroports = new ArrayList<>();

    public void add_aeroport(Aeroport aeroport){
        aeroports.add(aeroport);
    }
    
    public Ville(String nom){
        this.nom = nom ;
    }
    
    public String getNomVille(){
        return nom;
    }

    public List<Aeroport> getAeroports() {
        return aeroports;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "nom='" + nom + '\'' +
                ", aeroports=" + aeroports +
                '}';
    }
}
