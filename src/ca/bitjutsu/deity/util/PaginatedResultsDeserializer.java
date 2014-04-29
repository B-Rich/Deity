package ca.bitjutsu.deity.util;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ca.bitjutsu.deity.DeepCloneable;
import ca.bitjutsu.deity.Deity;
import ca.bitjutsu.deity.impl.ActivityFeedItemImpl;
import ca.bitjutsu.deity.impl.PaginatedResults;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class PaginatedResultsDeserializer<E extends DeepCloneable>
		implements JsonDeserializer<PaginatedResults<E>> {
	
	private String mItemName;
	
	public PaginatedResultsDeserializer(String itemName) {
		mItemName = itemName;
	}

	@Override
	public PaginatedResults<E> deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject obj = json.getAsJsonObject();
		JsonArray data = obj.get(mItemName).getAsJsonArray();
		obj.remove(mItemName);
		
		Gson gson = Deity.getGson();
		Type typeOfElements = new TypeToken<ArrayList<ActivityFeedItemImpl>>(){}.getType();
		ArrayList<ActivityFeedItemImpl> elements = gson.fromJson(data, typeOfElements);
		System.out.println(elements.get(0));
		PaginatedResults<E> page = gson.fromJson(obj, type);
		//page.setElements(elements);
		return page;
	}
	
	public @interface DoNotSerialize { }
	
	public static class AnnotatedExclusionStrategy implements ExclusionStrategy {

		@Override
		public boolean shouldSkipClass(Class<?> clazz) {
			return clazz.getAnnotation(DoNotSerialize.class) != null;
		}

		@Override
		public boolean shouldSkipField(FieldAttributes attrs) {
			return attrs.getAnnotation(DoNotSerialize.class) != null;
		}
		
	}
}
