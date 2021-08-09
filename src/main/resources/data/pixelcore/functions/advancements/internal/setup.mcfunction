execute unless entity @a[advancements={minecraft:story/root=true}] run scoreboard objectives add pigfly_riding dummy
execute unless entity @a[advancements={minecraft:story/root=true}] run scoreboard objectives add pigfly_goal dummy
execute unless entity @a[advancements={minecraft:story/root=true}] run scoreboard objectives add pigfly_current dummy
execute unless entity @a[advancements={minecraft:story/root=true}] run scoreboard objectives add pigfly_input dummy
scoreboard players set @p pig_riding 0
scoreboard players set @p pigfly_goal 0
scoreboard players set @p pigfly_current 0
scoreboard players set @p pigfly_input 0
advancement revoke @p only pixelcore:legacy_achievements/technical/when_pigs_fly_ad1