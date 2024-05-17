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
  
***Gestion des Statuts et de la Visibilité des Références:***

Nous allons utiliser le State Pattern pour gérer les statuts des références. Chaque référence peut être dans un état spécifique: Ouvert, Limité, Publique, ou Privé. Voici comment on peut implémenter cela:
```java
// Etat.java (interface)
public interface Etat {
    void ouvrir(Reference ref);
    void limiter(Reference ref);
    void rendrePublique(Reference ref);
    void rendrePrive(Reference ref);
}

// Ouvert.java (Concrete State)
public class Ouvert implements Etat {
    public void ouvrir(Reference ref) {
        // Already opened
    }
    public void limiter(Reference ref) {
        ref.setEtat(new Limite());
    }
    public void rendrePublique(Reference ref) {
        ref.setEtat(new Publique());
    }
    public void rendrePrive(Reference ref) {
        ref.setEtat(new Prive());
    }
}

// Limite.java (Concrete State)
public class Limite implements Etat {
    public void ouvrir(Reference ref) {
        ref.setEtat(new Ouvert());
    }
    public void limiter(Reference ref) {
        // Already limited
    }
    public void rendrePublique(Reference ref) {
        ref.setEtat(new Publique());
    }
    public void rendrePrive(Reference ref) {
        ref.setEtat(new Prive());
    }
}

// Publique.java (Concrete State)
public class Publique implements Etat {
    public void ouvrir(Reference ref) {
        ref.setEtat(new Ouvert());
    }
    public void limiter(Reference ref) {
        ref.setEtat(new Limite());
    }
    public void rendrePublique(Reference ref) {
        // Already public
    }
    public void rendrePrive(Reference ref) {
        ref.setEtat(new Prive());
    }
}

// Prive.java (Concrete State)
public class Prive implements Etat {
    public void ouvrir(Reference ref) {
        ref.setEtat(new Ouvert());
    }
    public void limiter(Reference ref) {
        ref.setEtat(new Limite());
    }
    public void rendrePublique(Reference ref) {
        ref.setEtat(new Publique());
    }
    public void rendrePrive(Reference ref) {
        // Already private
    }
}

// Reference.java (Context)
public class Reference {
    private String identifiant;
    private String auteur;
    private String titre;
    private ZonedDateTime date;
    private String description;
    private Etat etat;

    public Reference() {
        this.etat = new Prive(); // Default state
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void ouvrir() {
        etat.ouvrir(this);
    }

    public void limiter() {
        etat.limiter(this);
    }

    public void rendrePublique() {
        etat.rendrePublique(this);
    }

    public void rendrePrive() {
        etat.rendrePrive(this);
    }

    // Other attributes and methods...
}
```
***Fonctionnalités d'Import-Export de Différents Formats:***

Nous allons utiliser le Strategy Pattern pour permettre l'import-export de différents formats de données. Voici une implémentation en Java pour les stratégies CSV et XML:
```java
// ImportExportStrategy.java (interface)
public interface ImportExportStrategy {
    void importData(String data);
    String exportData();
}

// CSVStrat.java (Concrete Strategy)
public class CSVStrat implements ImportExportStrategy {
    public void importData(String data) {
        // Implement CSV import logic
    }

    public String exportData() {
        // Implement CSV export logic
        return "CSV data";
    }
}

// XMLStrat.java (Concrete Strategy)
public class XMLStrat implements ImportExportStrategy {
    public void importData(String data) {
        // Implement XML import logic
    }

    public String exportData() {
        // Implement XML export logic
        return "XML data";
    }
}

// Reference.java (Context updated with strategy)
public class Reference {
    private String identifiant;
    private String auteur;
    private String titre;
    private ZonedDateTime date;
    private String description;
    private Etat etat;
    private ImportExportStrategy importExportStrategy;

    public Reference() {
        this.etat = new Prive(); // Default state
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setImportExportStrategy(ImportExportStrategy strategy) {
        this.importExportStrategy = strategy;
    }

    public void ouvrir() {
        etat.ouvrir(this);
    }

    public void limiter() {
        etat.limiter(this);
    }

    public void rendrePublique() {
        etat.rendrePublique(this);
    }

    public void rendrePrive() {
        etat.rendrePrive(this);
    }

    public void importData(String data) {
        if (importExportStrategy != null) {
            importExportStrategy.importData(data);
        }
    }

    public String exportData() {
        if (importExportStrategy != null) {
            return importExportStrategy.exportData();
        }
        return null;
    }

    // Other attributes and methods...
}
```


