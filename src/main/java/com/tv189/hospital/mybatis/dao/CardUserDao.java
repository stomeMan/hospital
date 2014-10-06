package com.tv189.hospital.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tv189.hospital.mybatis.model.CardInfo;
import com.tv189.hospital.mybatis.model.CardUser;

@Repository
public interface CardUserDao extends ISqlDao{
	@Autowired
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(CardUser record);

    public int insertCardUser(CardUser record);
    public int insertCardUsers(List<CardUser> cardUsers);
    public CardInfo selectByPrimaryKey(Integer id);
    public CardUser selectByUserId(String userId);
    public List<CardInfo> selectByStatus(Integer status);

    public int updateByPrimaryKeySelective(CardUser record);

    public int updateByPrimaryKey(CardUser record);
}