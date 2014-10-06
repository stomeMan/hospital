package com.tv189.hospital.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.lang.time.DateUtils;


public class DateHelper {
	public static Date getDateByStr(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(time);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getDateTimeByStr(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(time);
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static Date getDateTimeByyyyyMMddHHmmss(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.parse(time);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * 
	 * 以 yyyy-MM-dd HH:mm:ss格式返回当前世界
	 * @param time
	 * @return
	 */
	public static String getDateTimeStringBy_yyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.format(new Date());
		} catch (Exception e) {
			return null;
		}
	}
	public static Date getDateTimeByyyyyMMdd(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			return sdf.parse(time);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateTimeByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 获取当前时间
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateTimeByNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 以 yyyyMMddHHmmss格式返回氮气世界
	 * @return
	 */
	public static String getDateTimeByNowyyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 得到下一个小时的yyyyMMddHHmmss格式时间字符串
	 */
	public static String getDateTimeByNextHouryyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.format(new Date(System.currentTimeMillis()+3600*1000));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getDateTyimeByMillions(long millions){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.format(new Date(millions));
		} catch (Exception e) {
			return null;
		}		
	}
	public static String getDateTimeyymmddByMillions(long millions){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			return sdf.format(new Date(millions));
		} catch (Exception e) {
			return null;
		}		
	}
	public static String getDateTimeByyyyyMMddHHmmss(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateTimeByyyyyMMdd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Long getTomorrowSecond(long nowm){
		Date d = new Date(nowm);
		Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
        return now.getTimeInMillis() / 1000;
	}
	
	public static Long getNextMonthSecond(long nowm){
		Date d = new Date(nowm);
		Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.MONTH) + 1);
        return now.getTimeInMillis() / 1000;
	}

	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			return null;
		}
	}
	public static String getDateToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			return sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			return null;
		}
	}
	public static Date getNow() {
		return new Date(System.currentTimeMillis());
	}




	public static Date get0LDate() {
		return new Date(0L);
	}

	/**
	 * 根据传入的日期字符串以及格式，产生一个Calendar对象
	 * 
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return Calendar
	 * @throws java.text.ParseException
	 * @throws ParseException
	 *             当格式与日期字符串不匹配时抛出该异常
	 * @throws java.text.ParseException
	 */
	public static Calendar convertToCalendar(String date, String pattern)
			throws ParseException {

		Date d = DateUtils.parseDate(date, new String[] { pattern });

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		return calendar;
	}

	/**
	 * 计算传入的日期是星期几
	 * 
	 * @param date
	 *            String
	 * @return int
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	public static Integer getDayOfWeek(String date) throws ParseException {
		return DateHelper.convertToCalendar(date, "yyyy-MM-dd HH:mm:ss").get(
				new GregorianCalendar().DAY_OF_WEEK);
	}

	/**
	 * 判断传入的时间是否是周末(周六or周日)
	 * 
	 * @param date
	 *            String 时间格式一定是yyyy-MM-dd HH:mm:ss
	 * @return boolean
	 */
	@SuppressWarnings("static-access")
	public static boolean isWeekend(String date) throws ParseException {
		Calendar calendar = new GregorianCalendar();
		if ((DateHelper.getDayOfWeek(date) == calendar.SATURDAY)
				|| (DateHelper.getDayOfWeek(date) == calendar.SUNDAY)) {
			return true;
		} else {
			return false;
		}
	}

	public static Date add(Date date, Integer amount) {
		try {
			SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, amount);

			return dft.parse(dft.format(calendar.getTime()));
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date addMonth(Date date, Integer amount) {
		try {
			SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, amount);

			return dft.parse(dft.format(calendar.getTime()));
		} catch (ParseException e) {
			return null;
		}
	}
	public static Date subtract(Date date, Integer amount) {
		try {
			SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - amount);

			return dft.parse(dft.format(calendar.getTime()));
		} catch (ParseException e) {
			return null;
		}
	}
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String getPlayInfoGuid(){
		String uid = DateHelper.getUUID();
		int random = StringHelper.getRandom(0, 10000);
		return uid+random;
	}
	public static String getFormatTime(String time) {
	    try {
	    	StringBuffer fTime = new StringBuffer("");
	    	if (time.length()<14){
	    		time += "000000000000000";
	    	}
	    	fTime.append(time.substring(0, 4)).append("-");
	    	fTime.append(time.substring(4, 6)).append("-");
	    	fTime.append(time.substring(6, 8)).append(" ");
	    	fTime.append(time.substring(8, 10)).append(":");
	    	fTime.append(time.substring(10, 12)).append(":");
	    	fTime.append(time.substring(12, 14));
	      return fTime.toString();
	    } catch (Exception e) {
	      return null;
	    }
	  }
	
	public static Date getFormatTimeToDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(DateHelper.getFormatTime(time));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 输入:其它时区的时间(其格式为:yyyyMMddHHmmss)
	 * 输出:与本地时间的差值
	 * @param time		时间格式:yyyyMMddHHmmss
	 * @param srcTimeZoneId		来源时间的时区ID
	 */
	public static Long localTimeSubTime(String time,String srcTimeZoneId) {
		TimeZone timeZoneNY = TimeZone.getTimeZone(srcTimeZoneId);
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		inputFormat.setTimeZone(timeZoneNY);
		Date localDate = null;
		try {
			localDate = inputFormat.parse(time);						//得到的是传入时区转化成本地时区的时间
		} catch (ParseException e) {
			e.printStackTrace();
			return null;		
		}
		long scrTimeLong = localDate.getTime();
		long nowTime = new Date().getTime();
		long subMin = (int) ((nowTime-scrTimeLong)/1000/60);			//相差几分钟
		return subMin;
	}
	
	public static void main(String... args){
//		String str = DateHelper.getDateNumByNow();
//		MyLoggerManager.printInfo(str);
//		long str = UUID.randomUUID().getMostSignificantBits();
//		MyLoggerManager.printInfo(str);
//		MyLoggerManager.printInfo((str+"").length());
		for (int i = 0; i < 10; i++) {
//			System.out.println(DateHelper.getUUID());
//		System.out.println(DateHelper.getDateTimeByNow());
		String now = DateHelper.getDateTimeByNow();
		System.out.println("now--->"+now);
		Date nowtime = DateHelper.getDateTimeByStr(now);
		System.out.println("nowtime--->"+nowtime);
		System.out.println("当前时间" + nowtime.getTime());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
