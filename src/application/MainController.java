package application;

import java.io.BufferedWriter;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MainController implements Initializable {
	
	
	String end;
    Double dist;
    public static int ch;
    public static int pp;
    public static String user;
    public static String des="";
    public static String veh;
    public  static double fare;
    public static double carkm;
    public static double trainkm;
    public static double data;
    public static String trans="";
    
    @FXML
    private AnchorPane ap;
    
    @FXML
    private AnchorPane ap1;
    
    @FXML
    private TextField uname;

    @FXML
    private TextField ppl;

    @FXML
    private Button gen;

    @FXML
    private TextArea area;
    
    @FXML
	ComboBox dest=new ComboBox();
 @FXML
	ComboBox transport=new ComboBox();
 
 


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
   	 ObservableList<String> options = 
	       	    FXCollections.observableArrayList("Ckm","Mangalore","Udupi");
	       
		        dest.getItems().addAll(options);
		        
		        ObservableList<String> opt = 
	    	       	    FXCollections.observableArrayList("car","train");
	    	       
	    		        transport.getItems().addAll(opt);
	    		       
		
	}
	
	
	
	
	@FXML
	void display(ActionEvent event) 

    {   
		
	//	MainController d[]=new MainController[20];
		/*
	      d[0]=new MainController("Ckm",200.0);
	      d[1]=new MainController("Mangalore",450.0);
	      d[2]=new MainController("Hubbali",390.0);
	      d[3]=new MainController("Ooty",300.0);
	      d[4]=new MainController("Mysore",150.0);
	      d[5]=new MainController("Tumkur",80.0);
	      d[6]=new MainController("Hampi",350.0);
	      d[7]=new MainController("Karwar",500.0);
	      d[8]=new MainController("Kaiga",420.0);
	      d[9]=new MainController("Coorg",290.0);
	      d[10]=new MainController("Dharwad",400.0);
	      d[11]=new MainController("Udupi",480.0); */
	      
	      List <String> list = new ArrayList<String>();
	      list.add("Ckm");
	      list.add("Mangalore");
	      list.add("Udupi");
	      
	      List <Integer> list1 = new ArrayList<Integer>();
	      list1.add(200);
	      list1.add(450);
	      list1.add(480);
		
		 user=uname.getText();
		String ppls=ppl.getText().toString();
	  pp=Integer.parseInt(ppls);
	des=dest.getValue().toString();

 	 trans=transport.getValue().toString();
 	// System.out.println(trans);
	
	
	
	int found=0;
    try
    {
    for(int i=0;i<3;i++)
    { if (des.equalsIgnoreCase(list.get(i)))
     {
          data =list1.get(i);
         found=1;
         
         
            //System.out.println("enter the type of vehicle");
            
            switch(trans)
            {
                case "car" : System.out.println("car");
                 fare =calc(data);
                System.out.println("Total Fare="+fare);
                disp();
                break;
                case "train" : System.out.println("train");
                 fare =calc(data);
                 System.out.println("Total Fare="+fare);
                 disp();
                break;
                default: System.out.println("enter valid choice");
            }
    }
    else
    {
    	found=0;
    }
   
    }
    if(found==0)
        System.out.println("Enter valid destination");
    }
    
    catch(NullPointerException e)
    {
    	System.out.println(); 
    	
    }
    
   //if(found==0)
   //          System.out.println("Enter valid destination");
   
    


	
		
		
		
    }
	        
    	
	public static Double calc(Double datadup)
    { 
		System.out.println(trans);
         carkm=10.0;
    trainkm=6.0;
    Double fare=1.0;
    System.out.println(datadup);System.out.println(datadup);
    
    if(trans=="car")
    {fare=carkm*datadup*pp;
    System.out.println(datadup);System.out.println(datadup);
     //System.out.println("Total Fare="+fare);
     return fare;
    }
    else
    {
        fare=trainkm*datadup*pp;
     //System.out.println("Total Fare="+fare);
        return fare;
    }
    }
    
public void disp()
{   
	if(trans=="car")
	   veh= "CAR";
	if(trans=="train")
		veh="TRAIN";
	System.out.println("---------------------------------------");
	System.out.println("|Ticket in the name of   : "+user);
	System.out.println("|Starting from           : BANGALORE");
	System.out.println("|Destination             : "+ des );
	System.out.println("|Vehicle chosen          : "+ veh );
	System.out.println("|The fare is as follows  : "+ fare);
	System.out.println("|The price per person is : " + (fare/pp));
	System.out.println("---------------------------------------");
	System.out.println("---------------------------------------");
	
	area.setText("---------------------------------------------------------------");
	area.appendText("\n |Ticket in the name of   : " +user);
	area.appendText("\n |Starting from           : BANGALORE");
	area.appendText("\n |Destination             : "+ des );
	area.appendText("\n |Vehicle chosen          : "+ veh);
	area.appendText("\n |The fare is as follows  : "+ fare);
	area.appendText("\n |The price per person is : " + (fare/pp));
	area.appendText("\n---------------------------------------");
	area.appendText("\n---------------------------------------------------------------");
	
	
	if(pp>4)
	{
		area.appendText("\n Kudos!! The more the merrier :)");
		area.appendText("\n Travelling with fam is handsdown the best!!" +
				"Therefore your per km price would be reduced by 15%! ");
		 if(trans=="car")
		    {fare=(carkm-0.15*carkm)*data*pp;
		    area.appendText("\n Revised Fare="+fare);
		    area.appendText("\n Per person cost= "+(fare/pp));
		     
		    }
		    else
		    {
		        fare=(trainkm-0.15*trainkm)*data*pp;
		        area.appendText("\n Revised Fare="+fare);
		        area.appendText("\n Per person cost= "+(fare/pp));
		    }
		        
		
	}
}


    
	
	
	

}
