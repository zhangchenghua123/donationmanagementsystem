package sys.model.clouddatabase.daoimpl;

import java.util.ArrayList;
import sys.model.objects.Donation;

public class Test {

	public void test(){
		String donorAccount="4";//定义捐助者账号
		Object[] objects=new Object[]{donorAccount};//定义数组并赋值
		ArrayList<Donation> list=new DonationDaoImpl().getDonationsByDonor(objects);
		for(int i=0;i<list.size();i++){
			System.out.println("捐助时间："+list.get(i).getTime());
			System.out.println("捐助人账号："+list.get(i).getDonorAccount());
			System.out.println("捐助人姓名："+list.get(i).getDonorName());
			System.out.println("受助人身份证："+list.get(i).getDoneeIdentity());
			System.out.println("受助人姓名："+list.get(i).getDoneeName());
			System.out.println("捐助钱数："+list.get(i).getAmount());
			System.out.println("是否打款："+list.get(i).getHasPaid());
		}
	}
}
