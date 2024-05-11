  On se propose ici d’étudier un système de réservation de vol pour une compagnie aérienne.
Les interviews des experts métiers auxquels on a procédé ont permis de résumer leurs connaissances du domaine sous
la forme des phrases suivantes :

— des compagnies aériennes proposent différents vols ;

— un vol a un numéro unique ;

— un vol a un jour et une heure de départ et un jour et une heure d’arrivée ;

— un vol a un aéroport de départ et un aéroport d’arrivée ;

— un vol peut comporter des escales dans des aéroports ;

— une escale a une heure d’arrivée et une heure de départ ;

— chaque aéroport dessert une ou plusieurs villes.

— un vol est ouvert à la réservation et refermé sur ordre de la compagnie ;

— un client peut réserver un ou plusieurs vols, pour des passagers différents ;

— une réservation concerne un seul vol et un seul passager ;

— une réservation peut être annulée, ou confirmée si elle a été payée ;



Question 1 (Modélisation des vols et des compagnies) : Modélisez les aspects concernant les vols et les compagnies.

Question 2 (Modélisation des aéroports et des villes) : Modélisez les aéroports et les villes, en spécifiant bien la multiplicité
du coté aéroport (en argumentant votre choix).

Question 3 (Modélisation des escales) : Proposez plusieurs solutions pour modéliser les escales et justifier votre choix final.

Question 4 (Modélisation des réservations) : Nous pouvons maintenant aborder le traitement du concept de réservation.
D’après vous, faut-il vraiment distinguer les concepts de client et de passager ? Proposez alors une modélisation pour les
réservations.

Question 5 (État des réservations) : Proposez une modélisation des différents états possibles pour une réservation. Le
comportement de ces états pourra être modélisé dans un diagramme d’état. Proposez une modélisation de niveau
implémentation pour représenter les réservations dans les différents états.

Question 6 (Vols réguliers) : Que pensez vous de la classe Vol et quelles améliorations pourriez vous y apporter ? Vous
pouvez vous aider d’un diagramme d’instances concernant quelques vols et aéroports. Envisagez notamment les vols
régulier (partant et arrivant au même aéroport, à des dates et heures différentes).

Question 7 (Découpage en paquets) : Sur un nouveau diagramme complet de votre application, vous proposerez un
découpage de votre modèle conceptuel en deux paquets. Si plusieurs solutions sont possibles, décrivez les à l’aide des
diagrammes de paquets et choisissez celle qui minimisera le couplage entre les deux paquets.

<img src="uml.png" alt="Description de l'image">

Pour compiler : ./gradlew run
