import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	
	PreparedStatement state=null;
	Connection conn=null;
	ResultSet result=null;
	JTabbedPane tab=new JTabbedPane();
    int id = -1;
    
    JTable tableW = new JTable();
    JScrollPane scrollerW = new JScrollPane(tableW);
    
    JTable tableR = new JTable();
    JScrollPane scrollerR = new JScrollPane(tableR);
    
    JTable tableRS = new JTable();
    JScrollPane scrollerRS = new JScrollPane(tableRS);
    
    JTable tableI = new JTable();
    JScrollPane scrollerI = new JScrollPane(tableI);
	
	JPanel waterPanel=new JPanel();
	JPanel regionPanel=new JPanel();
	JPanel responsiblePanel=new JPanel();
	JPanel infoPanel = new JPanel();

	
	JPanel upPanelW = new JPanel();
	JPanel midPanelW = new JPanel();
	JPanel downPanelW = new JPanel();
	
	JPanel upPanelR = new JPanel();
	JPanel midPanelR = new JPanel();
	JPanel downPanelR = new JPanel();
	
	JPanel upPanelRS = new JPanel();
	JPanel midPanelRS = new JPanel();
	JPanel downPanelRS = new JPanel();
	
	JPanel upPanelI = new JPanel();
	JPanel downPanelI = new JPanel();
	
	
	JButton addButtonW = new JButton("Add");
	JButton deleteButtonW = new JButton("Delete");
	JButton editButtonW = new JButton("Edit");
	JButton searchButtonW = new JButton("Search");
	JButton resetButtonW = new JButton("Reset");
	JComboBox<String> searchComboW = new JComboBox<String>();

	JButton addButtonR = new JButton("Add");
	JButton deleteButtonR = new JButton("Delete");
	JButton editButtonR = new JButton("Edit");
	JButton searchButtonR = new JButton("Search");
	JButton resetButtonR = new JButton("Reset");
	JComboBox<String> searchComboR1 = new JComboBox<String>();
	JComboBox<String> searchComboR2 = new JComboBox<String>();

	JButton addButtonRS = new JButton("Add");
	JButton deleteButtonRS = new JButton("Delete");
	JButton editButtonRS = new JButton("Edit");
	JButton searchButtonRS = new JButton("Search");
	JButton resetButtonRS = new JButton("Reset");
	JComboBox<String> searchComboRS = new JComboBox<String>();
	
	JComboBox<String> searchComboI1 = new JComboBox<String>();
	JComboBox<String> searchComboI2 = new JComboBox<String>();
	JButton searchButtonI = new JButton("Search");

	
	
	
	JLabel waterNameL = new JLabel("Name:");
	JLabel waterAreaL = new JLabel("Area of water:");
	JLabel waterDepthL = new JLabel("Depth of water:");
	JLabel regionNameL = new JLabel("Region:");
	JLabel regionAreaL = new JLabel("Area of region:");
	JLabel regionPopulationL = new JLabel("Population of region:");
	JLabel responsibleFnameL = new JLabel("First name:");
	JLabel responsibleLnameL = new JLabel("Last name:");
	JLabel responsibleAgeL = new JLabel("Age:");
	JLabel responsibleCommentL = new JLabel("Text comment:");
	

	
	JTextField waterNameTF = new JTextField();
	JTextField waterAreaTF = new JTextField();
	JTextField waterDepthTF = new JTextField();
	JTextField regionNameTF = new JTextField();
	JTextField regionAreaTF = new JTextField();
	JTextField regionPopulationTF = new JTextField();
	JTextField responsibleFnameTF = new JTextField();
	JTextField responsibleLnameTF = new JTextField();
	JTextField responsibleAgeTF = new JTextField();
	JTextField responsibleCommentTF = new JTextField();

	
	
	

	public MyFrame() {
		

		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		tab.add(waterPanel, "Water");
		tab.add(regionPanel, "Region");
		tab.add(responsiblePanel, "Responible");
		tab.add(infoPanel, "Info");
		waterPanel.add(upPanelW);
		this.add(tab);
		
		
		
		
		upPanelW.setLayout(new GridLayout(3, 2));
		upPanelW.add(waterNameL);
		upPanelW.add(waterNameTF);
		upPanelW.add(waterAreaL);
		upPanelW.add(waterAreaTF);
		upPanelW.add(waterDepthL);
		upPanelW.add(waterDepthTF);

		upPanelR.setLayout(new GridLayout(4, 2));
		upPanelR.add(regionNameL);
		upPanelR.add(regionNameTF);
		upPanelR.add(regionAreaL);
		upPanelR.add(regionAreaTF);
		upPanelR.add(regionPopulationL);
		upPanelR.add(regionPopulationTF);
		upPanelR.add(searchComboR1);
		upPanelR.add(searchComboR2);

		upPanelRS.setLayout(new GridLayout(4, 2));
		upPanelRS.add(responsibleFnameL);
		upPanelRS.add(responsibleFnameTF);
		upPanelRS.add(responsibleLnameL);
		upPanelRS.add(responsibleLnameTF);
		upPanelRS.add(responsibleAgeL);
		upPanelRS.add(responsibleAgeTF);
		upPanelRS.add(responsibleCommentL);
		upPanelRS.add(responsibleCommentTF);
		
		
		upPanelI.add(searchButtonI);
		upPanelI.add(searchComboI1);
		upPanelI.add(searchComboI2);

		
		midPanelW.add(addButtonW);
		midPanelW.add(deleteButtonW);
		midPanelW.add(editButtonW);
		midPanelW.add(searchComboW);
		midPanelW.add(searchButtonW);
		midPanelW.add(resetButtonW);
		
		midPanelR.add(addButtonR);
		midPanelR.add(deleteButtonR);
		midPanelR.add(editButtonR);
		midPanelR.add(searchButtonR);
		midPanelR.add(resetButtonR);
		
		midPanelRS.add(addButtonRS);
		midPanelRS.add(deleteButtonRS);
		midPanelRS.add(editButtonRS);
		midPanelRS.add(searchComboRS);
		midPanelRS.add(searchButtonRS);
		midPanelRS.add(resetButtonRS);
		
		
		addButtonW.addActionListener(new AddActionWater());
		addButtonR.addActionListener(new AddActionRegion());
		addButtonRS.addActionListener(new AddActionResponsible());
		
		deleteButtonW.addActionListener(new DeleteWater());
		deleteButtonR.addActionListener(new DeleteRegion());
		deleteButtonRS.addActionListener(new DeleteResponsible());
		
		
		DBHelper.fillCombo(searchComboW, "name", "water");
		searchButtonW.addActionListener(new SearchActionWater());
		resetButtonW.addActionListener(new ResetActionWater());
	    editButtonW.addActionListener(new EditActionWater());
		
		
		DBHelper.fillComboRegion(searchComboR1);
		searchButtonR.addActionListener(new SearchActionRegion());
		resetButtonR.addActionListener(new ResetActionRegion());
		DBHelper.fillCombo(searchComboR2, "name", "water");
	    editButtonR.addActionListener(new EditActionRegion());
	    
		DBHelper.fillComboRegion(searchComboRS);
		searchButtonRS.addActionListener(new SearchActionResponsible());
		resetButtonRS.addActionListener(new ResetActionResponsible());
	    editButtonRS.addActionListener(new EditActionResponsible());
	    
	    searchButtonI.addActionListener(new SearchActionInfo());

		
		
		
		
		
		

		
		
		

		downPanelW.add(scrollerW);
		scrollerW.setPreferredSize(new Dimension(600, 200));
		tableW.setModel(DBHelper.getAllData("water"));
		tableW.addMouseListener(new TableListenerW());
	
		downPanelR.add(scrollerR);
		scrollerR.setPreferredSize(new Dimension(600, 200));
		tableR.setModel(DBHelper.getAllDataRegion());
		tableR.addMouseListener(new TableListenerR());
	
		downPanelRS.add(scrollerRS);
		scrollerRS.setPreferredSize(new Dimension(600, 200));
		tableRS.setModel(DBHelper.getAllData("responsible"));
		tableRS.addMouseListener(new TableListenerRS());
		
		downPanelI.add(scrollerI);
		scrollerI.setPreferredSize(new Dimension(600, 200));
		tableI.setModel(DBHelper.getAllDataInfo());


		


		
		
		
		waterPanel.setLayout(new GridLayout(3, 1));
		waterPanel.setSize(700, 800);
		waterPanel.add(upPanelW);
		waterPanel.add(midPanelW);
		waterPanel.add(downPanelW);
	
		regionPanel.setLayout(new GridLayout(3, 1));
		regionPanel.setSize(700, 800);
		regionPanel.add(upPanelR);
		regionPanel.add(midPanelR);
		regionPanel.add(downPanelR);
		
		responsiblePanel.setLayout(new GridLayout(3, 1));
		responsiblePanel.setSize(700, 800);
		responsiblePanel.add(upPanelRS);
		responsiblePanel.add(midPanelRS);
		responsiblePanel.add(downPanelRS);
		
		infoPanel.setLayout(new GridLayout(3, 1));
		infoPanel.setSize(700, 800);
		infoPanel.add(upPanelI);
		infoPanel.add(downPanelI);
		
		
	
		
		
		
		this.setVisible(true);
	}


	public void clearFormW() {
		waterNameTF.setText("");
		waterAreaTF.setText("");
		waterDepthTF.setText("");
	}

	public void clearFormR() {
		regionNameTF.setText("");
		regionAreaTF.setText("");
		regionPopulationTF.setText("");

	}

	public void clearFormRS() {
		responsibleFnameTF.setText("");
		responsibleLnameTF.setText("");
		responsibleAgeTF.setText("");
		responsibleCommentTF.setText("");

	}
	
    
	class DeleteWater implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBHelper.getConnection();
			String sql = "delete from water where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				tableW.setModel(DBHelper.getAllData("water"));
				DBHelper.fillCombo(searchComboW, "name", "water");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	class DeleteRegion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBHelper.getConnection();
			String sql = "delete from region where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				tableR.setModel(DBHelper.getAllDataRegion());
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	
	class DeleteResponsible implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBHelper.getConnection();
			String sql = "delete from responsible where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				tableRS.setModel(DBHelper.getAllData("responsible"));
				id = -1;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
    
    
