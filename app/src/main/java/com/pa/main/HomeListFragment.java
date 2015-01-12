package com.pa.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pa.R;
import com.pa.main.controller.HomeController;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2014-10-2
 * @desc   :
 */
public class HomeListFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private HomeController homeController;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeListFragment newInstance(int sectionNumber) {
        HomeListFragment fragment = new HomeListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        homeController = new HomeController(this.getActivity());
        homeController.setLayout(rootView);
        homeController.bindAction();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

}
