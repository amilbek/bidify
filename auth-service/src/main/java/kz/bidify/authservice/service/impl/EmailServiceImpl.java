package kz.bidify.authservice.service.impl;

import kz.bidify.authservice.config.KeycloakConfig;
import kz.bidify.authservice.service.EmailService;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class EmailServiceImpl implements EmailService {

    private final RestTemplate restTemplate;

    @Value("${keycloak.url}")
    private String keycloakUrl;

    @Value("${keycloak.realm_id}")
    private String realmId;

    public EmailServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendVerifyEmail(String id) {
        Keycloak keycloak = KeycloakConfig.getInstance();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(keycloak.tokenManager().getAccessTokenString());
        String sendVerifyEmailUrl = keycloakUrl + "/admin/realms/" + realmId + "/users/" + id + "/send-verify-email";
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.exchange(URI.create(sendVerifyEmailUrl), HttpMethod.PUT, entity, String.class);
    }
}
