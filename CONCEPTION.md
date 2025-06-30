# Document de Conception - Service Bancaire

## 1. Introduction

Ce document présente la conception logicielle de l'application "Service Bancaire". L'objectif est de détailler les choix d'architecture et de modélisation qui structurent le projet, en s'appuyant sur les diagrammes UML pour illustrer la vision fonctionnelle et technique.

## 2. Conception Fonctionnelle : Cas d'Utilisation

L'analyse fonctionnelle s'est concentrée sur les interactions de l'utilisateur final (le Client) avec le système. Le diagramme de cas d'utilisation suivant synthétise les fonctionnalités offertes.

![Diagramme de Cas d'Utilisation](https://storage.googleapis.com/project-os-stor/images/b2c019d6-5381-420d-b220-410a56d814be.png)

### Acteurs

*   **Client** : L'unique acteur du système. Il représente l'utilisateur qui souhaite gérer son compte bancaire.

### Cas d'utilisation

1.  **Effectuer un dépôt** : Permet au client de créditer une somme d'argent sur son compte.
2.  **Effectuer un retrait** : Permet au client de débiter une somme d'argent de son compte. La validité de l'opération est soumise à la vérification du solde.
3.  **Afficher le relevé du compte** : Permet au client de consulter l'historique de ses transactions.
4.  **Annuler l'opération** : Ce cas d'utilisation *étend* les fonctionnalités de dépôt et de retrait. Il offre au client la possibilité d'interrompre l'opération en cours, ce qui reflète une exigence de flexibilité de l'interface utilisateur.

## 3. Conception Technique : Diagramme de Classes

La conception technique s'appuie sur une approche orientée objet. Le diagramme de classes ci-dessous modélise la structure statique du système.

![Diagramme de Classes](https://storage.googleapis.com/project-os-stor/images/15479427-463f-4e02-9ca9-25f0a82b3c2d.png)

### Description des Composants

*   **`AccountService` (Interface)** :
    *   **Rôle** : Définit le contrat des fonctionnalités d'un compte bancaire. Elle assure un couplage faible entre l'interface utilisateur et l'implémentation de la logique métier.
    *   **Méthodes** : `deposit()`, `withdraw()`, `printStatement()`.

*   **`Account` (Classe)** :
    *   **Rôle** : Implémente l'interface `AccountService`. C'est le cœur de la logique métier. Elle gère le solde et l'historique des transactions.
    *   **Attributs** : `balance`, `transactions`.
    *   **Relation** : Elle *implémente* `AccountService` et est en relation de *composition* avec `Transaction`.

*   **`Transaction` (Classe)** :
    *   **Rôle** : C'est une classe de type "Modèle" qui représente une opération de crédit ou de débit. Elle stocke les informations immuables d'une transaction passée.
    *   **Attributs** : `date`, `amount`, `balance`.

### Relations entre les classes

*   **Implémentation (`Account` -> `AccountService`)**: `Account` fournit une implémentation concrète pour les opérations définies dans `AccountService`.
*   **Composition (`Account` -> `Transaction`)**: La relation entre `Account` et `Transaction` est une composition (losange plein). Un compte "possède" ses transactions. Si le compte est supprimé, toutes les transactions associées le sont aussi. La multiplicité `0..*` indique qu'un compte peut avoir de zéro à plusieurs transactions.

## 4. Architecture Logique

Le projet est structuré en trois packages distincts pour respecter le principe de séparation des préoccupations :

*   `ui` : Contient la classe `Main`, responsable de toute l'interaction avec l'utilisateur (présentation et saisie).
*   `service` : Contient l'interface `AccountService` et son implémentation `Account`. Ce package renferme toute la logique métier de l'application.
*   `model` : Contient la classe `Transaction`, qui représente le modèle de données de l'application.

Cette architecture simple facilite la maintenance et l'évolutivité du code. Par exemple, on pourrait remplacer l'interface en ligne de commande (`ui`) par une interface graphique sans impacter le package `service`. 