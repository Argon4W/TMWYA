package com.github.argon4w.tmwya;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ExampleMod.MODID)
public class ExampleMod {

    public static final String MODID = "tmwya";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {

    }
}
