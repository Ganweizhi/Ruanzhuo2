package com.dgut.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class Send {

    public static String post(String url, List<NameValuePair> formparams) {

        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;

        // 创建默认的httpClient实例.
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);

            try (CloseableHttpResponse response = httpclient.execute(httppost)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
