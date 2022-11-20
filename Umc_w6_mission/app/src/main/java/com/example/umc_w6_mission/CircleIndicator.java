package com.example.umc_w6_mission;

import android.content.Context;
import android.util.AttributeSet;

import me.relex.circleindicator.CircleIndicator3;

public class CircleIndicator extends CircleIndicator3 {
    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void animatePageSelected(int position) {
        // 현재 보고 있는 페이지가 indicator에서 선택되도록 함
        // 무한 스크롤이므로 itemList size만큼 나눈 나머지값이 선택되는 것(일단 지금은 하드코딩...)
        super.animatePageSelected(position % 6);
    }
}
