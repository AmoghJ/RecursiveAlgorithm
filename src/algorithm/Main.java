package algorithm;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import algorithm.RecursiveAlgorithm;
import algorithm.WriteFile;
import algorithm.TextPanel;

public class Main 
{ 
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Recursive Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TextPanel());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void compute(int width, int height, int x, int y, String location)
	{
		RecursiveAlgorithm algorithm = new RecursiveAlgorithm();
		
		if (algorithm.fillGrid(width, height, x, y) == 0)
		{
			WriteFile fileWriter = new WriteFile(location + "Computed Algorithm.txt");
			
			try
			{
				fileWriter.startWriteToFile();
				fileWriter.writeToFile("Recursive Algorithm");
				fileWriter.writeNewLine();
				fileWriter.writeToFile("Width: " + width);
				fileWriter.writeNewLine();
				fileWriter.writeToFile("Height: " + height);
				fileWriter.writeNewLine();
				fileWriter.writeToFile("Pos X: " + x);
				fileWriter.writeNewLine();
				fileWriter.writeToFile("Pos Y: " + y);
				fileWriter.writeNewLine();
				fileWriter.writeNewLine();
				
				for(int i = 0; i < height; i++)
				{
					for(int j = 0; j < width; j++)
					{
						fileWriter.writeToFile(algorithm.blocks[i][j].value + " ");
					}
					
					fileWriter.writeNewLine();
				}
				
				fileWriter.closeWriteToFile();
				
				JOptionPane.showMessageDialog(null, "Done!", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Arguments", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
}
