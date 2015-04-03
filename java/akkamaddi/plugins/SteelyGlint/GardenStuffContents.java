/**
 * 
 */
package akkamaddi.plugins.SteelyGlint;

import net.minecraft.item.Item;
import akkamaddi.api.core.ModContents;

/**
 * @author cyhiggin
 *
 */
public class GardenStuffContents extends ModContents
{
    public Class<?> items;
    
    public Content<Item> wroughtIronIngot;

    public GardenStuffContents()
    {
        if (!isModLoaded())
        {
            return;
        }
        try
        {
            items = Class.forName("com.jaquadro.minecraft.gardenstuff.core.ModItems");
        }
        catch (ClassNotFoundException e)
        {
            throw new ModReflectionFailException(e);
        }
        wroughtIronIngot = of(items, "wroughtIronIngot");
    } // end ctor
    
    /* (non-Javadoc)
     * @see akkamaddi.api.core.ModContents#getModId()
     */
    @Override
    public String getModId()
    {
        return "GardenStuff";
    } 

} // end class GardenStuffContents
