package aeroport;

import java.time.Duration      ;
import java.time.ZonedDateTime ;

// cette interface declare quelques methodes pour les classes Escale et Vol
public interface Etape {
    Duration getDuree() ;
    void     info()     ;
}
