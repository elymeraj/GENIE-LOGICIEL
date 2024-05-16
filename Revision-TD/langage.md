## Exercice (Langage)

On cherche à représenter un programme dans un langage simple sous la forme d'un arbre. Chaque élément de l'arbre représente un élément du langage. On dispose donc de différents types de feuilles (les valeurs littérales, les variables) et de différents types de nœuds (opérateurs, déclarations, boucles, branches conditionnelles, etc.)

Le langage est simple, et ne dispose que d'une boucle **while**, d'une branche conditionnelle (**if then else**), des types primitifs **int**, **string**, et **bool** avec les opérateurs classiques associés, de tableaux, et de l'affectation de valeur à une variable.

Par ailleurs, différentes opérations devront être effectuées sur cette structure, comme par exemple en vérifier la validité, la convertir en code bas niveau (compilation), ou l'afficher sous la forme de code source correctement formaté (**pretty print**).

1. **(3 pt)** Quels patrons de conceptions seront nécessaires à cette mise en œuvre ? Pourquoi ? Qu'apportent-ils ?
2. **(3 pt)** Donnez une ébauche de représentation UML statique et dynamique de ce système.

## Patrons de conception nécessaires

Pour la mise en œuvre d'un programme représenté sous forme d'arbre avec les opérations associées, plusieurs patrons de conception peuvent être utilisés. Voici les plus pertinents et leur justification :

### Composite Pattern (Patron Composite)

**Pourquoi** : Le patron Composite permet de composer des objets en structures arborescentes pour représenter des hiérarchies de type partie-tout. Il permet aux clients de manipuler les objets individuels et les compositions de manière uniforme.

**Apport** : Simplifie la manipulation des structures complexes (comme un arbre syntaxique) en traitant les objets composites (comme les nœuds) et les objets primitifs (comme les feuilles) de la même manière.

### Visitor Pattern (Patron Visiteur)

**Pourquoi** : Le patron Visitor permet de séparer un algorithme de la structure de l'objet sur lequel il opère. Ceci est particulièrement utile pour les opérations comme la vérification de la validité, la compilation et le pretty-printing.

**Apport** : Facilite l'ajout de nouvelles opérations sans modifier les classes des éléments sur lesquels elles opèrent, en définissant un nouveau visiteur pour chaque nouvelle opération.

## Explication du diagramme UML:
- 1. La classe Noeud est une classe de base pour tous les éléments de l'arbre syntaxique.
- 2. Les classes Valeurs et Variables héritent de Noeud et représentent les feuilles de l'arbre.
- 3. La classe Composite représente les nœuds composés et contient une liste de nœuds enfants.
- 4. Les classes While, Operation, Condition, et Loop héritent de Composite et représentent les différentes structures de contrôle et opérations.
- 5. La classe Visiteur définit les méthodes visit pour chaque type de Noeud, et les classes CompileVisitor, PrettyPrintVisitor, et ValidationVisitor héritent de Visiteur pour implémenter des comportements spécifiques.




