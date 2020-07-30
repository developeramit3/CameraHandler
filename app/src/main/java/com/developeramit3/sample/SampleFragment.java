package com.developeramit3.sample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.developeramit3.adapters.MyAdapter;
import com.developeramit3.Handler.CameraOptions;
import com.developeramit3.Handler.CameraHandler;
import com.developeramit3.utility.PermUtil;

import java.util.ArrayList;

public class SampleFragment extends Fragment {
private static final String ARG_PARAM1 = "param1";
private static final String ARG_PARAM2 = "param2";
RecyclerView recyclerView;
MyAdapter myAdapter;
CameraOptions cameraOptions;
ArrayList<String> returnValue = new ArrayList<>();
public SampleFragment() {
	// Required empty public constructor
}

public static SampleFragment newInstance(String param1, String param2) {
	SampleFragment fragment = new SampleFragment();
	Bundle args = new Bundle();
	args.putString(ARG_PARAM1, param1);
	args.putString(ARG_PARAM2, param2);
	fragment.setArguments(args);
	return fragment;
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View root = inflater.inflate(R.layout.fragment_sample, container, false);
	RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
	recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
	myAdapter = new MyAdapter(getActivity());
	cameraOptions = CameraOptions.init()
			.setRequestCode(100)
			.setCount(5)
			.setScreenOrientation(CameraOptions.SCREEN_ORIENTATION_PORTRAIT);
	recyclerView.setAdapter(myAdapter);
	root.findViewById(R.id.fab).setOnClickListener((View view) -> {
		CameraHandler.start(this, cameraOptions);
	});
	return root;
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	//Log.e("val", "requestCode ->  " + requestCode+"  resultCode "+resultCode);
	switch (requestCode) {
		case (100): {
			if (resultCode == Activity.RESULT_OK) {
				returnValue = data.getStringArrayListExtra(CameraHandler.IMAGE_RESULTS);
				myAdapter.addImage(returnValue);
			}
		}
		break;
	}
}

@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
	switch (requestCode) {
		case PermUtil.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
			// If request is cancelled, the result arrays are empty.
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				CameraHandler.start(SampleFragment.this, cameraOptions);
			} else {
				Toast.makeText(getActivity(), "Approve permissions to open Pix ImagePicker",
						Toast.LENGTH_LONG).show();
			}
			return;
		}
	}
}
}
