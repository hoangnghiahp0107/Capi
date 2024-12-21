package com.example.capi;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout group, personal;
    private PopupWindow popupWindow; // Thêm biến để lưu tham chiếu PopupWindow
    private TextView tinhcam, congviec, giadinh, khac, banbe, ramdom;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Lấy tham chiếu LinearLayout
        group = view.findViewById(R.id.group);
        personal = view.findViewById(R.id.personal);
        // Gọi phương thức AddEvent sau khi view đã được khởi tạo
        AddEvent(view);

        return view;
    }
    private void handlePopupOption(String option) {
        // Kiểm tra xem Fragment hiện tại có phải là DoctorFragment chưa
        DoctorFragment doctorFragment = new DoctorFragment();

        // Đặt thông tin cho DoctorFragment nếu cần, ví dụ như tên hoặc loại dịch vụ
        Bundle args = new Bundle();
        args.putString("selected_option", option);
        doctorFragment.setArguments(args);

        // Thực hiện chuyển fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, doctorFragment); // R.id.fragment_container là ID của container chứa fragment
        transaction.addToBackStack(null); // Để có thể quay lại fragment trước đó
        transaction.commit();

        // Đóng PopupWindow
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    private void AddEvent(View view){
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem PopupWindow có đang mở hay không
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    // Tạo PopupWindow mới và hiển thị
                    View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_group, null);
                    popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    // Khởi tạo các TextView trong popup
                    banbe = popupView.findViewById(R.id.banbe);
                    ramdom = popupView.findViewById(R.id.ramdom);

                    // Thêm sự kiện cho từng TextView
                    banbe.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showPopupLayout(view, "Bạn bè, người quen");
                        }
                    });

                    ramdom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showPopupLayout(view, "Ngẫu nhiên");
                        }
                    });



                    // Hiển thị PopupWindow ở giữa màn hình
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                }
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra xem PopupWindow có đang mở hay không
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    // Tạo PopupWindow mới và hiển thị
                    View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_layout, null);
                    popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    // Khởi tạo các TextView trong popup
                    tinhcam = popupView.findViewById(R.id.tinhcam);
                    congviec = popupView.findViewById(R.id.congviec);
                    giadinh = popupView.findViewById(R.id.giadinh);
                    khac = popupView.findViewById(R.id.khac);

                    // Thêm sự kiện cho từng TextView
                    tinhcam.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Chuyển đến DoctorFragment khi chọn "Tình cảm"
                            handlePopupOption("Tình cảm");
                        }
                    });

                    congviec.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Chuyển đến DoctorFragment khi chọn "Công việc"
                            handlePopupOption("Công việc");
                        }
                    });

                    giadinh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Chuyển đến DoctorFragment khi chọn "Gia đình"
                            handlePopupOption("Gia đình");
                        }
                    });

                    khac.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Chuyển đến DoctorFragment khi chọn "Khác"
                            handlePopupOption("Khác");
                        }
                    });

                    // Hiển thị PopupWindow ở giữa màn hình
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Kiểm tra xem PopupWindow có đang mở không, nếu có thì đóng nó
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    // Phương thức mới để hiển thị popup_layout khi chọn banbe hoặc ramdom
    private void showPopupLayout(View view, String option) {
        // Đảm bảo rằng popup_group được đóng trước khi hiển thị popup_layout
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss(); // Đóng popup hiện tại nếu có
        }

        // Tạo PopupWindow mới và hiển thị
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_layout, null);
        popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        // Khởi tạo các TextView trong popup
        tinhcam = popupView.findViewById(R.id.tinhcam);
        congviec = popupView.findViewById(R.id.congviec);
        giadinh = popupView.findViewById(R.id.giadinh);
        khac = popupView.findViewById(R.id.khac);

        // Thêm sự kiện cho từng TextView
        tinhcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến DoctorFragment khi chọn "Tình cảm"
                handlePopupOption("Tình cảm");
            }
        });

        congviec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến DoctorFragment khi chọn "Công việc"
                handlePopupOption("Công việc");
            }
        });

        giadinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến DoctorFragment khi chọn "Gia đình"
                handlePopupOption("Gia đình");
            }
        });

        khac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến DoctorFragment khi chọn "Khác"
                handlePopupOption("Khác");
            }
        });

        // Hiển thị PopupWindow ở giữa màn hình
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }}
