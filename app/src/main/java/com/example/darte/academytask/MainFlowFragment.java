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
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainFlowFragment extends Fragment implements BackButtonListener {

    /*Router router;
    private Navigator navigator;
    private NavigatorHolder navigatorHolder;*/

    Router router2;
    private Navigator navigator2;
    private NavigatorHolder navigatorHolder2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_flow,container,false);

        /*navigator = new SupportAppNavigator(getActivity(),getChildFragmentManager(),R.id.pirato_container);
        navigatorHolder = AcademyApplication.INSTANCE.getNavigatorHolder();

        navigatorHolder.setNavigator(navigator);
        router = AcademyApplication.INSTANCE.getRouter();*/

        Button mainButton = view.findViewById(R.id.main_flow__button);
        final TextView text = view.findViewById(R.id.main_flow__text);

        ///////////////////////////////////////////////////////

        router2 = AcademyApplication.INSTANCE.getChildRouter();
        navigator2 = new SupportAppNavigator(getActivity(),getChildFragmentManager(),R.id.pirato_container);
        navigatorHolder2 = AcademyApplication.INSTANCE.getChildNavigatorHolder();
        navigatorHolder2.setNavigator(navigator2);


        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //router2.newRootChain(new Screens.OneFragment());
                text.setText("PIRATO");
                router2.navigateTo(new Screens.OneFragment());

            }
        });

        Button mainButtonSecond = view.findViewById(R.id.main_flow__button_second);

        mainButtonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //router2.navigateTo(new Screens.TwoFragment());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onBackPressed() {
        router2.exit();
        //router2.finishChain();
        return true;
    }
}
