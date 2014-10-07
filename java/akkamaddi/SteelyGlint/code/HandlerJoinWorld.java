package akkamaddi.SteelyGlint.code;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraft.item.Item;

public class HandlerJoinWorld
{
    public static double rand;
    public static int range;

    public static RandomRange random = new RandomRange();

    public static final String HANDLED_KEY = "steelyglint.spawn.handled";

    /**
     * This class allows zombies and skeletons to spawn holding/wearing SimpleOres items.
     */
    @ForgeSubscribe
    public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        rand = Math.random();
        range = random.nextInt(1, 14);
        
    if (event.world.isRemote)
            return;
    
    Entity entity = event.entity;
    
    if (!(entity.getClass() == EntitySkeleton.class && ((EntitySkeleton) entity).getSkeletonType() == 0
            || entity.getClass() == EntityZombie.class)
            || entity.getEntityData().getBoolean(HANDLED_KEY))
    return;

    event.entity.getEntityData().setBoolean(HANDLED_KEY, true);

        if (rand <= 0.02D)
        {
            EntityLiving living = (EntityLiving)event.entity;

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
            
        }
    }
}

class RandomRange extends Random
{
    public int nextInt(int min, int max)
    {
        return nextInt(max - min + 1) + min;
    }
}