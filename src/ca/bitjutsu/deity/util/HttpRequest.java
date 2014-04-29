package ca.bitjutsu.deity.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
	private String mMethod;
	private String mUrl;
	
	private HttpRequestCompletedListener mListener;
	
	public HttpRequest(String method, String url) {
		this(method, url, null);
	}
	
	public HttpRequest(String method, String url, HttpRequestCompletedListener listener) {
		mMethod = method;
		mUrl = url;
		
		mListener = listener;
	}
	
	public void start() {
		new Thread(new Runnable() {
			public void run() {
				try {
					final URL url = new URL(mUrl);
					
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod(mMethod);
					conn.connect();
					
					String response = "";
					String line;
					BufferedReader in = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					
					while ((line = in.readLine()) != null)
						response += line;
					
					in.close();	
					conn.disconnect();
					
					if (mListener != null)
						mListener.onCompleted(response);
				} catch (IOException e) {
					/* TODO: improve this */
					if (mListener != null)
						mListener.onError("Oops");
				}
			}
		}).start();
	}
	
	public interface HttpRequestCompletedListener {
		public void onCompleted(String data);
		public void onError(String reason);
	}
}