class AddActionWater implements ActionListener{
  	 @Override
  	 public void actionPerformed(ActionEvent arg0) {
  		 String name = waterNameTF.getText();
  		 int area = Integer.parseInt(waterAreaTF.getText());
  		 int depth = Integer.parseInt(waterDepthTF.getText());
  		 conn = DBHelper.getConnection();
  		try {
			state = conn.prepareStatement("insert into water values(null,?,?,?);");
			state.setString(1, name);
			state.setInt(2, area);
			state.setInt(3, depth);
  		
  			
  			state.execute();
  			tableW.setModel(DBHelper.getAllData("water"));
  			DBHelper.fillCombo(searchComboW, "name", "water");

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
  		 clearFormW();
  	 }
  	 
   }



	class AddActionResponsible implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String fname = responsibleFnameTF.getText();
			String lname = responsibleLnameTF.getText();
			int age = Integer.parseInt(responsibleAgeTF.getText());
			String comment = responsibleCommentTF.getText();
			conn = DBHelper.getConnection();
			try {

				state = conn.prepareStatement("insert into responsible values(null,?,?,?,?);");
				state.setString(1, fname);
				state.setString(2, lname);
				state.setInt(3, age);
				state.setString(4, comment);

				state.execute();
				tableRS.setModel(DBHelper.getAllData("responsible"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clearFormRS();
		}

	}

	class AddActionRegion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String item = searchComboR2.getSelectedItem().toString();
			String[] content = item.split(" ");
			int waterId = Integer.parseInt(content[0]);
			String responsible = searchComboR1.getSelectedItem().toString();
			String[] responsibleContent = responsible.split(" ");
			int responsibleId = Integer.parseInt(responsibleContent[0]);
			String name = regionNameTF.getText();
			int area = Integer.parseInt(regionAreaTF.getText());
			int population = Integer.parseInt(regionPopulationTF.getText());
			conn = DBHelper.getConnection();
			try {
				
				state = conn.prepareStatement("insert into region values(null,?,?,?,?,?);");
				state.setString(1, name);
				state.setInt(2, area);
				state.setInt(3, population);
				state.setInt(4, responsibleId);
				state.setInt(5, waterId);
				state.execute();
				tableR.setModel(DBHelper.getAllDataRegion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clearFormR();
		}

	} 
	
	class SearchActionWater implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String item = searchComboW.getSelectedItem().toString();
            String [] content = item.split(" ");
            int personId = Integer.parseInt(content[0]);

            conn = DBHelper.getConnection();
            String sql = "select * from water where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, personId);
                result = state.executeQuery();
                tableW.setModel(new MyModel(result));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
	}
	
