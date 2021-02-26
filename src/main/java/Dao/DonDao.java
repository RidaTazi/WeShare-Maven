package Dao;

import java.util.List;

import Entities.Association;
import Entities.Don;
import Entities.Donneur;
import Entities.Publication;

public interface DonDao {
	int createDon(Don d);
	int updateDon(Don p);
	int deleteDon(long id);
	Don findById(long id);
	List<Don> findByDonneur(Donneur donneur);
	List<Don> findByPublication(Publication pub);
	List<Don> findByAssociation(Association assoc);
	List<Don> findAll(); //a revoir (static)
}
