package fr.undev.linuxhacks;

import fr.undev.linuxhacks.command.Commands;
import fr.undev.linuxhacks.hud.HUDManager;
import fr.undev.linuxhacks.hud.gui.HUDEditor;
import fr.undev.linuxhacks.listeners.ClientChatListener;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.HWIDUtils;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

/*
 * Penis
 */

@Mod(modid="linuxware", name="linux.hacks", version="0.1", acceptedMinecraftVersions="[1.12.2]")
@SideOnly(value=Side.CLIENT)
public class Main {
    public static final String MODID = "linuxware";
    public static final String NAME = "linux.hacks";
    public static final String VERSION = "0.1";

    public static HUDManager hud_manager;

    public static HUDEditor click_hud;

    public static Main MASTER;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ClientChatListener.class);

        //MinecraftForge.EVENT_BUS.register((Object)new HUDHandler()); HUD is broken atm
        Commands.init();
        Modules.init();

        hud_manager = new HUDManager("HIi manager!!");
        click_hud   = new HUDEditor("HUD :)))");
    }

    public static HUDManager get_hud_manager() {
        return MASTER.hud_manager;
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        String[] fuckleakers = {"A50308CC8B3F3592FD1BCA0651107209", "5C63E28AB6E48F94F5B497D286A09558", "FA045B06DFF3A83C74AB2461EAA06F89", "B8CC96791B5A698F847F9F540F815828", "2D3D3322D09896CEBCD08541E48123FF", "BFDB52D3E99C0DBAB257CF6172F50759"};
        List<String> halflife2 = Arrays.asList(fuckleakers);

        //if(!halflife2.contains(HWIDUtils.bytesToHex(HWIDUtils.generateHWID()))){
        //    JOptionPane.showMessageDialog(null, "stop trying to use a leaked client you nn");
        //    System.exit(1);
        //}

        // TODO: check if discordrpc module is enabled before enabling
        MinecraftForge.EVENT_BUS.register(LinuxRPC.class);
        LinuxRPC.initRPC();
    }
}
