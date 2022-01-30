import java.util.Scanner;
class Link{
    public Link next;
    public int item;
    public int item2;
    /////////////////////////////////////////////////////////////
    public Link(int i){
        item=i;
        //item2=j;
    }
    /////////////////////////////////////////////////////////////
    public void displayLink(){
        System.out.println(item);
    }  
}
//------------------------------------------------------------------------
class StackedLinkedList{
  private Link top;
  public int count;
////////////////////////////////////////////////////////////////////////  
  public StackedLinkedList(){
      top=null;
      count=0;
  }
////////////////////////////////////////////////////////////////////////// 
  public void push(int i){
      Link newlink=new Link(i);
      newlink.next=top;
      top=newlink;
      count++;
  }
////////////////////////////////////////////////////////////////////////////
  public Link pop(){
      Link temp=top;
      top=top.next;
      count--;
      return temp;
  }
////////////////////////////////////////////////////////////////////////////
  public Link peek(){
      return top;
  }
////////////////////////////////////////////////////////////////////////////
  public int size(){
      return count;
  }
////////////////////////////////////////////////////////////////////////////
  public void displayList(){
      System.out.println("Items in stack: ");
      Link current=top;
      while(current!=null){
          current.displayLink();
          current=current.next;
      }
      System.out.println();
  }
//---------------------------------------------------------------------------  
}

class StackLink{
    public static void main(String args[]){
      Scanner input=new Scanner(System.in);
      StackedLinkedList sll=new StackedLinkedList();
      boolean status=true;
      while(status!=false){
           System.out.println("Enter: \n 1.Push \n 2.Pop \n 3.Peek \n 4.Size \n 5.Display \n 6.Exit ");
           int in=input.nextInt();
          switch (in) {
              case 1:
                  System.out.print("Enter item to be pushed into the stack: ");
                  int m=input.nextInt();
                  sll.push(m);
                  break;
              case 2:
                  sll.pop();
                  break;
              case 3:
                  System.out.println(sll.peek());
                  break;
              case 4:
                  System.out.println(sll.size());
                  break;
              case 5:
                  sll.displayList();
                  break;
              case 6:
                  status=false;
                  break;
              default:
                  System.out.println("Invalid Choice Try Again!!");
                  break;
          }
      }
     
    }
}