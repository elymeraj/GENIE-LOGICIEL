## Exercice (Patrons fonctionnels)

**Les fonctions d’ordre suppérieur map, filter et fold (ou reduce) sont des patrons classiques des langages fonctionnels.**

Le **map** s'applique sur une liste (ou similaire) et la transforme par application d'une fonction. Par exemple, **map(f, [v1, v2, v3])** renvoie **[f(v1), f(v2), f(v3)]**. **filter** renvoie une nouvelle liste ne contenant que les éléments validant un prédicat. Ainsi, par exemple, **filter(isEven, [1, 2, 3, 4, 5])** renvoie **[2, 4]**. Enfin, le **fold** agrège les éléments d'une liste. Par exemple, **fold(add, 0, [1, 2, 3, 4, 5])** renvoie 15 et **fold(concat, "", ["a", "b", "c"])** renvoie "abc".

On souhaite implémenter une approche similaire en objet pur, par exemple en Java. Il faut de plus que la mise en œuvre proposée soit paresseuse (c'est-à-dire que les traitements ne soient appliqués que si nécessaire) et composable (on peut chainer plusieurs de ces opérations), comme c'est le cas en fonctionnel (par exemple **reduce(add, 0, map(double, filter(isEven, [1, 2, 3, 4, 5]))** donne 12).

1. **(2 pt)** Quels patrons de conception orientée objets classiques sont utiles pour modéliser ce système ?
1. **Patron Template Method ou Stratégie :**
   - **Template Method** : Ce patron permet de définir le squelette d'un algorithme dans une méthode, en laissant la définition de certaines étapes aux sous-classes. Ici, il pourrait être utilisé pour définir la structure des opérations `map`, `filter` et `fold`, laissant les sous-classes spécifier les détails de chaque opération.
   - **Stratégie** : Ce patron permet d'encapsuler des algorithmes interchangeables dans des classes distinctes. Il peut être utilisé pour définir des stratégies différentes pour les opérations `map`, `filter` et `fold`, et pour permettre de les appliquer de manière interchangeable sur les éléments de la collection.

2. **Patron Décorateur :**
   - Le décorateur permet d’ajouter dynamiquement des responsabilités à un objet. Dans ce contexte, il peut être utilisé pour enchaîner les transformations sans modifier les objets de base. Par exemple, on pourrait décorer une collection avec des comportements `map`, `filter`, et `fold` successifs, permettant de construire une chaîne de transformations.

3. **Patron Itérateur :**
   - L'itérateur permet de parcourir les éléments d'une collection sans exposer sa représentation interne. Ce patron est crucial pour implémenter des traitements paresseux, car il permet de traiter les éléments un par un à la demande. Chaque transformation (`map`, `filter`) peut être vue comme un itérateur qui applique l'opération lors de l'itération.

4. **Patron Builder :**
   - Si on souhaite fournir une API fluide (fluente) pour enchaîner les opérations, le patron Builder peut être utilisé. Il permet de construire un objet complexe étape par étape. Dans ce cas, chaque étape de construction peut représenter une opération (map, filter, reduce), facilitant ainsi la composition et l'enchaînement de ces opérations.

5. **Patron Adaptateur :**
   - L'adaptateur permet de convertir une interface en une autre interface attendue par un client. Dans ce cas, un adaptateur peut être utilisé pour ajouter des méthodes `map`, `filter`, `reduce` à une collection existante, telle qu'une `List`, sans modifier sa structure initiale.

3. **(3 pt)** Faire la représentation UML du diagramme de classe.
4. **(2 pt)** Donner le code Java correspondant.
