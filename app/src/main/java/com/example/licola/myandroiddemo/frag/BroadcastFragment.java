package com.example.licola.myandroiddemo.frag;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import butterknife.OnClick;
import com.example.licola.myandroiddemo.R;
import com.example.licola.myandroiddemo.receiver.MainLocalBroadcastReceiver;


/**
 * A simple {@link Fragment} subclass. Use the {@link BroadcastFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
public class BroadcastFragment extends BaseFragment {


  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";

  // TODO: Rename and change types of parameters
  private String mParam1;

  MainLocalBroadcastReceiver receiver;


  public BroadcastFragment() {
    // Required empty public constructor
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_module;
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @return A new instance of fragment ModuleFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static BroadcastFragment newInstance(String param1) {
    BroadcastFragment fragment = new BroadcastFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
    }
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    receiver = new MainLocalBroadcastReceiver();
    LocalBroadcastManager.getInstance(getContext())
        .registerReceiver(receiver, new IntentFilter(Intent.ACTION_PICK_ACTIVITY));
  }

  @OnClick(R.id.btn_send_broad)
  public void onBtnSendBroadClick(View view) {
    LocalBroadcastManager.getInstance(getActivity())
        .sendBroadcast(new Intent(Intent.ACTION_PICK_ACTIVITY));
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
  }
}
