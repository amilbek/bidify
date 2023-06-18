package kz.bidify.authservice.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    private static final String realmId = "master";
    private static final String clientId = "admin-cli";
    private static final String adminUsername = "admin";
    private static final String adminPassword = "admin";
    private static final String keycloakUrl = "http://localhost:8080";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(keycloakUrl)
                    .realm(realmId)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(adminUsername)
                    .password(adminPassword)
                    .clientId(clientId)
                    .build();
        }
        return keycloak;
    }

    public static Keycloak newKeycloakBuilderWithPasswordCredentials(String username, String password) {
        return KeycloakBuilder
                .builder()
                .grantType("password")
                .serverUrl(keycloakUrl)
                .realm("bidify")
                .clientId("bidify")
                .username(username)
                .password(password)
                .build();
    }
}
