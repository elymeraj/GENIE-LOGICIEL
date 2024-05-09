package aeroport;

public class Aeroport {
    private final String nom ;
    private final String code;
    private       Ville ville;

    public Aeroport(String nom ,String code,Ville ville){
        this.nom   = nom  ;
        this.code  = code ;
        this.ville = ville;
        setVille(ville);
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'aéroport ne doit pas être vide.");
        }
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Le code de l'aéroport ne doit pas être vide.");
        }
        if (ville == null) {
            throw new IllegalArgumentException("La ville de l'aéroport ne doit pas être nulle.");
        }
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
