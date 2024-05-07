package aeroport;

//import javax.xml.validation.Validator ;
import java.util.regex.Pattern        ;

public class NumVol {
    private String numero ;
    
    private static final Pattern VALIDATION_RE = Pattern.compile("^\\d{2}[A-Z]{2}\\d{2}$");

    public NumVol() {
    }

    public static String set_numvol(String numero){
        if(!numero.matches(VALIDATION_RE.pattern())){
            throw new IllegalArgumentException("Le numéro de vol ne respecte pas le format requis !");
        }
        else {
            return numero;
        }
    }
    //
    public NumVol(String numero){
        this.numero = set_numvol(numero);
    }
    public String getNumVol(){
        return numero;
    }
}
