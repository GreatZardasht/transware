package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;
import fr.undev.linuxhacks.friends.Friends;
import fr.undev.linuxhacks.util.UUIDUtils;

import java.io.IOException;


public class CommandFriend
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        return false;
    }


    @Override
    public String getUsage() {
        return "friend aComm|del <Username>";
    }

    @Override
    public String getDescription() {
        return "Whitelist people from CrystalAura, KillAura, etc.";
    }
}

