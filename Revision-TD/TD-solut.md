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

## Exercice (Réveil)

**Étudions le comportement d'un réveil électronique, disposant d'un affichage et de deux boutons de réglage, mode et changement. Dans le mode normal, il affiche l'heure. Si le bouton changement est activé, l'heure de sonnerie qui est affichée. Lorsque le bouton mode est activé, le réveil passe en mode de réglage de l'heure. Dans ce mode, l'heure est toujours affichée, mais celle-ci clignote, et chaque pression sur le bouton changement l'incrémente d'une minute. Si l'on appuie à nouveau sur mode, le réveil passe en mode de réglage de l'heure de sonnerie, avec un comportement similaire. Un nouvel appui sur mode fait repasser le réveil en mode d'affichage de l'heure.**

1. **(État simple)** Réaliser le diagramme d'états de ce réveil.
2. **(État avancé)** Faire évoluer le diagramme d'états pour représenter cette fonctionnalité.
3. **(Classes)** Réaliser le diagramme de classe de ce réveil, en détaillant la solution choisie.

## Exercice (Patrons fonctionnels)

**Les fonctions d’ordre suppérieur map, filter et fold (ou reduce) sont des patrons classiques des langages fonctionnels.**

Le **map** s'applique sur une liste (ou similaire) et la transforme par application d'une fonction. Par exemple, **map(f, [v1, v2, v3])** renvoie **[f(v1), f(v2), f(v3)]**. **filter** renvoie une nouvelle liste ne contenant que les éléments validant un prédicat. Ainsi, par exemple, **filter(isEven, [1, 2, 3, 4, 5])** renvoie **[2, 4]**. Enfin, le **fold** agrège les éléments d'une liste. Par exemple, **fold(add, 0, [1, 2, 3, 4, 5])** renvoie 15 et **fold(concat, "", ["a", "b", "c"])** renvoie "abc".

