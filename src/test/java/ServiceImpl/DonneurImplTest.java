package ServiceImpl;

import Dao.DonneurDAO;
import DaoImpl.DonneurDaoImpl;
import Service.IDonneur;
import Web.DonneurController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;


@RunWith(Arquillian.class)
public class DonneurImplTest {
    @Inject
    private IDonneur idonneur;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(DonneurImpl.class, DonneurDAO.class, DonneurController.class,DonneurDaoImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void getDonneurById() {

    }
}
