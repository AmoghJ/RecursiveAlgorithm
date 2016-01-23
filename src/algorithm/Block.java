package algorithm;

import java.util.ArrayList;

public class Block 
{
	public int value = 0;
	public int posX = 0, posY = 0;
	
	public boolean previousLayer = false;
	public boolean currentLayer = false;
	
	Block rBlock, lBlock, uBlock, dBlock;
	Block upRBlock, upLBlock, downRBlock, downLBlock;
	
	Block sideBlocks[] = new Block[8];
	
	public void markValues()
	{
		Block blocks[] = getSideBlocks();
		
		for(int i = 0; i < 8; i++)
		{
			if(blocks[i] != null && blocks[i].previousLayer == false && blocks[i].currentLayer == true)
			{
				blocks[i].value++;
			}
		}
	}
	
	public void markCurrentLayer(ArrayList<Block> layer)
	{
		Block blocks[] = getSideBlocks();
		
		for(int i = 0; i < 8; i++)
		{
			if(blocks[i] != null && blocks[i].previousLayer == false && blocks[i].currentLayer == false)
			{
				blocks[i].currentLayer = true;
				layer.add(blocks[i]);
				currentLayer = false;
			}
		}
	}
	
	public Block[] getSideBlocks()
	{
		sideBlocks[0] = upLBlock;
		sideBlocks[1] = uBlock;
		sideBlocks[2] = upRBlock;
		sideBlocks[3] = rBlock;
		sideBlocks[4] = downRBlock;
		sideBlocks[5] = dBlock;
		sideBlocks[6] = downLBlock;
		sideBlocks[7] = lBlock;
		
		return sideBlocks;
	}
}
