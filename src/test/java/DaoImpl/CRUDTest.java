package DaoImpl;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import Dao.DonDao;
import DaoImpl.DonDaoImpl;
import Entities.Don;
import Entities.Donneur;

public class CRUDTest {
	

	

	@Test
	public void DonCRUDTest()
	{
		DonDao donDao = new DonDaoImpl();
		// create
		String type = "vêtements";
		String logo = "image.jpg";
		String desc = "ceci est une description";
		String state = "attente";
		Donneur donneur = new Donneur();
		donneur.setIdDonneur(Long.valueOf(1));
		Don don = new Don(type, logo, desc, state, donneur);
		
		assertEquals(1,donDao.createDon(don));        // createDao returns the number of rows processed
		
		//retrieve and update
		
		assertEquals(1,donDao.findAll().size());    // make sure the only Don is retrieved 
		don = donDao.findAll().get(0);              // retrieve the only Don
		
		don.setType("nouveau type");
		assertEquals(1,donDao.updateDon(don));  
		
		don = donDao.findAll().get(0);
		
		assertEquals("nouveau type",don.getType()); // to make sure 
		
		// delete 
		
		assertEquals(1,donDao.deleteDon(don.getiD()));
		assertEquals(0, donDao.findAll().size());
		
	}
}
