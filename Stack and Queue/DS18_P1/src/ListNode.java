class ListNode<T> {
    private T data;
    private ListNode next;

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }
    
    public ListNode(T ob) {
        this(ob,null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T obj) {
        this.data = obj;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return this.data.toString();
    }
    
}