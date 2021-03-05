package Dao;

import Entities.Association;

import java.sql.SQLException;
import java.util.List;

public interface AssociationDao 
{
    int createAssociation(Association association) throws SQLException;
    boolean updateAssociation(Long id, Association association) throws SQLException;
    boolean deleteAssociation(Long id) throws SQLException;
    Association getAssociationById(Long id) throws SQLException;
    List<Association> getAll() throws SQLException;
}