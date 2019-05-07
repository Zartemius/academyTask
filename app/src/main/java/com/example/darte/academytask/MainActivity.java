package com.example.darte.academytask;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import android.os.Bundle;
import android.util.Log;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends AppCompatActivity {

    public final static String REPORTS_URL = "https://devfest-spb.com/";
    private Router router;
    private NavigatorHolder navigatorHolder;
    private Navigator navigator = new SupportAppNavigator(this,getSupportFragmentManager(),R.id.container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_layout);

        Log.i("APP_INSTANCE", "result " + AcademyApplication.INSTANCE.toString());

        router = AcademyApplication.INSTANCE.getRouter();
        navigatorHolder =  AcademyApplication.INSTANCE.getNavigatorHolder();

        router.newRootChain(new Screens.MainFlowFragment());

        /*final TextView button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showAllReports(REPORTS_URL);

            }
        });*/
    }

    public void showAllReports(String url){
        String urlWithReports = url;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(urlWithReports));
        startActivity(i);
    }


    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            super.onBackPressed();
        }
    }
}
