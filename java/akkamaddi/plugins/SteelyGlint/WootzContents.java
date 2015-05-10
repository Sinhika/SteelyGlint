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
public class WootzContents extends ModContents
{
    public Class<?> items;
    
    public Content<Item> pigIronIngot;

    public WootzContents()
    {
        if (!isModLoaded())
        {
            return;
        }
        try
        {
            items = Class.forName("theoldone822.WootzPignGray.Content");
        }
        catch (ClassNotFoundException e)
        {
            throw new ModReflectionFailException(e);
        }
        pigIronIngot = of(items, "rePigironIngot");
    } // end ctor
    
    /* (non-Javadoc)
     * @see akkamaddi.api.core.ModContents#getModId()
     */
    @Override
    public String getModId()
    {
        return "wootzpigngray";
    }

} // end class WootzContents
