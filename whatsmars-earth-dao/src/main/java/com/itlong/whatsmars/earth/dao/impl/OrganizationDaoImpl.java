package com.itlong.whatsmars.earth.dao.impl;

import com.itlong.whatsmars.earth.dao.OrganizationDao;
import com.itlong.whatsmars.earth.domain.pojo.OrganizationDO;
import com.itlong.whatsmars.earth.domain.query.OrganizationQuery;
import com.itlong.whatsmars.earth.domain.query.QueryResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by shenhongxi on 2016/4/6.
 */
public class OrganizationDaoImpl extends BaseDao implements OrganizationDao {
    @Override
    public QueryResult<OrganizationDO> query(OrganizationQuery query) {
        QueryResult<OrganizationDO> qr = new QueryResult<OrganizationDO>();
        qr.setQuery(query);

        Map<String,Object> params = query.build();
        int amount = this.countAll(params);
        qr.setAmount(amount);
        if(amount == 0) {
            qr.setResultList(Collections.EMPTY_LIST);
            return qr;
        }

        List<OrganizationDO> organizations =  this.sqlSession.selectList("OrganizationMapper.query", params);
        qr.setResultList(organizations);
        return qr;
    }

    private int countAll(Map<String,Object> params) {
        //return this.sqlSession.selectOne("OrganizationMapper.countAll",params);
        return 0;
    }
}
