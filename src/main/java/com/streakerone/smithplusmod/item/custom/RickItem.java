package com.streakerone.smithplusmod.item.custom;

import net.minecraft.Util;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RickItem extends Item {
    private final String RICKROLL_LINK = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley";

    public RickItem(Properties p_41383_) {
        super(p_41383_);
    }

    public void openWebpage(URI uri) {
        Util.getPlatform().openUri(uri);
    }

    public void openWebpage(String link) {
        try {
            openWebpage(new URL(link).toURI());
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (level.isClientSide()) {
            openWebpage(RICKROLL_LINK);
        }
        return super.use(level, player, interactionHand);
    }
}
