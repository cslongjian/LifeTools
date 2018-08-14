package com.cslong.app.lifetools.designpatterndemo.structure_pattern.facade;

import java.util.logging.Logger;

//Memory子系统类
public class Memory {
    public static final Logger LOGGER = Logger.getLogger("Memory");
    public void start()
    {
        LOGGER.info("Memory is start...");
    }

    public void shutDown()
    {
        LOGGER.info("Memory is shutDown...");
    }
}
