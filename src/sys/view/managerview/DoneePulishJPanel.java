package sys.view.managerview;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.LineBorder;

import sys.GlobalVariables;
import sys.model.objects.AffairManager;
import sys.model.objects.Donee;
import sys.presenter.DoneePresenter;
import sys.view.DataVerifyTool;
import sys.view.GetResourceClass;
import sys.view.customview.ImagePanel;
/**
 * 受助者信息发布panel
 * @author Berry
 *
 */
public class DoneePulishJPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel identityLabel;
	private JTextField identityInput;
	private JLabel nameLabel;
	private JTextField nameInput;//输入姓名
	private JLabel genderJLabel;
	private ButtonGroup genderGroup;//性别单选按钮组
	private JRadioButton manButton;
	private JRadioButton famaleButton;
	private JLabel phoneLabel;
	private JTextField phoneField;//输入电话
	private JLabel addressLabel;
	private JTextField addressInput;//输入地址
	private JLabel bankLabel;
	private JTextField bankInput;//输入银行卡号
	private JLabel expectedAmountLabel;
	private JTextField expectedAmountInput;//输入期望金额
	private JLabel experieceLabel;
	private JTextArea experienceTextArea;//输入经历
	private JScrollPane experienceScrollPane;//经历文本域太长后出现的滚动条
	
	private JLabel infoLabel;//提示信息
	private JLabel submitLabel;//提交按钮
	private JLabel resetLabel;//重置按钮
	
	private ImagePanel picyulanView;//图片区域
	
	
	private String filePath="";  //保存选择的图片
	public DoneePulishJPanel(){
		
		setBounds(GetResourceClass.getRealSize(270), GetResourceClass.getRealSize(0),
				GetResourceClass.getRealSize(930),
				GetResourceClass.getRealSize(650));  //设置jpanel区域
		setLayout(null);      //绝对布局
		setOpaque(true);  //不透明
		setBackground(Color.white);  //背景白
		setForeground(Color.white);  //前景色白
		
		identityLabel=new JLabel("身份证号:");
		identityLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(70),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		identityLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(identityLabel);
		
		identityInput=new JTextField();
		identityInput.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(70),
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		identityInput.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(identityInput);
		
		nameLabel=new JLabel("姓    名:");
		nameLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(110),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		nameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(nameLabel);
		
		nameInput=new JTextField(JTextField.CENTER);
		nameInput.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(110), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		nameInput.setFont(new Font("黑体",Font.PLAIN,20));
		add(nameInput);
		
		genderJLabel=new JLabel("性    别:");
		genderJLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		genderJLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(genderJLabel);
		
		manButton=new JRadioButton("男");
		manButton.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(75), GetResourceClass.getRealSize(25));
		manButton.setOpaque(false);           //设置透明
		manButton.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		manButton.setSelected(true);           //默认选中
		add(manButton);
		
		famaleButton=new JRadioButton("女");
		famaleButton.setBounds(GetResourceClass.getRealSize(300), GetResourceClass.getRealSize(150),
				GetResourceClass.getRealSize(75), GetResourceClass.getRealSize(25));
		famaleButton.setOpaque(false);
		famaleButton.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(famaleButton);
		
		genderGroup=new ButtonGroup(); //单选按钮组，只能选中一个
		genderGroup.add(manButton);
		genderGroup.add(famaleButton);
		
		picyulanView=new ImagePanel(new ImageIcon(GetResourceClass.class.getResource("image/doneepic.png")));
    	picyulanView.setBounds(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(90),
    			GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(240));
    	add(picyulanView);
   
    	/**
    	 * 设置可拖拽图片，网上找的，不懂
    	 */
    	picyulanView.setTransferHandler(new TransferHandler()
        {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    Object o = t.getTransferData(DataFlavor.javaFileListFlavor);

                    String filepath = o.toString();
                    if (filepath.startsWith("[")) {
                        filepath = filepath.substring(1);
                    }
                    if (filepath.endsWith("]")) {
                        filepath = filepath.substring(0, filepath.length() - 1);
                    }
                    System.out.println(filepath);
                    //拖拽的不是图片
                    if(!filepath.endsWith(".jpg")&&!filepath.endsWith(".png")&&!filepath.endsWith(".bmp"))
                    	return false;
                    DoneePulishJPanel.this.filePath=filepath;  //保存路径
                    picyulanView.setImageIcon(new ImageIcon(filepath));  ///绘制界面
                    picyulanView.repaint();
                    return true;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
            @Override
            public boolean canImport(JComponent comp, DataFlavor[] flavors) {
                for (int i = 0; i < flavors.length; i++) {
                    if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {
                        return true;
                    }
                }
                return false;
            }
        });
		
		
		
		phoneLabel=new JLabel("联系电话:");
		phoneLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(190),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		phoneLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(phoneLabel);
		
		phoneField=new JTextField();
		phoneField.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(190),
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		phoneField.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(phoneField);
		
		addressLabel=new JLabel("家庭地址:");
		addressLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(230),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		addressLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(addressLabel);
		
		addressInput=new JTextField();
		addressInput.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(230),
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		addressInput.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(addressInput);
		
		bankLabel=new JLabel("银行卡号:");
		bankLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(270),
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		bankLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(bankLabel);
		
		bankInput=new JTextField();
		bankInput.setBounds(GetResourceClass.getRealSize(200),GetResourceClass.getRealSize(270), 
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		bankInput.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(bankInput);
		
		expectedAmountLabel=new JLabel("期望额(元):");
		expectedAmountLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(310), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		expectedAmountLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(expectedAmountLabel);
		
		expectedAmountInput=new JTextField();
		expectedAmountInput.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(310),
				GetResourceClass.getRealSize(250), GetResourceClass.getRealSize(25));
		expectedAmountInput.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		add(expectedAmountInput);
		
		experieceLabel=new JLabel("主要经历:");
		experieceLabel.setBounds(GetResourceClass.getRealSize(50), GetResourceClass.getRealSize(350), 
				GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
		experieceLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(experieceLabel);
		
		experienceTextArea=new JTextArea();
		experienceTextArea.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(350),
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		experienceTextArea.setLineWrap(true);   //自动换行
		experienceTextArea.setBorder(new LineBorder(new Color(160,160,160)));
		experienceTextArea.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		experienceScrollPane=new JScrollPane(experienceTextArea);
		experienceScrollPane.setBounds(GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(350),
				GetResourceClass.getRealSize(500), GetResourceClass.getRealSize(100));
		add(experienceScrollPane);
		
		submitLabel=new JLabel("发布受助信息",JLabel.CENTER);
		submitLabel.setBounds(GetResourceClass.getRealSize(200),GetResourceClass.getRealSize(490) ,
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
		submitLabel.setOpaque(true);
		submitLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		submitLabel.setBackground(new Color(102,205,0));
		submitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //移上手型
		add(submitLabel);
		
		infoLabel=new JLabel();
		infoLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(infoLabel);
		/**
		 * 提交按钮的鼠标事件
		 */
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
				infoLabel.setForeground(Color.red);
				if(identityInput.getText().equals("")){
					infoLabel.setText("请输入身份证号");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(70), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(nameInput.getText().equals("")){
					infoLabel.setText("请输入姓名");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(110), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(filePath.equals("")){
					infoLabel.setText("请选择图片");
					infoLabel.setBounds(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(330), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(phoneField.getText().equals("")){
					infoLabel.setText("请输入电话");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(190), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(addressInput.getText().equals("")){
					infoLabel.setText("请输入地址");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(230), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(bankInput.getText().equals("")){
					infoLabel.setText("请输入卡号");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(270), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(expectedAmountInput.getText().equals("")){
					infoLabel.setText("请输入金额");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(310), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(experienceTextArea.getText().equals("")){
					infoLabel.setText("请输入经历");
					infoLabel.setBounds(GetResourceClass.getRealSize(705), GetResourceClass.getRealSize(350), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(!new DataVerifyTool().verifyBirthdayCode(identityInput.getText())){
					infoLabel.setText("身份证不存在");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(70), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(!new DataVerifyTool().verifyPhone(phoneField.getText())){
					infoLabel.setText("手机号不存在");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(190),
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				
				else if(!new DataVerifyTool().verifyBank(bankInput.getText())){
					infoLabel.setText("卡号不存在");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(270), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else if(!new DataVerifyTool().verifyMoney(expectedAmountInput.getText())){
					infoLabel.setText("请输入数字");
					infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(310), 
							GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
					return;
				}
				else {
					System.out.println(phoneField.getText());
					switch (DoneePresenter.validate(identityInput.getText(), phoneField.getText(), bankInput.getText())) {
					case DoneePresenter.IDENTITY_EXISTED:
						infoLabel.setText("已存在");
						infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(70), 
								GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
						infoLabel.repaint();
						return;
					case DoneePresenter.PHONE_EXISTED:
						infoLabel.setText("已存在");
						System.out.println("dianhuacunzai");
						infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(190), 
								GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
						infoLabel.repaint();
						return;
					case DoneePresenter.CARD_EXISTED:
						infoLabel.setText("已存在");
						infoLabel.setBounds(GetResourceClass.getRealSize(455), GetResourceClass.getRealSize(270), 
								GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
						infoLabel.repaint();
						return;
					default://-1,验证通过
						break;
					}
				}
				//创建一个donee对象
				Donee donee=new Donee();
				donee.setIdentity(identityInput.getText());
				donee.setName(nameInput.getText());
				donee.setGender(manButton.isSelected()?"男":"女");
				donee.setFilePath(filePath);
				donee.setPhone(phoneField.getText());
				donee.setAddress(addressInput.getText());
				donee.setBank(bankInput.getText());
				AffairManager aManager=(AffairManager)GlobalVariables.userInfo.get("user");
				
				donee.setTaskID(aManager.getTaskId());
				donee.setReleaseTime(new Date(new java.util.Date().getTime()));
				donee.setExpectedamount(Float.parseFloat(expectedAmountInput.getText()));
				donee.setExperience(experienceTextArea.getText());
				//插入数据库
				if(DoneePresenter.insert(donee)){
					infoLabel.setText("发布成功！");
					infoLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.setForeground(Color.green);
					infoLabel.repaint();
				}
				else{
					infoLabel.setText("发布失败！");
					infoLabel.setBounds(GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(30), GetResourceClass.getRealSize(150), GetResourceClass.getRealSize(20));
					infoLabel.repaint();
				}
				
			}
		});
		
		resetLabel=new JLabel("重置信息",JLabel.CENTER);
		resetLabel.setBounds(GetResourceClass.getRealSize(380),GetResourceClass.getRealSize(490) , 
				GetResourceClass.getRealSize(160), GetResourceClass.getRealSize(40));
		resetLabel.setOpaque(true);
		resetLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(20)));
		resetLabel.setBackground(new Color(102,205,0));
		resetLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		resetLabel.addMouseListener(new MouseListener() {
			
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
				infoLabel.setText("");
				identityInput.setText("");
				nameInput.setText("");
				manButton.setSelected(true);
				filePath="";;
				phoneField.setText("");
				addressInput.setText("");
				bankInput.setText("");
				expectedAmountInput.setText("");
				experienceTextArea.setText("");
				picyulanView.setImageIcon(new ImageIcon(GetResourceClass.class.getResource("image/doneepic.png")));
				picyulanView.repaint();
			}
		});
		add(resetLabel);
		
	}
	
	
}

