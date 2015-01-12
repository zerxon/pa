package com.pa.account;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pa.R;
import com.pa.account.controller.SignInController;
import com.pa.main.MainActivity;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/12
 * @desc   :
 */
public class SignInFragment extends Fragment {

    private SignInController signInController;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "sign_in_fragment";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SignInFragment newInstance(int sectionNumber) {
        SignInFragment fragment = new SignInFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        signInController = new SignInController(this.getActivity());
        signInController.setLayout(rootView);
        signInController.bindAction();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
