package ca.bitjutsu.deity.auth;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
	@SerializedName("access_token")
	private String mAccessToken;
	
	@SerializedName("token_type")
	private String mTokenType;
	
	public AccessToken(String token, String type) {
		mAccessToken = token;
		mTokenType = type;
	}
	
	public String getAccessToken() {
		return mAccessToken;
	}
	
	public String getTokenType() {
		return mTokenType;
	}
}
