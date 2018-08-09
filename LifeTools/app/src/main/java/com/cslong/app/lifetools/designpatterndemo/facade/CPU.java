package com.cslong.app.lifetools.designpatterndemo.facade;

import java.util.logging.Logger;

//cpu子系统类
public class CPU {
    public static final Logger LOGGER = Logger.getLogger("CPU");

    public void start() {
        LOGGER.info("cpu is start...");
    }

    public void shutDown() {
        LOGGER.info("CPU is shutDown...");
    }
}
