package in.ashwanik.builditbigger.fragments;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import in.ashwanik.builditbigger.activity.MainActivity;
import in.ashwanik.builditbigger.common.BaseApplication;
import in.ashwanik.builditbigger.common.Constants;
import in.ashwanik.retroclient.ui.TransparentProgressDialog;

/**
 * A placeholder fragment containing a simple view.
 */
public class BaseFragment extends Fragment {

    public void showSnackBar(String message) {
        MainActivity baseActivity = (MainActivity) getActivity();
        baseActivity.showSnackBar(message, baseActivity.getCoordinatorLayout());
    }

    protected TransparentProgressDialog progressDialog;


    public void logDebug(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Log.d(Constants.LOG_CATEGORY, message);
    }

    public TransparentProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new TransparentProgressDialog(getActivity(), BaseApplication.getInstance().getProgressViewColor());
            progressDialog.setCancelable(false);
        }
        return progressDialog;
    }

    public void showProgress(TransparentProgressDialog progressDialog) {
        if (progressDialog == null) {
            return;
        }
        if (getActivity().isFinishing()) {
            return;
        }
        progressDialog.show();
    }

    public void hideProgress(TransparentProgressDialog progressDialog) {

        if (getActivity().isFinishing()) {
            return;
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}
