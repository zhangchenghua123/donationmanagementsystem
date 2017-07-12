package sys.view.manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sys.model.objects.Donee;
import sys.presenter.DoneePresenter;
import sys.view.GetResourceClass;
import sys.view.customView.TextInput;

public class DoneePulishJPanel extends JPanel {

	private JLabel identityLabel;
	private JTextField identityInput;
	private JLabel nameLabel;
	private JTextField nameInput;
	private JLabel genderJLabel;
	private ButtonGroup genderGroup;
	private JRadioButton manButton;
	private JRadioButton famaleButton;
	private JLabel pictureLabel;
	private JLabel picselectedLabel;
	private JButton chooseFileButton;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JLabel addressLabel;
	private JTextField addressInput;
	private JLabel bankLabel;
	private JTextField bankInput;
	private JLabel expectedAmountLabel;
	private JTextField expectedAmountInput;
	private JLabel experieceLabel;
	private JTextArea experienceTextArea;
	private JLabel infoLabel;
	private JLabel submitLabel;
	private JLabel resetLabel;
	public DoneePulishJPanel(){
		
		setBounds(270, GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));// 不可修改
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setForeground(Color.white);
		
		identityLabel=new JLabel("身份证号:");
		identityLabel.setBounds(50, 70, 150, 20);
		identityLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(identityLabel);
		
		identityInput=new JTextField();
		identityInput.setBounds(200, 70, 250, 25);
		identityInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(identityInput);
		
		nameLabel=new JLabel("姓    名:");
		nameLabel.setBounds(50, 110, 150, 20);
		nameLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(nameLabel);
		
		nameInput=new JTextField(JTextField.CENTER);
		nameInput.setBounds(200, 110, 250, 25);
		nameInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(nameInput);
		
		genderJLabel=new JLabel("性    别:");
		genderJLabel.setBounds(50, 150, 150, 20);
		genderJLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(genderJLabel);
		
		manButton=new JRadioButton("男");
		manButton.setBounds(200, 150, 75, 25);
		manButton.setOpaque(false);
		manButton.setFont(new Font("黑体",Font.PLAIN,20));
		manButton.setSelected(true);
		add(manButton);
		
		famaleButton=new JRadioButton("女");
		famaleButton.setBounds(300, 150, 75, 25);
		famaleButton.setOpaque(false);
		famaleButton.setFont(new Font("黑体",Font.PLAIN,20));
		add(famaleButton);
		
		genderGroup=new ButtonGroup();
		genderGroup.add(manButton);
		genderGroup.add(famaleButton);
		
		pictureLabel=new JLabel("本人照片:");
		pictureLabel.setBounds(50, 190, 150, 20);
		pictureLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(pictureLabel);
		
		picselectedLabel=new JLabel("未选择");
		picselectedLabel.setBounds(200, 190, 100, 25);
		picselectedLabel.setFont(new Font("黑体",Font.PLAIN,20));
		add(picselectedLabel);
		
		chooseFileButton=new JButton("打开文件");
		chooseFileButton.setBounds(350, 190, 100, 25);
		chooseFileButton.setFont(new Font("黑体",Font.PLAIN,16));
		add(chooseFileButton);
		
		phoneLabel=new JLabel("联系电话:");
		phoneLabel.setBounds(50, 230, 150, 20);
		phoneLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(phoneLabel);
		
		phoneField=new JTextField();
		phoneField.setBounds(200, 230, 250, 25);
		phoneField.setFont(new Font("黑体",Font.PLAIN,20));
		add(phoneField);
		
		addressLabel=new JLabel("家庭地址:");
		addressLabel.setBounds(50, 270, 150, 20);
		addressLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(addressLabel);
		
		addressInput=new JTextField();
		addressInput.setBounds(200, 270, 250, 25);
		addressInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(addressInput);
		
		bankLabel=new JLabel("银行卡号:");
		bankLabel.setBounds(50, 310, 150, 20);
		bankLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(bankLabel);
		
		bankInput=new JTextField();
		bankInput.setBounds(200, 310, 250, 25);
		bankInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(bankInput);
		
		expectedAmountLabel=new JLabel("期望额(元):");
		expectedAmountLabel.setBounds(50, 340, 150, 20);
		expectedAmountLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(expectedAmountLabel);
		
		expectedAmountInput=new JTextField();
		expectedAmountInput.setBounds(200, 340, 250, 25);
		expectedAmountInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(expectedAmountInput);
		
