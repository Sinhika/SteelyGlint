package akkamaddi.SteelyGlint.code;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import akkamaddi.akkamaddiCore.api.AkkaJoinWorldHelper;

public class JoinWorldHandler extends AkkaJoinWorldHelper {

	@Override
	public void EquipMobs(EntityJoinWorldEvent event) 
	{
        int range = random.nextInt(1, 14);
        EntityLiving living = (EntityLiving) event.entity;

        if (range == 1)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(SteelyGlintCore.highSteelHelm));
        }

        if (range == 2)
        {
            living.setCurrentItemOrArmor(3, new ItemStack(SteelyGlintCore.highSteelChest));
        }

        if (range == 3)
        {
            living.setCurrentItemOrArmor(2, new ItemStack(SteelyGlintCore.highSteelLegs));
        }

        if (range == 4)
        {
            living.setCurrentItemOrArmor(1, new ItemStack(SteelyGlintCore.highSteelBoots));
        }

        if (range == 5)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.highSteelSword));
        }

        if (range == 6)
        {
            living.setCurrentItemOrArmor(4, new ItemStack(SteelyGlintCore.lowSteelHelm));
        }

        if (range == 7)
        {
            living.setCurrentItemOrArmor(3, new ItemStack(SteelyGlintCore.lowSteelChest));
        }

        if (range == 8)
        {
            living.setCurrentItemOrArmor(2, new ItemStack(SteelyGlintCore.lowSteelLegs));
        }

        if (range == 9)
        {
            living.setCurrentItemOrArmor(1, new ItemStack(SteelyGlintCore.lowSteelBoots));
        }

        if (range == 10)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.lowSteelSword));
        }

        if (range == 11)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.refinedIronSword));
        }

        if (range == 12)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.refinedIronPickaxe));
        }

        if (range == 13)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.carbonizedIronSword));
        }

        if (range == 14)
        {
            living.setCurrentItemOrArmor(0, new ItemStack(SteelyGlintCore.carbonizedIronPickaxe));
        }

	} // end EquipMobs()

} // end class JoinWorldHandler
