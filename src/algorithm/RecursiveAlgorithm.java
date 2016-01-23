package algorithm;

import java.util.ArrayList;

import algorithm.Block;

public class RecursiveAlgorithm 
{
	Block blocks[][];
	
	ArrayList<Block> currentLayer = new ArrayList<Block>();
	ArrayList<Block> nextLayer = new ArrayList<Block>();
	
	public int fillGrid(int width, int height, int x, int y)
	{
		if(x > width || y > height)
			return 1;
		
		if(width == 0 || height == 0)
			return 1;
		
		if(x == 0 || y == 0)
			return 1;
		
		blocks = new Block[height][width];
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				blocks[j][i] = new Block();
			}
		}
		
		Block tempBlock;
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				tempBlock = blocks[j][i];
				tempBlock.posX = i;
				tempBlock.posY = j;
				
				if(i - 1 > -1)
					tempBlock.lBlock = blocks[j][i-1];
				if(i + 1 < width)
					tempBlock.rBlock = blocks[j][i+1];
				
				if(j - 1 > -1)
				{
					tempBlock.uBlock = blocks[j-1][i];
					
					if(i + 1 < width)
						tempBlock.upRBlock = blocks[j-1][i+1];
					
					if(i - 1 > -1)
						tempBlock.upLBlock = blocks[j-1][i-1];
				}
				
				if(j + 1 < height)
				{
					tempBlock.dBlock = blocks[j+1][i];
					
					if(i + 1 < width)
						tempBlock.downRBlock = blocks[j+1][i+1];
					
					if(i - 1 > -1)
						tempBlock.downLBlock = blocks[j+1][i-1];
				}
			}
		}
		
		tempBlock = blocks[y - 1][x - 1];
		tempBlock.previousLayer = true;
		tempBlock.value = 0;
		
		nextLayer.add(tempBlock);
		
		int layers = Math.abs(width - x);
		
		if(Math.abs(y - height) > layers)
			layers = Math.abs(y - height);
		
		if(x > layers)
			layers = x;
		if(y > layers)
			layers = y;
		
		for(int i = 0; i < layers; i++)
		{
			currentLayer = (ArrayList<Block>) nextLayer.clone();
			nextLayer.clear();
			markLayers(currentLayer, nextLayer);
			
			for(int j = 0; j < currentLayer.size(); j++)
			{
				currentLayer.get(j).markValues();
			}
		}
		
		return 0;
	}
	
	public void markLayers(ArrayList<Block> layer, ArrayList<Block> nLayer)
	{
		for(int i = 0; i < layer.size(); i++)
		{
			layer.get(i).previousLayer = true;
			layer.get(i).markCurrentLayer(nLayer);
		}
	}
}
