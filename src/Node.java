public class Node {
	private Object info;
	private Node link;

	public Node(Object o) {
		info = o;
		link=null;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	@Override
	public String toString(){
        return "[" + info+ "]";
    }	

}
