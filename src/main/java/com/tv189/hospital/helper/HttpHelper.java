package com.tv189.hospital.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



import com.tv189.hospital.constant.Constant;
import com.tv189.hospital.logger.LogInfo;
import com.tv189.hospital.logger.LogThread;
import com.tv189.hospital.logic.LoggerLogic;



public class HttpHelper {
	private static ThreadSafeClientConnManager cm  = null;
    static {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        cm = new ThreadSafeClientConnManager(schemeRegistry);
        cm.setMaxTotal(800);
        cm.setDefaultMaxPerRoute(50);

    }
	private static final Log log = LogFactory.getLog(HttpHelper.class);

	public static String doGet(String url, String charset) {
		String reInfo = "";
		HttpClient httpclient = null;
		InputStream in = null;
//		String startTime=DateUtil.getDateTimeByDate(new Date());
		try {
			httpclient = HttpClientUtils.getHttpClient();
			// HttpHelper.addProxyRequestLog(uuid, url, queryStr, "GET");
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			LoggerLogic.httpLog(url);
			// 执行get请求.
			HttpResponse response = httpclient.execute(httpget);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			in = entity.getContent();
			String reTemp = EntityUtils.toString(entity, charset);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				reInfo = reTemp;
			}
		} catch (ClientProtocolException e) {
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
					log.error(e.getMessage());
				}
			}
		}

		return reInfo.toString();
	}
	/**
	 * 
	 * @param url
	 * @param queryStr
	 * @param charset
	 * @param pretty
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url,String queryStr,String charset) throws IOException {
		return doGet(url+queryStr, queryStr,charset);
	}
	/**
	 * 
	 * @param url
	 * @param pretty
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url) throws IOException {
		return doGet(url,"UTF-8");
	}
	/**
	 * 
	 * @param url
	 * @param pretty
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url,Map<String,String> params) throws IOException {
		return doGet(url+getQueryString(params));
	}
	/**
	 *传入Map<String,String> 返回 String,最前面带？ 
	 * @param params
	 * 
	 * @return
	 */
	public static String getQueryString(Map<String,String> params){
		StringBuilder queryString=new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if(queryString.indexOf("?")==-1){
				queryString.append("?");
			}else{
				queryString.append(StringHelper.URL_CONCAT); 
			}
			queryString.append(entry.getKey() + StringHelper.PARA_EQUAL + entry.getValue());
			
		}
		return queryString.toString();
	}
/**
 * 
 * @param url
 * @param params
 * @param charset
 * @param pretty
 * @return
 */
 	public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) {

		String reInfo = "";
		InputStream in = null;
		HttpClient httpclient = null;
		HttpPost httppost = null;
		UrlEncodedFormEntity uefEntity = null;
		String startTime=DateUtil.getDateTimeByDate(new Date());
		try {
			httpclient = getHttpClient();
			httppost = new HttpPost(url);

			// 创建参数队列
			List<BasicNameValuePair> postValues = new ArrayList<BasicNameValuePair>();
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
			HttpEntity entity = response.getEntity();
			// // 打印响应状态
			System.out.println(response.getStatusLine());
			in = entity.getContent();
			String reTemp = HttpHelper.getStringByInputStream(entity.getContent(), pretty);
//			String reTemp = EntityUtils.toString(entity, charset);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				reInfo = reTemp;
			}

		} catch (ClientProtocolException e) {
			log.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (in != null) {
				// 关闭连接,释放资源
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			}
		}
		return reInfo;
	}
//	/**
//	 * 
//	 * @param uuid
//	 * @param url
//	 * @param queryStr
//	 * @param reInfo
//	 * @param reqType
//	 
//	public static void addProxyHttpLogNew(String localurl,String startTime, String url, String queryStr, String reInfo) {
//		String loginfo="----start----"+startTime+"\n"+localurl+"\nrequest:"+url + "?"+ queryStr + "\nmsresponse:" + reInfo+"\n----end----";
//		LogInfo logger = new LogInfo(LogConfigHelper.getProxyHttpLog(),loginfo,Constant.DAILY);
//		LogThread.addLogInfo(logger);;
//	}


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
			log.error(e.getMessage());
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
					log.error(e.getMessage());
				}
			}
		}
		return buffer.toString();

	}

 
/**
 * 
 * @param url
 * @param headerMap
 * @param charset
 * @param bodyContent
 * @return
 */
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

	public static void main(String[] args) throws IOException {
		String response=doGet("http://127.0.0.1:8080/mvc/helloword/hello.json");
		System.out.println(response);

	}
    public static HttpClient getHttpClient() {
        HttpParams params = new BasicHttpParams();
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, "30000");

        return new DefaultHttpClient(cm, params);
    }
}
