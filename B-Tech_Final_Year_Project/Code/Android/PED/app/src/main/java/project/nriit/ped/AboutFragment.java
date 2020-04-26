package project.nriit.ped;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setActionBarTitle("About");

        return inflater.inflate(R.layout.fragment_about, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        TextView text = (TextView) getView().findViewById(R.id.textView2);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView gp = (ImageView) getView().findViewById(R.id.googleplus);
        gp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://plus.google.com/u/0/+KVRKS"));
                startActivity(intent);
            }
        });
        ImageView fb = (ImageView) getView().findViewById(R.id.facebook);
        fb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/kvrks"));
                startActivity(intent);
            }
        });
        ImageView tr = (ImageView) getView().findViewById(R.id.twitter);
        tr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/kvrksastry"));
                startActivity(intent);
            }
        });
    ImageView yt = (ImageView) getView().findViewById(R.id.youtube);
        yt.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.youtube.com/channel/UCuSLGWcQmwU7aSOdEqSTb_w"));
            startActivity(intent);
        }
    });
    }
}
