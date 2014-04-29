package ca.bitjutsu.deity.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ca.bitjutsu.deity.DeepCloneable;
import ca.bitjutsu.deity.util.HttpRequest;
import ca.bitjutsu.deity.util.HttpRequest.HttpRequestCompletedListener;
import ca.bitjutsu.deity.util.PaginatedResultsDeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class PaginatedResults<E extends DeepCloneable> {
	@SerializedName("last_page")
	private int mLastPage;
	
	@SerializedName("page")
	private int mLatestPage = 0;
	
	@SerializedName("per_page")
	private int mPerPage;
	
	@SerializedName("total")
	private int mTotal;
	
//	@DoNotSerialize
	private ArrayList<E> mElements;
	
	private String mContentUrl;
	private boolean mUpdating;
	
	private OnNextPageLoadedListener<E> mListener;
	
	public PaginatedResults(String url) {
		mLatestPage = 0;
		mElements = new ArrayList<E>();
		mContentUrl = url;
		mLastPage = 1;
	}
	
	/* Return null to signal end of data or next page loading */
	public E get(int index) {
		if (index < mElements.size()) {
			return mElements.get(index);
		} else if (mUpdating) {
			return null;
		} else {
			/* Need a new page if it exists */
			if (this.hasNextPage())
				fetchNextPage();
			else
				notifyListeners(null);
			
			return null;
		}
	}
	
	public void setListener(OnNextPageLoadedListener<E> listener) {
		mListener = listener;
	}
	
	private void notifyListeners(List<E> results) {
		if (mListener != null)
			mListener.notify(results);
	}

	private void fetchNextPage() {
		/* Make asynchronous GET request using mContentUrl */
		mUpdating = true;
		mLatestPage++;
		new HttpRequest("GET", mContentUrl + "?page=" + mLatestPage,
				new HttpRequestCompletedListener() {			
			@Override
			public void onCompleted(String data) {
				System.out.println(data);
				mLastPage = 4;
				mTotal = 100;
				
				GsonBuilder gbuild = new GsonBuilder();
				Type type = new TypeToken<PaginatedResults<E>>(){}.getType();
				gbuild.registerTypeAdapter(type, new PaginatedResultsDeserializer<E>("feed"));
				Gson gson = gbuild.create();
				PaginatedResults<E> result = gson.fromJson(data, type);
				mTotal = result.mTotal;
				mLastPage = result.mLastPage;
				
				mElements.addAll(result.getAll());
				
				notifyListeners(result.getAll());
				mUpdating = false;
			}

			@Override
			public void onError(String reason) {
				notifyListeners(null);
			}
		}).start();
	}
	
	public void setElements(List<E> elements) {
		mElements = (ArrayList<E>) elements;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		ArrayList<E> clone = new ArrayList<E>();
		
		for (E el : mElements)
			clone.add((E) el.deepClone());
		
		return clone;
	}

	public boolean hasNextPage() {
		return (mLatestPage < mLastPage);
	}
	
	/* package */ void setContentUrl(String url) {
		this.mContentUrl = url;
	}
	
	public interface OnNextPageLoadedListener<E> {
		public void notify(List<E> results);
	}
	
	public static void main(String[] args) throws InterruptedException {
		OnNextPageLoadedListener<ActivityFeedItemImpl> listener = new OnNextPageLoadedListener<ActivityFeedItemImpl>() {
			@Override
			public void notify(List<ActivityFeedItemImpl> results) {
				if (results == null)
					return;
				
				for (ActivityFeedItemImpl el : results)
					System.out.println(el.getId());
			}
		};
		
		PaginatedResults<ActivityFeedItemImpl> feed = new PaginatedResults<ActivityFeedItemImpl>("https://api.angel.co/1/feed");
		feed.setListener(listener);
		
		System.out.println(feed.get(0));
		
		Thread.sleep(4000);
		System.out.println(feed.get(0));
	}
}
