import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/* Author: Brent Dewald
 * 04-12-2011
 * 
 * This Class is for the GUI for the shim calculator. The user will enter all the values needed and they 
 * will be passed tp the other class to make the calculations.
 * 
 */
public class ShimCalculatorGUI extends JFrame implements ActionListener{

	//variables for GUI components
	private JComboBox cb_CalChoice = null;
	private JComboBox cb_MHD = null;
	private JComboBox cb_Block = null;
	private JComboBox cb_Ext = null;
	
	private JLabel jl_CalChoice = null;
	private JLabel jl_Differential = null;
	private JLabel jl_PinionHeight = null;
	private JLabel jl_ToolExt = null;
	private JLabel jl_Reading = null;
	private JLabel jl_Shim = null;
	private JLabel jl_Block = null;
	private JLabel jl_ScribedDepth = null;
	
	private JTextField tf_PinionHeight = null;
	private JTextField tf_Reading = null;
	private JTextField tf_Shim = null;
	private JTextField tf_ScribedDepth = null;
	
	private JButton jb_Calculate = null;
	private JButton jb_Close = null;
	
	private JPanel panel1 = null;
        private JPanel panel2 = null;

        private JSplitPane splitpane = null;
	
	public ShimCalculatorGUI() {
		
		loadGUI();
		setSize(600,400);
                setTitle("Shim Calculator");
	}
	
