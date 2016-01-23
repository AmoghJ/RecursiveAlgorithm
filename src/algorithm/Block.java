package algorithm;

import java.util.ArrayList;

public class Block 
{
	public int value = 0;
	
	public boolean previousLayer = false;
	public boolean currentLayer = false;
	
	Block sideBlocks[] = new Block[8];
	
	public void markValues()
	{		
		for(int i = 0; i < 8; i++)
		{
			if(sideBlocks[i] != null && sideBlocks[i].previousLayer == false && sideBlocks[i].currentLayer == true)
			{
				sideBlocks[i].value++;
			}
		}
	}
	
	public void markCurrentLayer(ArrayList<Block> layer)
	{
		for(int i = 0; i < 8; i++)
		{
			if(sideBlocks[i] != null && sideBlocks[i].previousLayer == false && sideBlocks[i].currentLayer == false)
			{
				sideBlocks[i].currentLayer = true;
				layer.add(sideBlocks[i]);
				currentLayer = false;
			}
		}
	}
	
	public Block[] getSideBlocks()
	{
		return sideBlocks;
	}
}
