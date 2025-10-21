package top.clarkhg.democms.util;

import java.util.Date;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenUtil {
	// private static Logger logger = LoggerFactory.getLogger(TokenUtil.class);

	private static final String SECRET = "CLxJO8+wni!{K4z+][yHuaGBt_V{_7T^+cTf4uBO4kxpP(;rlyvYd^H.u=!mqK3']_nfzz[SH6c7,uN'(CuSmZt1]lhYJwX8eAigdDgi%;8~_]]eqwhD&8~70Y2nDPHfP7u1SBnop0YgsCXvOU4jKJ";

	public static String genToken(String username, String password) {
		return JWT.create()
				// .withClaim("email", email)
				.withClaim("username", username)
				.withClaim("password", password)
				.withClaim("UUID", UUID.randomUUID().toString()) // 想伪造除非知道这个UUID
				.withIssuedAt(new Date())
				.sign(Algorithm.HMAC256(SECRET));
	}

	// 拿 user 的 id
	public static String getUsername(String token) {
		try {
			DecodedJWT djwt = JWT.decode(token);
			// System.out.println("djwt: "+djwt);
			String username=djwt.getClaim("username").asString();
			// System.out.println("Username: "+username);
			return username;
		} catch (Exception e) {
			log.debug("Token->username failed!");
			return null;
		}
	}

	// role:0-null,1-admin
	public static Integer getRole(String token) {
		try {
			DecodedJWT djwt = JWT.decode(token);
			return djwt.getClaim("role").asInt();
		} catch (Exception e) {
			return null;
		}
	}

}




