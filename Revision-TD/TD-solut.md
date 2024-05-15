# Exercices

## Exercice (4 pt)

On veut créer trois types **Triangle**, **Rectangle** et **Cercle**. Ces trois types doivent être des sous-types d'un type abstrait **Forme**. Cependant, on veut garantir que les seuls sous-types possibles de **Forme** sont ces trois là. Comment faire en **JAVA**?
### Définition de la classe `Forme` et de ses sous-classes

```java
// Définition du package
package formes;

public abstract class Forme {
    // Constructeur package-private
    Forme() {}

    // Méthodes abstraites communes
    public abstract double aire();
    public abstract double perimetre();

    // Méthodes de fabrique statiques pour créer des instances
    public static Forme createTriangle(double base, double hauteur) {
        return new Triangle(base, hauteur);
    }

    public static Forme createRectangle(double longueur, double largeur) {
        return new Rectangle(longueur, largeur);
    }

    public static Forme createCercle(double rayon) {
        return new Cercle(rayon);
    }

    // Sous-classe Triangle
    private static class Triangle extends Forme {
        private final double base;
        private final double hauteur;

        Triangle(double base, double hauteur) {
            this.base = base;
            this.hauteur = hauteur;
        }

        @Override
        public double aire() {
            return (base * hauteur) / 2;
        }

        @Override
        public double perimetre() {
            // Exemple simplifié
            return 0;
        }
    }

    // Sous-classe Rectangle
    private static class Rectangle extends Forme {
        private final double longueur;
        private final double largeur;

        Rectangle(double longueur, double largeur) {
            this.longueur = longueur;
            this.largeur = largeur;
        }

        @Override
        public double aire() {
            return longueur * largeur;
        }

        @Override
        public double perimetre() {
            return 2 * (longueur + largeur);
        }
    }

    // Sous-classe Cercle
    private static class Cercle extends Forme {
        private final double rayon;

        Cercle(double rayon) {
            this.rayon = rayon;
        }

        @Override
        public double aire() {
            return Math.PI * rayon * rayon;
        }

        @Override
        public double perimetre() {
            return 2 * Math.PI * rayon;
        }
    }
}
```
### Explications

### Classe `Forme`
- **Constructeur package-private**: Le constructeur de `Forme` est défini sans modificateur d'accès, ce qui le rend package-private. Cela empêche toute classe en dehors du package `formes` de directement instancier `Forme`.

- **Méthodes abstraites**: Les méthodes `aire` et `perimetre` sont abstraites, ce qui oblige les sous-classes à les implémenter.

- **Méthodes de fabrique statiques**: Les méthodes statiques `createTriangle`, `createRectangle` et `createCercle` permettent de créer des instances des sous-classes. Cela garantit que les instances des sous-classes sont créées de manière contrôlée.

### Sous-classes

- **Sous-classes privées**: Les classes `Triangle`, `Rectangle` et `Cercle` sont définies comme des classes internes privées de `Forme`. Cela signifie qu'elles ne peuvent pas être étendues ou instanciées directement en dehors de `Forme`.

#### `Triangle`
- La classe `Triangle` est définie avec des propriétés `base` et `hauteur` et implémente les méthodes `aire` et `perimetre`.

#### `Rectangle`
- La classe `Rectangle` est définie avec des propriétés `longueur` et `largeur` et implémente les méthodes `aire` et `perimetre`.

#### `Cercle`
- La classe `Cercle` est définie avec une propriété `rayon` et implémente les méthodes `aire` et `perimetre`.

### Utilisation
- La classe `Main` montre comment utiliser les méthodes de fabrique statiques de la classe `Forme` pour créer des instances de `Triangle`, `Rectangle` et `Cercle` et calculer leurs aires.
```java
package formes;

public class Main {
    public static void main(String[] args) {
        Forme triangle = Forme.createTriangle(3, 4);
        Forme rectangle = Forme.createRectangle(5, 6);
        Forme cercle = Forme.createCercle(7);

        System.out.println("Aire du triangle: " + triangle.aire());
        System.out.println("Aire du rectangle: " + rectangle.aire());
        System.out.println("Aire du cercle: " + cercle.aire());
    }
}
```

En utilisant un constructeur package-private pour `Forme` et des classes internes privées pour `Triangle`, `Rectangle` et `Cercle`, nous pouvons garantir que les seuls sous-types de `Forme` sont ceux définis à l'intérieur de `Forme`. Cette solution assure que les sous-classes ne peuvent pas être étendues ou instanciées en dehors du contrôle de la classe `Forme`, répondant ainsi aux exigences de l'exercice.

```plaintext
+------------------------------------+
|               Forme                |
|------------------------------------|
| - Forme()                          |
| + aire(): double                   |
| + perimetre(): double              |
|------------------------------------|
| + createTriangle(base: double,     |
|   hauteur: double): Forme          |
| + createRectangle(longueur: double,|
|   largeur: double): Forme          |
| + createCercle(rayon: double):     |
|   Forme                            |
+------------------------------------+
                 ^
                 |
                 |
+----------------+-------------------+
|                                    |
|                                    |
+-------------------+----------------+
|                   |                |
|                   |                |
|                   |                |
|   +---------------+--------------+ |
|   |               |              | |
|   |               |              | |
|   V               V              V |
| +-----------+ +-----------+ +-----------+
| | Triangle  | | Rectangle | |  Cercle   |
| |-----------| |-----------| |-----------|
| | - base    | | - longueur | | - rayon  |
| | - hauteur | | - largeur  | |           |
| |-----------| |-----------| |-----------|
| | + aire()  | | + aire()  | | + aire()  |
| | + perimetre()| + perimetre()| + perimetre()|
+-----------+ +-----------+ +-----------+
```


