package Lesson8;

public class LinkedList implements List{

    private int size = 0;
    private Node head = null;

    public class Node {
        Object data;
        Node next;

        /*
         * Node Constructor - New Nodes
         */
        Node(){
            this.data = 0;
            this.next = null;
        }
        public Node(Object data){
            this.data = data;
            this.next = null;
        }
        public Object getObjData(){
            return data;
        }
        public Node getNextNode(){
            return next;
        }
        public void setNextNode(Node next){
            this.next = next;
        }
    }

    /**
     * Insert a Node
     * @param obj the object in question
     */
    @Override
    public void add(Object obj){
        Node node = new Node(obj);
        node.setNextNode(head);
        head = node;
        size++;
    }

    @Override
    public void add(int pos, Object obj) throws Exception {
        if(pos < 0 || size > pos)
            throw new Exception();
        if(pos == 0) {
            Node node = new Node();
            node.data = obj;
            node.next = head;
            head = node;
            size++;
        }
        else {
            Node prev = getNode(pos-1);
            Node node = new Node();
            node.data = obj;
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    @Override
    public Object get(int pos) throws Exception {
        if(pos >= size || pos < 0)
            throw new Exception();
        Node current = getNode(pos);
        return current.data;
    }

    @Override
    public Object remove(int pos) throws Exception {
        if(pos < 0 || pos >= size)
            throw new Exception();
        if(pos == 0) {
            Node current = head;
            head = head.getNextNode();
            size--;
            return current.data;
        }
        else {
            Node previous = getNode(pos-1);
            Node current = previous.next;
            previous.next = current.next;
            size--;
            return current.data;
        }
    }

    public Node getNode(int pos){
        Node node = head;
        for(int i=0; i<pos; i++)
            node = node.getNextNode();
        return node;
    }

    @Override
    public int size() {
        if (size == 0)
            return 0;
        return size;
    }

}

