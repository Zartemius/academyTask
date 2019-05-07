package com.example.darte.academytask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.Router;

public class FragmentThree extends Fragment {

    TextView textView;
    Router router;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);

        textView = view.findViewById(R.id.pirato_text);
        textView.setText("three_fragment");

        router = AcademyApplication.INSTANCE.getChildRouter();
        //navigatorHolder =  AcademyApplication.INSTANCE.getNavigatorHolder();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button_in_child);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("pirato");
                //router.navigateTo(new Screens.TwoFragment());
                router.backTo(null);

            }
        });
    }
}