## Exercice (Réveil)

**Étudions le comportement d'un réveil électronique, disposant d'un affichage et de deux boutons de réglage, mode et changement. Dans le mode normal, il affiche l'heure. Si le bouton changement est activé, l'heure de sonnerie qui est affichée. Lorsque le bouton mode est activé, le réveil passe en mode de réglage de l'heure. Dans ce mode, l'heure est toujours affichée, mais celle-ci clignote, et chaque pression sur le bouton changement l'incrémente d'une minute. Si l'on appuie à nouveau sur mode, le réveil passe en mode de réglage de l'heure de sonnerie, avec un comportement similaire. Un nouvel appui sur mode fait repasser le réveil en mode d'affichage de l'heure.**

1. **(État simple)** Réaliser le diagramme d'états de ce réveil.
2. **(État avancé)** Faire évoluer le diagramme d'états pour représenter cette fonctionnalité.
3. **(Classes)** Réaliser le diagramme de classe de ce réveil, en détaillant la solution choisie.

## Exercice (Patrons fonctionnels)

**map, filter et fold (ou reduce) sont des patrons classiques des langages fonctionnels.**

Le **map** s'applique sur une liste (ou similaire) et la transforme par application d'une fonction. Par exemple, **map(f, [v1, v2, v3])** renvoie **[f(v1), f(v2), f(v3)]**. **filter** renvoie une nouvelle liste ne contenant que les éléments validant un prédicat. Ainsi, par exemple, **filter(isEven, [1, 2, 3, 4, 5])** renvoie **[2, 4]**. Enfin, le **fold** agrège les éléments d'une liste. Par exemple, **fold(add, 0, [1, 2, 3, 4, 5])** renvoie 15 et **fold(concat, "", ["a", "b", "c"])** renvoie "abc".

On souhaite implémenter une approche similaire en objet pur, par exemple en Java. Il faut de plus que la mise en œuvre proposée soit paresseuse (c'est-à-dire que les traitements ne soient appliqués que si nécessaire) et composable (on peut chainer plusieurs de ces opérations), comme c'est le cas en fonctionnel (par exemple **reduce(add, 0, map(double, filter(isEven, [1, 2, 3, 4, 5]))** donne 12).

1. **(2 pt)** Quels patrons de conception orientée objets classiques sont utiles pour modéliser ce système ?
2. **(3 pt)** Faire la représentation UML du diagramme de classe.
3. **(2 pt)** Donner le code Java correspondant.

## Exercice (4 pt)

On souhaite évaluer différents algorithmes pour une tâche donnée. On veut donc exécuter une série de traitement identique en mesurant les performances et les résultats, pour chacune de ces méthodes. Les paramètres d'exécution peuvent changer. Quels patrons sont utiles pour réaliser ce système ? Expliquer le fonctionnement de ces patrons et leur intérêt dans ce cas précis.

## Exercice (Gestionnaire de tâches)

**On se propose ici de modéliser une application de gestion de tâches (simplifiée).**

Une tâche possède un titre, une description, une charge, un niveau d'importance, et éventuellement des sous-tâches. De plus, une tâche peut être affectée à une ou plusieurs personnes. La durée d'une tâche est calculée en fonction de sa charge et du nombre de personnes qui y sont affectées, ainsi que de l'avancement de ses sous-tâches. La priorité d'une tâche est définie par son importance et sa durée restante. Enfin, une tâche peut posséder une tâche parente dont elle est dépendante.

Une tâche peut être virtuelle si elle ne correspond pas à un travail à faire, mais est utilisée pour regrouper des sous-tâches ou pour servir de repère. Un projet est constitué de plusieurs tâches éventuellement interdépendantes, des personnes y participant, d'une date de début et d'un calendrier décrivant diverses informations temporelles (nombre d'heures travaillées par jour, etc.). La durée et la date de fin du projet sont calculées en fonction de ses tâches et de leur avancement.

Les personnes ont un nom, une fonction, et diverses informations utiles.

1. **(4 pt)** Effectuer le diagramme de classe à un niveau analyse de cette application. Pensez à y apporter toutes les informations nécessaires.
2. **(2 pt)** On désire représenter les tâches d'un projet sous plusieurs formes : calendrier, planning, graphe de dépendance, etc. Comment modéliser l'aspect représentation d'un projet pour garder une flexibilité de représentation ?

## Exercice (Langage)

On cherche à représenter un programme dans un langage simple sous la forme d'un arbre. Chaque élément de l'arbre représente un élément du langage. On dispose donc de différents types de feuilles (les valeurs littérales, les variables) et de différents types de nœuds (opérateurs, déclarations, boucles, branches conditionnelles, etc.)

Le langage est simple, et ne dispose que d'une boucle **while**, d'une branche conditionnelle (**if then else**), des types primitifs **int**, **string**, et **bool** avec les opérateurs classiques associés, de tableaux, et de l'affectation de valeur à une variable.

Par ailleurs, différentes opérations devront être effectuées sur cette structure, comme par exemple en vérifier la validité, la convertir en code bas niveau (compilation), ou l'afficher sous la forme de code source correctement formaté (**pretty print**).

1. **(3 pt)** Quels patrons de conceptions seront nécessaires à cette mise en œuvre ? Pourquoi ? Qu'apportent-ils ?
2. **(3 pt)** Donnez une ébauche de représentation UML statique et dynamique de ce système.
