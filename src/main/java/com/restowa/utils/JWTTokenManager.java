/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restowa.utils;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmConstraints.ConstraintType;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

/**
 * singleton gérant les tokens (JWT)
 * @author Paul
 */
public class JWTTokenManager {
    
    
    private static RsaJsonWebKey rsaJsonWebKey;
    
    private static JWTTokenManager currentInstance;
    
    /**
     * Constructeur privé de JWTTokenManager
     */
    private JWTTokenManager() {
        try { 
            // génére une clé RSA
            rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
            rsaJsonWebKey.setKeyId("k1");
        } catch (JoseException ex) {
            Logger.getLogger(JWTTokenManager.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    /**
     * Fonction permettant d'accéder à cette classe en la créant si elle n'existe pas ou en retournant l'instance de la classe si elle existe
     * @return la seul instance de cette classe
     */
    public static JWTTokenManager getInstance() {
            if (currentInstance == null)
                    currentInstance = new JWTTokenManager();

            return currentInstance;
    }
   
    /**
     * Génere le token à partir d'un userId, l'encrypte puis le return sous la forme d'un String
     * @param userId
     * @return
     * @throws JoseException 
     */
    public String generateToken(int userId) throws JoseException{

        // créer le claims qui est le contenu du token et le rempli d'information
        JwtClaims claims = new JwtClaims();  
        claims.setIssuer("Issuer");  // qui a créé ce token
        claims.setAudience("Audience"); // pour qui est ce token
        claims.setExpirationTimeMinutesInTheFuture(3600); // quand ce token expire
        claims.setGeneratedJwtId(); // créer un id pour ce token
        claims.setIssuedAtToNow();  // date de création du token
        claims.setSubject("subject"); // sujet du token
        claims.setNotBeforeMinutesInThePast(1); // temps avant que le token soit valide
        claims.setClaim("id",userId); // un attribut du token, l'id de l'utilisateur
    
        // créer le jws token puis l'encrypte
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        String jwt = jws.getCompactSerialization(); 

        return jwt;
    }
    
    /**
     * Vérifie si les tokens sont les mêmes et si ils sont valides
     * @param headerJwt le token venant du header 
     * @param userJwt le token venant de l'utilisateur dont on a besoin des informations
     * @return un string indicant si la verification est valide ou donnant des informations sur pourquoi elle ne l'est pas
     */
    public String verifyToken(String headerJwt, String userJwt){
        String result = "";
        // compare les 2 tokens
        if (headerJwt.equals(userJwt)){
            // vérifie le token et son contenu
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime() 
                    .setAllowedClockSkewInSeconds(30) 
                    .setRequireSubject() 
                    .setExpectedIssuer("Issuer") 
                    .setExpectedAudience("Audience") 
                    .setVerificationKey(rsaJsonWebKey.getKey()) 
                    .setJwsAlgorithmConstraints( 
                            new AlgorithmConstraints(ConstraintType.WHITELIST,
                                    AlgorithmIdentifiers.RSA_USING_SHA256))
                    .build(); 

            try
            {
                //  valide le token
                JwtClaims jwtClaims = jwtConsumer.processToClaims(headerJwt);
                result = "Token validation succeeded! " + jwtClaims;
            }
            catch (InvalidJwtException e)
            {
                // le token est invalide
                result = "Invalid Token! " + e;

                // le token a expiré
                if (e.hasExpired())
                {
                    try {
                        result = "\n" + "Token expired at " + e.getJwtContext().getJwtClaims().getExpirationTime();
                    } catch (MalformedClaimException ex) {
                        Logger.getLogger(JWTTokenManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                // l'audience est invalide
                if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID))
                {
                    try {
                        result = "\n" + "Token had wrong audience: " + e.getJwtContext().getJwtClaims().getAudience();
                    } catch (MalformedClaimException ex) {
                        Logger.getLogger(JWTTokenManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else{
            result = "Wrong Token! ";
        }
        
        return result;
    }   
    
}
