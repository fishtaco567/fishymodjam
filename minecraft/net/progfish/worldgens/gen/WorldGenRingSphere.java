package net.progfish.worldgens.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenRingSphere extends FishyWorldGenBase {

	public WorldGenRingSphere(World worldObj, Random rand) {
		super(worldObj, rand);
	}

	@Override
	public void generate(int i, int j, int k) {
		j = getTerrainHeightAt(i, k) + rand.nextInt(30) + 10;
		
		int ringSize = 6 + rand.nextInt(6);
		
		genCircle(i, j, k, Block.stone.blockID, 0, ringSize, ringSize - 1.5F, 0);
		genCircle(i, j, k, Block.stone.blockID, 0, ringSize, ringSize - 1.5F, 1);
		genCircle(i, j, k, Block.stone.blockID, 0, ringSize, ringSize - 1.5F, 2);
	}

}
