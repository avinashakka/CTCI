//Q:4.1
//Function to check if a binary tree is balanced.
//With an example case

import java.io.*;
import java.util.*;

class BalancedBT
{
  public static class Node
  {
    Node left;
    Node right;
    int val;
  }

  public static class BTree
  {
    Node head;

    void display(Node h)
    {
      if(h != null)
      {
        display(h.left);
        System.out.print(h.val);
        display(h.right);
      }

    }

    Node insert(int val,Node current)
    {
      if(current == null)
      {
        current = new Node();
        current.left = null;
        current.right = null;
        current.val = val;
        return current;
      }
      else
      {
        if(val > current.val)
        {
          current.right = insert(val,current.right);
        }
        else
        {
          current.left = insert(val,current.left);
        }
        return current;
      }

    }

    void add(int val)
    {
      if(this.head == null)
      {
        this.head = new Node();
        this.head.val = val;
        this.head.left = null;
        this.head.right = null;
      }
      else
      {
        if(val > this.head.val)
        {
          this.head.right = insert(val,this.head.right);
        }
        else
        {
          this.head.left = insert(val,this.head.left);
        }
      }
    }
  }



  public static boolean Solution(Node head)
  {
    if(head == null)
      return false;

    if(head.left == null && head.right == null)
    {
      return false;
    }

    int leftHeight = getHeight(head.left);
    int rightHeight = getHeight(head.right);

    System.out.println("Left height: "+leftHeight);
    System.out.println("Right height: "+rightHeight);

    if(Math.abs(leftHeight - rightHeight) > 1)
      return false;
    else
      return true;
  }

  public static int getHeight(Node current)
  {
      if(current == null)
        return 0;
      else
      {
        return Math.max(getHeight(current.left)+1,getHeight(current.right)+1);
      }
  }

  public static void main(String[] args)
  {
    BTree BT = new BTree();
    BT.add(4);
    BT.add(3);
    BT.add(5);
    BT.add(6);
    BT.add(2);
    BT.add(11);
    BT.add(15);
    BT.add(10);
    BT.display(BT.head);
    System.out.println(Solution(BT.head));

  }

}
