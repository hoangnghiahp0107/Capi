package com.example.capi;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class BookingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button chonthoigian;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BookingFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        chonthoigian = view.findViewById(R.id.chonthoigian);
        AddEvent(view);
        return view;
    }

    private void AddEvent(View view) {
        // Giả sử datlich là đối tượng Button đã được khởi tạo đúng
        chonthoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment BookingFragment mới
                BankFragment bankFragment = new BankFragment();

                // Chuyển dữ liệu từ fragment hiện tại sang BookingFragment
                Bundle args = new Bundle();
                bankFragment.setArguments(args);  // Gán arguments vào fragment mới

                // Thực hiện chuyển fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame, bankFragment);  // Thay thế fragment trong layout
                transaction.addToBackStack(null);  // Thêm vào back stack để có thể quay lại
                transaction.commit();  // Xác nhận thay đổi
            }
        });
    }
}