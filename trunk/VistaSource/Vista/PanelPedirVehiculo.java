package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
 
public class PanelPedirVehiculo implements ActionListener{//implementando el listener de eventos
 
    JButton jb1, jb2, jb3, jbP1, jbP2, jbP3;   
    JFrame jfM = new JFrame("Seleccion de Vehiculo");
    Vehiculo vehiculo;
    
    public PanelPedirVehiculo(Vehiculo unVehiculo){
    	
        this.vehiculo = unVehiculo;  
        jfM.setLayout(null);
        
        jbP1 = new JButton("Auto"); jbP2 = new JButton("4x4"); jbP3 = new JButton("Moto");
 
        jbP1.setBounds(0, 0, 90, 20); jbP2.setBounds(100, 0, 90, 20); jbP3.setBounds(200, 0, 90, 20);
        jfM.add(jbP1); jfM.add(jbP2); jfM.add(jbP3);
        jbP1.addActionListener(this); jbP2.addActionListener(this); jbP3.addActionListener(this);
        
        jfM.setLocation(0, 0);
        jfM.setResizable(false);
        jfM.setVisible(true);
        jfM.setSize(300, 100);
        jfM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
  
 
    public static void main(String[] args) {        
    	Vehiculo vehiculo = null;
        PanelPedirVehiculo gj = new PanelPedirVehiculo(vehiculo);//uso de constructor para la ventana
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {//sobreescribimos el metodo del listener
 
        if(e.getSource() == jbP1){
        	 this.vehiculo = new Auto();
        	this.jfM.dispose();
        }else if(e.getSource() == jbP2){
            this.vehiculo = new CuatroXCuatro();    
        	this.jfM.dispose();
        
        }else if(e.getSource() == jbP3){
            this.vehiculo = new Moto();
        	this.jfM.dispose();
        }
    }
}