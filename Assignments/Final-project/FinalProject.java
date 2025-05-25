import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class FinalProject extends JFrame implements ActionListener, MouseListener
{
	ImageIcon img1, img2;
	JLabel chipsLabel, drinksLabel, imgLabel1, imgLabel2, chipsPriceLabel, drinksPriceLabel;
	JTextField chipsTF, drinksTF;
	JTextArea purchaseHistoryArea;
	JButton clearBtn, cartBtn, purchaseBtn;
	JScrollPane scrollPane;
	JPanel panel;
	
	
	
	public FinalProject()
	{
		super("Grocery Shop Managememnt");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		img1 = new ImageIcon("Images/Chips.jpeg");
		imgLabel1 = new JLabel(img1);
		imgLabel1.setBounds(10, -20, 200, 300);
		panel.add(imgLabel1);
		
		chipsLabel = new JLabel("Chips Quantity");
		chipsLabel.setBounds(250, 100, 100, 30);
		panel.add(chipsLabel);
		
		chipsTF = new JTextField();
		chipsTF.setBounds(250, 130, 100, 30);
		panel.add(chipsTF);
		
		chipsPriceLabel = new JLabel("Price: 10 Taka");
		chipsPriceLabel.setBounds(65, 237, 160, 30);
		panel.add(chipsPriceLabel);
		
		
		
		img2 = new ImageIcon("Images/Drinks.png");
		imgLabel2 = new JLabel(img2);
		imgLabel2.setBounds(10, 270, 200, 270);
		panel.add(imgLabel2);
		
		drinksLabel = new JLabel("Drinks Quantity");
		drinksLabel.setBounds(250, 370, 100, 30);
		panel.add(drinksLabel);
		
		drinksTF = new JTextField();
		drinksTF.setBounds(250, 400, 100, 30);
		panel.add(drinksTF);
		
		drinksPriceLabel = new JLabel("Price: 25 Taka");
		drinksPriceLabel.setBounds(65, 535, 160, 30);
		panel.add(drinksPriceLabel);
		
		
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(350, 230, 150, 30);
		clearBtn.addActionListener(this);
		panel.add(clearBtn);
		
		cartBtn = new JButton("Add To Cart");
		cartBtn.setBounds(350, 260, 150, 30);
		cartBtn.addActionListener(this);
		panel.add(cartBtn);
		
		purchaseBtn = new JButton("Confirm Purchase");
		purchaseBtn.setBounds(350, 290, 150, 30);
		purchaseBtn.addActionListener(this);
		panel.add(purchaseBtn);
		
		
		
		purchaseHistoryArea = new JTextArea();
		purchaseHistoryArea.setEditable(false);
		scrollPane = new JScrollPane(purchaseHistoryArea);
		scrollPane.setBounds(550, 20, 400, 520);
		panel.add(scrollPane);
		
		
		
		this.add(panel);
		this.setLocationRelativeTo(null);
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(cartBtn.getText().equals(command))
		{
			addToCart();
		}
		else if(purchaseBtn.getText().equals(command))
		{
			purchase();
		}
		else if(clearBtn.getText().equals(command))
		{
			clearFields();
		}
	}
	
	
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	
	
	
	private void addToCart()
	{
		String chipsQuantity = chipsTF.getText();
		String drinksQuantity = drinksTF.getText();
		
		if(chipsQuantity.isEmpty() && drinksQuantity.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter quantity");
			return;
		}
		
		Info newInfo;
		
		if(chipsQuantity.isEmpty())
		{
			chipsQuantity = null;
			newInfo = new Info(chipsQuantity, drinksQuantity);
		}
		else if(drinksQuantity.isEmpty())
		{
			drinksQuantity = null;
			newInfo = new Info(chipsQuantity, drinksQuantity);
		}
		else
		{
			newInfo = new Info(chipsQuantity, drinksQuantity);
		}
		
		try
		{
			FileWriter writer = new FileWriter("PurchaseData.txt", true);
			writer.write("Chips" + ", " + newInfo.getChipsQuantity() + ", " + "Drinks" + ", " + newInfo.getDrinksQuantity() + ", " + "Total price" + ", " + newInfo.getTotalPrice() + "\n");
			writer.close();
			JOptionPane.showMessageDialog(this, "Successfully added to cart");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	private void purchase()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("PurchaseData.txt"));
			String line;
			StringBuilder content = new StringBuilder();
			int customerCount = 1;
			
			while( (line = reader.readLine()) != null )
			{
				String[] parts = line.split(",");
				
				if(parts.length >= 5)
				{
					String chipsQuantity = parts[1].trim();
					String drinksQuantity = parts[3].trim();
					String total = parts[5].trim();
					
					content.append("------------------------------ \n");
					content.append("Customer ").append(customerCount++).append("\n");
					content.append("Chips: ").append(chipsQuantity).append("\n");
					content.append("Drinks: ").append(drinksQuantity).append("\n");
					content.append("Total Price: ").append(total).append("\n");
					content.append("------------------------------ \n");
				}
			}
			
			reader.close();
			purchaseHistoryArea.setText(content.toString());
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	private void clearFields()
	{
		chipsTF.setText("");
		drinksTF.setText("");
	}
}