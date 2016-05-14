package com.tecapro.inventory.common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Process request call webservice
 * 
 * @author loinx
 * @version 1.0
 */
@Component("HttpRequest")
public class HttpRequest {
    public void init() {

    }

    public JSONObject getResponseFromConnection(HttpURLConnection conn) {
        JSONObject jsonResult = new JSONObject();
        try {
            
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) {//error connect to server
                //System.out.print("Response code: " + conn.getResponseCode());
                return new JSONObject();
            }
            
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {

                builder.append(output);
                
            }
            try {// get data from server
                jsonResult = new JSONObject(builder.toString());
                
            } catch (JSONException e) {
                e.printStackTrace();
                jsonResult = new JSONObject();
            }
            is.close();
            br.close();
            conn.disconnect();
        } catch (IOException ie) {

            ie.printStackTrace();

        }
        return jsonResult;
    }
    /**
     * Get json object from server
     * 
     * @param jsonRequest
     * @return
     */
    public JSONObject getResponse(JSONObject jsonRequest, String sUrl) {
        URL url = null;
        JSONObject jsonResult = null;
        HttpURLConnection conn = null;
        try {

            url = new URL(sUrl);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {

            e.printStackTrace();

        }
        // set post request out in
        conn.setDoOutput(true);

        conn.setDoInput(true);
        // set post request
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON + ";Charset=UTF-8");
        conn.setRequestProperty("Accept-Charset", "UTF-8");
        try {
            conn.connect();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        jsonResult = new JSONObject();

        OutputStream os = null;

        try {
            os = conn.getOutputStream();

            if (jsonRequest == null) {// param is null

                return new JSONObject();
            }

            String urlParameters = "jsonRequest=" + jsonRequest.toString();

            DataOutputStream wr = new DataOutputStream(os);

            wr.write(urlParameters.getBytes(Charset.forName("UTF-8")));

            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) {//error connect to server
                //System.out.print("Response code: " + conn.getResponseCode());
                return new JSONObject();
            }
            
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String output;
            StringBuilder builder = new StringBuilder();

            while ((output = br.readLine()) != null) {

                builder.append(output);
                
            }
            try {// get data from server
                jsonResult = new JSONObject(builder.toString());
                
            } catch (JSONException e) {
                e.printStackTrace();
                jsonResult = new JSONObject();
            }
            is.close();
            br.close();
            conn.disconnect();
        } catch (IOException ie) {

            ie.printStackTrace();

        }
        return jsonResult;
    }

    /**
     * Get Connection for dowload file
     * 
     * @param jsonRequest
     * @return HttpURLConnection
     *         to handle dowload
     */
    public HttpURLConnection callDowloadService(String sUrl, String downloadFilePath, String accessToken) {
        HttpURLConnection conn = null;
        OutputStream os = null;
        int actualReceivedBytes = 0;
        URL url = null;
        try {

            url = new URL(sUrl);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        try {
            
            conn = (HttpURLConnection) url.openConnection();
            
        } catch (IOException e) {

            e.printStackTrace();

        }
        // set post request out in
        conn.setDoOutput(true);

        conn.setDoInput(true);
        // set post request
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setChunkedStreamingMode(1024);
        conn.setUseCaches(false);
        conn.setRequestProperty("Content-Type", MediaType.APPLICATION_FORM_URLENCODED +";Charset=UTF-8");
        conn.setRequestProperty("Accept-Charset", "UTF-8");
        try {
            conn.connect();
            os = conn.getOutputStream();
            
            StringBuilder urlParameters = new StringBuilder();

            urlParameters.append("downloadFilePath=");
            urlParameters.append(downloadFilePath);
            urlParameters.append("&actualReceivedBytes=");
            urlParameters.append(actualReceivedBytes);
            urlParameters.append("&accessToken=");
            urlParameters.append(accessToken);
            DataOutputStream wr = new DataOutputStream(os);
            wr.write(urlParameters.toString().getBytes(Charset.forName("UTF-8")));

            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    /**
     * Get Connection for download share file
     * 
     * @param jsonRequest
     * @return HttpURLConnection
     *         to handle dowload
     */
    public HttpURLConnection callDowloadShareService(String sUrl, String downloadFilePath, String accessToken, int resourceId) {
        HttpURLConnection conn = null;
        OutputStream os = null;
        URL url = null;
        try {

            url = new URL(sUrl);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        try {
            
            conn = (HttpURLConnection) url.openConnection();
            
        } catch (IOException e) {

            e.printStackTrace();

        }
        // set post request out in
        conn.setDoOutput(true);

        conn.setDoInput(true);
        // set post request
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setChunkedStreamingMode(1024);
        conn.setUseCaches(false);
        conn.setRequestProperty("Content-Type", MediaType.APPLICATION_FORM_URLENCODED +";Charset=UTF-8");
        conn.setRequestProperty("Accept-Charset", "UTF-8");
        try {
            conn.connect();
            os = conn.getOutputStream();
            
            StringBuilder urlParameters = new StringBuilder();

            urlParameters.append("subPath=");
            urlParameters.append(downloadFilePath);
            urlParameters.append("&accessToken=");
            urlParameters.append(accessToken);
            urlParameters.append("&resourceId=");
            urlParameters.append(resourceId);
            
            DataOutputStream wr = new DataOutputStream(os);

            wr.write(urlParameters.toString().getBytes(Charset.forName("UTF-8")));

            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    public HttpURLConnection uploadRequest(JSONObject jsonRequest) {
        
        
        return null;
    }
}
