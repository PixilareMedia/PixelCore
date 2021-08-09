execute unless entity @e[type=pig,distance=..3] run scoreboard players set @p pigfly_riding 0
advancement revoke @p only pixelcore:legacy_achievements/technical/when_pigs_fly_ad1

execute as @e[type=pig,limit=1] at @e[distance=0.324..0.500] store result score @p pigfly_current run data get entity @p Pos[1]




execute if score @p pigfly_riding matches 0 run execute as @e[type=pig] at @e[type=pig,distance=0.1..0.400] run scoreboard players set @p pigfly_riding 1

execute if score @p pigfly_riding matches 0..1 store result score @p pigfly_input run data get entity @p Pos[1]
execute if score @p pigfly_riding matches 0..1 run execute if score @p pigfly_input > @p pigfly_goal store result score @p pigfly_goal run data get entity @p Pos[1]
execute if score @p pigfly_riding matches 0..1 run execute if score @p pigfly_input < @p pigfly_goal store result score @p pigfly_goal run data get entity @p Pos[1]
execute if score @p pigfly_riding matches 0 run scoreboard players set @p pigfly_goal 0


execute if score @p pigfly_riding matches 1 run execute as @e[type=pig,limit=1] at @e[distance=..0.500] run execute if block ~ ~-1 ~ minecraft:air run execute if block ~ ~-5 ~ minecraft:air run scoreboard players set @p pigfly_riding 2
execute unless score @p pigfly_riding matches 0..1 run execute unless score @p pigfly_riding matches 3 run execute as @e[type=pig,limit=1] at @e[distance=..0.500] run execute unless block ~ ~-1 ~ minecraft:air run scoreboard players set @p pigfly_riding 1


execute if score @p pigfly_riding matches 2 run scoreboard players remove @p pigfly_goal 5
execute if score @p pigfly_riding matches 2 run execute if score @p pigfly_current > @p pigfly_goal run execute if score @p pigfly_riding matches 2 run scoreboard players set @p pigfly_riding 3

execute if score @p pigfly_riding matches 3 run execute if score @p pigfly_current > @p pigfly_goal run execute unless block ~ ~-1 ~ minecraft:air run scoreboard players set @p pigfly_riding 1
execute if score @p pigfly_riding matches 3 run execute if score @p pigfly_current <= @p pigfly_goal run scoreboard players set @p pigfly_riding 4




execute if score @p pigfly_riding matches 4 run advancement grant @p only pixelcore:legacy_achievements/when_pigs_fly