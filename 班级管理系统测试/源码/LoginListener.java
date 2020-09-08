import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
//监听事件
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;			//账号输入框对象
	private javax.swing.JPasswordField jp;		//密码输入框对象
	private new000 lg;							//传入登录窗口参数
	private javax.swing.JFrame login;			//定义一个窗体对象
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp,new000 login000) {
		this.login=login;//获取登录界面
		this.jt=jt;//获取登录界面中的账号输入框对象
		this.jp=jp;//获取登录界面中的密码输入框对象
		this.lg=login000;//获取传入登录窗口参数
	}
 
	public void actionPerformed(ActionEvent e) {
		//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
		int lingpai=0;												//令牌0-错误1-正确
		for(int i=0;i<lg.ALL_NUMBER;i++) {
			//System.out.println(lg.MAP[i][0]);
			//System.out.println(lg.MAP[i][1]);
			if(jt.getText()!=null&&jp.getText()!=null&&lg.MAP[i][1]!=null&&lg.MAP[i][0]!=null) {
				if(lg.MAP[i][0].equals(jt.getText())&&lg.MAP[i][1].equals(jp.getText())) {
					lingpai=1;
					break;
				}
			}
		}
		if(lingpai==0) {
			//若输入不匹配则：
			System.out.println("输入错误！！！");
		}else if(lingpai==1) {
			//若输入匹配则：则生成一个新的界面
			javax.swing.JFrame jf=new javax.swing.JFrame();
			jf.setTitle("登录后的用户界面");
			jf.setSize(340,500);//只对顶级容器有效
			jf.setDefaultCloseOperation(3);//窗体关闭时结束程序
			jf.setLocationRelativeTo(null);//居中
			jf.setResizable(false);
			jf.setVisible(true);
			
			// 通过我们获取的登录界面对象，用dispose方法关闭它
			login.dispose();
		}
		
		
		
		
	}
}
