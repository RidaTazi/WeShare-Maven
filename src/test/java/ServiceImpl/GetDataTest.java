package ServiceImpl;


import Dao.AssociationDao;
import Dao.DonneurDAO;
import DaoImpl.AssociationDaoImpl;
import DaoImpl.DonneurDaoImpl;
import Entities.Association;
import Entities.Donneur;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetDataTest {
    @Test
    public void getDonneurByIdTest(){
        final DonneurDaoImpl donneurDAOimpl = new DonneurDaoImpl();
        Long id = 28L;
        Donneur result = donneurDAOimpl.getDonneurById(id);
        assertEquals(id,result.getIdDonneur());
    }
    @Test
    public void getAssociationByIdTest(){
        final AssociationDaoImpl associationDAOimpl = new AssociationDaoImpl();
        Long id = 6L;
        Association result = associationDAOimpl.getAssociationById(id);
        assertEquals(id,result.getIdAssoc());
    }

}
