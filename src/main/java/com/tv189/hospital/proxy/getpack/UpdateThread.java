package com.tv189.hospital.proxy.getpack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


import org.apache.log4j.Logger;

import com.tv189.hospital.logger.LogThread;
import com.tv189.hospital.mybatis.dao.CardUserDao;
import com.tv189.hospital.mybatis.dao.PackDao;
import com.tv189.hospital.mybatis.model.CardInfo;
import com.tv189.hospital.mybatis.model.CardUser;


/**
 * 
 * @author gaohailiang
 * 
 *         2014-08-29
 */
public class UpdateThread extends Thread {
	
	public static Queue<CardUser> cardusers = new ConcurrentLinkedQueue<CardUser>();
	public static Queue<CardInfo> updatedCards = new ConcurrentLinkedQueue<CardInfo>();
//	@Autowired
	private PackDao packDao;
//	@Autowired
	private CardUserDao cardUserDao;
	Logger log=Logger.getLogger(UpdateThread.class);

	public void run() {
		System.out.println("************************更新线程启动**************************");
		while (true) {
			List<CardUser> listCardUsers=new ArrayList<CardUser>();
			Integer size = cardusers.size();
			for(int i=0;i<size;i++){
				listCardUsers.add(cardusers.poll());
			}
			if(listCardUsers!=null&&listCardUsers.size()>0){
				for(CardUser cu:listCardUsers){
					if(cu!=null){
						cardUserDao.insertCardUser(cu);
					}
					
				}
				
			}
			Integer cardsSize = updatedCards.size();
			List<CardInfo> listCards=new ArrayList<CardInfo>();
			for(int i=0;i<cardsSize;i++){
				listCards.add(updatedCards.poll());
			}
			if(listCards!=null&&listCards.size()>0){
				for(CardInfo card:listCards){
					packDao.updateCardInfo(card);
				}
				
			}
			Integer sleepTime = 5 * 1000; //5秒钟更新一次数据到数据库
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param obj 将 obj转化成 key=>value对应的map
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String,String> getObjectMap(Object obj){
		Map<String,String> map=new HashMap<String, String>();
		Class zz=obj.getClass();
		Field[] fs=zz.getDeclaredFields();
		try {
			for(Field field:fs){
				if(!(field.getName().equals("url")|(field.getName().equals("accessUrl")))){
					map.put(field.getName(), (String) field.get(obj));
				}
			}
		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
	private static Integer tempNum = 1;
	public void initThread(){
		if(tempNum == 1){
			Thread th = new LogThread();
			th.start();
			tempNum++;
		}
	}
	
	
}
