package com.jeff;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Armor {

    public static final int BASE_DURABILITY = 999999999;
    public static final ResourceKey<@NotNull EquipmentAsset> VILLAGER_NOSE_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(VanillaEnhancements.MOD_ID, "nose"));
    public static final TagKey<@NotNull Item> REPAIRS_VILLAGER_NOSE = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(VanillaEnhancements.MOD_ID, "repairs_villager_nose"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(

            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.MUSIC_DISC_LAVA_CHICKEN,
            1.0F,
            1.0F,
            REPAIRS_VILLAGER_NOSE,
            VILLAGER_NOSE_MATERIAL_KEY
    );
}
