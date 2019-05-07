package com.example.darte.academytask;

import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class MainFlowFragment extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new com.example.darte.academytask.MainFlowFragment();
        }
    }

    public static final class OneFragment extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new FragmentOne();
        }
    }

    public static final class TwoFragment extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new FragmentTwo();
        }
    }

    public static final class ThreeFragment extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return new FragmentThree();
        }
    }

}