	//method that loads all the GUI components
	private void loadGUI(){
		
		//sets up the panels with a vertical box layout
                panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel2 = new JPanel();
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		//Labels for descriptions of fields
                Dimension d = new Dimension(175,44);
                Dimension d2 = new Dimension(425,44);
		jl_CalChoice = new JLabel("Type of Gears");
                jl_CalChoice.setPreferredSize(d);
                jl_CalChoice.setMaximumSize(d);
		jl_Differential = new JLabel("Differential Type");
                jl_Differential.setPreferredSize(d);
                jl_Differential.setMaximumSize(d);
		jl_PinionHeight = new JLabel("Pinion Height");
                jl_PinionHeight.setPreferredSize(d);
                jl_PinionHeight.setMaximumSize(d);
		jl_ToolExt = new JLabel("Extension used");
                jl_ToolExt.setPreferredSize(d);
                jl_ToolExt.setMaximumSize(d);
		jl_Reading = new JLabel("Indicator Reading");
                jl_Reading.setPreferredSize(d);
                jl_Reading.setMaximumSize(d);
		jl_Shim = new JLabel("Shim size");
                jl_Shim.setPreferredSize(d);
                jl_Shim.setMaximumSize(d);
		jl_Block = new JLabel("Block used");
                jl_Block.setPreferredSize(d);
                jl_Block.setMaximumSize(d);
		jl_ScribedDepth = new JLabel("Scribed Depth");
                jl_ScribedDepth.setPreferredSize(d);
                jl_ScribedDepth.setMaximumSize(d);
		
		//comboboxes String Variables to load the values of the ComboBoxes
		String[] gears = {"OEM", "Aftermarket", "1-2-3 Block"};
		cb_CalChoice = new JComboBox(gears);
		cb_CalChoice.setSelectedIndex(0);
                cb_CalChoice.setPreferredSize(d2);
                cb_CalChoice.setMaximumSize(d2);
		cb_CalChoice.addActionListener(this);
		String[] differentials = {"GM 10 Bolt 7.2(3.693 MHD)", "GM 10 Bolt 7.5(3.787 MHD)", "GM 10 Bolt 8.2 x 25 Spline Pinion (4.175 MHD)",
				"GM 10 Bolt 8.2 x 27 Spline Pinion (4.175 MHD)", "GM 10 Bolt 8.2 x Thin 55-64 Vette (4.125 MHD",
				"GM 10 Bolt 8.5 x 30 Spline (4.262 MHD)", "GM 10 Bolt 8.5 27 Spline (4.262 MHD)", "GM 12 Bolt 8.875 x 1.438 Pinion Dia. (4.556 MHD)",
				"GM 12 Bolt 8.875 x 1.625 Pinion Dia. (4.670 MHD)", "GM 12 Bolt 9.300 (4.620 MHD)", "Chrysler 10 Bolt 8.250 (4.124 MHD)",
				"Chrysler 12 Bolt 8.750 x 1.750 Pinion Stem (4.350 MHD)", "Chrysler 12 Bolt 8.750 x 1.875 Pinion Stem (4.344 MHD)",
				"Chrysler 12 Bolt 9.250 (4.625 MHD)", "Ford 6.625 (3.500 MHD)", "Ford 7.5 (4.040 MHD)", "Ford 8.0 (4.000 MHD)",
				"Ford 8.8 (4.415 MHD)", "Ford 9.0 (4.375 MHD)", "AMC 8 Bolt 8.875 (4.500 MHD)", "Dana Spicer 30 (3.625 MHD)",
				"Dana Spicer 36 (3.931 MHD)", "Dana Spicer 44 (4.312 MHD)", "Dana Spicer 50 (4.616 MHD)", "Dana Spicer 60 (5.000 MHD)",
				"Dana Spicer 70 (5.375 MHD)"};
		cb_MHD = new JComboBox(differentials);
		cb_MHD.setSelectedIndex(0);
                cb_MHD.setPreferredSize(d2);
                cb_MHD.setMaximumSize(d2);
		String[] block = {"1 inch", "2 inch", "3 inch"};
		cb_Block = new JComboBox(block);
		cb_Block.setSelectedIndex(0);
                cb_Block.setPreferredSize(d2);
                cb_Block.setMaximumSize(d2);
		String[] ext = {"Short (1.900)", "Medium (2.500)", "Long (3.375)"};
		cb_Ext = new JComboBox(ext);
		cb_Ext.setSelectedIndex(0);
                cb_Ext.setPreferredSize(d2);
                cb_Ext.setMaximumSize(d2);
		
		//text fields
		tf_PinionHeight = new JTextField(10);
                tf_PinionHeight.setPreferredSize(d2);
                tf_PinionHeight.setMaximumSize(d2);
		tf_Reading = new JTextField(10);
                tf_Reading.setPreferredSize(d2);
                tf_Reading.setMaximumSize(d2);
		tf_Shim = new JTextField(10);
                tf_Shim.setPreferredSize(d2);
                tf_Shim.setMaximumSize(d2);
		tf_ScribedDepth = new JTextField(10);
                tf_ScribedDepth.setPreferredSize(d2);
		tf_ScribedDepth.setMaximumSize(d2);
		//Jbuttons
		jb_Calculate = new JButton("Calculate");
                jb_Calculate.setHorizontalAlignment(SwingConstants.CENTER);
                jb_Calculate.setPreferredSize(new Dimension(100,40));
		jb_Calculate.addActionListener(this);
		jb_Close = new JButton("Close");
                jb_Close.setHorizontalAlignment(SwingConstants.CENTER);
                jb_Close.setPreferredSize(new Dimension(200,40));
		jb_Close.addActionListener(this);
		
		//add components to panel1
		panel1.add(jl_CalChoice);
                panel1.add(jl_Differential);
                panel1.add(jl_PinionHeight);
                panel1.add(jl_ToolExt);
                panel1.add(jl_Reading);
                panel1.add(jl_Block);
                panel1.add(jl_ScribedDepth);
                panel1.add(jl_Shim);
                panel1.add(jb_Calculate);
		
                //add componets to panel2
                panel2.add(cb_CalChoice);
		panel2.add(cb_MHD);
                panel2.add(tf_PinionHeight);
		panel2.add(cb_Ext);
		panel2.add(tf_Reading);
		panel2.add(cb_Block);
		panel2.add(tf_ScribedDepth);
		panel2.add(tf_Shim);
		panel2.add(jb_Close);
		
		jl_Block.setEnabled(false);
		jl_ScribedDepth.setEnabled(false);
		cb_Block.setEnabled(false);
		tf_ScribedDepth.setEnabled(false);

                splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
		splitpane.setDividerLocation(175);
                add(splitpane);
				
	}//end loadGUI
	
