package ui;

import service.Account;
import service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountService account = new Account();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBienvenue à la banque !");
            System.out.println("1. Dépôt");
            System.out.println("2. Retrait");
            System.out.println("3. Voir relevé");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            String input = scanner.nextLine().trim();
            int choix;
            try {
                choix = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre valide (1 à 4).");
                continue;
            }

            switch (choix) {
                case 1 -> {
                    System.out.print("Montant à déposer (ou tapez Q pour annuler) : ");
                    String depInput = scanner.nextLine().trim();
                    if (depInput.equalsIgnoreCase("q")) {
                        System.out.println("Dépôt annulé.");
                        break;
                    }
                    try {
                        int montant = Integer.parseInt(depInput);
                        account.deposit(montant);
                        System.out.println("Dépôt de " + montant + " MAD effectué avec succès.");
                    } catch (NumberFormatException e) {
                        System.out.println(" Montant invalide.");
                    }
                }

                case 2 -> {
                    System.out.println("Choisissez un montant à retirer :");
                    System.out.println("1. 100 MAD");
                    System.out.println("2. 200 MAD");
                    System.out.println("3. 400 MAD");
                    System.out.println("4. 500 MAD");
                    System.out.println("5. 1000 MAD");
                    System.out.println("6. 2000 MAD");
                    System.out.println("7. Autre montant");
                    System.out.print("Votre choix (ou Q pour annuler) : ");

                    String retraitInput = scanner.nextLine().trim();
                    if (retraitInput.equalsIgnoreCase("q")) {
                        System.out.println(" Retrait annulé.");
                        break;
                    }

                    int montant = -1;
                    try {
                        int option = Integer.parseInt(retraitInput);

                        if (option >= 1 && option <= 7) {
                            switch (option) {
                                case 1 -> montant = 100;
                                case 2 -> montant = 200;
                                case 3 -> montant = 400;
                                case 4 -> montant = 500;
                                case 5 -> montant = 1000;
                                case 6 -> montant = 2000;
                                case 7 -> {
                                    System.out.print("Entrez votre propre montant (ou Q pour annuler) : ");
                                    String customInput = scanner.nextLine().trim();
                                    if (customInput.equalsIgnoreCase("q")) {
                                        System.out.println("Retrait annulé.");
                                        break;
                                    }
                                    montant = Integer.parseInt(customInput);
                                }
                            }
                        } else {
                            montant = option;
                        }

                        if (montant > 0) {
                            account.withdraw(montant);
                            if (((Account) account).wasLastWithdrawSuccessful()) {
                                System.out.println(" Retrait de " + montant + " MAD effectué avec succès.");
                            }

                        }

                    } catch (NumberFormatException e) {
                        System.out.println(" Entrée invalide. Veuillez entrer un numéro entre 1 et 7 ou un montant.");
                    }
                }





                case 3 -> account.printStatement();
                case 4 -> {
                    System.out.println("Merci d'avoir utilisé notre banque !");
                    break;
                }
                default -> System.out.println("Choix invalide.");
            }

            if (choix == 4) break;
        }

        scanner.close();
    }
}
