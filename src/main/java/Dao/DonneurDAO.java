package Dao;

import Entities.Donneur;

import java.sql.SQLException;
import java.util.List;

public interface DonneurDAO {
    int createDonneur(Donneur donneur) throws SQLException;
    boolean updateDonneur(Long id, Donneur donneur) throws SQLException;
    boolean deleteDonneur(Long id) throws SQLException;
    Donneur getDonneurById(Long id) throws SQLException;
    List<Donneur> getAllDonneur() throws SQLException;
}
