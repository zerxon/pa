package com.pa.order;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pa.R;
import com.pa.main.MainActivity;
import com.pa.main.controller.HomeController;
import com.pa.order.controller.MyOrderController;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2015/1/12
 * @desc   :
 */
public class MyOrderFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "my_order_fragment";

    private MyOrderController myOrderController;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MyOrderFragment newInstance(int sectionNumber) {
        MyOrderFragment fragment = new MyOrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order, container, false);

        myOrderController = new MyOrderController(this.getActivity());
        myOrderController.setLayout(rootView);
        myOrderController.bindAction();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
