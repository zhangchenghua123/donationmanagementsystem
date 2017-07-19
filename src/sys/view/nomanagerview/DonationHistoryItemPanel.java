package sys.view.nomanagerview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import sys.GlobalVariables;
import sys.model.objects.Donation;
import sys.view.GetResourceClass;

public class DonationHistoryItemPanel extends JPanel {

	private JLabel donationTimeLabel;
	private JLabel doneeNameLabel;
	private JLabel amountLabel;
	private Donation donation;
	
	public DonationHistoryItemPanel(Donation donation){
		
		this.donation=donation;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);
		setPreferredSize(new Dimension(GetResourceClass.getRealSize(600), GetResourceClass.getRealSize(40)));
		setBorder(new MatteBorder(1, 0, 1, 0, new Color(238,238,238)));
		
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/mm/dd");
		donationTimeLabel=new JLabel("捐助时间:"+simpleDateFormat.format(donation.getTime()));
		donationTimeLabel.setBounds(GetResourceClass.getRealSize(10), GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		donationTimeLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(donationTimeLabel);
		
		doneeNameLabel=new JLabel("受助人:"+donation.getDoneeName(),JLabel.CENTER);
		doneeNameLabel.setBounds(GetResourceClass.getRealSize(220), GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(130), GetResourceClass.getRealSize(20));
		doneeNameLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		doneeNameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(doneeNameLabel);
		
		amountLabel=new JLabel("捐助金额:"+donation.getAmount()+"元");
		amountLabel.setBounds(GetResourceClass.getRealSize(380), GetResourceClass.getRealSize(10),
				GetResourceClass.getRealSize(200), GetResourceClass.getRealSize(20));
		amountLabel.setFont(new Font("黑体",Font.PLAIN,GetResourceClass.getRealSize(16)));
		add(amountLabel);
		
		doneeNameLabel.addMouseListener(new MouseListener() {
			
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
				doneeNameLabel.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				doneeNameLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).remove(1);
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).repaint();
				((Container)(GlobalVariables.frame.getContentPane().getComponent(1))).add(new DoneeDetailJPanel(DonationHistoryItemPanel.this.donation.getDoneeIdentity()),1);
			}
		});
		
	}
	
}
