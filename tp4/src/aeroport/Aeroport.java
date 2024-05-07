package aeroport;

public class Aeroport {
    private String nom ;
    private String code ;
    private Ville ville ;

    // Constructeur
    public Aeroport(String nom ,String code,Ville ville){
        this.nom   = nom  ;
        this.code  = code ;
        this.ville = ville;
    }

    //getters des attributs
    public String get_nom (){
        return nom ;
    }
    public String get_code (){
        return code ;
    }
    public Ville getVille(){
        return ville ;
    }


}
