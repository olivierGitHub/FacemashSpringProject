import com.oliver.girl.dao.GirlDao;
import com.oliver.girl.dao.GirlDaoImpl;
import com.oliver.girl.util.entity.Girl;

/**
 * Created by oliver on 08/08/15.
 */
public class TestDao {

    public static void main(String[] args){
        Girl girl = new Girl();
            girl.setName("essai22");
            girl.setPath("essai22");
            girl.setRate(35.2);
            girl.setVictorious(false);

        GirlDao girlDao = new GirlDaoImpl();
        Girl retrieved = girlDao.read(2);

        System.out.println(retrieved.getName());


    }

}