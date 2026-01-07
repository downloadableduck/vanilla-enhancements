package com.jeff;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class Items {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {

        ResourceKey<@NotNull Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(VanillaEnhancements.MOD_ID, name));

        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;

    }

    public static final Consumable ABSORPTION_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2 * (60 * 20), 1))).build();

    public static final FoodProperties ABSORPTION_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();

    public static final Consumable POISON_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 20 * 10))).build();

    public static final FoodProperties POISON_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();

    public static final Item DIAMOND_APPLE = register("diamond_apple", Item::new, new Item.Properties()
            .food(ABSORPTION_FOOD_COMPONENT, ABSORPTION_FOOD_CONSUMABLE_COMPONENT));
    public static final Item VILLAGER_NOSE = register("villager_nose", Item::new, new Item.Properties()
            .humanoidArmor(Armor.INSTANCE, ArmorType.HELMET)
            .food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT)
            .durability(Armor.BASE_DURABILITY));

    public static void initialize() {

    }
}
