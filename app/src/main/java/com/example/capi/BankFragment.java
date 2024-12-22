package com.example.capi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout atm, lienket, momo, zalopay;

    public BankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BankFragment newInstance(String param1, String param2) {
        BankFragment fragment = new BankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bank, container, false);
        atm = view.findViewById(R.id.atm);
        lienket = view.findViewById(R.id.lienket);
        momo = view.findViewById(R.id.momo);
        zalopay = view.findViewById(R.id.zalopay);
        AddEvent(view);
        return view;
    }
    private void AddEvent(View view) {
        // Giả sử datlich là đối tượng Button đã được khởi tạo đúng
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment BookingFragment mới
                RoomFragment roomFragment = new RoomFragment();

                // Chuyển dữ liệu từ fragment hiện tại sang BookingFragment
                Bundle args = new Bundle();
                roomFragment.setArguments(args);  // Gán arguments vào fragment mới

                // Thực hiện chuyển fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, roomFragment);  // Thay thế fragment trong layout
                transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại
                transaction.commit();  // Xác nhận thay đổi
            }
        });
        lienket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment BookingFragment mới
                RoomFragment roomFragment = new RoomFragment();

                // Chuyển dữ liệu từ fragment hiện tại sang BookingFragment
                Bundle args = new Bundle();
                roomFragment.setArguments(args);  // Gán arguments vào fragment mới

                // Thực hiện chuyển fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, roomFragment);  // Thay thế fragment trong layout
                transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại
                transaction.commit();  // Xác nhận thay đổi
            }
        });
        momo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment BookingFragment mới
                RoomFragment roomFragment = new RoomFragment();

                // Chuyển dữ liệu từ fragment hiện tại sang BookingFragment
                Bundle args = new Bundle();
                roomFragment.setArguments(args);  // Gán arguments vào fragment mới

                // Thực hiện chuyển fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, roomFragment);  // Thay thế fragment trong layout
                transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại
                transaction.commit();  // Xác nhận thay đổi
            }
        });
        zalopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment BookingFragment mới
                RoomFragment roomFragment = new RoomFragment();

                // Chuyển dữ liệu từ fragment hiện tại sang BookingFragment
                Bundle args = new Bundle();
                roomFragment.setArguments(args);  // Gán arguments vào fragment mới

                // Thực hiện chuyển fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, roomFragment);  // Thay thế fragment trong layout
                transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại
                transaction.commit();  // Xác nhận thay đổi
            }
        });
    }
}