package com.example.darte.academytask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.Router;

public class FragmentTwo extends Fragment  {

    private Router router;
    TextView textView;
    //private NavigatorHolder navigatorHolder;
    // private Navigator navigator = new SupportAppNavigator(getActivity(),R.id.container);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);

        textView = view.findViewById(R.id.pirato_text);
        textView.setText("two_fragment");

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
                //textView.setText("sec_screen");
                router.navigateTo(new Screens.ThreeFragment());
            }
        });
    }

}
