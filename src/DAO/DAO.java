package com.sdz.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO<T> {
    protected Connection connect;

    public DAO(){
        this.connect = null;
    }

    /**
     * Méthode de création
     * @param obj
     */
    public abstract void create(T obj);

    /**
     * Méthode pour effacer
     * @param obj
     */
    public abstract void delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     */
    public abstract void update(T obj);

    /**
     * Méthode de recherche des informations et de connexion
     * @param id
     * @return T
     */
    public abstract T Connection(int id) throws SQLException;
}