import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Search_Sort extends JFrame implements ActionListener {
	
	JLabel l0,l1,l2,l3;
	JTextField t1,t2,t3;
	JComboBox combo1;
	JButton b1,b2,b3,b4;
	Container c=getContentPane();
	
	String op[]={"Linear Search","Binary Search","Bubble Sort","Quick Sort","Selection Sort","Insertion Sort"};

	Search_Sort(){
		 c.setBackground(Color.yellow);
		c.setLayout(null);
		setSize(1350,900);
		
		l0=new JLabel("Welcome, Select the below options ");
		l0.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
		l0.setBounds(700,50,500,50);
        c.add(l0);
        
        combo1=new JComboBox(op); 
        combo1.addActionListener(this);
        combo1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
		combo1.setBounds(1140,50,200,50); 
		c.add(combo1);
        
		
		c.setBounds(850,200,500,500);
		c.setLayout(null);
		
		
		l1 = new JLabel("Enter Elements seperated by space");
        l1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
		l1.setBounds(750,150,500,50);
        c.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("SANS_SERIF", Font.PLAIN, 25));
		t1.setBounds(780,200,350,40);
		c.add(t1);
		
			l2 = new JLabel("Enter key ");
	        l2.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
			l2.setBounds(900,250,200,50);	
			c.add(l2);
	        t2 = new JTextField();
	        t2.setFont(new Font("SANS_SERIF", Font.PLAIN, 25));
			t2.setBounds(910,300,100,40);
			c.add(t2);
			
			b1= new JButton("Search");
			b1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
			b1.setBounds(800,360,150,60);
			 b1.addActionListener(this); 
			 c.add(b1);
			 
			 b2= new JButton("Reset");
				b2.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
				b2.setBounds(960,360,150,60);
				 b2.addActionListener(this); 
				 c.add(b2);
						 
						 
				b3= new JButton("Sort");
				b3.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
				b3.setBounds(800,360,150,60);
			    b3.addActionListener(this); 
				c.add(b3);
				
				b4= new JButton("Reset");
				b4.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
				b4.setBounds(960,360,150,60);
			    b4.addActionListener(this); 
				c.add(b4);
			
			l3 = new JLabel("");
			l3.setFont(new Font("SANS_SERIF", Font.BOLD, 35));
	        l3.setBounds(810,450,1000,60);
	        c.add(l3);
		
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			 setVisible(true);
	
	}
		public void actionPerformed(ActionEvent e){
			int index=combo1.getSelectedIndex();
		if(index==0)
		{
			l3.setText("");
			l1.setText("Enter Elements");
			l2.setVisible(true);
			t2.setVisible(true);
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(false);
			b4.setVisible(false);
			l3.setBounds(810,450,1000,60);
			String act1=e.getActionCommand();
			if(act1.equals("Search"))
			{
			String str1[]=t1.getText().split(" ");
			String res1="Element ";
			int arr1[]=new int[str1.length];
			for(int i=0;i<str1.length;i++)
					arr1[i]=Integer.parseInt(str1[i]);
			int key=Integer.parseInt(t2.getText()),pos1=-1;
			for(int i=0;i<arr1.length;i++)
			{
				if(key==arr1[i])
					pos1=i+1;
			}
			if(pos1==-1)
				res1+=String.valueOf(key)+" not found ! ";
			else
				res1+=String.valueOf(key)+" found at position "+(String.valueOf(pos1))+" !";
			l3.setText(res1);
			
			}
			else if(act1.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
			}
			l1.setText("Enter Elements seperated by space");
		}
		
		
		else if(index==1)
		{
			l3.setText("");
			l2.setVisible(true);
			t2.setVisible(true);
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(false);
			b4.setVisible(false);
			l3.setBounds(810,450,1000,60);
			l1.setText("Enter Sorted elements seperated by space");
			String act2=e.getActionCommand();
			if(act2.equals("Search"))
			{
			String str2[]=t1.getText().split(" ");
			String res2="Element ";
			int arr2[]=new int[str2.length];
			for(int i=0;i<str2.length;i++)
					arr2[i]=Integer.parseInt(str2[i]);
			int key=Integer.parseInt(t2.getText()),pos2;
			int len=arr2.length,l=0,h=len-1;
		    pos2= bin_logic(arr2,l,h,key)+1;
		    if(pos2>0)
				res2+=String.valueOf(key)+" found at position "+(String.valueOf(pos2))+" !";
			else
				res2+=String.valueOf(key)+" not found ! ";
			l3.setText(res2);
			
	}
			else if(act2.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
				}
			l1.setText("Enter Sorted array seperated by space");
			}
		
		
		else if(index==2)
		{
			l3.setText("");
			l1.setText("Enter Elements seperated by space");
			l2.setVisible(false);
			t2.setVisible(false);
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(true);
			b4.setVisible(true);
			l3.setBounds(800,380,1000,60);											//BUBBLE SORT
			b3.setBounds(800,300,100,40);
			b4.setBounds(960,300,150,40);
			String act3=e.getActionCommand();
			if(act3.equals("Sort"))
			{
			String str3[]=t1.getText().split(" ");
			String res3="";
			int arr3[]=new int[str3.length];
			for(int i=0;i<str3.length;i++)
					arr3[i]=Integer.parseInt(str3[i]);
			for(int i=0;i<arr3.length;i++)
			{
				for(int j=i+1;j<arr3.length;j++)
				{
					if(arr3[i]>arr3[j])
					{
					int temp=arr3[i];
					arr3[i]=arr3[j];
					arr3[j]=temp;
					}
				}
				}
			for(int i=0;i<arr3.length;i++)
				res3+=String.valueOf(arr3[i])+"   ";
			l3.setText(res3);
			}
			else if(act3.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
				}
			l1.setText("Enter Elements seperated by space");
			}
		
		else if(index==3)
		{
			l3.setText("");
			l1.setText("Enter Elements seperated by space");
			l2.setVisible(false);
			t2.setVisible(false);
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(true);
			b4.setVisible(true);
			b3.setBounds(800,300,100,40);
			b4.setBounds(960,300,150,40);
			l3.setBounds(800,380,1000,60);
			String act4=e.getActionCommand();
			if(act4.equals("Sort"))
			{
			String str4[]=t1.getText().split(" ");
			String res4="";
			int arr4[]=new int[str4.length];
			for(int i=0;i<str4.length;i++)
					arr4[i]=Integer.parseInt(str4[i]);
			quick_Part(arr4,0,arr4.length-1); 
			for(int i=0;i<arr4.length;i++)
					res4+=String.valueOf(arr4[i])+"   ";
			l3.setText(res4);
			}
			else if(act4.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
				}
			l1.setText("Enter Elements seperated by space");
			}
		
		
		else if(index==4)
		{
			l3.setText("");
			l1.setText("Enter Elements seperated by space");
			l2.setVisible(false);
			t2.setVisible(false);
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(true);
			b4.setVisible(true);
			b3.setBounds(800,300,100,40);
			b4.setBounds(960,300,150,40);
			l3.setBounds(800,380,1000,60);
			String act5=e.getActionCommand();
			if(act5.equals("Sort"))
			{
			String str5[]=t1.getText().split(" ");
			String res5="";
			int arr5[]=new int[str5.length];
			for(int i=0;i<str5.length;i++)
					arr5[i]=Integer.parseInt(str5[i]);
			 for (int i = 0; i < arr5.length-1; i++)
			    {
			        int min_idx = i;
			        for (int j = i+1; j < arr5.length; j++)
			        {
			            if (arr5[j] < arr5[min_idx])
			            		min_idx = j;
			        }

			        int temp = arr5[min_idx];
			        arr5[min_idx] = arr5[i];
			        arr5[i] = temp;
			    }
			 for(int i=0;i<arr5.length;i++)
					res5+=String.valueOf(arr5[i])+"  ";
			l3.setText(res5);
			}
			else if(act5.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
				}
			l1.setText("Enter Elements seperated by space");
			}
		
		
		else if(index==5)
		{
			l3.setText("");
			l1.setText("Enter Elements seperated by space");
			l2.setVisible(false);
			t2.setVisible(false);
			b1.setVisible(false);
			b2.setVisible(false);
			b3.setVisible(true);
			b4.setVisible(true);
			b3.setBounds(800,300,100,40);
			b4.setBounds(960,300,150,40);
			l3.setBounds(800,380,1000,60);
			String act6=e.getActionCommand();
			if(act6.equals("Sort"))
			{
			String str6[]=t1.getText().split(" ");
			String res6="";
			int arr6[]=new int[str6.length];
			for(int i=0;i<str6.length;i++)
					arr6[i]=Integer.parseInt(str6[i]);
			for (int i = 1; i < arr6.length; ++i) {
		        int key = arr6[i];
		        int j = i - 1;

		        while (j >= 0 && arr6[j] > key) {
		            arr6[j + 1] = arr6[j];
		            j = j - 1;
		        }
		        arr6[j + 1] = key;
		    }
			for(int i=0;i<arr6.length;i++)
				res6+=String.valueOf(arr6[i])+"  ";
			l3.setText(res6);
			
			}
			else if(act6.equals("Reset"))
			{
				t1.setText(null);
				t2.setText(null);
				l3.setText(null);
				}
			l1.setText("Enter Elements seperated by space");
			}
}
		public static int bin_logic(int[] arr2,int l,int h,int key)
		{
	        if(h>=l){
		       int mid=l+(h-l)/2;
		       if(arr2[mid]==key)
		              return mid;
		       else if(arr2[mid]>key) 
		              return bin_logic(arr2,l,mid-1,key);
		       else
		              return bin_logic(arr2,mid+1,h,key);
		        }
		    return -1;
		}
		
		public static void quick_Part(int[] arr4, int low, int high) 
	    {
	        
	        if (arr4 == null || arr4.length == 0){
	            return;
	        }
	         
	        if (low >= high){
	            return;
	        }
	        int middle = low + (high - low) / 2;
	        int pivot = arr4[middle];
	        int i = low, j = high;
	        while (i <= j) 
	        {
	            
	            while (arr4[i] < pivot) 
	            {
	                i++;
	            }
	           
	            while (arr4[j] > pivot) 
	            {
	                j--;
	            }
	           
	            if (i <= j) 
	            {
	                quick_swap (arr4, i, j);
	                i++;
	                j--;
	            }
	        }
	        
	        if (low < j){
	            quick_Part(arr4, low, j);
	        }
	        if (high > i){
	            quick_Part(arr4, i, high);
	        }
	    }
	     
	    public static void quick_swap (int arr4[], int x, int y)
	    {
	        int temp = arr4[x];
	        arr4[x] = arr4[y];
	        arr4[y] = temp;
	    }
	    
	   
	public static void main(String[] args){
	new Search_Sort();
	}
}