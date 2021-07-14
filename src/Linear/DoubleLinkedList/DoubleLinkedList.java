public class DoubleLinkedList {
	private Node head;
	private Node tail;
	public DoubleLinkedList() {
		head=null;
		tail=null;
	}
	public void addEnd(Object data) {
		if( head==null && tail == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		}
		else {
			Node newnode = new Node(data);
			newnode.setPrev(tail);
			tail.setNext(newnode);
			tail = newnode;
		}
	}
	public void addFront(Object data) {
		if( head==null && tail == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = newNode;
		}
		else {
			Node newnode = new Node(data);
			newnode.setNext(head);
			head.setPrev(newnode);
			head = newnode;
		}
	}
	public void removeEnd() {
		if( head==null && tail == null) {
			System.out.println("Linked List is empty");
		}
		else {
			Node temp =tail.getPrev();
			tail = temp;
			temp.setNext(null);
		}
	}
	public void removeFront() {
		if( head==null && tail == null) {
			System.out.println("Linked List is empty");
		}
		else {
			Node temp =head.getNext();
			head = temp;
			temp.setPrev(null);
		}
	}
	public void addSorted(Object newdata, boolean ascending) {
		Node data = new Node(newdata);
		if(head == null && tail == null) {
			head = data;
			tail = data;
			return;
		}
		Node temp = head;
		try {
			if( ascending ? ((int)newdata < (int)head.getData()) : ((int)newdata > (int)head.getData())) {
				data.setNext(head);
				head.setPrev(data);
				head = data;
				if(size() == 2) tail = head.getNext();
				return;
			}
			while(temp.getNext() != null) {
				if(ascending ? (((int)temp.getNext().getData()) >= (int)newdata) : (((int)temp.getNext().getData()) <= (int)newdata)) break;
				temp = temp.getNext();
			}
		}catch(Exception e) {
			if(ascending ? (((String)newdata).compareTo((String)(head.getData()))<0) : (((String)newdata).compareTo((String)(head.getData()))>0)) {
				data.setNext(head);
				head.setPrev(data);
				head = data;
				if(size() == 2) tail = head.getNext();
				return;
			}
			while(temp.getNext() != null) {
				if(ascending ? (((String)temp.getNext().getData()).compareTo((String)newdata)>=0) :  (((String)temp.getNext().getData()).compareTo((String)newdata)<=0)) break;
				temp = temp.getNext();
			}
		}
		if(temp.getNext() == null) {
			this.addEnd(newdata);
		}
		else {
			data.setNext(temp.getNext());
			temp.getNext().setPrev(data);
			temp.setNext(data);
			data.setPrev(temp);
		}
	}
	public void sort(boolean ascending) {
		if(size() == 1) return;
		DoubleLinkedList newList = new DoubleLinkedList();
		Node temp = head;
		for(int i = 0; i<size() ; i++) {
			newList.addSorted(temp.getData(), ascending);
			temp = temp.getNext();
		}
		head = newList.head;
	}
	public boolean search(int number) { //Returns true if specified item in list
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			Node temp = head;
			while(temp != null) {
				if (number == (int) temp.getData())
					return true;
				temp = temp.getNext();
			}
		}
		return false;
	}
	public void removeString(String s) {
        if(head == null) {
            System.out.println("LinkedList is empty");
        }
        else {
            while((head.getData()).equals(s)) {
                head = head.getNext();
                head.setPrev(null);
            }
            Node temp = head;
            while(temp != null) {
                if((temp.getData()).equals(s)) {
                    if(temp.getNext() == null) {
                        tail = tail.getPrev();
                        tail.setNext(null);
                    }
                    else {
                        temp.getPrev().setNext(temp.getNext());
                        temp.getNext().setPrev(temp.getPrev());
                    }
                }
                temp = temp.getNext();
            }
        }
    }
	public void removeInt(int i) {
        if(head == null) {
            System.out.println("LinkedList is empty");
        }
        else {
            while((int)(head.getData()) == i) {
                head = head.getNext();
                head.setPrev(null);
            }
            Node temp = head;
            while(temp != null) {
                if((int)(temp.getData()) == i) {
                    if(temp.getNext() == null) {
                        tail = tail.getPrev();
                        tail.setNext(null);
                    }
                    else {
                        temp.getPrev().setNext(temp.getNext());
                        temp.getNext().setPrev(temp.getPrev());
                    }
                }
                temp = temp.getNext();
            }
        }
    }
	public Object getElement(int x) { //Returns item by index
		if(head == null) {
			System.out.println("LinkedList is empty");
			return null;
		}
		else if(x > size() || x < 0) {
			System.out.println("Index is out of range");
			return null;
		}
		else {
			Node temp = head;
			int count = 1;
			while(temp != null){
				if(count == x)
					return temp.getData();
				temp = temp.getNext();
				count++;
			}
			return null;
		}
	}
	public void swap(int x) { //Changes the x from the beginning and the xth from the end indexes
		x+=1;
		if(head== null) {
			System.out.println("LinkedList is empty");
		}
		else if(x>= size() || x< 0) {
			System.out.println("Index is out of range");
		}
		else {
			int element1 = -1;
			Node temp1 = head;
			int count =1;
			while(temp1 != null) {
				if(count == x) {
					element1 = (Integer) temp1.getData();
					break;
				}
				temp1 = temp1.getNext();
				count++;
			}
			int element2= -1;
			Node temp2 = tail;
			count = 1;
			while(temp2 != null) {
				if(count == x) {
					element2 = (Integer)temp2.getData();
					temp2.setData(element1);
					break;
				}
				temp2 = temp2.getPrev();
				count++;
			}
			temp1.setData(element2);
		}
	}
	public int size(){
		int count = 0;
		Node temp = head;
		while(temp != null){
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public void display() {
		if(head == null && tail == null ) {
			System.out.println("LinkedList is empty");
		}
		else {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.getData()+" ");
				temp = temp.getNext();
			}
			System.out.println();
		}
	}
	public void displayReverse() {
		if(head == null && tail == null) {
			System.out.println("LinkedList is empty");
		}
		else {
			Node temp = tail;
			while(temp != null) {
				System.out.print(temp.getData()+" ");
				temp = temp.getPrev();
			}
			System.out.println();
		}
	}
}
