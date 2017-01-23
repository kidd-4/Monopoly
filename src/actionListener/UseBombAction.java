package actionListener;

import house.Location;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import others.MainT;
import player.Player;
import basicFrame.BFrame;
import actionListener.ButtonDiceAction;

public class UseBombAction implements ActionListener {

	private BFrame basicFrame;
	static Player[] player;
	JTextField[] showPlayerInfo;
	
	
	public UseBombAction(BFrame frame) {
	this.basicFrame = frame;
	
}
	public UseBombAction()
	{
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ButtonDiceAction btnDA =new ButtonDiceAction();
		int flag = btnDA.getFlag();
		
		if(flag==1 && player[0].getState()!=3)
		{
		    
		    List<JButton> labelList = basicFrame.getButtonList();
		    
		    if(player[0].getBomb()>0)
		    { 
		    if((!MainT.isNumeric((basicFrame.getBombLocation().getText().trim())))) 
		    {
				JOptionPane.showMessageDialog(basicFrame.getFrame(), "����������");
			}
		    else if(Integer.parseInt(basicFrame.getBombLocation().getText().trim())>10)
		    {
		    	JOptionPane.showMessageDialog(basicFrame.getFrame(), "������10���ڵ�����");
		    }
		    
		    else
		    {
		    int loclab=Integer.parseInt(basicFrame.getBombLocation().getText().trim());//���label�е�Stringֵ��ת����int��
		    
		    JOptionPane.showMessageDialog(null,basicFrame.getBombLocation().getText().trim()+player[0].getPlayerName());
		    
		    int locply= player[0].getLocation();//��õ�ǰ��ҵĵ�ֵַ
		
		    Location loc3 = MainT.markLocation.get(locply+loclab);//���Ҫ����ը����λ�õĶ���
			
		   
		    
		   
			if(loc3.getIsToolState()=="isBomb")//�жϸ�λ�õĵ���״̬
			{
				JOptionPane.showMessageDialog(null, "�˴���ը�����������ը����");
				
			}
			else if (loc3.getIsToolState()=="isRoadBlock")
			{
				JOptionPane.showMessageDialog(null, "�˴���·�ϣ��������ը����");
				
			} 
			else if (loc3.getIsToolState()=="isForbid")
			{
				JOptionPane.showMessageDialog(null, "�˴����ڹ����������������ը����");
				
			} 
			else 
			{
				loc3.setIsToolState("isBomb");
				int NumBomb = player[0].getBomb()-1;//�����ҵ�ը����
				player[0].setBomb(NumBomb);//����ҵ�ը������һ
				
			
				labelList.get(loc3.getLocation()).setText("<html>"+"<br>"+" B "+"<html>");//��ʾ��λ����ը����������
			}
		}
			
			for(int i =0;i<70;i++) {
				System.out.println(i + ":" + MainT.markLocation.get(i).getIsHouseState() + "," +  MainT.markLocation.get(i).getIsToolState());
				
			}
		
		
	}
		    
		    else
		    {
		    	JOptionPane.showMessageDialog(null, player[0].getPlayerName()+"û��ը����");
		    }
		}
		
		
		
		if(flag==2 &&  player[flag-1].getState()!=3)
		{
			List<JButton> labelList = basicFrame.getButtonList();
			
			if(player[flag-1].getBomb()>0)
			{
			if((!MainT.isNumeric((basicFrame.getBombLocation().getText().trim())))) 
		    {
				JOptionPane.showMessageDialog(basicFrame.getFrame(), "����������");
			}
			
			else if(Integer.parseInt(basicFrame.getBombLocation().getText().trim())>10)
		    {
		    	JOptionPane.showMessageDialog(basicFrame.getFrame(), "������10���ڵ�����");
		    }
			
			else
			{
		    int loclab=Integer.parseInt(basicFrame.getBombLocation().getText().trim());//���label�е�Stringֵ��ת����int��
		    
		    JOptionPane.showMessageDialog(null,basicFrame.getBombLocation().getText().trim()+player[flag-1].getPlayerName());
		    
		    int locply= player[flag-1].getLocation();//��õ�ǰ��ҵĵ�ֵַ
		
		    Location loc3 = MainT.markLocation.get(locply+loclab);//���Ҫ����ը����λ�õĶ���
			
	
		    
		   
			if(loc3.getIsToolState()=="isBomb")//�жϸ�λ�õĵ���״̬
			{
				JOptionPane.showMessageDialog(null, "�˴���ը�����������ը����");
				
			}
			else if (loc3.getIsToolState()=="isRoadBlock")
			{
				JOptionPane.showMessageDialog(null, "�˴���·�ϣ��������ը����");
				
			} 
			else if (loc3.getIsToolState()=="isForbid")
			{
				JOptionPane.showMessageDialog(null, "�˴����ڹ����������������ը����");
				
			} 
			else 
			{
				loc3.setIsToolState("isBomb");
				int NumBomb = player[flag-1].getBomb()-1;//�����ҵ�ը����
				player[flag-1].setBomb(NumBomb);//����ҵ�ը������һ
				labelList.get(loc3.getLocation()).setText("<html>"+"<br>"+" B "+"<html>");//��ʾ��λ����ը����������
			}
		}
		}
			
			 else
			    {
			    	JOptionPane.showMessageDialog(null, player[flag-1].getPlayerName()+"û��ը����");
			    }
		}
		
		
		if(player.length>=3) {
			if(flag==3) {
				if(player[flag-1].getState()!=3) {
					
					List<JButton> labelList = basicFrame.getButtonList();
					if(player[flag-1].getBomb()>0)
					{
					if((!MainT.isNumeric((basicFrame.getBombLocation().getText().trim())))) 
				    {
						JOptionPane.showMessageDialog(basicFrame.getFrame(), "����������");
					}
					
					else if(Integer.parseInt(basicFrame.getBombLocation().getText().trim())>10)
				    {
				    	JOptionPane.showMessageDialog(basicFrame.getFrame(), "������10���ڵ�����");
				    }
					
					else
					{	
				    int loclab=Integer.parseInt(basicFrame.getBombLocation().getText().trim());//���label�е�Stringֵ��ת����int��
				    
				    JOptionPane.showMessageDialog(null,basicFrame.getBombLocation().getText().trim()+player[flag-1].getPlayerName());
				    
				    int locply= player[flag-1].getLocation();//��õ�ǰ��ҵĵ�ֵַ
				
				    Location loc3 = MainT.markLocation.get(locply+loclab);//���Ҫ����ը����λ�õĶ���
					
				  
				    
				   
					if(loc3.getIsToolState()=="isBomb")//�жϸ�λ�õĵ���״̬
					{
						JOptionPane.showMessageDialog(null, "�˴���ը�����������ը����");
						
					}
					else if (loc3.getIsToolState()=="isRoadBlock")
					{
						JOptionPane.showMessageDialog(null, "�˴���·�ϣ��������ը����");
						
					} 
					else if (loc3.getIsToolState()=="isForbid")
					{
						JOptionPane.showMessageDialog(null, "�˴����ڹ����������������ը����");
						
					} 
					else 
					{
						loc3.setIsToolState("isBomb");
						int NumBomb = player[flag-1].getBomb()-1;//�����ҵ�ը����
						player[flag-1].setBomb(NumBomb);//����ҵ�ը������һ
						labelList.get(loc3.getLocation()).setText("<html>"+"<br>"+" B "+"<html>");//��ʾ��λ����ը����������
					}
					
				}
					}	
					
					
					 else
					    {
					    	JOptionPane.showMessageDialog(null, player[flag-1].getPlayerName()+"û��ը����");
					    }
				}
			}
			
			
			
			if(flag==4) {
				if(player[flag-1].getState()!=3) {
					List<JButton> labelList = basicFrame.getButtonList();
					if(player[flag-1].getBomb()>0)
					{
					if((!MainT.isNumeric((basicFrame.getBombLocation().getText().trim())))) 
				    {
						JOptionPane.showMessageDialog(basicFrame.getFrame(), "����������");
					}
					
					else if(Integer.parseInt(basicFrame.getBombLocation().getText().trim())>10)
				    {
				    	JOptionPane.showMessageDialog(basicFrame.getFrame(), "������10���ڵ�����");
				    }
					
					else
					{
				    int loclab=Integer.parseInt(basicFrame.getBombLocation().getText().trim());//���label�е�Stringֵ��ת����int��
				    
				    JOptionPane.showMessageDialog(null,basicFrame.getBombLocation().getText().trim()+player[flag-1].getPlayerName());
				    
				    int locply= player[flag-1].getLocation();//��õ�ǰ��ҵĵ�ֵַ
				
				    Location loc3 = MainT.markLocation.get(locply+loclab);//���Ҫ����ը����λ�õĶ���
					
				   
				    
				   
					if(loc3.getIsToolState()=="isBomb")//�жϸ�λ�õĵ���״̬
					{
						JOptionPane.showMessageDialog(null, "�˴���ը�����������ը����");
						
					}
					else if (loc3.getIsToolState()=="isRoadBlock")
					{
						JOptionPane.showMessageDialog(null, "�˴���·�ϣ��������ը����");
						
					} 
					else if (loc3.getIsToolState()=="isForbid")
					{
						JOptionPane.showMessageDialog(null, "�˴����ڹ����������������ը����");
						
					} 
					else 
					{
						loc3.setIsToolState("isBomb");
						int NumBomb = player[flag-1].getBomb()-1;//�����ҵ�ը����
						player[flag-1].setBomb(NumBomb);//����ҵ�ը������һ
						labelList.get(loc3.getLocation()).setText("<html>"+"<br>"+" B "+"<html>");//��ʾ��λ����ը����������
					}
					
					}
				}
					
					
					 else
					    {
					    	JOptionPane.showMessageDialog(null, player[flag-1].getPlayerName()+"û��ը����");
					    }
				}
				}
			
				}
		
	
		/**
		 * ����2����3����4����תЧ��
		 */
		if(player.length==2) {
			flag = (flag%2==0) ? 1 : 2;
		} else if (player.length==3) {
			if(flag==3) {
				flag=1;
			} else {
				flag++;
			}
		} else {
			if(flag==4) {
				flag=1;
			} else {
				flag++;
			}
		}
		

	}

}









