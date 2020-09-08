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
 
	
	public static final int ALL_NUMBER=30;									//�û�������
	
	public String[][] MAP=new String[ALL_NUMBER][2];						//���ڴ������ݼ���
	
	public static void main(String[] args) {
		new000 login = new new000();
		login.initUI();
 
	}
 
	
	 
	public void initUI() {
		
		//��ȡ���ݲ�����Ƿ������쳣
		try {
			readData("important.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��½����
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("��¼����");
		jf.setSize(340,500);//ֻ�Զ���������Ч
		jf.setDefaultCloseOperation(3);//����ر�ʱ��������
		jf.setLocationRelativeTo(null);//����
		jf.setResizable(false);
 
		//ѡ�񲼾����ͣ�������ʽ���ֵĶ���,��������ÿ�����֮�����5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,0,0);
		jf.setLayout(fl);//���ö��������Ĳ���Ϊ��ʽ����
		
		//���ø�ʽ��С
		java.awt.Dimension dim1=new java.awt.Dimension(340,300);//ͼƬ��С
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//��ǩ�Ĵ�С
		java.awt.Dimension dim3=new java.awt.Dimension(250, 30);//�����Ĵ�С		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//��ť�Ĵ�С	
		
		//������
		//���ͼƬ����Ҫ��ͼƬ���ص��ڴ��С�����IamgeIcon���ͼƬ���ص��ڴ�
		javax.swing.ImageIcon icon=new javax.swing.ImageIcon("bd4632598c2408.jpg");
		JLabel labpic=new JLabel(icon);//������ֱ�Ӱ�ͼƬ�ӵ����������У���Ҫ�Ƚ�������Ϊ��ǩ
		labpic.setPreferredSize(dim1);
		jf.add(labpic);//�ٽ���ǩ�ӵ�����������
		
		//��ӡ��˺š���ǩ
		JLabel labname=new JLabel();
		labname.setText("�˺ţ�");
		labname.setPreferredSize(dim2);
		jf.add(labname);
		
		//����˺�����򣬲���Ӽ���¼�
		JTextField textname=new JTextField();
		textname.setPreferredSize(dim3);
		jf.add(textname);
		
		//��ӡ����롱��ǩ
		JLabel labpassword=new JLabel();
		labpassword.setText("���룺");
		labpassword.setPreferredSize(dim2);
		jf.add(labpassword);
		
		//�����������򣬲���Ӽ���¼�
		JPasswordField jp=new JPasswordField();
		jp.setPreferredSize(dim3);
		jf.add(jp);
		
		//���һ��button��ť
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("��¼");
		button.setPreferredSize(dim4);
		jf.add(button);
		
		jf.setVisible(true);
		
		//����ʵ������¼��ť������Ķ��󣬲��ѵ�¼�������˺ź����������Ķ��󴫸���
		LoginListener ll=new LoginListener(jf,textname,jp,this);
		//�Ե�ǰ������Ӽ�������
		button.addActionListener(ll);//��ذ�ť
		
	}

	
 
	
	public void readData(String file)throws IOException{			//���ļ�֮��ת������Map��								
		//���ļ�
		FileReader fr=new FileReader(file);
		//System.out.println(file);									//�㱨�������
		BufferedReader br=new BufferedReader(fr);
		String str1,line[];
		String str2;
		while((str1=br.readLine())!=null) {							//�ļ�ĩβ�������ո񣡣���
			//��������
			String a1=null;					//�ݴ����к�
			String a2=null;					//�ݴ��˺�
			String a3=null;					//�ݴ�����
			StringTokenizer str=new StringTokenizer(str1,"=");
			str1=str.nextToken();					//��ʶ��������
			str2=str.nextToken();					//��������
			if(str1.equals("student")) {
				line=str2.split(",");
				a1=line[0];		//�ݴ����к�
				a2=line[1];		//�ݴ��˺�
				a3=line[2];		//�ݴ�����
				System.out.println("�����˺� : "+a2);
				System.out.println("�������� : "+a3);
			}
			//��a1��Ϊ�㣬����и�ֵ
			if(a1!=null) {
				System.out.println("HAVE FINISHED : "+Integer.parseInt(a1)*100/ALL_NUMBER+"%");
				this.MAP[Integer.parseInt(a1)-1][0]=a2;				//�ڶ�Ӧ���кż�һ��λ�ø�ֵ�˺�
				this.MAP[Integer.parseInt(a1)-1][1]=a3;				//�ڶ�Ӧ���кż�һ��λ�ø�ֵ����
			}
			
			
			//while end//
		}
		br.close();
		fr.close();						
		//readData end//
	}
	
	
	
	
	
	
	
	
	
	
}
/*
ע��㣺1.setSize������ô�С�ķ���ֻ�Զ���������Ч��Ҳ�������������JFrame�������Ҫ��������Ĵ�С��������setPreferredSize();��ʽ��

        Dimension dim = new Dimension(400,300);//����Dimension���úô�С

        labIcon.setPreferredSize(dim);//�ٰ����úõ�Dimension���󴫵�setPreferredSize��

2.frame.setVisible(true);�������ý���ɼ����������������������֮��

3.�������ʵ�������˼ǵ���frame.add(textName)��������ӵ������ϡ�

ʵ�ֺ�������£�
*/


 


