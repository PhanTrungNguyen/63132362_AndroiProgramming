package ntu63132362.Cau1_AppBMI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Cau1_AppBMI_ManHinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField heightValue;
	private JTextField weightValue;
	private JTextField bmiValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cau1_AppBMI_ManHinh frame = new Cau1_AppBMI_ManHinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cau1_AppBMI_ManHinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(0, 0, 401, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BODY MASS INDEX");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 34));
		lblNewLabel.setBounds(41, 17, 322, 45);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 103, 401, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Height (m):");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(39, 31, 78, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Weight (kg):");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2.setBounds(39, 70, 89, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BMI =");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel_3.setBounds(19, 92, 139, 50);
		panel.add(lblNewLabel_3);
		
		heightValue = new JTextField();
		heightValue.setBounds(219, 26, 130, 26);
		panel.add(heightValue);
		heightValue.setColumns(10);
		
		weightValue = new JTextField();
		weightValue.setBounds(219, 65, 130, 26);
		panel.add(weightValue);
		weightValue.setColumns(10);
		
		bmiValue = new JTextField();
		bmiValue.setBounds(219, 98, 130, 44);
		panel.add(bmiValue);
		bmiValue.setColumns(10);
		
		JLabel status = new JLabel("");
		status.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setBounds(204, 143, 145, 26);
		panel.add(status);
		
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double iHeight = Double.parseDouble(heightValue.getText());
				double iWeight = Double.parseDouble(weightValue.getText());
				double iBMI = iWeight / (iHeight * iHeight);
				
				String cal_BMI = String.format("%.2f", iBMI);
				bmiValue.setText(cal_BMI);
				if (iBMI <= 18.5) 
				{
					bmiValue.setOpaque(true);
					bmiValue.setBackground(Color.blue);
					status.setForeground(Color.blue);
					status.setText("UnderWeight");
				}else if(iBMI <= 24.9) 
				{
					bmiValue.setOpaque(true);
					bmiValue.setBackground(Color.green);
					status.setForeground(Color.green);
					status.setText("NormalWeight");
				}else if(iBMI <= 29.9) 
				{
					bmiValue.setOpaque(true);
					bmiValue.setBackground(Color.yellow);
					status.setForeground(Color.yellow);
					status.setText("OverWeight");
				}else if(iBMI >= 30) 
				{
					bmiValue.setOpaque(true);
					bmiValue.setBackground(Color.red);
					status.setForeground(Color.red);
					status.setText("Obese");
				}
			}
		});
		calculate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		calculate.setBounds(29, 178, 117, 29);
		panel.add(calculate);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heightValue.setText(null);
				weightValue.setText(null);
				bmiValue.setText(null);
				
			}
		});
		clear.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		clear.setBounds(158, 178, 117, 29);
		panel.add(clear);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		exit.setBounds(274, 178, 117, 29);
		panel.add(exit);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(0, 315, 401, 260);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("<18.5");
		lblNewLabel_4.setBounds(39, 21, 83, 16);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("18.5 to 24.9");
		lblNewLabel_5.setBounds(39, 49, 83, 16);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("25 to 29.9");
		lblNewLabel_6.setBounds(39, 77, 83, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(">30");
		lblNewLabel_7.setBounds(39, 103, 83, 16);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("UnderWeight");
		lblNewLabel_8.setBounds(251, 21, 83, 16);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("NormalWeight");
		lblNewLabel_9.setBounds(251, 49, 103, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("OverWeight");
		lblNewLabel_10.setBounds(251, 77, 103, 16);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Obese");
		lblNewLabel_11.setBounds(251, 103, 83, 16);
		panel_2.add(lblNewLabel_11);
	}
}
