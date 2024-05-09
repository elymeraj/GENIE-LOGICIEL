package test;

import aeroport.Aeroport               ;
import aeroport.Compagnie              ;
import aeroport.NumVol                 ;
import aeroport.Ville                  ;
import aeroport.Vol                    ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test      ;

import java.time.ZoneId       ;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.equalTo    ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*   ;

public class CompagnieTest {
    private Compagnie easyJet       ;
    private Aeroport  parisCdG      ;
    private Aeroport  londonHeathrow;
    private NumVol    volNum        ;
    private ZoneId    zoneId        ;

    @BeforeEach
    public void setUp() {
        easyJet        = new Compagnie("EasyJet");
        Ville paris    = new Ville("Paris")      ;
        Ville london   = new Ville("Londres")    ;
        parisCdG       = new Aeroport("Paris Charles de Gaulle", "CDG", paris);
        londonHeathrow = new Aeroport("London Heathrow", "LHR", london)       ;
        volNum         = new NumVol("24XC12")    ;
        zoneId         = ZoneId.of("Europe/Paris");
    }

    @Test
    public void testGetNomCompagnie() {
        assertThat(easyJet.toString(), equalTo("Compagnie{nom='EasyJet'}"));
    }

    @Test
    public void testAjouterVol() {
        ZonedDateTime dep = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
        ZonedDateTime ar = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, zoneId);
        Vol vol = new Vol(volNum, dep, ar, parisCdG, londonHeathrow);

        easyJet.ajouterVol(vol);
        assertThat(easyJet.getVolListe().size(), equalTo(1));
        assertThat(easyJet.getVolListe().get(0), equalTo(vol));
    }

    @Test
    public void testProposeVolValide() {
        ZonedDateTime dep = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
        ZonedDateTime ar = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, zoneId);

        easyJet.propose(volNum, dep, ar, parisCdG, londonHeathrow);
        assertThat(easyJet.getVolListe().size(), equalTo(1));
        assertThat(easyJet.getVolListe().get(0).getNumVol(), equalTo("24XC12"));
    }

    @Test
    public void testProposeVolMemeAeroport() {
        ZonedDateTime dep = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
        ZonedDateTime ar = ZonedDateTime.of(2024, 6, 1, 16, 0, 0, 0, zoneId);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                easyJet.propose(volNum, dep, ar, parisCdG, parisCdG));
        assertEquals("Les aéroports de départ et d'arrivée doivent être différents pour chaque vol!", exception.getMessage());
    }

    @Test
    public void testProposeVolMauvaiseDate() {
        ZonedDateTime dep = ZonedDateTime.of(2024, 6, 1, 14, 0, 0, 0, zoneId);
        ZonedDateTime ar = ZonedDateTime.of(2024, 6, 1, 12, 0, 0, 0, zoneId);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                easyJet.propose(volNum, dep, ar, parisCdG, londonHeathrow));
        assertEquals("La date de départ doit être antérieure à la date d'arrivée !!! ", exception.getMessage());
    }
}
