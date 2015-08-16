package com.oliver.girl.service;

import com.oliver.girl.util.entity.Girl;

/**
 * Created by oliver on 16/08/15.
 */
public interface GirlService {

    public Girl getWinningGirl(Girl girlA, Girl girlB);

    public double calculateEloRate(Girl girlA, Girl girlB);
}
