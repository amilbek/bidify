package kz.bidify.authservice.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {

    static Keycloak keycloak = null;
    private static final String REALM_ID = "master";
    private static final String CLIENT_ID = "admin-cli";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String KEYCLOAK_URL = "http://localhost:8080";

    private KeycloakConfig() {
    }

    public static Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(KEYCLOAK_URL)
                    .realm(REALM_ID)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(ADMIN_USERNAME)
                    .password(ADMIN_PASSWORD)
                    .clientId(CLIENT_ID)
                    .build();
        }
        return keycloak;
    }

    public static Keycloak newKeycloakBuilderWithPasswordCredentials(String username, String password) {
        return KeycloakBuilder
                .builder()
                .grantType("password")
                .serverUrl(KEYCLOAK_URL)
                .realm("bidify")
                .clientId("bidify")
                .username(username)
                .password(password)
                .build();
    }
}
