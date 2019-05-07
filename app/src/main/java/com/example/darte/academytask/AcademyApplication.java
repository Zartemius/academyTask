package com.example.darte.academytask;

import android.app.Application;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class AcademyApplication extends Application {

    public static AcademyApplication INSTANCE;
    private Cicerone<Router> cicerone;
    private Cicerone<Router> childCicerone;


    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;
        initCicerone();
    }

    private void initCicerone(){
        cicerone = Cicerone.create();
        childCicerone = Cicerone.create();
    }

    public Router getChildRouter(){
        return childCicerone.getRouter();
    }

    public NavigatorHolder getChildNavigatorHolder(){
        return childCicerone.getNavigatorHolder();
    }

    public NavigatorHolder getNavigatorHolder(){
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter(){
        return cicerone.getRouter();
    }
}
