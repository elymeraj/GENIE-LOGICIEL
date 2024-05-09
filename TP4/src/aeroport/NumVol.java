package aeroport;

import java.util.Objects      ;
import java.util.regex.Pattern;

public class NumVol {
    private        final String  numero ;
    private static final Pattern VALIDATION_RE = Pattern.compile("^\\d{2}[A-Z]{2}\\d{2}$");

    public static String set_numvol(String numero){
        if(!numero.matches(VALIDATION_RE.pattern())){
            throw new IllegalArgumentException("Le numéro de vol ne respecte pas le format requis !");
        }
        else {
            return numero;
        }
    }

    public NumVol(String numero){
        this.numero = set_numvol(numero);
    }

    public String getNumVol(){
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NumVol numVol = (NumVol) obj;
        return Objects.equals(numero, numVol.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "NumVol{numero='" + numero + "'}";
    }
}
