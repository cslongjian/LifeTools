package com.cslong.app.lifetools.designpatterndemo.structure_pattern.facade;

import java.util.logging.Logger;

//Disk子系统类
public class Disk {
    public static final Logger LOGGER = Logger.getLogger("Disk");
    public void start()
    {
        LOGGER.info("Disk is start...");
    }

    public void shutDown()
    {
        LOGGER.info("Disk is shutDown...");
    }
}
