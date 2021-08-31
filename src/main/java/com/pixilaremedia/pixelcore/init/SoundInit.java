package com.pixilaremedia.pixelcore.init;

import com.pixilaremedia.pixelcore.Ref;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ref.MODID);

    public static final RegistryObject<SoundEvent> AINT_NO_CRYING = createSound("music_disc.aint_no_crying");
    public static final RegistryObject<SoundEvent> SYNDICATE = createSound("music_disc.syndicate");
    public static final RegistryObject<SoundEvent> WELCOME_HOME = createSound("music_disc.welcome_home");
    public static final RegistryObject<SoundEvent> BLUE = createSound("music_disc.blue");
    public static final RegistryObject<SoundEvent> IN_MY_HEAD = createSound("music_disc.in_my_head");
    public static final RegistryObject<SoundEvent> KISS_YOUR_DREAMS_GOODBYE = createSound("music_disc.kiss_your_dreams_goodbye");
    public static final RegistryObject<SoundEvent> TURN_BACK_TIME = createSound("music_disc.turn_back_time");
    public static final RegistryObject<SoundEvent> FOUR_AM = createSound("music_disc.four_am");

    public static final RegistryObject<SoundEvent> TELL_YOUR_STORY = createSound("music_disc.tell_your_story");
    public static final RegistryObject<SoundEvent> WRITE_IT_DOWN = createSound("music_disc.write_it_down");
    public static final RegistryObject<SoundEvent> NIGHT_BEFORE_DAWN = createSound("music_disc.night_before_dawn");
    public static final RegistryObject<SoundEvent> DOOMSDAY = createSound("music_disc.doomsday");
    public static final RegistryObject<SoundEvent> WHY = createSound("music_disc.why");
    public static final RegistryObject<SoundEvent> REVIVED = createSound("music_disc.revived");
    public static final RegistryObject<SoundEvent> CASINO_ROYALE = createSound("music_disc.casino_royale");

    private static RegistryObject<SoundEvent> createSound(String name)
    {
        return SOUNDS.register(name, () -> new SoundEvent(Ref.location(name)));
    }
}
