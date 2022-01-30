package testing;
import java.util.Scanner;
class Link{
    public Link next;
    public int item;
    
    public Link(int i){
        item=i;
    }
    
    public void displayLink(){
        System.out.println(item);
    }
}
///////////////////////////////////////////////////////////////
class QyLink{
    public Link first;
    public Link last;
    public int count;
    
    public QyLink(){
        first=null;
        last=null;
        count=0;
    }
    
    public boolean isEmpty(){
        return(first==null);
    }
    
    public void insert(int i){
        Link newLink=new Link( i);
        if(isEmpty()){
            first=newLink;   
            last=newLink;
        }else{
            last.next=newLink;
            last=newLink;
        }
        System.out.println("Item inserted successfully");
        count++;
    }
    
    public Link remove(){
        
        Link temp=first;
        first=first.next;
        System.out.println("Item removed successfully");
        count--;
        return temp;
    }
    
    public int size(){
        return count;
    }
    
    public Link peek(){
        return (first);
    }
    
     public void displayList(){
      System.out.println("Items in Queue: ");
      Link current=first;
      while(current!=null){
          current.displayLink();
          current=current.next;
      }
      System.out.println();
  }
}

class QueLink{
    public static void main(String []args){
      Scanner input=new Scanner(System.in);
      QyLink ql=new QyLink();
      boolean finish=true;
      while(finish!=false){
          System.out.println("Enter \n 1.Insert item \n 2. Remove item \n 3. Size of the queue \n 4. Return peek \n 5. Display queue \n 6.Exit");
          int answer=input.nextInt();
          
          switch(answer){
              case 1:
                  System.out.println("Enter item to be inserted: ");
                  int in=input.nextInt();
                  ql.insert(in);
                  break;
              case 2:
                  if(ql.isEmpty()){
                      System.out.println("Failed!! The Queue is Empty");
                  }else{
                      ql.remove();
                  }
                  break;
              case 3:
                  ql.size();
                  break;
              case 4:
                  ql.peek();
                  break;
              case 5:
                  if(ql.isEmpty()){
                      System.out.println("Failed The Queue is Empty");
                  }else{
                     ql.displayList(); 
                  }
                  break;
              case 6:
                  finish=false;
                  break;
              default:
                  System.out.println("Invalid choice!! Try Again");
          }
      }
    }
}