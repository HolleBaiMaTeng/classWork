import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
 
//监听事件
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;			//账号输入框对象
	private javax.swing.JPasswordField jp;		//密码输入框对象
	private new000 lg;							//传入登录窗口参数
	private javax.swing.JFrame login;			//定义一个窗体对象
	private int lingpai1=0;						//令牌0-错误1-正确   用于查看本轮次输入是否正确（令牌一反应账号情况）
	private int lingpai2=0;						//令牌0-错误1-正确   用于查看本轮次输入是否正确（令牌二反应密码情况）
	
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp,new000 login000) {
		this.login=login;						//获取登录界面
		this.jt=jt;								//获取登录界面中的账号输入框对象
		this.jp=jp;								//获取登录界面中的密码输入框对象
		this.lg=login000;						//获取传入登录窗口参数
	}
 
	public void actionPerformed(ActionEvent e) {
		//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
		lingpai1=0;																					//重置本轮令牌1数据
		lingpai2=0;																					//重置本轮令牌2数据
		for(int i=0;i<lg.ALL_NUMBER;i++) {															//遍历MAP密码本
			//System.out.println(lg.MAP[i][0]);
			//System.out.println(lg.MAP[i][1]);
			if(jt.getText()!=null&&jp.getText()!=null&&lg.MAP[i][1]!=null&&lg.MAP[i][0]!=null) {	//验证非空
				//验证账号是否存在
				if(lg.MAP[i][0].equals(jt.getText())) {
					lingpai1=1;									//用令牌一记录账号情况
				}
				if(lingpai1==1) {								//输入账号存在，则验证密码
					if(lg.MAP[i][1].equals(jp.getText())) {		//验证密码
						lingpai2=1;								//若密码正确，更改令牌2
						break;
					}else {
						break;									//若密码不正确，直接跳出，令牌2值为0
					}
				}
			}
		}
		
		
		if(lingpai1==1&&lingpai2==1) {
			//若输入匹配则：则生成一个新的界面
			System.out.println("输入正确！！！");
			javax.swing.JFrame jf=new javax.swing.JFrame();
			jf.setTitle("登录后的用户界面");
			jf.setSize(800,600);				//只对顶级容器有效
			jf.setDefaultCloseOperation(3);		//窗体关闭时结束程序
			jf.setLocationRelativeTo(null);		//居中
			jf.setResizable(false);
			jf.setVisible(true);				//设置可见性
			
			// 通过我们获取的登录界面对象，用dispose方法关闭它
			login.dispose();
		}else {
			if(lingpai1==0) {
				//若lingpai1为0说明账号不存在
				System.out.println("输入账号不存在");
				
				javax.swing.JFrame jf=new javax.swing.JFrame();
				jf.setTitle("WRONING");
				jf.setSize(200,150);				//只对顶级容器有效
				jf.setDefaultCloseOperation(2);		//窗体关闭时结束对话框
				jf.setLocationRelativeTo(null);		//居中
				jf.setResizable(false);				
				jf.setVisible(true);				//设置可见性
				
				java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,0,0);
				jf.setLayout(fl);											//设置顶级容器的布局为流式布局
				
				//设置格式大小
				java.awt.Dimension dim2=new java.awt.Dimension(100, 80);		//标签的大小
				
				//添加“账号”标签
				JLabel labname=new JLabel();
				labname.setText("输入账号不存在");
				labname.setPreferredSize(dim2);
				jf.add(labname);
			}else {
				//若lingpai1为1，说明对应的密码错误
				System.out.println("密码输入错误");
				javax.swing.JFrame jf=new javax.swing.JFrame();
				jf.setTitle("WRONING");
				jf.setSize(200,150);				//只对顶级容器有效
				jf.setDefaultCloseOperation(2);		//窗体关闭时结束对话框
				jf.setLocationRelativeTo(null);		//居中
				jf.setResizable(false);				
				jf.setVisible(true);				//设置可见性
				
				
				java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,0,0);
				jf.setLayout(fl);											//设置顶级容器的布局为流式布局
				
				//设置格式大小
				java.awt.Dimension dim2=new java.awt.Dimension(100, 80);		//标签的大小
				
				//添加“账号”标签
				JLabel labname=new JLabel();
				labname.setText("密码输入错误");
				labname.setPreferredSize(dim2);
				jf.add(labname);
			}
		}
		
		
		
		
	}
}
