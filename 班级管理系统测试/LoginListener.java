import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
 
//�����¼�
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;			//�˺���������
	private javax.swing.JPasswordField jp;		//������������
	private new000 lg;							//�����¼���ڲ���
	private javax.swing.JFrame login;			//����һ���������
	private int lingpai1=0;						//����0-����1-��ȷ   ���ڲ鿴���ִ������Ƿ���ȷ������һ��Ӧ�˺������
	private int lingpai2=0;						//����0-����1-��ȷ   ���ڲ鿴���ִ������Ƿ���ȷ�����ƶ���Ӧ���������
	
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp,new000 login000) {
		this.login=login;						//��ȡ��¼����
		this.jt=jt;								//��ȡ��¼�����е��˺���������
		this.jp=jp;								//��ȡ��¼�����е�������������
		this.lg=login000;						//��ȡ�����¼���ڲ���
	}
 
	public void actionPerformed(ActionEvent e) {
		//����get��������ȡ�˺ź����������ı���Ϣ������equal���������жϡ���ò�Ҫ��==����==����ط���֤����ȥ��
		lingpai1=0;																					//���ñ�������1����
		lingpai2=0;																					//���ñ�������2����
		for(int i=0;i<lg.ALL_NUMBER;i++) {															//����MAP���뱾
			//System.out.println(lg.MAP[i][0]);
			//System.out.println(lg.MAP[i][1]);
			if(jt.getText()!=null&&jp.getText()!=null&&lg.MAP[i][1]!=null&&lg.MAP[i][0]!=null) {	//��֤�ǿ�
				//��֤�˺��Ƿ����
				if(lg.MAP[i][0].equals(jt.getText())) {
					lingpai1=1;									//������һ��¼�˺����
				}
				if(lingpai1==1) {								//�����˺Ŵ��ڣ�����֤����
					if(lg.MAP[i][1].equals(jp.getText())) {		//��֤����
						lingpai2=1;								//��������ȷ����������2
						break;
					}else {
						break;									//�����벻��ȷ��ֱ������������2ֵΪ0
					}
				}
			}
		}
		
		
		if(lingpai1==1&&lingpai2==1) {
			//������ƥ����������һ���µĽ���
			System.out.println("������ȷ������");
			javax.swing.JFrame jf=new javax.swing.JFrame();
			jf.setTitle("��¼����û�����");
			jf.setSize(800,600);				//ֻ�Զ���������Ч
			jf.setDefaultCloseOperation(3);		//����ر�ʱ��������
			jf.setLocationRelativeTo(null);		//����
			jf.setResizable(false);
			jf.setVisible(true);				//���ÿɼ���
			
			// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
			login.dispose();
		}else {
			if(lingpai1==0) {
				//��lingpai1Ϊ0˵���˺Ų�����
				System.out.println("�����˺Ų�����");
				
				javax.swing.JFrame jf=new javax.swing.JFrame();
				jf.setTitle("WRONING");
				jf.setSize(200,150);				//ֻ�Զ���������Ч
				jf.setDefaultCloseOperation(2);		//����ر�ʱ�����Ի���
				jf.setLocationRelativeTo(null);		//����
				jf.setResizable(false);				
				jf.setVisible(true);				//���ÿɼ���
				
				java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,0,0);
				jf.setLayout(fl);											//���ö��������Ĳ���Ϊ��ʽ����
				
				//���ø�ʽ��С
				java.awt.Dimension dim2=new java.awt.Dimension(100, 80);		//��ǩ�Ĵ�С
				
				//��ӡ��˺š���ǩ
				JLabel labname=new JLabel();
				labname.setText("�����˺Ų�����");
				labname.setPreferredSize(dim2);
				jf.add(labname);
			}else {
				//��lingpai1Ϊ1��˵����Ӧ���������
				System.out.println("�����������");
				javax.swing.JFrame jf=new javax.swing.JFrame();
				jf.setTitle("WRONING");
				jf.setSize(200,150);				//ֻ�Զ���������Ч
				jf.setDefaultCloseOperation(2);		//����ر�ʱ�����Ի���
				jf.setLocationRelativeTo(null);		//����
				jf.setResizable(false);				
				jf.setVisible(true);				//���ÿɼ���
				
				
				java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,0,0);
				jf.setLayout(fl);											//���ö��������Ĳ���Ϊ��ʽ����
				
				//���ø�ʽ��С
				java.awt.Dimension dim2=new java.awt.Dimension(100, 80);		//��ǩ�Ĵ�С
				
				//��ӡ��˺š���ǩ
				JLabel labname=new JLabel();
				labname.setText("�����������");
				labname.setPreferredSize(dim2);
				jf.add(labname);
			}
		}
		
		
		
		
	}
}
