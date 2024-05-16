# Exercices

## Exercice (4 pt)

On veut créer trois types **Triangle**, **Rectangle** et **Cercle**. Ces trois types doivent être des sous-types d'un type abstrait **Forme**. Cependant, on veut garantir que les seuls sous-types possibles de **Forme** sont ces trois là. Comment faire en **JAVA**?

Les classes scellées en Java permettent de contrôler les hiérarchies de classes en spécifiant explicitement quels types peuvent étendre ou implémenter une classe ou une interface donnée. Cela est particulièrement utile pour créer des modèles de domaines où la sécurité du type et la prévisibilité sont cruciales.

### Définition de la Classe Abstraite `Forme`

La classe `Forme` est définie comme une classe abstraite scellée. Elle spécifie ses sous-types autorisés avec le mot-clé `permits`. Cela garantit que seuls les types listés (`Triangle`, `Rectangle`, `Cercle`) peuvent hériter de `Forme`.

```java
public abstract sealed class Forme permits Triangle, Rectangle, Cercle {
    public abstract double calculerAire();
```
### Définition des Sous-Classes
Chaque sous-classe de Forme doit être déclarée soit comme `final` , soit comme `sealed`, soit comme `non-sealed`. Ici, chaque sous-classe est définie comme `final`, ce qui signifie qu'aucune autre classe ne peut hériter de ces sous-classes.
**Classe Triangle**
La classe Triangle est une `sous-classe` de Forme qui calcule l'aire d'un triangle.
```java
public final class Triangle extends Forme {
    private double base;
    private double hauteur;

    public Triangle(double base, double hauteur) {
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    public double calculerAire() {
        return 0.5 * base * hauteur;
    }
}
```
**Classe Rectangle**
La classe Rectangle calcule l'aire d'un rectangle:
```java
public final class Rectangle extends Forme {
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public double calculerAire() {
        return largeur * longueur;
    }
}
```
**Classe Cercle**
La classe Cercle calcule l'aire d'un cercle à partir de son rayon:
```java
public final class Cercle extends Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }
}
```
**Avantages des Classes Scellées:**
- ***Contrôle Strict de l'Héritage:*** Seuls les sous-types explicitement permis peuvent étendre la classe Forme.
- ***Sécurité de Type Améliorée:*** Cela aide à garantir que les instances sont de types connus et contrôlés, ce qui est essentiel pour la robustesse des applications.
- ***Facilitation du Refactoring:*** Le compilateur peut signaler des erreurs si le code existant n'est pas adapté aux sous-classes prévues.
**Exemple de la classe main:**
```java
public class Main {
    public static void main(String[] args) {
        Forme triangle = new Triangle(3.0, 4.0);
        Forme rectangle = new Rectangle(4.0, 5.0);
        Forme cercle = new Cercle(3.0);

        System.out.println("Aire du triangle : " + triangle.calculerAire());
        System.out.println("Aire du rectangle : " + rectangle.calculerAire());
        System.out.println("Aire du cercle : " + cercle.calculerAire());
    }
}
```
La classe `Main` est utilisée pour créer des instances de `Triangle`, `Rectangle`, et `Cercle`, et pour calculer et afficher leur aire respective. Ceci démontre l'utilisation pratique des classes scellées avec des méthodes concrètes.
