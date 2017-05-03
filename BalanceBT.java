//Q:4.1
//Function to check if a binary tree is balanced.

class BalanceBT
{
  
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
  
}
