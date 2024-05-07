import aeroport.*;
import reservation.Client;
import reservation.Passager;
import reservation.Reservation;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Compagnie easyJet     = new Compagnie("Easyjet")     ;
        Compagnie airAlbania  = new Compagnie("Air Albania") ;
        Compagnie flyEmirates = new Compagnie("Fly-Emirates");
        Compagnie airFrance   = new Compagnie("Air France")  ;

        NumVol volParisConakry   = new NumVol("24XC12"); // Paris -Conakry
        NumVol volConakryTirana  = new NumVol("32XC13"); // Conakry - Tirana (easyJet)
        NumVol volParisTirana    = new NumVol("10BJ12"); // Paris - Tirana
        NumVol volLosAngConakry  = new NumVol("03DZ11"); // Los Angeles - Conakry
        NumVol volTiranaParis    = new NumVol("11AB91"); // Tirana - Paris
        NumVol volLosAngTirana   = new NumVol("25GN17"); // Los Angeles - Tirana
        NumVol volClermontParis  = new NumVol("12CL09"); // Clermont-ferrand -> Paris
        NumVol volParisAmsterdam = new NumVol("98PA56"); // Paris - Amsterdam
        NumVol volLyonIstanbul   = new NumVol("03IS45"); // Lyon - Istanbul
        NumVol volIstanbulDubai  = new NumVol("43DB09"); // Istanbul - Dubai

        ZoneId zoneId = ZoneId.of("GMT+2");

        List<ZonedDateTime> timeParisConakry = new ArrayList<>();
        timeParisConakry.add(ZonedDateTime.of(2020, 11, 13, 12, 00, 00, 00, zoneId));
        timeParisConakry.add(ZonedDateTime.of(2020, 11, 13, 23, 15, 00, 00, zoneId));

        List<ZonedDateTime> timeConakryTirana = new ArrayList<>();
        timeConakryTirana.add(ZonedDateTime.of(2020, 11, 15, 12, 00, 00, 00, zoneId));
        timeConakryTirana.add(ZonedDateTime.of(2020, 11, 15, 15, 55, 00, 00, zoneId));

        List<ZonedDateTime> timeParisTirana = new ArrayList<>();
        timeParisTirana.add(ZonedDateTime.of(2020, 11, 7, 12, 00, 00, 00, zoneId));
        timeParisTirana.add(ZonedDateTime.of(2020, 11, 7, 17, 25, 00, 00, zoneId));

        List<ZonedDateTime> timeLosAngConakry = new ArrayList<>();
        timeLosAngConakry.add(ZonedDateTime.of(2020, 12, 13, 8, 45, 00, 00, zoneId));
        timeLosAngConakry.add(ZonedDateTime.of(2020, 12, 13, 14, 15, 00, 00, zoneId));

        List<ZonedDateTime> timeTiranaParis = new ArrayList<>();
        timeTiranaParis.add(ZonedDateTime.of(2021, 4, 13, 18, 00, 00, 00, zoneId));
        timeTiranaParis.add(ZonedDateTime.of(2021, 4, 13, 23, 15, 00, 00, zoneId));

        List<ZonedDateTime> timeLosAngTirana = new ArrayList<>();
        timeLosAngTirana.add(ZonedDateTime.of(2021, 7, 13, 11, 35, 00, 00, zoneId));
        timeLosAngTirana.add(ZonedDateTime.of(2021, 7, 13, 21, 15, 00, 00, zoneId));

        List<ZonedDateTime> timeClermontParis = new ArrayList<>();
        timeClermontParis.add(ZonedDateTime.of(2024, 9, 23, 8, 15, 00, 00, zoneId));
        timeClermontParis.add(ZonedDateTime.of(2024, 9, 23, 9, 20, 00, 00, zoneId));

        List<ZonedDateTime> timeParisAmsterdam = new ArrayList<>();
        timeParisAmsterdam.add(ZonedDateTime.of(2024, 9, 23, 12, 33, 00, 00, zoneId));
        timeParisAmsterdam.add(ZonedDateTime.of(2024, 9, 23, 13, 46, 00, 00, zoneId));

        List<ZonedDateTime> timeLyonIstanbul = new ArrayList<>();
        timeLyonIstanbul.add(ZonedDateTime.of(2024, 5, 16, 23, 56, 00, 00, zoneId));
        timeLyonIstanbul.add(ZonedDateTime.of(2024, 5, 17, 03, 14, 00, 00, zoneId));

        List<ZonedDateTime> timeIstanbulDubai = new ArrayList<>();
        timeIstanbulDubai.add(ZonedDateTime.of(2024, 5, 17, 07, 25, 00, 00, zoneId));
        timeIstanbulDubai.add(ZonedDateTime.of(2024, 5, 17, 11, 50, 00, 00, zoneId));

        Ville paris      = new Ville("Paris")           ;
        Ville losAngeles = new Ville("Los Angeles")     ;
        Ville conakry    = new Ville("Conakry")         ;
        Ville tirana     = new Ville("Tirana")          ;
        Ville clermont   = new Ville("Clermont-Ferrand");
        Ville amsterdam  = new Ville("Amsterdam")       ; 
        Ville istanbul   = new Ville("Istambul")        ;
        Ville lyon       = new Ville("Lyon")            ;
        Ville dubai      = new Ville("Dubai")           ;

        Aeroport parisCharleDeGaull      = new Aeroport("Paris Charle De Gaull", "CDG", paris)                    ;
        Aeroport losAngelesInternational = new Aeroport("Los Angelos International", "LAX", losAngeles)           ;
        Aeroport gbessiaConakry          = new Aeroport("GBESSIA-CONAKRY", "CKY", conakry)                        ;
        Aeroport tiranaAirport           = new Aeroport("Tirana International Airport Nënë Tereza", "TIA", tirana);
        Aeroport clermontAeroport        = new Aeroport("Clermont-Ferrand Auvergne Aéroport", "CFE", clermont)    ;
        Aeroport amsterdamAeroport       = new Aeroport("Aéroport d'Amsterdam Schiphol", "AMS", amsterdam)        ;
        Aeroport istanbulAirport         = new Aeroport("Istanbul Atatürk Airport", "IST", istanbul)              ;
        Aeroport lyonAirport             = new Aeroport("Lyon–Saint Exupéry Airport", "LYS", lyon)                ;
        Aeroport dubaiAirport            = new Aeroport("Dubai International Airport", "LYS", dubai)              ;
        //Aeroport parisOrly      = new Aeroport("Paris orly", "OR", paris)                    ;

        List<Compagnie> compagnies = new ArrayList<>();
        easyJet.propose(volParisConakry, timeParisConakry.get(0), timeParisConakry.get(1), parisCharleDeGaull,gbessiaConakry);
        easyJet.propose(volConakryTirana, timeConakryTirana.get(0), timeConakryTirana.get(1), gbessiaConakry,tiranaAirport)  ;
        easyJet.propose(volParisTirana, timeParisTirana.get(0), timeParisTirana.get(1), parisCharleDeGaull,tiranaAirport)    ;

        airAlbania.propose(volLosAngConakry, timeLosAngConakry.get(0), timeLosAngConakry.get(1),losAngelesInternational, gbessiaConakry);

        flyEmirates.propose(volTiranaParis, timeTiranaParis.get(0), timeTiranaParis.get(1), tiranaAirport,parisCharleDeGaull)        ;
        flyEmirates.propose(volLosAngTirana, timeLosAngTirana.get(0), timeLosAngTirana.get(1), losAngelesInternational,tiranaAirport);
        flyEmirates.propose(volIstanbulDubai, timeIstanbulDubai.get(0), timeIstanbulDubai.get(1), istanbulAirport,dubaiAirport)      ;

        airFrance.propose(volClermontParis, timeClermontParis.get(0), timeClermontParis.get(1), clermontAeroport,parisCharleDeGaull)    ;
        airFrance.propose(volParisAmsterdam, timeParisAmsterdam.get(0), timeParisAmsterdam.get(1), parisCharleDeGaull,amsterdamAeroport);
        airFrance.propose(volLyonIstanbul, timeLyonIstanbul.get(0), timeLyonIstanbul.get(1), lyonAirport,istanbulAirport)               ;

        // Ajout des compagnies aériennes à la liste des compagnies
        compagnies.add(easyJet)    ;
        compagnies.add(flyEmirates);
        compagnies.add(airAlbania) ;
        compagnies.add(airFrance)  ;

        // Gestion des escales pour le vol Clermont-Paris-Amsterdam
        List<ZonedDateTime> timeEscaleParis = new ArrayList<>();
        timeEscaleParis.add(timeClermontParis.get(1)); // Heure d'arrivée à Paris
        timeEscaleParis.add(timeParisAmsterdam.get(0)); // Heure de départ de Paris

        Escale escaleParis = new Escale(parisCharleDeGaull, timeEscaleParis.get(0), timeEscaleParis.get(1));
        airFrance.getVolListe().get(airFrance.getVolListe().size() - 2).add_Escale(escaleParis); // Ajouter l'escale au vol Clermont-Paris

        // Gestion des escales pour le vol Lyon-Istanbul-Dubai
        List<ZonedDateTime> timeEscaleIstanbul = new ArrayList<>();
        timeEscaleIstanbul.add(timeLyonIstanbul.get(1)); 
        timeEscaleIstanbul.add(timeIstanbulDubai.get(0)); 

        // Création et ajout de l'escale à Istanbul pour le vol Lyon-Istanbul
        Escale escaleIstanbul = new Escale(istanbulAirport, timeEscaleIstanbul.get(0), timeEscaleIstanbul.get(1));
        // L'escale est ajoutée au  dernier vol ajouté à la liste
        airFrance.getVolListe().get(airFrance.getVolListe().size() - 1).add_Escale(escaleIstanbul); 

        for (Compagnie compagnie : compagnies) {
            for (Vol vol : compagnie.getVolListe()) {
                vol.ouvrir();
            }
        }

        for (Compagnie compagnie : compagnies) {
            for (Vol vol : compagnie.getVolListe()) {
                ZonedDateTime dateDepart = vol.getDateDepart();
                ZonedDateTime dateActuelle = ZonedDateTime.now();
                Duration duree = Duration.ofHours(6);
                if (Duration.between(dateDepart, dateActuelle).compareTo(duree) > 0)
                    vol.fermer();
            }
        }

        List<Client> clients = new ArrayList<>();
        Client eldis         = new Client("Ymeraj Eldis", "cl0001", "CB", "0765448596")         ;
        Client sebastien     = new Client("Cocosinscki Sébastien", "cl0002", "EP", "0623458569");
        Client bradPitt      = new Client("Brad Pitt", "cl0003", "CB", "0523487569")            ;
        Client florian       = new Client("Forestiner Florian", "cl004", "EP", "0783456712")    ;
        Client guillaume     = new Client("Morin Guillaume", "cl005", "EP", "0783456712")       ;

        clients.add(eldis)    ;
        clients.add(sebastien);
        clients.add(bradPitt) ;
        clients.add(florian)  ;
        clients.add(guillaume);

        Passager alex        = new Passager("Fernandez Alexandra");
        Passager guendoline  = new Passager("Durand Guendoline")  ;

        List<Reservation> reservations = new ArrayList<>();
        ZonedDateTime date1 = ZonedDateTime.of(2020, 10, 28, 12, 15, 00, 00, zoneId);
        ZonedDateTime date2 = ZonedDateTime.of(2020, 10, 25, 00, 15, 00, 00, zoneId);
        ZonedDateTime date3 = ZonedDateTime.of(2020, 11, 01, 20, 35, 00, 00, zoneId);
        ZonedDateTime date4 = ZonedDateTime.of(2020, 10, 30, 00, 15, 00, 00, zoneId);
        ZonedDateTime date5 = ZonedDateTime.of(2020, 11, 01, 20, 35, 00, 00, zoneId);
        ZonedDateTime date6 = ZonedDateTime.of(2023, 5, 02, 21, 15, 00, 00, zoneId) ;

        Reservation reservation1 = eldis    .effectue("BVC13Q", date1, eldis.getNom(),easyJet.getVolListe().get(0))               ;
        Reservation reservation2 = eldis    .effectue("DUX22B", date1, "Colin Clement",easyJet.getVolListe().get(0));
        Reservation reservation3 = sebastien.effectue("ZNB00P", date2, sebastien.getNom(),airAlbania.getVolListe().get(0))        ;
        Reservation reservation4 = bradPitt .effectue("DUX22R", date3, bradPitt.getNom(),flyEmirates.getVolListe().get(1))        ;
        Reservation reservation5 = alex     .effectue("XSL02A", date4, alex.getNom(), easyJet.getVolListe().get(2))                          ;
        Reservation reservation6 = alex     .effectue("AHA99O", date5, guendoline.getNom(),flyEmirates.getVolListe().get(0))                 ;
        Reservation reservation7 = eldis    .effectue("FLR45T", date6, florian.getNom(), airFrance.getVolListe().get(1))          ;
        Reservation reservation8 = guillaume.effectue("GUR12M", date6, guillaume.getNom(),airFrance.getVolListe().get(1))         ;

        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        reservations.add(reservation4);
        reservations.add(reservation5);
        reservations.add(reservation6);
        reservations.add(reservation7);
        reservations.add(reservation8);

        for (Reservation reservation : clients.get(0).getClientReservations()) {
            reservation.cancel();
        }

        for (Client client : clients) {
            for (Reservation reservation : client.getClientReservations()) {
                if (Duration.between(reservation.getReservationDate(), ZonedDateTime.now())
                        .compareTo(Duration.ofHours(24)) > 0) {
                    reservation.confirm();
                } else
                    reservation.cancel();
            }
        }
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|                          Réservation Vol                            |");
        System.out.println("|                            Eldis YMERAJ                             |");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("");
        System.out.println("_______________________ Menu _______________________");
        /* 
        // Tester la double navigabilité Passager -> Reservation
        System.out.println("\nRéservations d'Alexandra (Passager vers Reservation) :");
        for (Reservation res : alex.getPassagerReservations()) {
            System.out.println(res);
        }
        // Tester la double navigabilité Reservation -> Passager
        System.out.println("\nReservation -> Passager) :");
        System.out.println("\nPassager de la première réservation d'Alexandra (Reservation vers Passager) :");
        if (!alex.getPassagerReservations().isEmpty()) {
            System.out.println(alex.getPassagerReservations().get(0).getPassenger().getNom());
        }

        // Tester la double navigabilité Client -> Reservation
        System.out.println("\nClient -> Reservation :");
        System.out.println("\nRéservations de Eldis (Client vers Reservation) :");
        for (Reservation res : eldis.getClientReservations()) {
            System.out.println(res);
        }

        // Tester la double navigabilité Reservation -> Client
        System.out.println("\nReservation -> Client :");
        System.out.println("\nClient de la première réservation d'Eldis (Reservation vers Client) :");
        if (!eldis.getClientReservations().isEmpty()) {
            Client client = eldis.getClientReservations().get(0).getClient();
            System.out.println(client != null ? client.getNom() : "Pas de client");
        }

        System.out.println("\nVols proposés par EasyJet :");
        for (Vol vol : easyJet.getVolListe()) {
            System.out.println(vol);
        } */

        //Scanner scanner = new Scanner(System.in);
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println(" 1) Liste des Vols");
            System.out.println(" 2) Liste des Reservations");
            System.out.print("Saisissez votre choix : ");
            
            int choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 1:
                    for (Compagnie compagnie : compagnies) {
                        System.out.println("----------------------- Liste des Vols -----------------------");
                        compagnie.info();
                    }
                    break;
                case 2:
                    System.out.println("----------------------- Liste des Reservations -----------------------");
                    for (Reservation reservation : reservations) {
                        reservation.displayReservationDetails();
                    }
                    break;
                default:
                    System.out.println(" Erreur de saisie");
                    break;
            }
        }catch(NumberFormatException e){
            System.out.println(" Entrée invalide : " + e.getMessage());
        }
        
    }

}