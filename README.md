# Projet de Service Bancaire

Ce projet est une simulation simple d'un service bancaire en ligne de commande, développé en Java. Il a été réalisé dans le cadre d'un test technique pour démontrer les compétences en développement logiciel, incluant la conception orientée objet, la gestion des exceptions et les tests unitaires.

## Table des matières
- [Fonctionnalités](#fonctionnalités)
- [Technologies](#technologies)
- [Structure du projet](#structure-du-projet)
- [Documentation](#documentation)
- [Installation et Lancement](#installation-et-lancement)
- [Lancer les tests](#lancer-les-tests)

## Fonctionnalités

Cette application vous permet de gérer un compte bancaire simple directement depuis votre terminal. Vous pouvez facilement :
*   **Déposer de l'argent** sur votre compte.
*   **Effectuer des retraits**, avec une vérification pour s'assurer que votre solde est suffisant.
*   **Consulter un relevé détaillé** de toutes vos transactions, affichant la date, le montant et le solde pour chaque opération.

## Technologies

Pour réaliser ce projet, les technologies suivantes ont été mises à contribution :
*   **Langage :** Java (JDK 17)
*   **Tests :** JUnit 5 (Jupiter)
*   **IDE (recommandé) :** IntelliJ IDEA ou Eclipse pour un développement et des tests facilités.

## Structure du projet

Le code source est structuré de manière à séparer clairement les différentes parties de l'application :

```
.
├── doc/                  # Documentation Javadoc générée
├── src/                  # Fichiers source
│   ├── model/
│   │   └── Transaction.java  # Le modèle de données pour une transaction
│   ├── service/
│   │   ├── Account.java      # L'implémentation de la logique du compte
│   │   └── AccountService.java # L'interface définissant les actions possibles
│   └── ui/
│       └── Main.java         # Le point d'entrée de l'application et son interface console
├── test/                 # Fichiers de test
│   └── service/
│       └── AccountTest.java  # Tests unitaires pour la logique du compte
└── README.md             # Ce fichier
```

## Documentation

Le projet inclut une documentation Javadoc complète pour toutes les classes et méthodes publiques. Vous pouvez la consulter pour obtenir des détails sur l'implémentation.

Pour y accéder, il suffit d'ouvrir le fichier `doc/index.html` dans votre navigateur web préféré.

## Installation et Lancement

### Prérequis
-   Java Development Kit (JDK) 17 ou plus récent.
-   Git pour cloner le dépôt.

### Compilation
1.  Depuis votre terminal, naviguez à la racine du projet.
2.  Pour compiler le projet, utilisez la commande :
    ```bash
    javac -d out src/model/*.java src/service/*.java src/ui/*.java
    ```
    Cette commande placera les fichiers `.class` compilés dans le dossier `out`.

### Lancement de l'application

Une fois les fichiers compilés, vous pouvez lancer l'application avec :
```bash
java -cp out ui.Main
```
L'interface de la banque se lancera dans votre terminal.

## Lancer les tests

Les tests unitaires (basés sur JUnit 5) sont un bon moyen de vérifier que tout fonctionne comme prévu. La manière la plus simple de les lancer est depuis votre IDE (IntelliJ, Eclipse, etc.).

1.  Ouvrez le projet dans votre IDE préféré.
2.  Assurez-vous que la bibliothèque JUnit 5 est bien configurée pour le projet.
3.  Localisez le fichier `test/service/AccountTest.java`.
4.  Faites un clic droit sur ce fichier et choisissez l'option pour exécuter les tests (ex: "Run 'AccountTest'").

Les résultats s'afficheront directement dans votre IDE.

