package pixilaregames.pixelcore.Commands;

import net.minecraft.command.arguments.EntityArgument;

public class EntityArgumentTempFix extends EntityArgument
{

	protected EntityArgumentTempFix(boolean p_i47969_1_, boolean p_i47969_2_) {
		super(p_i47969_1_, p_i47969_2_);
	}
	
	public static EntityArgumentTempFix multiplePlayers() {
		return new EntityArgumentTempFix(false, true);
	}
}
