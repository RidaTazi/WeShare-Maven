package DaoImpl;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

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
		List<Don> list ;
		
		assertEquals(1,donDao.createDon(don));        // createDao returns the number of rows processed
		
		//retrieve and update
			 
		list = donDao.findAll();              // retrieve 
		don = list.get(list.size()-1);
		
		assertEquals("ceci est une description",don.getDesc());
		
		don.setType("argent");
		assertEquals(1,donDao.updateDon(don));  
		
		don = donDao.findById(don.getiD());
		
		assertEquals("argent",don.getType()); // to make sure 
		
		// delete 
		
		assertEquals(1,donDao.deleteDon(don.getiD()));
		assertEquals(list.size() - 1, donDao.findAll().size());
		
	}
}
