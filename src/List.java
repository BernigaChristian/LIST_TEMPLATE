public class List {
	private Node head;
	private int elements;
	
	public List() {
		head = null;
		elements = 0;
	}
	
	public int getElements() {
		return elements;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void headAdd(Object o) {
		Node newNode = new Node(o);
		newNode.setLink(head);
		head = newNode;
		elements ++;
	}
	
	public void tailAdd(Object o) {
		if(isEmpty()) headAdd(o);
		else {
			Node newNode = new Node(o);
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
			elements ++;
		}
	}
	
	public void positionAdd(Object o, int index) throws ListException{
		Node temp = head;
		Node newNode = new Node(o);
		int i = 1;
		if(index < 1 || index > (elements + 1))
			throw new ListException("INVALID POSITION");
		if(isEmpty() || index==1)   headAdd(o);
		else if(index == (elements+1))  tailAdd(o);
		else {
			while(i ++ < index-1)
				temp = temp.getLink();
			newNode.setLink(temp.getLink());
			temp.setLink(newNode);
			elements ++;
		}
	}
	
	public void headRemove() throws ListException {
		if(isEmpty())
			throw new ListException("EMPTY LIST");
		head = head.getLink();
		elements --;
	}
	
	public void tailRemove() throws ListException {
		Node prevNode = head, nextNode = head;
		if(isEmpty())
			throw new ListException("EMPTY LIST");
		while(prevNode.getLink() != null) {
			nextNode = prevNode;
			prevNode = prevNode.getLink();
		}
		if(prevNode == head)    headRemove();
		else {
			nextNode.setLink(null);
			elements --;
		}
	}
	
	public void positionRemove(int index) throws ListException {
		Node prevNode = head, nextNode = head;
		int i = 0;
		if(isEmpty())
			throw new ListException("EMPTY LIST");
		if(index < 1 || index > (elements+1))
			throw new ListException("INVALID POSITION");
		if(index == 1)
			headRemove();
		else if(index == elements)
			tailRemove();
		else {
			while(prevNode.getLink() !=null && i ++ < index - 1) {
			 nextNode = prevNode;
			 prevNode = prevNode.getLink();
			}
			nextNode.setLink(prevNode.getLink());
			elements --;
		}
	}
	
	public String toString() {
		Node temp = head;
		String list = "";
		if(isEmpty())   list=" EMPTY LIST.\n ";
		while(temp != null) {
			list += temp.getInfo().toString() + " \n ";
			temp = temp.getLink();
		}
		return list;
	}
}
