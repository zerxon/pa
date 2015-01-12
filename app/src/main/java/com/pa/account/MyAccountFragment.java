package com.pa.account;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pa.R;
import com.pa.account.controller.MyAccountController;
import com.pa.main.MainActivity;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014/12/21
 * @desc   :
 */
public class MyAccountFragment extends Fragment {

    private MyAccountController myAccountController;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "my_account_fragment";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MyAccountFragment newInstance(int sectionNumber) {
        MyAccountFragment fragment = new MyAccountFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);

        myAccountController = new MyAccountController(this.getActivity());
        myAccountController.setLayout(rootView);
        myAccountController.bindAction();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