On souhaite implémenter une approche similaire en objet pur, par exemple en Java. Il faut de plus que la mise en œuvre proposée soit paresseuse (c'est-à-dire que les traitements ne soient appliqués que si nécessaire) et composable (on peut chainer plusieurs de ces opérations), comme c'est le cas en fonctionnel (par exemple **reduce(add, 0, map(double, filter(isEven, [1, 2, 3, 4, 5]))** donne 12).

1. **(2 pt)** Quels patrons de conception orientée objets classiques sont utiles pour modéliser ce système ?
2. **(3 pt)** Faire la représentation UML du diagramme de classe.
3. **(2 pt)** Donner le code Java correspondant.

## Exercice (4 pt)

On souhaite évaluer différents algorithmes pour une tâche donnée. On veut donc exécuter une série de traitement identique en mesurant les performances et les résultats, pour chacune de ces méthodes. Les paramètres d'exécution peuvent changer. Quels patrons sont utiles pour réaliser ce système ? Expliquer le fonctionnement de ces patrons et leur intérêt dans ce cas précis.

###Solution:
#### 1. Strategy Pattern (Patron de Stratégie)

**Fonctionnement :**
Le patron de stratégie permet de définir une famille d'algorithmes, de les encapsuler chacun dans des classes séparées, et de les rendre interchangeables. Ce patron permet de modifier l'algorithme utilisé indépendamment des clients qui l'utilisent.

**Intérêt :**
- **Flexibilité** : Permet de changer dynamiquement l'algorithme utilisé sans modifier le code du client.
- **Facilité de comparaison** : On peut facilement implémenter et comparer différentes stratégies (algorithmes) en changeant simplement l'objet stratégie.
- **Maintenabilité** : Sépare les différentes implémentations algorithmiques, ce qui simplifie la gestion et l’évolution du code.

#### 2. Template Method Pattern (Patron de Méthode Template)

**Fonctionnement :**
Le patron de méthode template définit le squelette d'un algorithme dans une méthode de base, laissant certaines étapes de l'algorithme à des sous-classes. Les sous-classes peuvent redéfinir certaines étapes de l'algorithme sans changer sa structure globale.

**Intérêt :**
- **Réutilisabilité** : Permet de réutiliser le squelette de l'algorithme tout en permettant des modifications dans les étapes spécifiques.
- **Consistance** : Garantit que la structure de l'algorithme reste cohérente, ce qui facilite la comparaison des performances et des résultats.
- **Centralisation** : Le squelette de l'algorithme est centralisé, ce qui simplifie les modifications globales.

#### 3. Factory Method Pattern (Patron de Méthode Fabrique)

**Fonctionnement :**
Le patron de méthode fabrique fournit une interface pour créer des objets dans une classe de base, mais laisse les sous-classes décider quelle classe instancier. Cela permet de différer l'instanciation à des sous-classes spécifiques.

**Intérêt :**
- **Création flexible** : Permet de créer des instances d'algorithmes de manière flexible et dynamique en fonction des paramètres d'exécution.
- **Encapsulation** : Encapsule le processus de création des algorithmes, ce qui facilite la gestion et le changement d'implémentations spécifiques.
- **Extensibilité** : Permet d'ajouter facilement de nouveaux algorithmes sans modifier le code existant.

#### 4. Observer Pattern (Patron d'Observateur)

**Fonctionnement :**
Le patron d'observateur définit une relation de dépendance un-à-plusieurs entre des objets, de sorte que lorsqu'un objet change d'état, tous ses dépendants en sont notifiés et mis à jour automatiquement.

**Intérêt :**
- **Réactivité** : Permet de suivre les performances et les résultats en temps réel et de notifier les composants concernés (comme une interface utilisateur ou un système de logs).
- **Découplage** : Découple le traitement des résultats et des performances de la logique de l'algorithme, ce qui rend le système plus modulaire et flexible.
- **Extensibilité** : Facile d'ajouter de nouveaux observateurs pour de nouvelles métriques ou des fonctionnalités supplémentaires.

#### Conclusion

L'utilisation combinée de ces patrons permet de créer un système flexible, modulaire et extensible pour évaluer différents algorithmes. Le **Strategy Pattern** et le **Template Method Pattern** sont particulièrement utiles pour structurer et comparer les différentes implémentations algorithmiques. Le **Factory Method Pattern** facilite la création dynamique des algorithmes, tandis que l'**Observer Pattern** permet de surveiller et de réagir aux résultats en temps réel.

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

### Patrons de conception nécessaires

#### Composite

- **Pourquoi** : Le patron Composite permet de représenter des structures hiérarchiques d'objets de manière à traiter de manière uniforme les objets simples (feuilles) et les compositions d'objets (nœuds). Cela est particulièrement utile pour représenter des arbres syntaxiques, où chaque nœud peut être une feuille ou un autre nœud contenant d'autres nœuds.
- **Ce qu'il apporte** : Il permet de construire une structure arborescente flexible et de traiter les nœuds et les feuilles de manière uniforme, facilitant ainsi les opérations telles que la traversée de l'arbre.

#### Visitor

- **Pourquoi** : Le patron Visitor permet de séparer l'algorithme de la structure de l'objet sur lequel il opère. Cela est utile pour effectuer différentes opérations (validation, compilation, pretty print) sur les éléments de l'arbre sans modifier les classes des éléments eux-mêmes.
- **Ce qu'il apporte** : Il permet d'ajouter de nouvelles opérations sur les éléments de l'arbre sans modifier les classes des éléments, rendant le système plus extensible et maintenable.

#### Factory Method

- **Pourquoi** : Le patron Factory Method permet de créer des objets sans spécifier la classe exacte de l'objet qui sera créé. Cela est utile pour la création des différents types d'éléments du langage (variables, opérateurs, boucles, etc.) de manière flexible.
- **Ce qu'il apporte** : Il permet d'instancier les objets de manière flexible et centralisée, facilitant ainsi l'ajout de nouveaux types d'éléments au langage.


