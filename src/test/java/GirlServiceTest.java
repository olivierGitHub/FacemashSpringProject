import com.oliver.girl.service.GirlServiceImpl;
import com.oliver.girl.util.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


/**
 * Created by oliver on 08/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/GirlServiceTest-context.xml" })
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class GirlServiceTest {


    @Test
    public void shouldCalculateRateOfGirlA(){

        Girl girlA = new Girl();
            girlA.setRate(100.0);
        Girl girlB = new Girl();
            girlB.setRate(50.0);

        GirlServiceImpl girlService = new GirlServiceImpl();
        Double winningRate = girlService.calculateEloRate(girlA,girlB);

        Assert.assertEquals(0.57,winningRate,0.01);

    }

    @Test
    public void shouldCalculateRateOfWinningGirlAOnly(){

        Girl girlA = new Girl();
            girlA.setVictorious(true);
            girlA.setRate(100.0);
        Girl girlB = new Girl();
            girlB.setVictorious(false);
            girlB.setRate(50.0);

        GirlServiceImpl girlService = new GirlServiceImpl();
        Girl winner = girlService.getWinningGirl(girlA, girlB);

        girlA.setRate(0.57);

        Assert.assertEquals(girlA.getRate(),winner.getRate(),0.01);
        Assert.assertFalse(winner.getVictorious());
        Assert.assertEquals(50.0,girlB.getRate(),0.01);
    }

    @Test
    public void shouldCalculateRateOfWinningGirlBOnly(){

        Girl girlA = new Girl();
            girlA.setVictorious(false);
            girlA.setRate(100.0);
        Girl girlB = new Girl();
            girlB.setVictorious(true);
            girlB.setRate(50.0);

        GirlServiceImpl girlService = new GirlServiceImpl();
        Girl winner = girlService.getWinningGirl(girlA, girlB);

        girlB.setRate(0.43);

        Assert.assertEquals(girlB.getRate(),winner.getRate(),0.01);
        Assert.assertFalse(winner.getVictorious());
        Assert.assertEquals(100.0,girlA.getRate(),0.01);
    }


}
