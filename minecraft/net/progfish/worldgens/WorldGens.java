package net.progfish.worldgens;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
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
			config = new Configuration(preInitEvent.getSuggestedConfigurationFile());
			ConfigHandler.initConfig(config);
	}
	
	@Init
	public void init(FMLInitializationEvent initEvent)
	{
		
	}
	
}
