//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node start = null;
            Node temp=null, r = null;

            // Create linked list from the array arr[].
            // Created linked list will be 1->2->11->56->12
            if (n > 0) {
                int arr = sc.nextInt();

                temp = new Node(arr);
                start = temp;
                r = start;
            }

            for (int i = 0; i < n - 1; i++) {
                int arr = sc.nextInt();
                temp = new Node(arr);
                r.next = temp;
                r = r.next;
            }

            if (n > 0)
            {
                temp.next = start;
                r = temp; 
            }


            int x = sc.nextInt();
            Solution ob = new Solution();
            start = ob.sortedInsert(start, x);
            printList(start);
            r = start;
            while (r != start.next) {
                temp = start;
                start = start.next;
                temp = null;
            }
            temp = null;
        }
    }

    /* Function to print Nodes in a given linked list */
    static void printList(Node start) {
        Node temp;

        if (start != null) {
            temp = start;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != start);
            System.out.println();
        }
    }
}

// } Driver Code Ends
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

//User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node cur = head;
        Node newNode = new Node(data);
        
        // CASE 1 : Empty Linked List
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        
        // CASE 2 : New Node is smaller than head
        else if(data <= head.data){
            while(cur.next != head){
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.next = head;
            return newNode;
        }
        
        // CASE 3 : New Node can be inserted in between the list
        else{
            while(cur.next != head && data > cur.next.data){
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            return head;
        }
    }
}
