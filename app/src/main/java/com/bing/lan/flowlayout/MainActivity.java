package com.bing.lan.flowlayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FlowLayout mFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFlowLayout();
            }
        });
    }

    public void initFlowLayout() {
        mFlowLayout = (FlowLayout) findViewById(R.id.flow_container);
        mFlowLayout.setTextSize(dp2px(12));
        mFlowLayout.setBackgroundRadius(dp2px(40));
        mFlowLayout.setTextPadding(dp2px(15));
        mFlowLayout.setSpace(dp2px(11), dp2px(11));

        // mFlowLayout.setColorProvider(new FlowLayout.ColorProvider() {
        //     @Override
        //     public int textColor(int position) {
        //         return Resources.getSystem().getColor(R.color.color_text_333333);
        //     }
        //
        //     @Override
        //     public int normalBackgroundColor(int position) {
        //         return 0;
        //     }
        //
        //     @Override
        //     public int normalStrokeColor(int position) {
        //         return Resources.getSystem().getColor(R.color.color_text_333333);
        //     }
        //
        //     @Override
        //     public int selectBackgroundColor(int position) {
        //         return Resources.getSystem().getColor(R.color.colorPrimary);
        //     }
        //
        //     @Override
        //     public int selectStrokeColor(int position) {
        //         return Resources.getSystem().getColor(R.color.colorPrimary);
        //     }
        // });

        mFlowLayout.setOnItemClickListener(new FlowLayout.OnFlowItemClickListener() {
            @Override
            public void onFlowItemClick(FlowLayout flowLayout, View view, int position, FlowLayout.FlowBean flowBean) {
                flowLayout.setSelectFlowItem(position);
                Toast.makeText(MainActivity.this, flowBean.getFlowText(), Toast.LENGTH_SHORT).show();
            }
        });

        mFlowLayout.removeAllViews();

        ArrayList<FlowLayout.FlowBean> flowBeen = new ArrayList<>();
        flowBeen.add(new FlowBeanTest("微辣"));
        flowBeen.add(new FlowBeanTest("中辣"));
        flowBeen.add(new FlowBeanTest("中辣"));
        flowBeen.add(new FlowBeanTest("中不要葱蒜辣"));
        flowBeen.add(new FlowBeanTest("重辣"));
        flowBeen.add(new FlowBeanTest("少不要葱蒜盐"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("不要不要葱蒜不要葱要葱蒜不要葱蒜葱蒜"));
        flowBeen.add(new FlowBeanTest("少盐盐盐"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("不要葱蒜"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("少不要葱蒜盐"));
        flowBeen.add(new FlowBeanTest("不要葱蒜"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("不要葱蒜"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("少不要葱蒜盐"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("不要葱蒜"));
        flowBeen.add(new FlowBeanTest("少盐"));
        flowBeen.add(new FlowBeanTest("不要葱蒜"));
        flowBeen.add(new FlowBeanTest("少油"));

        mFlowLayout.addAllChild(flowBeen);
        mFlowLayout.setSelectFlowItem(0);

        mFlowLayout.setLineFillProvider(new FlowLayout.LineFillProvider() {
            @Override
            public boolean fillLine(int allLineSize, int lineIndex,
                    int lineChildAllSize, int childIndex, float avg) {


                return allLineSize != lineIndex + 1;
            }
        });
    }

    public int dp2px(int dip) {
        // denstity*dip=px;
        float density = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dip * density + .5f);
    }

    public int px2dp(int px) {
        // denstity*dip=px;
        float density = Resources.getSystem().getDisplayMetrics().density;
        return (int) (px / density + .5f);
    }
}
