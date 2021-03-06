package Dao;

import java.util.List;

import Entities.*;

public interface DonDao {
	int createDon(Don d);
	int updateDon(Don p);
	int deleteDon(long id);
	Don findById(long id);
	List<Don> findByDonneur(Donneur donneur);
	List<Don> findByPublication(Publication pub);
	List<Don> findByAssociation(MembreAssociation membreAssociation);
	List<Don> findAll(); //a revoir (static)
	long acceptDon(long id);
	long refuseDon(long id);
}
