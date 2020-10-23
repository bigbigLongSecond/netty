package com.designpattern.decoration.enhance;

/**
 * @author dzl
 * 2020/10/22 14:05
 * @Description
 */
public class RingeDecoration implements IBeauty {
    private final IBeauty me;

    public RingeDecoration(IBeauty me) {
        this.me = me;
    }
    @Override
    public int getBeautyValue() {
        return me.getBeautyValue() + 20;
    }
}
