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
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche des informations et de connexion
     * @param id
     * @return T
     */
    public abstract T Connection(int id) throws SQLException;
}