package com.cslong.app.lifetools.designpatterndemo.behavior_pattern.strategy.demo;


@PriceRegion(max=20000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.9;
    }
}