package in.ashwanik.builditbigger.fragments;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import in.ashwanik.builditbigger.activity.MainActivity;
import in.ashwanik.builditbigger.common.Constants;
import in.ashwanik.retroclient.entities.ErrorData;
import in.ashwanik.retroclient.utils.Helpers;

/**
 * A placeholder fragment containing a simple view.
 */
public class BaseFragment extends Fragment {

    public void showSnackBar(String message) {
        MainActivity baseActivity = (MainActivity) getActivity();
        baseActivity.showSnackBar(message, baseActivity.getCoordinatorLayout());
    }

    public void showSnackBar(ErrorData errorData) {
        MainActivity baseActivity = (MainActivity) getActivity();
        baseActivity.showSnackBar(errorData, baseActivity.getCoordinatorLayout());
    }


    public void logDebug(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Helpers.d(Constants.LOG_CATEGORY, message);
    }
}
