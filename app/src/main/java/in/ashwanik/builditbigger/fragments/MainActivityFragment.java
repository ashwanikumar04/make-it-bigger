package in.ashwanik.builditbigger.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.ashwanik.builditbigger.JokeAsyncTask;
import in.ashwanik.builditbigger.R;
import in.ashwanik.builditbigger.TaskHandler;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    View view;
    @Bind(R.id.btnJoke)
    Button btnJoke;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this, view);

        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JokeAsyncTask()
                        .execute(new Pair<Context, TaskHandler>(getActivity(), new TaskHandler() {
                            @Override
                            public void onComplete(String data) {

                            }
                        }));
            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
