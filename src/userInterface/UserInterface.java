/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import userInterface.frontEnd.AttributeViewer;
import userInterface.frontEnd.InfoWin;
import userInterface.frontEnd.SimulationViewer;

/**
 *
 * @author ShiuJia
 */
public class UserInterface
{
    private JFrame frame;
    private SimulationViewer simView;
    private InfoWin result;
    private JSplitPane splitPane;
    private JSplitPane bottomSplitPane ;
    private AttributeViewer atb; 
    
    public UserInterface()
    {
        this.initialize();
        this.frame.setVisible(true);
    }
    
    private void initialize()
    {
        this.frame = new JFrame("MCRTsim v2.0");
        this.frame.setBounds(100, 100, 1000, 600);
        this.frame.setMinimumSize(new Dimension(1000, 600));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       // this.frame.setTitle("MCRTSim v0.1");
        
        splitPane = new JSplitPane();
        this.frame.getContentPane().add(splitPane);
        splitPane.setOrientation(1);
        splitPane.setContinuousLayout(false);
        simView = new SimulationViewer(this);
        splitPane.setTopComponent(simView);
        splitPane.setDividerLocation(splitPane.getMinimumDividerLocation());
        
        result = new InfoWin(this);
        bottomSplitPane = new JSplitPane();
        bottomSplitPane.setOrientation(1);
        bottomSplitPane.setContinuousLayout(false);
       
        
        splitPane.setBottomComponent(bottomSplitPane);
        bottomSplitPane.setTopComponent(result);
        
        atb=new AttributeViewer(this);
        bottomSplitPane.setBottomComponent(atb);      
        System.out.println(bottomSplitPane.getMinimumDividerLocation()+","+bottomSplitPane.getMaximumDividerLocation()+","+this.frame.getWidth());
        bottomSplitPane.setDividerLocation(450);
    }
    
    
    
    public void extendSimulationViewer()
    {
        boolean b = false;
        int x = 0;
        if(this.bottomSplitPane.getDividerLocation() > this.bottomSplitPane.getWidth()-20)
        {
            b = true;
        }
        else
        {
            x = this.bottomSplitPane.getWidth() - this.bottomSplitPane.getDividerLocation();
        }
        
        if(splitPane.getDividerLocation() < 5)
        {
            splitPane.setDividerLocation(splitPane.getMinimumDividerLocation());
        }
        else
        {
            splitPane.setDividerLocation(0);
        }
        
        this.frame.revalidate();
        
        if(b)
        {
            
            System.out.println("3"+","+this.bottomSplitPane.getWidth());
            this.bottomSplitPane.setDividerLocation(this.bottomSplitPane.getWidth());
        }
        else
        {
            System.out.println("4"+","+this.bottomSplitPane.getWidth() + "," + x);
            this.bottomSplitPane.setDividerLocation(this.bottomSplitPane.getWidth() - x);
        }
        
    }
    
    public void extendAttributeViewer()
    {
        int i = this.bottomSplitPane.getWidth()-this.bottomSplitPane.getDividerSize();
        System.out.println(""+this.bottomSplitPane.getDividerLocation()+","+i);
        
        if(this.bottomSplitPane.getDividerLocation() < this.bottomSplitPane.getWidth() -this.bottomSplitPane.getDividerSize()-5)
        {
            System.out.println("1");
            this.bottomSplitPane.setDividerLocation(this.bottomSplitPane.getWidth());
        }
        else
        {
            System.out.println("2");
            this.bottomSplitPane.setDividerLocation(this.bottomSplitPane.getWidth()-200);
        }
        //System.out.println(""+this.bottomSplitpane.getDividerLocation() + ","+this.frame.getWidth());
    }
    
    public SimulationViewer getSimulationViewer()
    {
        return this.simView;
    }

    public JFrame getFrame()
    {
        return this.frame;
    }
    
    public AttributeViewer getAttributes()
    {
        return this.atb;
    }
    
    public InfoWin getInfoWin()
    {
        return this.result;
    }
    
    public JSplitPane getBottomSplitpane()
    {
        return this.bottomSplitPane;
    }
}
