package com.cslong.app.lifetools.designpatterndemo.behavior_pattern.strategy.demo;


@PriceRegion(min=20000,max=30000)
public class SuperVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.8;
    }
}