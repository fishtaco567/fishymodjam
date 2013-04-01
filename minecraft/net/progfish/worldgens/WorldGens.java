package net.progfish.worldgens;

import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod.Instance;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class WorldGens {

	@Instance(ModInfo.ID)
	public static WorldGens instance;
	
	public Configuration config;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent preInitEvent)
	{
		try
		{
			config = new Configuration(preInitEvent.getSuggestedConfigurationFile());
			ConfigHandler.initConfig(config);
		}
		catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "WorldGens has had a problem with it's configuration file");
		} 
		finally {
			config.save();
		}
		
	}
	
	@Init
	public void init(FMLInitializationEvent initEvent)
	{
		GameRegistry.registerWorldGenerator(new GenHandler());
	}
	
}
