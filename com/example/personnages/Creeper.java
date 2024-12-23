package com.example.personnages;

import com.example.LogInit;
import com.example.ennemis.Ennemis;

/**
 * La classe Creeper représente un personnage dans le jeu.
 * Elle implémente l'interface Personnage.
 */
public class Creeper implements Personnage {
    private int PV;
    private int force;
    private String nom;
    public boolean capaciteUtilisee;
    public int esquive = 0;

    /**
     * Construit un nouveau Creeper avec le nom spécifié.
     *
     * @param nom le nom du Creeper
     */
    public Creeper(String nom) {
        this.nom = nom;
        this.PV = 150;
        this.force = 15;
        this.capaciteUtilisee = false;
    }

    /**
     * Construit un nouveau Creeper avec le nom, la force et les PV spécifiés.
     *
     * @param nom   le nom du Creeper
     * @param force la force du Creeper
     * @param PV    les PV (points de vie) du Creeper
     */
    public Creeper(String nom, int force, int PV) {
        this.nom = nom;
        this.PV = PV;
        this.force = force;
        this.capaciteUtilisee = false;
    }

    /**
     * Obtient le nom du Creeper.
     *
     * @return le nom du Creeper
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Obtient les PV (points de vie) du Creeper.
     *
     * @return les PV du Creeper
     */
    @Override
    public int getPV() {
        return PV;
    }

    /**
     * Définit les PV (points de vie) du Creeper.
     *
     * @param PV les nouveaux PV du Creeper
     */
    @Override
    public void setPV(int PV) {
        this.PV = PV;
    }

    @Override
    public int getEsquive() {
        return 0;
    }

    @Override
    public void setEsquive(int esquive) {

    }

    /**
     * Utilise la capacité spéciale du Creeper.
     * Cette capacité définit la force à la valeur maximale.
     */
    @Override
    public void utiliserCapaciteSpeciale() {
        System.out.println(nom + " utilise sa capacité spéciale : Explosion !");
        this.force = Integer.MAX_VALUE;
    }

    /**
     * Obtient la force du Creeper.
     *
     * @return la force du Creeper
     */
    public int getForce() {
        return force;
    }

    /**
     * Réinitialise l'état d'utilisation de la capacité spéciale du Creeper.
     */
    @Override
    public void resetCapaciteUtilisee() {
        this.capaciteUtilisee = false;
    }

    /**
     * Vérifie si la capacité spéciale a été utilisée.
     *
     * @return true si la capacité spéciale a été utilisée, false sinon
     */
    @Override
    public boolean isCapaciteUtilisee() {
        return capaciteUtilisee;
    }

    /**
     * Utilise la capacité spéciale du Creeper, qui One Shot les ennemis.
     *
     * @param ennemi l'ennemi à attaquer
     * @param logInit les logs du jeu
     */

    @Override
    public void utiliserCapacite(Ennemis ennemi, LogInit logInit) {
        if (!capaciteUtilisee) {
            logInit.logMaker(nom + " utilise sa capacité spéciale : Explosion !");
            ennemi.setPV(0);
            this.capaciteUtilisee = true;
        } else {
            System.out.println(nom + " a déjà utilisé sa capacité spéciale.");
        }
    }
}