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
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class FragmentOne extends Fragment implements BackButtonListener{

    //private Router router;
    TextView textView;
    //private NavigatorHolder navigatorHolder;
   // private Navigator navigator = new SupportAppNavigator(getActivity(),R.id.container);


    Router router2;
    private Navigator navigator2;
    private NavigatorHolder navigatorHolder2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);

        textView = view.findViewById(R.id.pirato_text);
        textView.setText("one_fragment");

        //router = AcademyApplication.INSTANCE.getRouter();
        //navigatorHolder =  AcademyApplication.INSTANCE.getNavigatorHolder();

        router2 = AcademyApplication.INSTANCE.getChildRouter();
        /*navigator2 = new SupportAppNavigator(getActivity(),getFragmentManager(),R.id.pirato_container);
        navigatorHolder2 = AcademyApplication.INSTANCE.getNavigatorHolder();
        navigatorHolder2.setNavigator(navigator2);*/

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
                router2.navigateTo(new Screens.TwoFragment());
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        //router2.backTo(new Screens.ThreeFragment());
        router2.exit();
        return true;
    }
}
