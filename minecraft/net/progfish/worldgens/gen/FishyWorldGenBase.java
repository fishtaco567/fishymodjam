package net.progfish.worldgens.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class FishyWorldGenBase {

	World worldObj;
	Random rand;
	
	List<Integer> naturalBlocks = Arrays.asList(Block.dirt.blockID, Block.grass.blockID, Block.stone.blockID, Block.sand.blockID, Block.blockClay.blockID);
	
	public FishyWorldGenBase(World worldObj, Random rand)
	{
		this.worldObj = worldObj;
		this.rand = rand;
	}
	
	//0 = xz, 1 = yx, 2 = yz
	public void genCircle(int x, int y, int z, int id, int meta, int outerRadius, int innerRadius, int dir)
	{
		for(int i = -outerRadius; i < outerRadius; i++)
		{
			for(int j = -outerRadius; j < outerRadius; j++)
			{
				int dist2 = (i * i) + (j * j);
				if(outerRadius * outerRadius > dist2 && innerRadius * innerRadius < dist2)
				{
					switch(dir)
					{
						case 0:
							placeBlock(x + i, y, z + j, id, meta);
							break;
						case 1:
							placeBlock(x + i, y + j, z, id, meta);
							break;
						case 2:
							placeBlock(x, y + i, z + j, id, meta);
							break;
					}
				}
			}
		}
	}
	
	public void genSphere(int x, int y, int z, int id, int meta, int outerRadius, int innerRadius)
	{
		for(int i = -outerRadius; i < outerRadius; i++)
		{
			for(int j = -outerRadius; j < outerRadius; j++)
			{
				for(int k = -outerRadius; k < outerRadius; k++)
				{
					int dist2 = (i * i) + (j * j) + (k * k);
					if(outerRadius * outerRadius > dist2 && innerRadius * innerRadius < dist2)
					{
						placeBlock(x + i, y + j, z + k, id, meta);
					}
				}
			}
		}
	}
	
	public int getTerrainHeightAt(int x, int z)
	{
		for(int j = 127; j > 0; j--)
		{
			if(naturalBlocks.contains(getBlockId(x, j, z)))
			{
				return j;
			}
		}
		return 64;
	}
	
	public void placeBlock(int i, int j, int k, int id, int meta)
	{
		worldObj.setBlock(i, j, k, id, meta, 3);
	}
	
	public int getBlockId(int i, int j, int k)
	{
		return worldObj.getBlockId(i, j, k);
	}
	
	public abstract void generate(int i, int j, int k);
	
}
