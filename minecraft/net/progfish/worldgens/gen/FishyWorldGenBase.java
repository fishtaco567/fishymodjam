package net.progfish.worldgens.gen;

import java.util.Random;

import net.minecraft.world.World;

public class FishyWorldGenBase {

	World worldObj;
	Random rand;
	
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
	
	public void placeBlock(int i, int j, int k, int id, int meta)
	{
		worldObj.setBlock(i, j, k, id, meta, 3);
	}
	
}
