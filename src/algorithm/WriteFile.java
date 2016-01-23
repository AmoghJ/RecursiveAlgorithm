package algorithm;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile 
{
	private String path;
	private boolean append_to_file = false;
	private PrintWriter print_line;
	
	public WriteFile(String _path)
	{
		path = _path;
	}
	public WriteFile(String _path, boolean append)
	{
		path = _path;
		append_to_file = append;
	}
	
	public void startWriteToFile() throws IOException
	{
		FileWriter write = new FileWriter(path, append_to_file);
		print_line = new PrintWriter(write);
		//print_line.close();
	}
	
	public void writeToFile(String textLine) throws IOException
	{
		print_line.printf("%s", textLine);
	}
	
	public void writeNewLine() throws IOException
	{
		print_line.printf("%n", "");
	}
	
	public void closeWriteToFile() throws IOException
	{
		print_line.close();
	}
}
