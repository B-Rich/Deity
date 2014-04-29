package ca.bitjutsu.deity.impl;

import java.util.List;

import ca.bitjutsu.deity.DeepCloneable;
import ca.bitjutsu.deity.entity.ActivityFeedItem;
import ca.bitjutsu.deity.entity.Followable;
import ca.bitjutsu.deity.entity.User;

import com.google.gson.annotations.SerializedName;

public class ActivityFeedItemImpl implements ActivityFeedItem, DeepCloneable {
	@SerializedName("id")
	private String mId;
	
	@SerializedName("timestamp")
	private String mCreatedAt;
	
	@SerializedName("description")
	private String mDescription;
	
	@SerializedName("text")
	private String mText;
	
	@SerializedName("actor")
	private Followable mActor;
	
	@SerializedName("target")
	private Followable mTarget;
	
	@SerializedName("item.ids")
	private List<Integer> mGenerators;
	
	@SerializedName("promoted_by")
	private List<User> mPromoters;
	
	@SerializedName("likes")
	private int mLikes;
	
	@SerializedName("comments")
	private int mComments;
	
	@Override
	public String getId() {
		return mId;
	}

	@Override
	public String getCreatedAt() {
		return mCreatedAt;
	}

	@Override
	public String getDescription() {
		return mDescription;
	}

	@Override
	public String getText() {
		return mText;
	}

	@Override
	public Followable getActor() {
		return mActor;
	}

	@Override
	public Followable getTarget() {
		return mTarget;
	}

	@Override
	public List<Integer> getGenerators() {
		/* TODO: clone? */
		return mGenerators;
	}

	@Override
	public List<User> getPromoters() {
		// TODO Clone
		return mPromoters;
	}

	@Override
	public int getNumLikes() {
		return mLikes;
	}

	@Override
	public int getNumComments() {
		return mComments;
	}

	@Override
	public Object deepClone() {
		ActivityFeedItemImpl item = new ActivityFeedItemImpl();
		item.mId = this.mId;
		item.mComments = this.mComments;
		item.mCreatedAt = this.mCreatedAt;
		item.mDescription = this.mDescription;
		item.mGenerators = this.getGenerators();
		item.mText = this.mText;
		item.mLikes = this.mLikes;
		item.mPromoters = this.getPromoters();
		item.mTarget = this.mTarget;
		item.mActor = this.mActor;
		
		return item;
	}
}
