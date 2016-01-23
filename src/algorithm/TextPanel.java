package algorithm;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;

public class TextPanel extends JPanel implements ActionListener, PropertyChangeListener
{
	private static final long serialVersionUID = 1L;
	protected JTextField textFieldLoc;
	protected JFormattedTextField textFieldWidth, textFieldHeight, textFieldPosX, textFieldPosY;
    protected JTextArea textAreaLoc, textAreaWidth, textAreaHeight, textAreaPosX, textAreaPosY;
    
    private NumberFormat numberFormat;
    
    public String fileLocation;
	public int width, height, posX, posY;
	
	JButton button;
 
    public TextPanel() {
        super(new GridBagLayout());
 
        GridBagConstraints c = new GridBagConstraints();
        
        JTextArea text = new JTextArea("File Location");
        c.gridx = 0;
        c.gridy = 0;
        add(text, c);
        
        textFieldLoc = new JTextField(20);
        textFieldLoc.addActionListener(this);
        textAreaLoc = new JTextArea(5, 20);
        textAreaLoc.setEditable(false);
        c.gridx = 1;
        c.gridy = 0;
        add(textFieldLoc, c);
        
        JTextArea textWidth = new JTextArea("Width");
        c.gridx = 0;
        c.gridy = 1;
        add(textWidth, c);
        
        textFieldWidth = new JFormattedTextField(numberFormat);
        textFieldWidth.setValue(width);
        textFieldWidth.setColumns(20);
        textFieldWidth.addPropertyChangeListener("value", this);
        c.gridx = 1;
        c.gridy = 1;
        add(textFieldWidth, c);
        
        JTextArea textHeight = new JTextArea("Height");
        c.gridx = 0;
        c.gridy = 2;
        add(textHeight, c);
        
        textFieldHeight = new JFormattedTextField(numberFormat);
        textFieldHeight.setValue(height);
        textFieldHeight.setColumns(20);
        textFieldHeight.addPropertyChangeListener("value", this);
        c.gridx = 1;
        c.gridy = 2;
        add(textFieldHeight, c);
        
        JTextArea textPosX = new JTextArea("Position X");
        c.gridx = 0;
        c.gridy = 3;
        add(textPosX, c);
        
        textFieldPosX = new JFormattedTextField(numberFormat);
        textFieldPosX.setValue(posX);
        textFieldPosX.setColumns(20);
        textFieldPosX.addPropertyChangeListener("value", this);
        c.gridx = 1;
        c.gridy = 3;
        add(textFieldPosX, c);
        
        JTextArea textPosY = new JTextArea("Position Y");
        c.gridx = 0;
        c.gridy = 4;
        add(textPosY, c);
        
        textFieldPosY = new JFormattedTextField(numberFormat);
        textFieldPosY.setValue(posY);
        textFieldPosY.setColumns(20);
        textFieldPosY.addPropertyChangeListener("value", this);
        c.gridx = 1;
        c.gridy = 4;
        add(textFieldPosY, c);
        
        button = new JButton("Compute");
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setActionCommand("compute");
        button.addActionListener(this);
        c.gridx = 1;
        c.gridy = 5;
        add(button, c);
    }
 
    public void actionPerformed(ActionEvent evt) {
        fileLocation = textFieldLoc.getText();
        
        if("compute".equals(evt.getActionCommand()))
        {
        	algorithm.Main.compute(width, height, posX, posY, fileLocation);
        }
    }
    
    public void propertyChange(PropertyChangeEvent e)
    {
    	Object source = e.getSource();
    	
    	if(source == textFieldWidth)
    		width = ((Number)textFieldWidth.getValue()).intValue();
    	
    	if(source == textFieldHeight)
    		height = ((Number)textFieldHeight.getValue()).intValue();
    	
    	if(source == textFieldPosX)
    		posX = ((Number)textFieldPosX.getValue()).intValue();
    	
    	if(source == textFieldPosY)
    		posY = ((Number)textFieldPosY.getValue()).intValue();
    }
}
