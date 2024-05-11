# Tests unitaires

Dans ce TP, on se propose d'expérimenter l'utilisation des tests unitaires en Java. Pour cela, on va réaliser une classe permettant de gérer des chiffres romains.

## Rappel sur les chiffres romains

Dans la numérotation romaine, il y a sept symboles combinés de différentes manières pour composer les nombres :

- I = 1
- V = 5
- X = 10
- L = 50
- C = 100
- D = 500
- M = 1000

La construction des nombres plus complexes suit les règles suivantes :

- Les symboles sont additifs : I vaut 1, II vaut 2, VI vaut 6 (5 + 1), etc.
- Les symboles des multiples (I, X, C et M) peuvent être répétés jusqu'à trois fois. À partir de quatre, il faut soustraire du symbole suivant. Ainsi, 4 est représenté par IV, 40 s'écrit XL, etc.
- De même, si 8 est VIII, 9 est IX.
- Les symboles des "5" ne peuvent jamais être répétés.
- Les chiffres romains s'écrivent du plus grand vers le plus petit et se lisent de gauche à droite. L'ordre compte : DC est 600, mais CD est 400.

Les propriétés suivantes devront être respectées :

- Il n'existe qu'une seule manière de représenter un nombre en chiffres romains.
- Réciproquement, un nombre romain valide représente un seul nombre décimal.
- Seuls les nombres entiers compris entre 1 et 3999 inclus peuvent être représentés avec ce système.

## Module de conversion

Les algorithmes de conversion sont assez simples et sont donnés ci-dessous.

### Conversion d'un chiffre arabe vers un chiffre romain :

Données : table des symboles (symbole, nombre) connus  
Entrées : nombre entier inclus dans l'intervalle [1;3999] n  
Résultat : chiffre romain  
Début  
résultat = "";  
Pour chaque couple (symbole, nombre) de la table des symboles, faire :  
Tant que n >= nombre, faire :  
résultat = résultat + symbole;  
n = n - nombre  
Retourner résultat

### Conversion d'un chiffre romain vers un chiffre arabe :

Données : table des symboles (symbole, nombre) connus  
Entrées : chiffre romain s  
Résultat : nombre entier en décimal  
Début  
résultat = 0;  
index = 0;  
Pour chaque couple (symbole, nombre) de la table des symboles, faire :  
Tant que SousChaine(s, index, index + Longueur(symbole)) == symbole, faire :  
résultat = résultat + nombre;  
index = index + Longueur(symbole)  
Retourner résultat

Une base de code vous est donné dans la pièce jointe au TP.

Pour simplifier la conversion, les combinaisons soustractives ont été ajoutées à la table des symboles. De plus, l'expression régulière de validation des chiffres romains vous est donnée.

## Tests unitaires et TDD

### Principe des tests unitaires

Les tests unitaires ont pour but de tester les fonctions (ou méthodes) à un niveau élémentaire, avec une approche "boîte noire", c'est-à-dire que l'on ne connaît que la signature de la fonction à tester. On teste donc des unités fonctionnelles indépendantes d'un programme plus global.

Il existe des frameworks de test unitaire pour la plupart des langages de programmation, souvent inspiré de SUnit, le framework pour Smalltalk.

Les méthodes de test ne testent qu'un aspect particulier du cas, correspondant à une spécification particulière, et lève une exception si le résultat n'est pas celui attendu. Cette vérification se fait par l'intermédiaire de méthodes spécifiques (assertEquals, assertRaises, etc). Là aussi, il existe de nombreuses bibliothèques d'assertion.

### Mise en oeuvre

Nous allons suivre les principes du développement guidé par les tests, ou TDD (Test Driver Development). Cela signifie que nous allons écrire les tests avant d'écrire le code. C'est un principe mis en oeuvre dans les méthodes agiles.

Les tests à effectuer sont (au moins) les suivants :

#### Tests de réussite
- Donner les bonnes valeurs décimales pour des valeurs romaines connues
- Donner les bonnes valeurs romaines pour des valeurs décimales connues

#### Tests d'échec :
- Échouer pour les valeurs négatives
- Échouer pour des valeurs hors de l'intervalle [1;3999]
- Échouer pour des valeurs avec trop de répétitions de symboles
- Échouer pour des valeurs avec des répétitions de paires
- Échouer pour des valeurs avec des antécédents incorrects

#### Tests de validité :
- Pour tout entier n inclus dans l'intervalle [1;3999], fromRoman(toRoman(n)) = n

### Travail

L'idée est donc d'écrire les tests en premier, et d'implémenter les fonctionnalités petit à petit jusqu'à ce que tous les tests passent :

- Implémentez la totalité des tests unitaires d'après les spécifications fournies
- Implémentez les méthodes toRoman et fromRoman jusqu'à ce que tous les tests passent
- Implémentez et testez les méthodes définies dans java.lang.Number (toString(), toDouble(), etc)
- Faites en sorte qu'un chiffre romain soit comparable avec n'importe quel autre nombre (voir l'interface Comparable)
- Le modèle fournit pour ce TP utilise l'outil Gradle. Le fichier de configuration build.gradle défini les tâches et les dépendances du projet.

Pour exécuter les tests, lancez la tâche test de gradle : ./gradlew test sous Linux.
