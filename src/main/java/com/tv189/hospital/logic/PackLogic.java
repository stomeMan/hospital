package com.tv189.hospital.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tv189.hospital.constant.Constant;
import com.tv189.hospital.helper.DateHelper;
import com.tv189.hospital.mybatis.dao.CardUserDao;
import com.tv189.hospital.mybatis.dao.PackDao;
import com.tv189.hospital.mybatis.model.CardInfo;
import com.tv189.hospital.mybatis.model.CardUser;
import com.tv189.hospital.mybatis.model.CardView;
import com.tv189.hospital.pojo.RequestObject;
import com.tv189.hospital.pojo.ResponseObject;

/**
 * @author gaohailiang
 *
 * 2014-6-17
 */
@Service("packLogic")  
public class PackLogic {
	Logger log=Logger.getLogger(PackLogic.class);
	@Autowired
	private PackDao packDao;
	@Autowired
	private CardUserDao cardUserDao;
	@Autowired LoggerLogic loggerLogic;
	public static Queue<CardInfo> cards = new ConcurrentLinkedQueue<CardInfo>();
	/**
	 * 
	 * @param userId
	 * @return
	 * 
	 */
	public ResponseObject gethospital(RequestObject requestObject){
//		List<CardInfo> cul=null;
		String userId=requestObject.getUserId();
		CardUser cardUser=null;
		try{
			long start=new Date().getTime();
			cardUser=cardUserDao.selectByUserId(userId);
		}catch(Exception e){
			log.info("数据库访问失败");
		}
		CardView cv=null;
//		if(cardUser==null){
//			List<CardUser> list=new ArrayList<CardUser>();
//			list.addAll(UpdateThread.cardusers);
//			for(int i=0;i<list.size();i++){
//				CardUser cu=list.get(i);
//				if(cu!=null&&cu.getUserId().equals(requestObject.getUserId())){
//					cul=new ArrayList<CardInfo>();
//					cul.addAll(UpdateThread.updatedCards);
//					for(CardInfo ci:cul){
//						if(ci.getCardNumber().equals(cu.getCardNumber())){
//							return new CardView(ci.getCardNumber(),ci.getPassword());
//						}
//					}
//					return null;
//				}
//			}
//		}
		if(cardUser!=null){  //该用户已经领取过红包，返回领取过得红包
			CardInfo cardInfo=packDao.selectByCardNumber(cardUser.getCardNumber());
			if(cardInfo!=null){
				 cv =new CardView(cardInfo.getCardNumber(),cardInfo.getPassword());
			}
			return new ResponseObject(1,"您已经领取过红包，请保存好用户名密码",cv);
		}
		cv=  this.updateCardAndCardUser(userId);//不成功去抢未被领取的红包
		if(cv==null){
			return new ResponseObject(2,"对不起，红包已被抢光",cv);
		}
		return new ResponseObject(0,"恭喜您，红包领取成功，请保存好卡号和密码",cv);
	}
	/**
	 * 
	 * @param status
	 * @return
	 */
	public List<CardInfo> getCardInfosBystatus(Integer status){
		return packDao.selectByStatus(status);
	}
	/**
	 * 没有领取过红包的用户，取一个红包给他，并更新红包状态且在card_user中插入一条数据,表示该用户已经领取过红包
	 * @return
	 */
	public synchronized CardView  updateCardAndCardUser (String userId){
		CardInfo cardInfo=null;
		List<CardInfo> list=null;
		if(cards.size()==0){
			 list=packDao.selectByStatus(Constant.RED_PACK_STATUS_Available);//获取未被领取的红包
			 if(list!=null&&list.size()>0){
				 list.get(list.size()-1);
				 cards.addAll(list);
			 }else{
				 return null;
			 }
		}
		cardInfo=cards.poll();
		if(cardInfo!=null){
			cardInfo.setStatus(Constant.RED_PACK_STATUS_GETED);//表示已领取
			cardInfo.setUpdateTime(DateHelper.getDateTimeByNowyyyyMMddHHmmss());
			LoggerLogic.updateCardInfoLog(cardInfo.toString());
			packDao.updateCardInfo(cardInfo);
//			UpdateThread.updatedCards.add(cardInfo);//加到待更新队列
//			UpdateThread.cardusers.add(new CardUser(cardInfo.getCardNumber(),DateHelper.getDateTimeByNowyyyyMMddHHmmss(),userId));//加到等待插入队列
			CardUser cuu=new CardUser(cardInfo.getCardNumber(),DateHelper.getDateTimeByNowyyyyMMddHHmmss(),userId);
			LoggerLogic.updateCardUserLog(cuu.toString());
			cardUserDao.insertCardUser(cuu);
			return new CardView(cardInfo.getCardNumber(),cardInfo.getPassword());
		}
		return null;
	}
	public static void main(String[] args) {
//		new PackLogic().cardUserDao.insert(new CardUser("00000003",DateHelper.getDateTimeByNowyyyyMMddHHmmss(),"0002"));
	}
}
