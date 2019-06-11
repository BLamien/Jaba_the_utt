package com.sdz.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <b>Classe mere DAO</b>
 * @param <T> type que va prendre les differentes DAO
 */
public abstract class DAO<T> {
    protected Connection connect;

    /**
     * <b>COnstructeur par defaut</b>
     */
    public DAO(){
        this.connect = null;
    }

    /**
     * Méthode de mise à jour
     * @param obj objet contenant les parametres  a mettre a jour
     */
    public abstract void update(T obj);

    /**
     * Méthode de recherche des informations et de connexion
     * @param id ID permettant de selectionner l'item souhaite dans la table
     * @return T objet de type T
     * @throws SQLException exception
     */
    public abstract T Connection(int id) throws SQLException;
}