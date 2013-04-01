package net.progfish.worldgens;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GenHandler implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.isSurfaceWorld())
		{
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
		else
		{
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private void generateSurface(World world, Random rand, int i, int k)
	{
		
	}
	
	private void generateNether(World world, Random rand, int i, int k)
	{
		
	}

}
