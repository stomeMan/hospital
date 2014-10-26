package com.hospital.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hospital.constant.Constant;
import com.hospital.logger.LogInfo;
import com.hospital.logger.LogThread;

public class HttpHelper {
	private static final Log log = LogFactory.getLog(HttpHelper.class);
	public static String doGetAtfilter(String url, String queryStr, String charset, boolean pretty,HttpServletRequest request) {
		Date startTime=new Date();
		String reInfo = "";
		reInfo=executeGetRequest(url,queryStr,charset);
		Date endTime=new Date();
		HttpHelper.addProxyHttpLogNew(HttpUtil.getLocalURL(request),startTime,url, queryStr, reInfo.toString(),endTime);
		return reInfo.toString();
	}
	/**
	 * 
	 * @param url
	 * @param queryStr
	 * @param charset
	 * @param pretty
	 * @return
	 */
	public static String doGet(String url, String queryStr, String charset, boolean pretty) {
		String reInfo = "";
		Date startTime=new Date();
		reInfo=executeGetRequest(url,queryStr,charset);
		Date endTime=new Date();
		HttpHelper.addProxyHttpLogNew(HttpUtil.getLocalURL(null),startTime,url, queryStr, reInfo.toString(),endTime);
		return reInfo.toString();
	}
	/**
	 * 真正执行doGet请求的方法
	 * @param url 要请求链接
	 * @param queryStr 参数
	 * @param charset 编码方式
	 * @return
	 */
	private static String executeGetRequest(String url, String queryStr, String charset){
		HttpClient httpclient = null;
		InputStream in = null;
		String reInfo="";
		try {
			httpclient = HttpClientUtils.getHttpClient();
			// HttpHelper.addProxyRequestLog(uuid, url, queryStr, "GET");
			// 创建httpget.
			HttpGet httpget = new HttpGet(url + queryStr);
			// 执行get请求.
			HttpResponse response = httpclient.execute(httpget);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			// // 打印响应状态
			in = entity.getContent();
			String reTemp = EntityUtils.toString(entity, charset);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				reInfo = reTemp;
			}
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				// 关闭连接,释放资源
				try {
					in.close();
				} catch (IOException e) {
//					log.error(ExceptionInterceptor.getTrace(e));
				}
			}
		}
		return reInfo;
	}
	public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) {

		String reInfo = "";
		InputStream in = null;
		HttpClient httpclient = null;
		HttpPost httppost = null;
		UrlEncodedFormEntity uefEntity = null;
		Date startTime=new Date();
		try {
			httpclient = HttpClientUtils.getHttpClient();
			httppost = new HttpPost(url);

			// 创建参数队列
			List<NameValuePair> postValues = new ArrayList<NameValuePair>();
			StringBuffer queryStr = new StringBuffer();
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					postValues.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
					queryStr.append(entry.getKey() + StringHelper.PARA_EQUAL + entry.getValue()+ StringHelper.URL_CONCAT);
					if (!"content".equals(entry.getKey())) {
						httppost.setHeader(entry.getKey(), entry.getValue());
					}
				}
			}

			uefEntity = new UrlEncodedFormEntity(postValues, charset);
			httppost.setEntity(uefEntity);

			HttpResponse response;
			response = httpclient.execute(httppost);
			Date endTime=new Date();
			HttpEntity entity = response.getEntity();
			// // 打印响应状态
			in = entity.getContent();
			String reTemp = HttpHelper.getStringByInputStream(entity.getContent(), pretty);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				reInfo = reTemp;
			}

			HttpHelper.addProxyHttpLogNew(HttpUtil.getLocalURL(null),startTime,url, queryStr.toString(), reInfo.toString(),endTime);
		} catch (ClientProtocolException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} finally {
			if (in != null) {
				// 关闭连接,释放资源
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return reInfo;
	}
	/**
	 * 
	 * @param uuid
	 * @param url
	 * @param queryStr
	 * @param reInfo
	 * @param reqType
	 */
	public static void addProxyHttpLogNew(String localurl,Date startTime, String url, String queryStr, String reInfo,Date endTime) {
		long usingTime=endTime.getTime()-startTime.getTime();
		String startTimeStr=DateUtil.getDateTimeByDate(startTime);
		String endTimeStr=DateUtil.getDateTimeByDate(endTime);
		if(url!=null&&url.contains("?")||queryStr!=null&&queryStr.contains("?")){
			url+=queryStr;
		}else{
			url=url+"?"+queryStr;
		}
	
		String loginfo="----start----"+"\n"+startTimeStr+"\n"+localurl+"\nrequest:"+url+ "\nmsresponse:" + reInfo+"\nusedTime:"+usingTime+"\n"+endTimeStr+"\n----end----\n";
		LogInfo logger = new LogInfo(LogConfigHelper.getProxyHttpLog(),loginfo,Constant.DAILY);
		LogThread.addLogInfo(logger);
	}
	

	public static String doPost(String url, Map<String, String> params) throws IllegalStateException, IOException {
		String strResult = "";
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			postData.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			// System.out.print(entry.getValue());
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData, HTTP.UTF_8);// 过时了?
		post.setEntity(entity);
		HttpResponse response = httpClient.execute(post);

		// 若状态码为200 ok
		if (response.getStatusLine().getStatusCode() == 200) {
			// 取出回应字串
			strResult = EntityUtils.toString(response.getEntity());
		}
		return strResult;
	}

	public static String getStringByInputStream(InputStream input, boolean pretty) {
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String line;
		try {
			reader = new BufferedReader(new InputStreamReader(input));
			while ((line = reader.readLine()) != null) {
				if (pretty) {
					buffer.append(line).append(System.getProperty("line.separator"));
				} else {
					buffer.append(line);
				}
			}
		} catch (IOException e) {
//			log.error(ExceptionInterceptor.getTrace(e));
		} finally {
			if (reader != null) {
				try {
					reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
					while ((line = reader.readLine()) != null) {
						if (pretty) {
							buffer.append(line).append(System.getProperty("line.separator"));
						} else {
							buffer.append(line);
						}
					}
					reader.close();
				} catch (IOException e) {
//					log.error(ExceptionInterceptor.getTrace(e));
				}
			}
		}
		return buffer.toString();

	}

	@SuppressWarnings("finally")
	public static String doPost(String url, Map<String, String> headerMap, String charset, String bodyContent) {

		String BOUNDARY = "------WebKitFormBoundary"; // 数据分隔线
		StringBuilder sb = new StringBuilder();
		HttpURLConnection http = null;
		BufferedReader in = null;
		DataOutputStream out = null;
		try {
			URL u = new URL(url);
			http = (HttpURLConnection) u.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			String[] strs = headerMap.keySet().toArray(new String[] {});
			for (String str : strs) {

				http.setRequestProperty(str, headerMap.get(str));
			}
			http.setRequestProperty("Charset", charset);
			http.setRequestProperty("Charset", charset);
			http.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");
			http.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			http.setConnectTimeout(20000);
			http.setReadTimeout(500000);
			http.connect();

			out = new DataOutputStream(http.getOutputStream());

			out.writeBytes(bodyContent);
			// String postBody = endline +
			// "Content-Disposition: form-data;name=\"test\"\r\n\r\n11\r\n";
			// System.out.println(postBody);
			// out.write(postBody.getBytes());

			// out.write(endline.getBytes());
			out.flush();
			out.close();

			in = new BufferedReader(new InputStreamReader(http.getInputStream(), charset));
			String tmp;
			while ((tmp = in.readLine()) != null) {
				sb.append(tmp).append("\n");
			}

			in.close();
		} catch (Exception ex) {
		} finally {
			return sb.toString();
		}
	}

	public static void main(String[] args) {

		Map<String, String> params = new HashMap<String, String>();
		String urlStr = "http://test.zuoanlong.com:8083/tysx/api/v1/question/screen";
		// params.put("prgid", "98000000000000000001355725830536");
		// params.put("devid", "000001");
		// params.put("productid", "1000000054");

		// urlStr="http://test.zuoanlong.com:8083/tysx/api/v1/exterps/expertsList";
		// urlStr="http://test.zuoanlong.com:8083/tysx/api/v1/exterps/expertsdetails";
		// params.put("expertid", "1049");
		// params.put("useruid", "104211484674176130125");

		// urlStr =
		// "http://test.zuoanlong.com:8083/tysx/api/v1/exterps/requestvideochat";
		// params.put("expertid", "1049");
		// params.put("useruid", "104211484674176130125");
		urlStr = "http://test.zuoanlong.com:8083/mmsadmin/api/v1/screen/push";
		params.put("dev_id", "000002");

		String data = doPost("http://192.168.99.33:9795/service/CmmService/tree_list?"
				+ "devId=000002&appId=4321&rid=98000000000000000001355725830536"
				+ "&uid=12313213123&size=20&uncount=0&isEditor=1&commentType=2&plat=8"
				+ "&parentId=201309305c61e20299384e4996bc058a2c043cec&", null, "utf-8", false);
		String datastr = data;
		try {
			JSONObject jsonObject = JsonHelper.toJSONObject(data, JSONObject.class);
			Map map = (Map) jsonObject.get("info");
			String dataStr = map.get("data").toString();
			JSONArray jsonArray = JsonHelper.toJSONObject(dataStr, JSONArray.class);

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = JsonHelper.toJSONObject(jsonArray.get(i).toString(), JSONObject.class);
				String[] strs = object.keySet().toArray(new String[] {});
				for (String str : strs) {
					Object object2 = object.get(str);
					if (str.toLowerCase().indexOf("time") > 0) {
						continue;
					}
					if (object2 != null) {
//						object2 = URLEncoder.encode(object2.toString(), SystemConfigHelper.UTF_8);
						object.put(str, object2);
					}
				}
				jsonArray.set(i, object);
			}
			map.put("data", jsonArray);
			jsonObject.put("info", map);
			data = JsonHelper.toJsonStr(jsonObject);
			params.put("rid", "98000000000000000001355725830536");
			// String s=URLDecoder.decode(datastr,SystemConfigHelper.UTF_8);
			// s=URLEncoder.encode(datastr,SystemConfigHelper.UTF_8);
			// System.out.println(s);
			String resp = HttpHelper.doPost(urlStr, params, "utf-8", data);
			// String resp_ = HttpHelper.doPost(urlStr,
			// params,"utf-8",false,datastr);
			System.out.println("" + resp);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over!");

	}
}
