package com.tatonimatteo.waterhealth.fragment.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tatonimatteo.waterhealth.R;
import com.tatonimatteo.waterhealth.fragment.StationDetailsViewModel;

public class StationInfo extends Fragment {

    private StationDetailsViewModel viewModel;
    private TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(StationDetailsViewModel.class);
        return inflater.inflate(R.layout.station_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.stationName);

        viewModel.getSelectedStation().observe(getViewLifecycleOwner(), station -> {
            if (station != null) {
                name.setText(station.getName());
            }
        });
    }
}