package ca.bitjutsu.deity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Access singleton objects globally from here.
 */
public class Deity {
    private static Deity sInstance;
    private Gson mGson;

    private Deity() {
        GsonBuilder builder = new GsonBuilder();
        /* TODO: Configure Gson with deserializers for models */
        mGson = builder.create();
    }

    public static Deity getInstance() {
        if (sInstance == null)
            sInstance = new Deity();

        return sInstance;
    }

    public static Gson getGson() {
        return getInstance().mGson;
    }
}
