package com.github.orange.authentication;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2017-05-20 13:22
 */
public class OAuth2Token implements AuthenticationToken {
	private static final long serialVersionUID = 1L;
	
	private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
