import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
 

public class new000 {
 
	
	public static final int ALL_NUMBER=30;
	
	public String[][] MAP=new String[ALL_NUMBER][2];
	
	public static void main(String[] args) {
		
		
		
		new000 login = new new000();
		login.initUI();
 
	}
 
	
	 
	public void initUI() {
		
		//读取数据并检查是否跳出异常
		try {
			readData("important.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("登录界面");
		jf.setSize(340,500);//只对顶级容器有效
		jf.setDefaultCloseOperation(3);//窗体关闭时结束程序
		jf.setLocationRelativeTo(null);//居中
		jf.setResizable(false);
 
		//选择布局类型，定义流式布局的对象,并且设置每个组件之间相隔5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,5,5);
		jf.setLayout(fl);//设置顶级容器的布局为流式布局
		
		//设置格式大小
		java.awt.Dimension dim1=new java.awt.Dimension(340,300);//图片大小
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//标签的大小
		java.awt.Dimension dim3=new java.awt.Dimension(250, 30);//输入框的大小		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//按钮的大小	
		
		//添加组件
		//添加图片，先要把图片加载到内存中。利用IamgeIcon类把图片加载到内存
		javax.swing.ImageIcon icon=new javax.swing.ImageIcon("bd4632598c2408.jpg");
		JLabel labpic=new JLabel(icon);//不可以直接把图片加到顶级容器中，需要先将其设置为标签
		labpic.setPreferredSize(dim1);
		jf.add(labpic);//再将标签加到顶级容器中
		
		//添加“账号”标签
		JLabel labname=new JLabel();
		labname.setText("账号：");
		labname.setPreferredSize(dim2);
		jf.add(labname);
		
		//添加账号输入框，并添加监控事件
		JTextField textname=new JTextField();
		textname.setPreferredSize(dim3);
		jf.add(textname);
		
		//添加“密码”标签
		JLabel labpassword=new JLabel();
		labpassword.setText("密码：");
		labpassword.setPreferredSize(dim2);
		jf.add(labpassword);
		
		//添加密码输入框，并添加监控事件
		JPasswordField jp=new JPasswordField();
		jp.setPreferredSize(dim3);
		jf.add(jp);
		
		//添加一个button按钮
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("登录");
		button.setPreferredSize(dim4);
		jf.add(button);
		
		jf.setVisible(true);
		
		//首先实例化登录按钮监听类的对象，并把登录界面中账号和密码输入框的对象传给它
		LoginListener ll=new LoginListener(jf,textname,jp,this);
		//对当前窗体添加监听方法
		button.addActionListener(ll);//监控按钮
		
	}

	
 
	
	public void readData(String file)throws IOException{//将文件之接转换放入Map中								
		//读文件
		FileReader fr=new FileReader(file);
		//System.out.println(file);									//汇报读入情况
		BufferedReader br=new BufferedReader(fr);
		String str1,line[];
		String str2;
		while((str1=br.readLine())!=null) {//文件末尾不允许打空格！！！
			//读入数据
			String a1=null;					//暂存序列号
			String a2=null;					//暂存账号
			String a3=null;					//暂存密码
			StringTokenizer str=new StringTokenizer(str1,"=");
			str1=str.nextToken();					//标识名称数据
			str2=str.nextToken();					//数字数据
			if(str1.equals("student")) {
				line=str2.split(",");
				a1=line[0];		//暂存序列号
				a2=line[1];		//暂存账号
				a3=line[2];		//暂存密码
				System.out.println("读入账号 : "+a2);
				System.out.println("读入密码 : "+a3);
			}
			//若a1不为零，则进行赋值
			if(a1!=null) {
				System.out.println("HAVE FINISHED : "+Integer.parseInt(a1)*100/ALL_NUMBER+"%");
				this.MAP[Integer.parseInt(a1)-1][0]=a2;				//在对应序列号减一的位置赋值账号
				this.MAP[Integer.parseInt(a1)-1][1]=a3;				//在对应序列号减一的位置赋值密码
			}
			
			
			//while end//
		}
		br.close();
		fr.close();						
		//readData end//
	}
	
	
	
	
	
	
	
	
	
	
}
/*
注意点：1.setSize这个设置大小的方法只对顶层容器有效，也就是我们这里的JFrame，如果想要设置组件的大小，必须用setPreferredSize();格式是

        Dimension dim = new Dimension(400,300);//先用Dimension设置好大小

        labIcon.setPreferredSize(dim);//再把设置好的Dimension对象传到setPreferredSize中

2.frame.setVisible(true);这条设置界面可见的语句必须放在组件都添加完之后

3.组件对象实例化完了记得用frame.add(textName)语句把组件加到窗体上。

实现后界面如下：
*/


 


