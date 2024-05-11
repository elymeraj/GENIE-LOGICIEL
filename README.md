# Travaux pratiques de Génie Logiciel - TP3 & TP4

## TP3: Tests Unitaires pour la Gestion des Chiffres Romains

### Objectif
Expérimenter l'utilisation des tests unitaires en Java à travers une classe de gestion des chiffres romains, incluant les conversions entre les chiffres arabes et romains.

### Détails du Projet
- **Conversion Arabes vers Romains**:
  - Implémenté une méthode convertissant les nombres entiers de 1 à 3999 en chiffres romains.
  - Utilisé une table de correspondance des symboles romains pour la conversion.
  
- **Conversion Romains vers Arabes**:
  - Implémenté une méthode convertissant les chiffres romains valides en leur équivalent numérique.
  - Validé l'entrée avec une expression régulière pour assurer le respect des règles de la numérotation romaine.

- **Tests Unitaires**:
  - Écrit des tests pour vérifier la précision des conversions dans les deux directions.
  - Inclus des tests pour valider la gestion des cas d'erreurs (valeurs hors limite, formats incorrects).

### Technologies Utilisées
- Java
- JUnit pour les tests unitaires
- Gradle pour la compilation et l'exécution des tests

## TP4: Implémentation du Schéma UML pour la Réservation de Vols

### Objectif
Ce projet vise à implémenter un système de gestion de réservation de vols basé sur un schéma UML détaillé, en mettant l'accent sur les principes de l'ingénierie logicielle et la programmation orientée objet.

### Détails de l'Implémentation

### Modèle UML
Le projet est basé sur un modèle UML comprenant plusieurs classes et relations qui représentent le système de réservation de vols. Les principales entités incluent :

- **Compagnie** : Représente les compagnies aériennes offrant des vols.
- **Vol** : Gère les informations sur les vols, y compris les numéros de vols, les dates de départ et d'arrivée, et les escales.
- **Client** : Stocke les informations sur les clients qui réservent des vols.
- **Reservation** : Associe les clients à des vols et gère les détails des réservations.
- **Passager** : Représente les passagers inclus dans chaque réservation.

### Fonctionnalités Clés
- **Gestion des Vols** :
  - Chaque vol est lié à une compagnie et peut comporter plusieurs escales.
  - Les vols sont créés, modifiés, et consultés à travers des méthodes spécifiques.

- **Système de Réservation** :
  - Permet la création et la gestion des réservations pour les clients.
  - Inclut la gestion des passagers pour chaque réservation.

- **Double Navigabilité** :
  - Implémenté la double navigabilité entre les classes pour permettre des interactions bidirectionnelles, par exemple, entre `Client` et `Reservation`.
  - Assuré que les références mutuelles ne créent pas de boucles infinies.

### Tests Unitaires
Des tests unitaires complets ont été écrits pour chaque composante du système selon la méthodologie du développement piloté par les tests (Test Driven Development - TDD) :

- **Tests de Validation** :
  - Vérification que les données des vols et des réservations respectent les contraintes du modèle.
  
- **Tests de Performance** :
  - Tests pour s'assurer que le système peut gérer un volume élevé de réservations et de consultations simultanées.

- **Tests de Sécurité** :
  - Tests pour identifier et corriger les vulnérabilités potentielles dans la gestion des données utilisateurs et des réservations.

## Technologies Utilisées
- **Java** : Langage de programmation choisi pour le développement du backend.
- **JUnit** : Framework utilisé pour la création et l'exécution des tests unitaires.
- **Gradle** : Outil de build qui gère les dépendances et automatiser les tests et les builds.

## Commandes pour l'Exécution
Pour compiler et exécuter les tests, utilisez la commande suivante dans le terminal :
```bash
./gradlew test
