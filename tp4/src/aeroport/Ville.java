package aeroport;

import java.util.ArrayList ;
import java.util.List      ;

public class Ville {
    private String nom ;
    private List<Aeroport> aeroports = new ArrayList<>();

    // Methode de ajouter des aeroport a la meme ligne
    public void add_aeroport(Aeroport aeroport){
        aeroports.add(aeroport);
    }
    // Constructeur
    public Ville(String nom){
        this.nom = nom ;
    }
    // getter pour recuperer le nom de la ville
    public String getNomVille(){
        return nom;
    }
}
