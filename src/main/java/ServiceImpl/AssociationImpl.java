package ServiceImpl;

import Dao.AssociationDao;
import DaoImpl.AssociationDaoImpl;
import Entities.Association;
import Service.IAssociation;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class AssociationImpl implements IAssociation {
    private AssociationDao associationDao;

    public AssociationImpl() {
        this.associationDao = new AssociationDaoImpl();
    }

    @Override
    public List<String> getAssociationsName() {
        List<String> list=new ArrayList<>();
        try {
            associationDao.getAll().forEach(association -> list.add(association.getNomAssoc()));
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Long deleteAssociation(Long id) {
        return null;
    }

    @Override
    public Long addAssociation(String data) {
        return null;
    }

    @Override
    public Long updateAssociation(String data) {
        return null;
    }

    @Override
    public Association getAssociationById(Long id) {
        try {
            return associationDao.getAssociationById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
