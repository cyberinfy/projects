package hdwallpapers.hdwallpapers.kvrks.com.hdwallpapers;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener{
    int n,id = R.id.refresh;
    Intent intent;
    String filterText;
    private List<Item> items;
    public static HashMap<String,String> imageUrls;
    private String TAG="";
    SwipeRefreshLayout mSwipeRefreshLayout;
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        intent = new Intent(getApplicationContext(),LauncherActivity.class);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);

        //Search View
        MenuItem searchItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(isNetworkAvailable() == false)
            startActivity(intent);
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {

            onRefresh();
            return true;
        }

        else if (id == R.id.sort) {

            onRefresh();
            return true;
        }
        else if (id == R.id.search_view) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecycleView();
        // SwipeRefreshLayout
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {
                // Fetching data from server
                if(isNetworkAvailable())
                createRecycleView();
            }
        });

        }

        public void createRecycleView(){

            if(isNetworkAvailable()) {

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("name", "something");
                            final String str = (performPostCall("http://www.krishnasastry.me/wallpaperscount.php", hashMap).toString());

                            try {
                                n = Integer.parseInt(str.substring(1, str.length() ));
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (n==0) {
                                        Toast.makeText(getApplicationContext(), "No wallpapers", Toast.LENGTH_LONG).show();
                                    } else {
//                                        Toast.makeText(getApplicationContext(), Integer.toString(n), Toast.LENGTH_LONG).show();
                                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                                            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                                    == PackageManager.PERMISSION_DENIED) {

                                                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                                                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                                                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

                                            }
                                        }
                                        imageUrls = new HashMap<String,String>();
                                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                                        recyclerView.setHasFixedSize(true);
                                        items = new ArrayList<Item>();
                                        //allocating values

                                        if(id == R.id.search_view)
                                        {
                                            for (int i = 1; i <= n; i++) {
                                                if(Integer.toString(i).contains(filterText))
                                                items.add(new Item("" + i + ".jpg", "http://www.krishnasastry.me/wallpapersd/" + i + ".jpg"));
                                            }
//                                            List<Item> itemsCopy = new ArrayList<Item>();
//                                            itemsCopy.addAll(items);
//                                            items.clear();
//                                            if(filterText.isEmpty()){
//                                                items.addAll(itemsCopy);
//                                            } else{
//                                                filterText = filterText.toLowerCase();
//                                                for(Item item: itemsCopy){
//                                                    if(item.details.contains(filterText)){
//                                                        items.add(item);
//                                                    }
//                                                }
//                                            }
                                        }
                                        else {
//                                           Toast.makeText(getApplicationContext(),"not Search",Toast.LENGTH_LONG).show();
                                            for (int i = n; i > 0; i--) {
                                                items.add(new Item("" + i + ".jpg", "http://www.krishnasastry.me/wallpapersd/" + i + ".jpg"));
                                            }

                                            if (id == R.id.sort)
                                                Collections.sort(items);
                                            else
                                                Collections.shuffle(items);
                                        }
                                        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                                        recyclerView.setLayoutManager(llm);
                                        Adapter adapter = new Adapter(items);
                                        recyclerView.setAdapter(adapter);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
            else
            {
                if(isNetworkAvailable() == false)
                    startActivity(intent);
            }
        }

    //From here to the end post process is executed using the below two functions
    public String  performPostCall(String requestURL, HashMap<String, String> postDataParams) {

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onRefresh() {
        if(isNetworkAvailable() == false)
            startActivity(intent);
            deleteCache(getApplicationContext());
            mSwipeRefreshLayout.setRefreshing(true);
            Handler mHandler = new Handler();
            createRecycleView();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }, 5000);
        }


    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
            id = R.id.search_view;
            filterText = s;
            onRefresh();
            return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        id = R.id.search_view;
        filterText = s;
        onRefresh();
        return true;
    }


}
