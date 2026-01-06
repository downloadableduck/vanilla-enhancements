package com.jeff;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class Items {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VanillaEnhancements.MOD_ID, name));

        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;

    }
    public static final Item DIAMOND_APPLE = register("diamond_apple", Item::new, new Item.Properties());

    public static final Item VILLAGER_NOSE = register("villager_nose", Item::new, new Item.Properties()
            .humanoidArmor(Armor.INSTANCE, ArmorType.HELMET)
            .durability(Armor.BASE_DURABILITY));

    public static void initialize() {

    }
}
