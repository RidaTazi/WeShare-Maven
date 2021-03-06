package Dao;

import java.sql.SQLException;
import java.util.List;

import Entities.*;

public interface DonDao {
	int createDon(Don d);
	int addDon(Don don);
	int updateDon(Don p);
	int deleteDon(long id);
	Don findById(long id);
	List<Don> findByDonneur(Donneur donneur);
	List<Don> findByPublication(Publication pub);
	List<Don> findByAssociation(MembreAssociation membreAssociation);
	List<Don> findAll(); //a revoir (static)
	long acceptDon(long id);
	long refuseDon(long id);
	Long idAssociationFromIdPub(Long id) throws SQLException;

}
