package com.example.myapplication.slice;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.app.Context;

public class MyComponentContainer extends ComponentContainer implements Component.EstimateSizeListener , ComponentContainer.ArrangeListener,ComponentContainer.LayoutRefreshedListener {
    public MyComponentContainer(Context context) {
        super(context);
        init();
    }

    public MyComponentContainer(Context context, AttrSet attrSet) {
        super(context, attrSet);
        init();
    }

    public MyComponentContainer(Context context, AttrSet attrSet, String styleName) {
        super(context, attrSet, styleName);
        init();
    }

    private void init() {
        setEstimateSizeListener(this);
        setArrangeListener(this);
       setLayoutRefreshedListener(this);
    }


    @Override
    public boolean onEstimateSize(int i, int i1) {
        setEstimatedSize(500,400);


        Component component1= getComponentAt(0);
        Component component2= getComponentAt(1);
        component1.estimateSize(EstimateSpec.getSizeWithMode(2000,EstimateSpec.NOT_EXCEED),EstimateSpec.getSizeWithMode(50,EstimateSpec.PRECISE));
        component2.estimateSize(EstimateSpec.getSizeWithMode(2000,EstimateSpec.NOT_EXCEED),EstimateSpec.getSizeWithMode(50,EstimateSpec.PRECISE));
        return true;
    }

    @Override
    public boolean onArrange(int i, int i1, int i2, int i3) {
       Component component1= getComponentAt(0);
       Component component2= getComponentAt(1);
        component1.arrange(50,50,component1.getEstimatedWidth(),component1.getEstimatedHeight());
        component2.arrange(100,100,component2.getEstimatedWidth(),component2.getEstimatedHeight());
        return true;
    }


    @Override
    public void onRefreshed(Component component) {

    }
}
