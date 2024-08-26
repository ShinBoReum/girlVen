package com.girlvengers.gvc.controller;

import com.girlvengers.gvc.vo.GvcVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class gvcRestController {

    @RequestMapping(value="testValue",method = RequestMethod.GET)
    public String getTestValue(){
        String TestValue = "grilvengers";
        return TestValue;
    }

    @RequestMapping(value="openDartAPI", method = RequestMethod.GET)
    public ResponseEntity<String> openDartAPI(
            @RequestParam(value = "corpCode") String corpCode,
            @RequestParam(value = "bsnsYear") String bsnsYear,
            @RequestParam(value = "reprtCode") String reprtCode
    ) throws Exception {
        HttpsURLConnection urlConnection = null;
        InputStream stream = null;
        String result = null;

        System.out.println(corpCode);
        System.out.println(bsnsYear);
        System.out.println(reprtCode);

        String urlStr = "https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?" +
                "crtfc_key=" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx&" +
                "corp_code=" + corpCode +"&" +
                "bsns_year=" + bsnsYear +"&" +
                "reprt_code=" + reprtCode;

        try {
            URL url = new URL(urlStr);

            urlConnection = (HttpsURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            result = readStreamToString(stream);

            if(stream != null) stream.close();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }

        //https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxcorp_code=00126380bsns_year=2018reprt_code=11011
        //https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx&corp_code=00126380&bsns_year=2018&reprt_code=11011
        //https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx&corp_code=00126380&bsns_year=2018&reprt_code=11011
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* URLConnection 을 전달받아 연결정보 설정 후 연결, 연결 후 수신한 InputStream 반환 */
    private InputStream getNetworkConnection(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);

        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    /* InputStream을 전달받아 문자열로 변환 후 반환 */
    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            result.append(readLine + "\n\r");
        }

        br.close();

        return result.toString();
    }

}