	//method to enable and disable the proper fields depending on the selection of the combobox
	private void OEMfields() {
		jl_Differential.setEnabled(true);
		jl_PinionHeight.setEnabled(true);
		jl_Block.setEnabled(false);
		jl_ScribedDepth.setEnabled(false);
		cb_MHD.setEnabled(true);
		tf_PinionHeight.setEnabled(true);
		cb_Block.setEnabled(false);
		tf_ScribedDepth.setEnabled(false);
	}//end OEMfields
	
	private void AfterMarketFields(){
		jl_Differential.setEnabled(false);
		jl_PinionHeight.setEnabled(false);
		jl_Block.setEnabled(false);
		jl_ScribedDepth.setEnabled(true);
		cb_MHD.setEnabled(false);
		tf_PinionHeight.setEnabled(false);
		cb_Block.setEnabled(false);
		tf_ScribedDepth.setEnabled(true);
	}//end AfterMarketFields
	
	private void BlockFields(){
		jl_Differential.setEnabled(true);
		jl_PinionHeight.setEnabled(false);
		jl_Block.setEnabled(true);
		jl_ScribedDepth.setEnabled(false);
		cb_MHD.setEnabled(true);
		tf_PinionHeight.setEnabled(false);
		cb_Block.setEnabled(true);
		tf_ScribedDepth.setEnabled(false);
	}//end BlockFields
	
        private void ClearFields(){
                tf_PinionHeight.setText("");
		tf_Reading.setText("");
		tf_Shim.setText("");
		tf_ScribedDepth.setText("");
        }//end ClearFields

	public void actionPerformed(ActionEvent e) {
            //changes the fields depending on which selection is made in the combobox
            try{
            if(e.getSource() == cb_CalChoice){
			int index = cb_CalChoice.getSelectedIndex();
			switch (index) {
                            case 0: OEMfields();
                            break;
                            case 1: AfterMarketFields();
                            break;
                            case 2: BlockFields();
                            default: break;
			}//end switch
                        ClearFields();
		}//end if
             if(e.getSource() == jb_Calculate){
                        int index = cb_CalChoice.getSelectedIndex();
                        if (index == 0){
                            int diff = cb_MHD.getSelectedIndex();
                            double ph = Double.parseDouble(tf_PinionHeight.getText());
                            int ext = cb_Ext.getSelectedIndex();
                            double reading = Double.parseDouble(tf_Reading.getText());
                            ShimCalculator sc = new ShimCalculator(diff, ph, ext, reading);
                            tf_Shim.setText(sc.getShim());
                        }//end if
                        if (index == 1){
                            int ext = cb_Ext.getSelectedIndex();
                            double reading = Double.parseDouble(tf_Reading.getText());
                            double sd = Double.parseDouble(tf_ScribedDepth.getText());
                            ShimCalculator sc = new ShimCalculator(ext, reading, sd);
                            tf_Shim.setText(sc.getShim());
                        }//end if
                        if (index == 2){
                            int diff = cb_MHD.getSelectedIndex();
                            int ext = cb_Ext.getSelectedIndex();
                            double reading = Double.parseDouble(tf_Reading.getText());
                            int block = cb_Block.getSelectedIndex();
                            ShimCalculator sc = new ShimCalculator(diff, ext, reading, block);
                            tf_Shim.setText(sc.getShim());
                        }//end if
             }//end if
             if (e.getSource() == jb_Close){
                 System.exit(0);
             }//end if
            }//end try
            catch (NumberFormatException nfe){
		JOptionPane.showMessageDialog(null, "Please enter all entries in numeric form!");
            }//end catch
	}//end actionPerformed

	public static void main(String[] args){
		
		ShimCalculatorGUI gui = new ShimCalculatorGUI();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}//end ShimCalculatorGUI
