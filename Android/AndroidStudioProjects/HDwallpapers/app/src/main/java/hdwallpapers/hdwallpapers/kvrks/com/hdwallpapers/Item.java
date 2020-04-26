package hdwallpapers.hdwallpapers.kvrks.com.hdwallpapers;

import android.support.annotation.NonNull;

/**
 * Created by kvrks on 03-03-2018.
 */

public class Item implements Comparable{

        String details;
        String photoId;

        Item(String details, String photoId) {

            this.details = details;
            this.photoId = photoId;
        }


    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}
