package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import com.pixilaremedia.pixelcore.References;
import com.pixilaremedia.pixelcore.crafting.CurrencyConversionRecipe;
import com.pixilaremedia.pixelcore.crafting.EtchingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeSerializerInit
{
    public static final RecipeSerializer<CurrencyConversionRecipe> CURRENCY_CONVERSION = new SingleItemRecipe.Serializer<>(CurrencyConversionRecipe::new) {};
    public static final RecipeSerializer<EtchingRecipe> ETCHING = new SingleItemRecipe.Serializer<>(EtchingRecipe::new) {};

    @SubscribeEvent
    public static void onRegisterSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
        event.getRegistry().register(CURRENCY_CONVERSION.setRegistryName(Ref.location("currency_conversion")));
        event.getRegistry().register(ETCHING.setRegistryName(Ref.location("etching")));
        References.LOGGER.info("Registered Recipe Serializer");
    }
}
