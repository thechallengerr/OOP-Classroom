package com.hus.oop_classroom.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hus.oop_classroom.Fragment.AttendedCourse;
import com.hus.oop_classroom.Fragment.Infomation;

public class UserProfile_vpadapter extends FragmentStatePagerAdapter{
    public UserProfile_vpadapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new Infomation();
            case 1:
                return new AttendedCourse();
            default: return  new Infomation();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tittle="";
        switch (position){
            case 0:
                tittle="Infomation";
                break;
            case 1:
                tittle="Attended Courses";
                break;
        }


        return tittle;
    }
}
