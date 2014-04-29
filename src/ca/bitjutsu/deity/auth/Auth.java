package ca.bitjutsu.deity.auth;

import java.util.ArrayList;

import ca.bitjutsu.deity.util.HttpRequest;
import ca.bitjutsu.deity.util.HttpRequest.HttpRequestCompletedListener;

import com.google.gson.Gson;

public class Auth {
	private String mClientId;
	private String mClientSecret;
	
	private ArrayList<TokenRetrievedListener> mListeners;
	
	public Auth(String clientId, String clientSecret) {
		this.mClientId = clientId;
		this.mClientSecret = clientSecret;
		
		this.mListeners = new ArrayList<TokenRetrievedListener>();
	}
	
	/* Supported scopes: talent, invest, message, email, comment */
	/* No support for talent API yet */
	public String getAuthUrl(String... scopes) {
		String requestedScopes = "";
		
		/* Trailing space doesn't matter */
		for (String scope : scopes)
			requestedScopes += scope + "%20";
		
		return "https://angel.co/api/oauth/authorize?" +
				"client_id=" + mClientId +
				"&scope=" + requestedScopes +
				"&response_type=code";
	}

	public void retrieveAccessToken(final String code) {
		String url = "https://angel.co/api/oauth/token?" +
				"client_id=" + mClientId +
				"&client_secret=" + mClientSecret +
				"&code=" + code +
				"&grant_type=authorization_code";
		
		new HttpRequest("POST", url, new HttpRequestCompletedListener() {
			@Override
			public void onCompleted(String data) {
				Gson gson = new Gson();
				AccessToken token = gson.fromJson(data, AccessToken.class);
				
				notifyListeners(token);
			}

			@Override
			public void onError(String reason) { }
		}).start();
	}
	
	public void addListener(TokenRetrievedListener listener) {
		mListeners.add(listener);
	}
	
	public void removeListener(TokenRetrievedListener listener) {
		mListeners.remove(listener);
	}
	
	private void notifyListeners(AccessToken token) {
		for (TokenRetrievedListener listener : mListeners)
			if (listener != null)
				listener.notify(token);
	}
	
	public interface TokenRetrievedListener {
		public void notify(AccessToken token);
	}
}
