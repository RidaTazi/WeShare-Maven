package Dao;

import Entities.MembreAssociation;

import java.sql.SQLException;

public interface MembreDao {
    boolean createMembreAssoc(MembreAssociation membre) throws SQLException;
    Long updateMembreAssoc(MembreAssociation membre) throws SQLException;
    MembreAssociation getMembreById(Long id)  throws SQLException;
}
