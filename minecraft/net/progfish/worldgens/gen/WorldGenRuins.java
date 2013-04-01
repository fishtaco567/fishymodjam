package net.progfish.worldgens.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class WorldGenRuins extends FishyWorldGenBase {

	public WorldGenRuins(World worldObj, Random rand) {
		super(worldObj, rand);
	}

	@Override
	public void generate(int i, int j, int k) {
		j = getTerrainHeightAt(i, k);
		
		int radius = rand.nextInt(6) + 6;
		
		genCircle(i, j, k, Block.cobblestoneMossy.blockID, 0, radius, 0, 3, true);
		
		float pillarRadius = radius * .8F;
		float angle = rand.nextFloat() * 6;
		float step = (float) (6.28318531 / (radius / 2));
		for(int n = 0; n < radius / 2; n++)
		{
			int x = (int) (Math.sin(angle) * pillarRadius);
			int z = (int) (Math.cos(angle) * pillarRadius);
			fillDown(x + i, getTerrainHeightAt(x + i, z + k) + rand.nextInt(3) + 3, z + k, Block.cobblestoneMossy.blockID, 0);
			angle += step;
		}
		
		int towerHeight = rand.nextInt(15) + 15;
		fillDown(i, j + towerHeight + 3, k, Block.cobblestoneMossy.blockID, 0);
		fillDown(i + 1, j + towerHeight, k, Block.cobblestoneMossy.blockID, 0);
		fillDown(i - 1, j + towerHeight, k, Block.cobblestoneMossy.blockID, 0);
		fillDown(i, j + towerHeight, k + 1, Block.cobblestoneMossy.blockID, 0);
		fillDown(i, j + towerHeight, k - 1, Block.cobblestoneMossy.blockID, 0);

		placeBlock(i, j + towerHeight - 1, k, Block.chest.blockID, 0);
		
		TileEntityChest chest = (TileEntityChest) worldObj.getBlockTileEntity(i, j + towerHeight - 1, k);
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
	
}
