package kz.bidify.dictionaryservice.security;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class JwtTokenUtil {

    public static String parseJwt(final String token) {
        if (token.startsWith("Bearer ")) {
            return token.substring(7);
        }

        return token;
    }

    public static JwtClaims getDataJWT(String token) throws Exception {
        JwtConsumer consumer = new JwtConsumerBuilder()
                .setSkipAllValidators()
                .setDisableRequireSignature()
                .setSkipSignatureVerification()
                .build();

        return consumer.processToClaims(parseJwt(token));
    }

    public static boolean parseJWT(String token) throws Exception {
        JwtConsumer consumer = new JwtConsumerBuilder()
                .setSkipAllValidators()
                .setDisableRequireSignature()
                .setSkipSignatureVerification()
                .build();
        JwtClaims claims = consumer.processToClaims(parseJwt(token));

        LocalDateTime triggerTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(claims.getExpirationTime().getValueInMillis()),
                        TimeZone.getDefault().toZoneId());

        return !triggerTime.isBefore(LocalDateTime.now());
    }
}
