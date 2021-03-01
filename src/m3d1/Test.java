package m3d1;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode2 hn1=new HeroNode2(1,"�ν�","��ʱ��");
		HeroNode2 hn2=new HeroNode2(2,"¬����","������");
		HeroNode2 hn3=new HeroNode2(3,"����","�Ƕ���");
		HeroNode2 hn4=new HeroNode2(4,"�ֳ�","����ͷ");
		
		DoubleLinkedList dll=new DoubleLinkedList();
		dll.add(hn2);
		dll.add(hn4);
		dll.add(hn1);
		dll.add(hn3);
		
		//��ʾ����
		//dll.showList();
		
		//�޸Ĳ���
		//HeroNode2 hn5=new HeroNode2(4,"lc","bzt");
		//dll.modify(hn5);
		//dll.showList();
		
		//ɾ������
		dll.remove(1);
		dll.showList();
	}

}

class DoubleLinkedList{
	//��ʼ��ͷ�ڵ�
	private HeroNode2 head=new HeroNode2(0,"","");
	//����ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}
	//������ĩβ���Ԫ��
	/*���ҵ�˫���������һ���ڵ�
	 * temp.next=HeroNode
	 * HeroNode.pre=temp
	 */
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp=head;
		while(true) {
			if(temp.next==null){
				break;
			}
			temp=temp.next;
		}
		//�˳�ѭ����tempָ���������\
		//�γ�˫������
		temp.next=heroNode;
		heroNode.pre=temp;
	}
	
	//�޸Ľڵ�����(�͵�����һ��)
	public void modify(HeroNode2 heroNode) {
		if(head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		//���ݱ���ҵ���Ҫ�޸ĵĽڵ�
		HeroNode2 temp=head;
		boolean flag=false;//��ʾ�Ƿ��ҵ��ýڵ�
		while(true) {
			if(temp==null) {//�Ѿ�����������
				break;
			}
			if(temp.no==heroNode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.name=heroNode.name;
			temp.nickName=heroNode.nickName;
		}else {
			System.out.println("Ϊ�ҵ����Ϊ"+heroNode.no+"��Ԫ��");
		}
	}
	
	//ɾ���ڵ�
	//����˫���������ֱ���ҵ�Ҫɾ���Ľڵ�
	public void remove(int no) {
		if(head.next==null) { 
			System.out.println("����Ϊ�գ��޷�ɾ��");
		}
		
		HeroNode2 temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp==null) {
				System.out.println("�Ҳ�����ɾ��Ԫ��");
				break;
			}
			if(temp.no==no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.pre.next=temp.next;
			//ֱ��ִ��temp.next.pre=temp.pre�������һ���ڵ����ֿ�ָ���쳣
			if(temp.next!=null) {
				temp.next.pre=temp.pre;	
			}	
		}else {
			System.out.println("������Ҫɾ����Ԫ��");
		}
	}
	//��ʾ����(�͵�����һ��)
	public void showList() {
		if(head.next==null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp=head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//�����Ϣ
			System.out.println(temp);
			//����temp
			temp=temp.next;
		}
	}
}

class HeroNode2{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;
	public HeroNode2() {
		super();
	}
	public HeroNode2(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	public String toString() {
		return "["+no+","+name+","+nickName+"]";
	}
}