import java.io.PrintStream;
import java.util.NoSuchElementException;

class StringStackImpl<T> implements StringStack<T> {
	private ListNode<T> first;
    private int size;

	public StringStackImpl() {
		this.first = null;
        this.size = 0;
	}

	public void push(T item) {
		if (this.first != null) {
            this.first = new ListNode<T>(item,this.first);
        } else {
            this.first = new ListNode<T>(item);
        }
        this.size++;
	}

	public T pop() throws NoSuchElementException {
		if (this.size > 0) {
			T ob = this.first.getData();
			this.first = this.first.getNext();
			this.size--;
			return ob;
		} else {
			throw new java.util.NoSuchElementException();
		}
	}

	public T peek() throws NoSuchElementException {
		if (this.size > 0) {
			return this.first.getData();
		} else {
			throw new NoSuchElementException();
		}
	}

	public void printStack(PrintStream stream) {
		ListNode cur = this.first;
		while (cur != null) {
			stream.println(cur.getData());
			cur = cur.getNext();
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

}