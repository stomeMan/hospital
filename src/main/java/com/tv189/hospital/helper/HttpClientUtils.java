package com.tv189.hospital.helper;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;


public class HttpClientUtils {

    private static ThreadSafeClientConnManager cm  = null;

    static {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        cm = new ThreadSafeClientConnManager(schemeRegistry);
        cm.setMaxTotal(800);
        cm.setDefaultMaxPerRoute(50);

    }

    public static HttpClient getHttpClient() {
        HttpParams params = new BasicHttpParams();
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
        params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);

        return new DefaultHttpClient(cm, params);
    }

   
    public static void release() {
        if (cm != null) {
            cm.shutdown();
        }
    }
    
}

