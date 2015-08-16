package com.oliver.girl.service;

import com.oliver.girl.util.entity.Girl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by oliver on 08/08/15.
 */

@Component
public class GirlServiceImpl implements GirlService{

    @Override
    public Girl getWinningGirl(Girl girlA, Girl girlB) {
        if (girlA.getVictorious()){
            girlA.setRate(calculateEloRate(girlA,girlB));
            girlA.setVictorious(false);
            return girlA;
        }else {
            girlB.setRate(calculateEloRate(girlB,girlA));
            girlB.setVictorious(false);
            return girlB;
        }
    }

    @Override
    public double calculateEloRate(Girl girlA, Girl girlB) {
        double deltaRate = girlB.getRate() - girlA.getRate();
        double estimatedRate = 1 / (1 + Math.pow(10, deltaRate/400));
        return estimatedRate;
    }
}
