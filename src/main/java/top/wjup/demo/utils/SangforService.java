package top.wjup.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;


/**
 * zip utility
 *
 * @author sunguangtao
 * @date 2020/5/8
 */
@Slf4j
public class SangforService {
    public static void main(String[] args) {
        sendRiskRequest();
    }

    public static String login() {
        RestTemplate restTemplate = getRestTemplate();
        String name = "oss";
        String password = "123456a?";

        MultiValueMap<String, String> credentials = new LinkedMultiValueMap<>();
        credentials.add("name", name);
        credentials.add("password", password);

        String loginPolicy = "UEDC_LOGIN_POLICY_VALUE=checked";
        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.add(HttpHeaders.COOKIE, loginPolicy);
        requestHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);
//        String loginPage = "https://10.27.100.25/apps/secvisual/login/login.html";
//        requestHeader.add(HttpHeaders.REFERER, loginPage);

        String loginUrl = "https://10.253.24.1/apps/secvisual/index.html";
        HttpEntity<Object> requestEntity = new HttpEntity<>(credentials, requestHeader);
        HttpEntity responseEntity = restTemplate.exchange(loginUrl, HttpMethod.POST, requestEntity, String.class);
        List<String> cookieList = responseEntity.getHeaders().get(HttpHeaders.SET_COOKIE);
        return StringUtils.join(cookieList, ";");
    }

    public static RestTemplate getRestTemplate() {

        return new RestTemplateBuilder()
                .requestFactory(SkipHttpsVerifierRequestFactory.class).build();
    }

    public static void sendRiskRequest() {
//        String cookie = login();

        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        requestHeader.add(HttpHeaders.COOKIE, cookie);
        String referer = "https://10.253.24.1/apps";
        requestHeader.add(HttpHeaders.REFERER, referer);

        RiskQuery riskQuery = new RiskQuery("last7d", 0);
        HttpEntity<Object> requestEntity = new HttpEntity<>(riskQuery, requestHeader);

        RestTemplate restTemplate = getRestTemplate();

        ResponseEntity responseEntity = restTemplate
                .exchange("https://10.253.24.1/apps/secvisual/home/home/on_risk_user_top5", HttpMethod.POST,
                        requestEntity, String.class);

        System.out.println("res:" + responseEntity.getBody());
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RiskQuery {
        private String time_range;
        private int view_branch_id;
    }


    public static class SkipHttpsVerifierRequestFactory extends SimpleClientHttpRequestFactory {
        @Override
        protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
            if (connection instanceof HttpsURLConnection) {
                prepareHttpsConnection((HttpsURLConnection) connection);
            }
            super.prepareConnection(connection, httpMethod);
        }

        private void prepareHttpsConnection(HttpsURLConnection connection) {
            connection.setHostnameVerifier(new SkipHostnameVerifier());
            try {
                connection.setSSLSocketFactory(createSslSocketFactory());
            } catch (Exception ex) {
                // Ignore
            }
        }

        private SSLSocketFactory createSslSocketFactory() throws Exception {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[]{new SkipX509TrustManager()}, new SecureRandom());
            return context.getSocketFactory();
        }

        private class SkipHostnameVerifier implements HostnameVerifier {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        }

        private class SkipX509TrustManager implements X509TrustManager {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }
    }


}


