package com.cslong.app.lifetools.designpatterndemo.structure_pattern.adapter;

public class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }
}
