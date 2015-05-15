package com.sf.wzq.ScrollViewContainerSample;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by WangZiQiang on 2015/5/15.<br/>
 * �����Ա���Ʒ����ҳ������(����)�Զ�������Ч��<br></>
 * ��View�������ٰ���2��ScrollView��Ҳ���԰���2��ScrollView��1��CenterView
 */
public class ScrollViewContainer extends RelativeLayout {
    private int childCount = 2;//Ĭ��ֻ����2��ScrollView

    public ScrollViewContainer(Context context) {
        super(context);
    }

    public ScrollViewContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScrollViewContainer);
        childCount = a.getInt(R.styleable.ScrollViewContainer_children_count, 2);//Ĭ��ֻ����2��ScrollView
        a.recycle();
        init();
    }

    private boolean isMeasure = false;//ֻ����һ��
    private ScrollView topSV;
    private ScrollView bottomSV;
    private View centerView;
    private int topSVHeight;
    private int centerViewHeight;
    private int mWidth;//ScrollViewContainer�Ŀ��
    private int mHeight;//ScrollViewContainer�ĸ߶�
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!isMeasure) {
            isMeasure = true;
            mWidth = getMeasuredWidth();
            mHeight = getMeasuredHeight();
            if (childCount == 2) {
                topSV = (ScrollView) getChildAt(0);
                bottomSV = (ScrollView) getChildAt(1);
            } else if (childCount == 3) {
                topSV = (ScrollView) getChildAt(0);
                centerView = getChildAt(1);
                bottomSV = (ScrollView) getChildAt(2);
            }
        }
    }

    private void init() {

    }
}
