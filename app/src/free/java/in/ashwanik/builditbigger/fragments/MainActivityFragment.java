package in.ashwanik.builditbigger.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.ashwanik.builditbigger.JokeAsyncTask;
import in.ashwanik.builditbigger.R;
import in.ashwanik.builditbigger.TaskHandler;
import in.ashwanik.jokeui.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    View view;

    @Bind(R.id.btnJoke)
    Button btnJoke;

    @Bind(R.id.adView)
    AdView adView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, view);

        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress(getProgressDialog());
                new JokeAsyncTask(new TaskHandler() {
                    @Override
                    public void onComplete(String data) {
                        hideProgress(getProgressDialog());
                        Intent intent = new Intent(getActivity(), JokeActivity.class);
                        intent.putExtra("joke", data);
                        startActivity(intent);

                    }
                }).execute();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
                .build();

        adView.loadAd(adRequest);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
