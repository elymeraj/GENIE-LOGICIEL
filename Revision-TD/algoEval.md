## Exercice (Évaluation d'algorithmes)

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

