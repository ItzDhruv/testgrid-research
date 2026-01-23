class hello{
    public static void main(String []args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        // System.out.println();
        n1.right = n2;
        System.out.print(n1.data);
        System.out.println();
        System.out.print(n1.right.data);
        System.out.println();
    }
}


class Node{
    Node right,left,head;
    int data;
     Node(int d) {
        data = d;
    }
}
