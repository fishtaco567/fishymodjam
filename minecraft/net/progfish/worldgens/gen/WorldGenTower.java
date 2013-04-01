package net.progfish.worldgens.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class WorldGenTower extends FishyWorldGenBase {

	public WorldGenTower(World worldObj, Random rand) {
		super(worldObj, rand);
	}

	@Override
	public void generate(int i, int j, int k) {
		j = getTerrainHeightAt(i, k);

		int towerHeight = rand.nextInt(15) + 20;
		int topHeight = rand.nextInt(3) + 5;
		int towerRadius = rand.nextInt(3) + 3;
		int floorHeight = rand.nextInt(3) + 4;
		
		for(int y = j; y < towerHeight + j; y++)
		{
			int inner = towerRadius;
			if((y - j) % floorHeight == 0)
			{
				inner = 0;
			}
			if(y - j > towerHeight - topHeight)
			{
				genCircle(i, y, k, Block.stone.blockID, 0, towerRadius + 1, inner, 0, true);	
				if(rand.nextBoolean())
				{
					placeBlock(i, y, k + 2, Block.mobSpawner.blockID, 0);	
					TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldObj.getBlockTileEntity(i, y, k + 2);			
					if(spawner != null)
					{
						spawner.func_98049_a().setMobID(getMob());
					}
				}
			}
			else
			{
				genCircle(i, y, k, Block.stone.blockID, 0, towerRadius, inner - 1, 0, true);
			}
			placeBlock(i, y, k + 1, Block.stone.blockID, 0);
			placeBlock(i, y, k, Block.ladder.blockID, 2);
		}
		
		placeBlock(i, j + towerHeight - 1, k - 2, Block.chest.blockID, 0);
		
		TileEntityChest chest = (TileEntityChest) worldObj.getBlockTileEntity(i, j + towerHeight - 1, k - 2);
		if(chest != null)
		{
			int amountOfItem = 3 + rand.nextInt(4);
			for(int a = 0; a < amountOfItem; a++)
			{
				chest.setInventorySlotContents(rand.nextInt(chest.getSizeInventory()), getItem());
			}
		}
	}
	
	private ItemStack getItem()
	{
		switch(rand.nextInt(10))
		{
			case 0:
				return new ItemStack(Item.appleRed, rand.nextInt(5) + 2, 0);
			case 1:
				return new ItemStack(Item.appleGold, 1, 0);
			case 2:
				return new ItemStack(Item.arrow, rand.nextInt(30) + 25, 0);
			case 3:
				return new ItemStack(Item.saddle, 1, 0);
			case 4:
				return new ItemStack(Item.pocketSundial, 1, 0);
			case 5:
				return new ItemStack(Item.bootsChain, 1, 0);
			case 6:
				return new ItemStack(Item.plateChain, 1, 0);
			case 7:
				return new ItemStack(Item.eyeOfEnder, rand.nextInt(5) + 2, 0);
			default:
				return new ItemStack(Item.porkCooked, rand.nextInt(5) + 2, 0);
		}
	}
	
	private String getMob()
	{
		switch(rand.nextInt(3))
		{
			case 0:
				return "zombie";
			case 1:
				return "skeleton";
			case 2:
				return "spider";
		}
		return "zombie";
	}

}
