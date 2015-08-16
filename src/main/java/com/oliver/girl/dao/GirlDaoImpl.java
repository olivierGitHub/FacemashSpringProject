package com.oliver.girl.dao;

import com.oliver.common.AbstractDao;
import com.oliver.girl.util.entity.Girl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by oliver on 08/08/15.
 */
@Repository
@Scope("singleton")
public class GirlDaoImpl extends AbstractDao<Girl,Integer> implements GirlDao{



}
