package net.progfish.worldgens;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.progfish.worldgens.gen.WorldGenRingSphere;
import net.progfish.worldgens.gen.WorldGenRings;
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
		if(rand.nextInt(25) == 0)
		{
			new WorldGenRingSphere(world, rand).generate(i + 8, 0, k + 8);
		}
		if(rand.nextInt(25) == 0)
		{
			new WorldGenRings(world, rand).generate(i + 8, 0, k + 8);
		}
	}
	
	private void generateNether(World world, Random rand, int i, int k)
	{
		
	}

}