	class ResetActionWater implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "select * from water";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				tableW.setModel(DBHelper.getAllData("water"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class SearchActionRegion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String item = searchComboR1.getSelectedItem().toString();
            String [] content = item.split(" ");
            int personId = Integer.parseInt(content[0]);

            conn = DBHelper.getConnection();
            String sql = "select * from region where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, personId);
                result = state.executeQuery();
                tableW.setModel(new MyModel(result));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
	}
	
	class ResetActionRegion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "select * from region";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				tableR.setModel(DBHelper.getAllDataRegion());

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class EditActionWater implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "UPDATE water SET name = '" + waterNameTF.getText() + "', area = " + waterAreaTF.getText()
					+ ", depth = " + waterDepthTF.getText() + " WHERE ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				tableW.setModel(DBHelper.getAllData("water"));
				DBHelper.fillCombo(searchComboW, "name", "water");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class EditActionRegion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedItem = searchComboR1.getSelectedItem().toString();
			String[] items = selectedItem.split(" ");
			int itemIDRegion1 = Integer.parseInt(items[0]);
			String selectedItemRegion = searchComboR2.getSelectedItem().toString();
			String[] itemsRegion = selectedItemRegion.split(" ");
			int itemIDRegion2 = Integer.parseInt(itemsRegion[0]);
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "UPDATE region SET name = '" + regionNameTF.getText() + "', area = " + regionAreaTF.getText()
					+ ", population = " + regionPopulationTF.getText() + ", ID_RESPONSIBLE = " + itemIDRegion1 + ", ID_WATER = " + itemIDRegion2 +  " WHERE ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				tableR.setModel(DBHelper.getAllData("region"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
	class EditActionResponsible implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();
			String sql = "UPDATE responsible SET fname = '" + responsibleFnameTF.getText() + "', lname = '" + responsibleLnameTF.getText()
					+ "', age = " + responsibleAgeTF.getText() + ", comment = '" + responsibleCommentTF.getText() + "' WHERE ID=?;";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				id = -1;
				tableRS.setModel(DBHelper.getAllData("responsible"));
				DBHelper.fillComboRegion(searchComboRS);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class SearchActionResponsible implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String item = searchComboRS.getSelectedItem().toString();
            String [] content = item.split(" ");
            int personId = Integer.parseInt(content[0]);

            conn = DBHelper.getConnection();
            String sql = "select * from responsible where id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, personId);
                result = state.executeQuery();
                tableRS.setModel(new MyModel(result));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
	}
	
