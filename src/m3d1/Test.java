package m3d1;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode2 hn1=new HeroNode2(1,"宋江","及时雨");
		HeroNode2 hn2=new HeroNode2(2,"卢俊义","玉麒麟");
		HeroNode2 hn3=new HeroNode2(3,"吴用","智多星");
		HeroNode2 hn4=new HeroNode2(4,"林冲","豹子头");
		
		DoubleLinkedList dll=new DoubleLinkedList();
		dll.add(hn2);
		dll.add(hn4);
		dll.add(hn1);
		dll.add(hn3);
		
		//显示测试
		//dll.showList();
		
		//修改测试
		//HeroNode2 hn5=new HeroNode2(4,"lc","bzt");
		//dll.modify(hn5);
		//dll.showList();
		
		//删除测试
		dll.remove(1);
		dll.showList();
	}

}

class DoubleLinkedList{
	//初始化头节点
	private HeroNode2 head=new HeroNode2(0,"","");
	//返回头节点
	public HeroNode2 getHead() {
		return head;
	}
	//往链表末尾添加元素
	/*先找到双向链表最后一个节点
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
		//退出循环，temp指向链表最后\
		//形成双向链表
		temp.next=heroNode;
		heroNode.pre=temp;
	}
	
	//修改节点内容(和单链表一样)
	public void modify(HeroNode2 heroNode) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		//根据编号找到需要修改的节点
		HeroNode2 temp=head;
		boolean flag=false;//表示是否找到该节点
		while(true) {
			if(temp==null) {//已经遍历完链表
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
			System.out.println("为找到编号为"+heroNode.no+"的元素");
		}
	}
	
	//删除节点
	//对于双向链表可以直接找到要删除的节点
	public void remove(int no) {
		if(head.next==null) { 
			System.out.println("链表为空，无法删除");
		}
		
		HeroNode2 temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp==null) {
				System.out.println("找不到待删除元素");
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
			//直接执行temp.next.pre=temp.pre，当最后一个节点会出现空指针异常
			if(temp.next!=null) {
				temp.next.pre=temp.pre;	
			}	
		}else {
			System.out.println("不存在要删除的元素");
		}
	}
	//显示链表(和单链表一样)
	public void showList() {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp=head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			//输出信息
			System.out.println(temp);
			//后移temp
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