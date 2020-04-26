package hdwallpapers.hdwallpapers.kvrks.com.hdwallpapers;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

/**
 * Created by kvrks on 03-03-2018.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder>{

    List<Item> items;
    Context context;
    Adapter(List<Item> items){
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        context = viewGroup.getContext();
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_row, viewGroup, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int i) {

        if(true){
            holder.downloadButton.setColorFilter(Color.parseColor("#323232"));
        }
        holder.itemDetails.setText(items.get(i).details);
        Glide.with(context).load(items.get(i).photoId).into(holder.itemPhoto);
        MainActivity.imageUrls.put(holder.itemPhoto.getTag().toString(),items.get(i).photoId);
        holder.downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = MainActivity.imageUrls.get(holder.itemPhoto.getTag().toString());
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setDescription("Wallpaper: "+holder.itemDetails.getText().toString());
                request.setTitle(holder.itemDetails.getText().toString());
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, holder.itemDetails.getText().toString());

                // get download service and enqueue file
                DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView itemDetails;
        ImageView itemPhoto;
        ImageButton downloadButton;
        ItemViewHolder(View itemView) {
            super(itemView);
            downloadButton = (ImageButton) itemView.findViewById(R.id.downloadButton);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            itemDetails = (TextView)itemView.findViewById(R.id.item_details);
            itemPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
        }
    }


}