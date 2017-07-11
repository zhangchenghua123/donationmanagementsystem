package sys.view.manager;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import sys.view.customView.TextInput;

public class DoneePulishJPanel extends JPanel {

	private JLabel identityLabel;
	private TextInput identityInput;
	private JLabel nameLabel;
	private TextInput nameInput;
	private JLabel genderJLabel;
	private ButtonGroup genderGroup;
	private JRadioButton manButton;
	private JRadioButton famaleButton;
	private JLabel pictureLabel;
	private JLabel picselectedLabel;
	private JButton chooseFileButton;
	private JLabel addressLabel;
	private TextInput addressInput;
	private JLabel bankLabel;
	private TextInput bankInput;
	private JLabel expectedAmountLabel;
	private TextInput expectedAmountInput;
	private JLabel experieceLabel;
	private JTextArea experienceTextArea;
	
	public DoneePulishJPanel(){
		
		setBounds(300, 80, 900, 720);
		setLayout(null);
		
		identityLabel=new JLabel("身份证号:");
		identityLabel.setBounds(50, 120, 150, 20);
		identityLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(identityLabel);
		
		identityInput=new TextInput();
		identityInput.setBounds(200, 120, 250, 25);
		identityInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(identityInput);
		
		nameLabel=new JLabel("姓    名:");
		nameLabel.setBounds(50, 160, 150, 20);
		nameLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(nameLabel);
		
		nameInput=new TextInput();
		nameInput.setBounds(200, 160, 250, 25);
		nameInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(nameInput);
		
		genderJLabel=new JLabel("性    别:");
		genderJLabel.setBounds(50, 200, 150, 20);
		genderJLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(genderJLabel);
		
		manButton=new JRadioButton("男");
		manButton.setBounds(200, 200, 75, 25);
		manButton.setFont(new Font("黑体",Font.PLAIN,20));
		manButton.setSelected(true);
		add(manButton);
		
		famaleButton=new JRadioButton("女");
		famaleButton.setBounds(300, 200, 75, 25);
		famaleButton.setFont(new Font("黑体",Font.PLAIN,20));
		add(famaleButton);
		
		genderGroup=new ButtonGroup();
		genderGroup.add(manButton);
		genderGroup.add(famaleButton);
		
		pictureLabel=new JLabel("本人照片:");
		pictureLabel.setBounds(50, 240, 150, 20);
		pictureLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(pictureLabel);
		
		picselectedLabel=new JLabel("未选择");
		picselectedLabel.setBounds(200, 240, 100, 25);
		picselectedLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(picselectedLabel);
		
		chooseFileButton=new JButton("打开文件");
		chooseFileButton.setBounds(350, 240, 100, 25);
		chooseFileButton.setFont(new Font("黑体",Font.PLAIN,16));
		add(chooseFileButton);
		
		addressLabel=new JLabel("家庭地址:");
		addressLabel.setBounds(50, 280, 150, 20);
		addressLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(addressLabel);
		
		addressInput=new TextInput();
		addressInput.setBounds(200, 280, 250, 25);
		addressInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(addressInput);
		
		bankLabel=new JLabel("银行卡号:");
		bankLabel.setBounds(50, 320, 150, 20);
		bankLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(bankLabel);
		
		bankInput=new TextInput();
		bankInput.setBounds(200, 320, 250, 25);
		bankInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(bankInput);
		
		expectedAmountLabel=new JLabel("期望额(元):");
		expectedAmountLabel.setBounds(50, 360, 150, 20);
		expectedAmountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(expectedAmountLabel);
		
		expectedAmountInput=new TextInput();
		expectedAmountInput.setBounds(200, 360, 250, 25);
		expectedAmountInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(expectedAmountInput);
		
		experieceLabel=new JLabel("主要经历:");
		experieceLabel.setBounds(50, 400, 150, 20);
		experieceLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(experieceLabel);
		
		experienceTextArea=new JTextArea();
		experienceTextArea.setBounds(200, 400, 500, 100);
		experienceTextArea.setLineWrap(true);
		experienceTextArea.setFont(new Font("黑体",Font.PLAIN,16));
		add(experienceTextArea);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

