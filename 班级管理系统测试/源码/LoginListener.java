import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
//�����¼�
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;			//�˺���������
	private javax.swing.JPasswordField jp;		//������������
	private new000 lg;							//�����¼���ڲ���
	private javax.swing.JFrame login;			//����һ���������
	
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp,new000 login000) {
		this.login=login;//��ȡ��¼����
		this.jt=jt;//��ȡ��¼�����е��˺���������
		this.jp=jp;//��ȡ��¼�����е�������������
		this.lg=login000;//��ȡ�����¼���ڲ���
	}
 
	public void actionPerformed(ActionEvent e) {
		//����get��������ȡ�˺ź����������ı���Ϣ������equal���������жϡ���ò�Ҫ��==����==����ط���֤����ȥ��
		int lingpai=0;												//����0-����1-��ȷ
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
			//�����벻ƥ����
			System.out.println("������󣡣���");
		}else if(lingpai==1) {
			//������ƥ����������һ���µĽ���
			javax.swing.JFrame jf=new javax.swing.JFrame();
			jf.setTitle("��¼����û�����");
			jf.setSize(340,500);//ֻ�Զ���������Ч
			jf.setDefaultCloseOperation(3);//����ر�ʱ��������
			jf.setLocationRelativeTo(null);//����
			jf.setResizable(false);
			jf.setVisible(true);
			
			// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
			login.dispose();
		}
		
		
		
		
	}
}
