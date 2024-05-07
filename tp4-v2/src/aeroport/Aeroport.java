package aeroport;

public class Aeroport {
    private String nom ;
    private String code ;
    private Ville ville ;

    public Aeroport(String nom ,String code,Ville ville){
        this.nom   = nom  ;
        this.code  = code ;
        this.ville = ville;
        setVille(ville);
    }

    public String get_nom (){
        return nom ;
    }
    public String get_code (){
        return code ;
    }
    public Ville getVille(){
        return ville ;
    }

    public void setVille(Ville ville) {
        if (this.ville != ville) {
            this.ville = ville;
            this.ville.add_aeroport(this);
        }
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", ville=" + ville.getNomVille() +
                '}';
    }


}
