package com.bing.lan.flowlayout;

/**
 * @author 蓝兵
 * @email lan_bing2013@163.com
 * @time 2017/8/24  22:27
 */
class FlowBeanTest implements FlowLayout.FlowBean {

    String name;

    public FlowBeanTest(String name1) {
        name = name1;
    }

    @Override
    public CharSequence getFlowText() {
        return name;
    }
}