	class ResetActionResponsible implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			conn = DBHelper.getConnection();

			String sql = "select * from responsible";

			try {
				state = conn.prepareStatement(sql);
				state.execute();
				tableRS.setModel(DBHelper.getAllData("responsible"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class SearchActionInfo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String item = searchComboR2.getSelectedItem().toString();
			String[] content = item.split(" ");
			int waterId = Integer.parseInt(content[0]);
			String responsible = searchComboR1.getSelectedItem().toString();
			String[] responsibleContent = responsible.split(" ");
			int responsibleId = Integer.parseInt(responsibleContent[0]);
			String name = regionNameTF.getText();
			int area = Integer.parseInt(regionAreaTF.getText());
			int population = Integer.parseInt(regionPopulationTF.getText());
			conn = DBHelper.getConnection();
			try {
				
				state = conn.prepareStatement("insert into region values(null,?,?,?,?,?);");
				state.setString(1, name);
				state.setInt(2, area);
				state.setInt(3, population);
				state.setInt(4, responsibleId);
				state.setInt(5, waterId);
				state.execute();
				tableR.setModel(DBHelper.getAllDataRegion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clearFormR();
		}

	} 
	
	
	
	
	
	
	
	class TableListenerW implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableW.getSelectedRow();
			id = Integer.parseInt(tableW.getValueAt(row, 0).toString());

			if (e.getClickCount() == 2) {
				waterNameTF.setText(tableW.getValueAt(row, 1).toString());
				waterAreaTF.setText(tableW.getValueAt(row, 2).toString());
				waterDepthTF.setText(tableW.getValueAt(row, 3).toString());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		
		

	}

	class TableListenerR implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableR.getSelectedRow();
			id = Integer.parseInt(tableR.getValueAt(row, 0).toString());
			
			if (e.getClickCount() == 2) {
				regionNameTF.setText(tableR.getValueAt(row, 1).toString());
				regionAreaTF.setText(tableR.getValueAt(row, 2).toString());
				regionPopulationTF.setText(tableR.getValueAt(row, 3).toString());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class TableListenerRS implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableRS.getSelectedRow();
			id = Integer.parseInt(tableRS.getValueAt(row, 0).toString());
			
			if (e.getClickCount() == 2) {
				responsibleFnameTF.setText(tableRS.getValueAt(row, 1).toString());
				responsibleLnameTF.setText(tableRS.getValueAt(row, 2).toString());
				responsibleAgeTF.setText(tableRS.getValueAt(row, 3).toString());
				responsibleCommentTF.setText(tableRS.getValueAt(row, 4).toString());
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}