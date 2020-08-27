package com.tyron.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;


public class JwtHelper {
    public static Claims parseJWT(String jsonWebToken, String base64Security){
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    
    //iss：Issuer，发行者
//    sub：Subject，主题
//    aud：Audience，观众
//    exp：Expiration time，过期时间
//    nbf：Not before
//    iat：Issued at，发行时间
//    jti：JWT ID

    public static String createJWT( String audience, String issuer,
                                   long TTLMills, String base64Security){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);
        //生成签名密匙
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ","JWT")
                .claim("businessLine","_WMS")
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm,signingKey);
        //添加token过期时间
        if (TTLMills >=0 ){
            long expMills = nowMills + TTLMills;
            Date exp = new Date(expMills);
            builder.setExpiration(exp).setNotBefore(now);
        }
        //生成JWT
        return builder.compact();
    }

    public static String getJWTForCoor(String businessLine) {
          long TTLMills = 30000*1000;
    	  SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
          long nowMills = System.currentTimeMillis();
          Date now = new Date(nowMills);
          //生成签名密匙
          byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("0297AA1C20032F1D1E649F1F9442F17C");
          Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
          //添加构成JWT的参数
          JwtBuilder builder = Jwts.builder().setHeaderParam("typ","JWT")
                  .claim("businessLine",businessLine+ "_wms")
                  .setIssuer("wms")
                  .setAudience("coor")
                  .signWith(signatureAlgorithm,signingKey);
          //添加token过期时间
          if (TTLMills >=0 ){
              long expMills = nowMills + TTLMills;
              Date exp = new Date(expMills);
              builder.setExpiration(exp).setNotBefore(now);
          }
          //生成JWT
          return "bearer_"+builder.compact();
    }

}
