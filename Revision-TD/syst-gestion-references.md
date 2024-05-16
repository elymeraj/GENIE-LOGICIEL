## Exercice (Système de gestion de références):
On se propose ici de modéliser un système de gestion de références bibliographiques sous forme de service web. L’objectif est de permettre une gestion homogène des différents types de références dans un système accessible facilement depuis un poste client, tout en maintenant une intégration possible avec différents systèmes existants.

Les fonctionnalités sont les suivantes :

- Intégration possible avec différents systèmes existants : fonctions d’import/export des données, interfaçage, etc.
- Architecture en service web avec possibilité de travail déconnecté
- Système collaboratif : gestion des utilisateurs, droits d'accès
- Classification et recherche des références par des mots-clés, hiérarchisés par thèmes
- Notation des références (évaluation sur 5) et commentaires éventuels pour les utilisateurs enregistrés

Lors de la saisie d'une référence, un utilisateur peut décider si elle est ouverte (visible par tout le monde et modifiable par tout utilisateur enregistré) : publique, et donc visible par tout le monde ; limitée, c'est-à-dire visible uniquement par ses amis ; ou privée, et donc accessible uniquement par lui.

On peut avoir différents types de références, comme des livres, des articles, des sites web, etc. Une référence a au moins un identifiant, un auteur, un titre, une date et une description. Selon le type, on peut ensuite avoir différentes données. Ainsi, un livre ou un journal va avoir un nombre de pages, un éditeur, un ISBN. Un journal peut avoir de plus un numéro. Pour un article, ou un chapitre de livre, on spécifie les pages où ils apparaissent, ainsi qu'une référence vers l'ouvrage d'origine. Les sites web enfin ont une adresse (URL).

Au niveau interface, on veut suggérer aux utilisateurs enregistrés d'évaluer les références qui n'ont plus ou peu été notées. Par défaut, les dernières références ouvertes et publiques sont affichées.

### Question 1 (Diagramme de classe) (3 pts)
Réaliser un diagramme de classe du système, à un niveau conceptuel.

### Question 2 (Diagramme d'état) : (3 pts)
Analyser les différents états d'une référence, et les représenter sous forme de diagramme d'état.

### Question 3 (Détails des classes) : (4 pts)
Détaillez au niveau implémentation :
- La gestion des statuts et de la visibilité des références
- Les fonctionnalités d'import-export de différents formats


