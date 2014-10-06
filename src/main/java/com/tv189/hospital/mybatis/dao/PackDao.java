package com.tv189.hospital.mybatis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tv189.hospital.mybatis.model.CardInfo;

@Repository
public interface PackDao extends ISqlDao{
	@Autowired
	
    public int deleteByPrimaryKey(Integer id);

    public int insert(CardInfo record);

    public int insertSelective(CardInfo record);

    public CardInfo selectByPrimaryKey(Integer id);
    public CardInfo selectByCardNumber(String cardNumber);
    public List<CardInfo> selectByStatus(Integer status);

    public int updateByPrimaryKeySelective(CardInfo record);

    public int updateCardInfo(CardInfo record);
    public int updateCardInfos(List<CardInfo> list);
    public int InsertCardInfos(List<CardInfo> list);
}