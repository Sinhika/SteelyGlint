package akkamaddi.SteelyGlint.code;


public class ClientProxy extends akkamaddi.akkamaddiCore.api.ClientProxy
{
    @Override
    public void registerRenderers()
    {
        // This is for rendering entities and so forth later on
        //Armor Renderers
        SteelyGlintCore.rendererLowSteel = addArmor("lowSteel");
        SteelyGlintCore.rendererHighSteel = addArmor("highSteel");
    }

}