		experieceLabel=new JLabel("主要经历:");
		experieceLabel.setBounds(50, 390, 150, 20);
		experieceLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(experieceLabel);
		
		experienceTextArea=new JTextArea();
		experienceTextArea.setBounds(200, 390, 500, 100);
		experienceTextArea.setLineWrap(true);
		experienceTextArea.setBorder(new LineBorder(new Color(160,160,160)));
		experienceTextArea.setFont(new Font("黑体",Font.PLAIN,16));
		add(experienceTextArea);
		
		submitLabel=new JLabel("发布受助信息",JLabel.CENTER);
		submitLabel.setBounds(200,530 , 160, 40);
		submitLabel.setOpaque(true);
		submitLabel.setFont(new Font("黑体",Font.PLAIN,20));
		submitLabel.setBackground(new Color(102,205,0));
		submitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(submitLabel);
		
		infoLabel=new JLabel();
		infoLabel.setFont(new Font("黑体",Font.PLAIN,16));
		add(infoLabel);
		
		submitLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(identityInput.getText().equals("")){
					infoLabel.setText("请输入身份证号");
					infoLabel.setBounds(455, 70, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(nameInput.getText().equals("")){
					infoLabel.setText("请输入姓名");
					infoLabel.setBounds(455, 110, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(picselectedLabel.getText().equals("未选择")){
					infoLabel.setText("请选择图片");
					infoLabel.setBounds(455, 190, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(phoneField.getText().equals("")){
					infoLabel.setText("请输入电话");
					infoLabel.setBounds(455, 230, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(addressInput.getText().equals("")){
					infoLabel.setText("请输入地址");
					infoLabel.setBounds(455, 270, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(bankInput.getText().equals("")){
					infoLabel.setText("请输入卡号");
					infoLabel.setBounds(455, 310, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(expectedAmountInput.getText().equals("")){
					infoLabel.setText("请输入金额");
					infoLabel.setBounds(455, 350, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(experienceTextArea.getText().equals("")){
					infoLabel.setText("请输入经历");
					infoLabel.setBounds(705, 390, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(!verifyIdentity(identityInput.getText())){
					infoLabel.setText("格式不正确");
					infoLabel.setBounds(455, 70, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(!verifyBank(bankInput.getText())){
					infoLabel.setText("格式不对");
					infoLabel.setBounds(455, 310, 150, 20);
					infoLabel.repaint();
					return;
				}
				else if(!verifyMoney(expectedAmountInput.getText())){
					infoLabel.setText("格式不对");
					infoLabel.setBounds(455, 350, 150, 20);
					infoLabel.repaint();
					return;
				}
				else {
					switch (DoneePresenter.validate(identityInput.getText(), phoneField.getText(), bankInput.getText())) {
					case DoneePresenter.IDENTITY_EXISTED:
						infoLabel.setText("已存在");
						infoLabel.setBounds(455, 70, 150, 20);
						infoLabel.repaint();
						return;
					case DoneePresenter.PHONE_EXISTED:
						infoLabel.setText("已存在");
						infoLabel.setBounds(455, 230, 150, 20);
						infoLabel.repaint();
						return;
					case DoneePresenter.CARD_EXISTED:
						infoLabel.setText("已存在");
						infoLabel.setBounds(455, 310, 150, 20);
						infoLabel.repaint();
						return;
					default://-1,验证通过
						break;
					}
				}
				Donee donee=new Donee();
				donee.setIdentity(identityInput.getText());
				donee.setName(nameInput.getText());
				
				
				
				
			}
		});
		
		resetLabel=new JLabel("重置信息",JLabel.CENTER);
		resetLabel.setBounds(380,530 , 160, 40);
		resetLabel.setOpaque(true);
		resetLabel.setFont(new Font("黑体",Font.PLAIN,20));
		resetLabel.setBackground(new Color(102,205,0));
		resetLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(resetLabel);
		
	}
	/**
	 * 验证一个字符串是不是身份证号
	 * 只需18位数字，中间的出生日期是大于1970年1月1日，小于今天的某一天
	 * @param identity
	 * @return
	 */
	public boolean verifyIdentity(String identity){
		
		return true;
	}
	/**
	 * 验证一个字符串是不是大于零的金额
	 */
	public boolean verifyMoney(String text){
		
		return true;
	}
	/**
	 * 检测一个字符串是不是纯数字，只要是纯数字就是正确的银行卡号
	 */
	public boolean verifyBank(String text){
		return true;
	}
	/**
	 * 检测一个字符串是不是手机号
	 */
	public boolean verifyPhone(String text){
		return true;
	}
}

