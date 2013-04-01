package net.progfish.worldgens.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenRuins extends FishyWorldGenBase {

	public WorldGenRuins(World worldObj, Random rand) {
		super(worldObj, rand);
	}

	@Override
	public void generate(int i, int j, int k) {
		j = getTerrainHeightAt(i, k);
		
		int radius = rand.nextInt(6) + 6;
		
		genCircle(i, j, k, Block.cobblestoneMossy.blockID, 0, radius, 0, 0);
	}

	
	
}
