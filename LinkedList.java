import java.util.Scanner;
class Link
{
public int iData; // data item (key)
public int dData; // data item
public Link next; // next link in list
// -------------------------------------------------------------
public Link(int id, int dd) // constructor
{
iData = id;
dData = dd;
}

  
// -------------------------------------------------------------
public void displayLink() // display ourself
{
//System.out.print(“{“ + iData + “, “ + dData + “} “);
System.out.println("{"+iData+","+dData+"}");
}
} // end class Link


class FirstLastList
{
private Link first; // ref to first link
private Link last; // ref to last link
// -------------------------------------------------------------
public FirstLastList() // constructor
{
first = null; // no links on list yet
last = null;
}
// -------------------------------------------------------------
public boolean isEmpty() // true if no links
{ return first==null; }
// -------------------------------------------------------------
public void insertFirst(int id,int dd) // insert at front of list
{
Link newLink = new Link(id,dd); // make new link
if( isEmpty() ) // if empty list,
last = newLink; // newLink <-- last
newLink.next = first; // newLink --> old first
first = newLink; // first --> newLink
}
// -------------------------------------------------------------
public void insertLast(int id,int dd) // insert at end of list
{
Link newLink = new Link(id,dd); // make new link
if( isEmpty() ) // if empty list,
first = newLink; // first --> newLink
else
last.next = newLink; // old last --> newLink
last = newLink; // newLink <-- last
}
// -------------------------------------------------------------
public void deleteFirst() // delete first link
{ // (assumes non-empty list)
/*Link temp = first.dData;
if(first.next == null) // if only one item
last = null; // null <-- last
first = first.next; // first --> old next
return temp;*/
    Link current = first; // search for link
    //Link previous = first;
    //if(current == first) // if first link,
        first = first.next; // change first
    //else // otherwise,
        //previous.next = current.next; // bypass it
    //return current;
}
// -------------------------------------------------------------
public Link find(int key) // find link with given key
{ // (assumes non-empty list)
Link current = first; // start at ‘first’
while(current.iData != key&&current.dData!=key) // while no match,
{
if(current.next == null) // if end of list,
return null; // didn’t find it
else // not end of list,
current = current.next; // go to next link
}
return current; // found it
}
// -------------------------------------------------------------
public Link delete(int key) // delete link with given key
{ // (assumes non-empty list)
Link current = first; // search for link
Link previous = first;
while(current.iData != key&&current.dData!=key)
{
if(current.next == null)
return null; // didn’t find it
else
{
previous = current; // go to next link
}
} // found it
if(current == first) // if first link,
first = first.next; // change first
else // otherwise,
previous.next = current.next; // bypass it
return current;
}
// -------------------------------------------------------------
// -------------------------------------------------------------
public void displayList()
{
System.out.println("List (first-->last): ");
Link current = first; // start at beginning
while(current != null) // until end of list,
{
current.displayLink(); // print data
current = current.next; // move to next link
}
System.out.println("");
}
// -------------------------------------------------------------
} // end class FirstLastList
////////////////////////////////////////////////////////////////
class LinkList2App
{
public static void main(String[] args)
{
    Scanner input= new Scanner(System.in);
    FirstLastList list=new FirstLastList();
    boolean done=true;
    while(done=true){
        System.out.println("Enter\n1.Insert link\n2.Find Link\n3.Delete link\n4.Display list\n5.Exit");
    int choice=input.nextInt();
    
    switch (choice) {
        case 1:
            System.out.println("Insert at 1.First 2.Last");
            int option=input.nextInt();
            if(option==1){
                 System.out.println("Enter item 1");
                 int i1=input.nextInt();
                 System.out.println("Enter item 2");
                 int i2=input.nextInt();
                 list.insertFirst(i1, i2);
                 System.out.println("Link inserted Successfully");
                 list.displayList(); // display list
            }else{
                System.out.println("Enter item 1");
                 int i1=input.nextInt();
                 System.out.println("Enter item 2");
                 int i2=input.nextInt();
                 list.insertLast(i1, i2);
                 System.out.println("Link inserted Successfully");
                 list.displayList(); // display list
            }
           
            break;
        case 2:
            if(list.isEmpty()){
                System.out.println("Failed! The list is Empty!!");
            }else{
                System.out.println("Enter key to find");
            int i3=input.nextInt();
            Link f = list.find(i3); // find item
            if( f != null)
                System.out.println("Found link with key "+i3);
            else
                System.out.println("Can't find link");
            }
            
            break;
        case 3:
            if(list.isEmpty()){
                System.out.println("Failed! The list is Empty!!");
            }else{
                System.out.println("Select 1.Delete first 2.Delete by key");
                int select=input.nextInt();
                if(select==1){
                   list.deleteFirst();
                   System.out.println("first link deleted Successfully");
                }else{
                    System.out.println("Enter key to delete");
                    int i4=input.nextInt();
                    Link d = list.delete(i4); // delete item
                    if( d != null )
                        //System.out.println(“Deleted link with key “ + d.iData);
                       System.out.println("Link with key "+d.iData+" and "+d.dData+" deleted successfully");
                    else
                       //System.out.println(“Can’t delete link”);
                      System.out.println("Can't delete link");
                    }
                }
                 
           
            break;
        case 4:
            if(list.isEmpty()){
                System.out.println("Failed! The list is Empty!!");
            }else
            list.displayList(); // display list
            break;
        case 5:
            done=false;
        default:
            System.out.println("Invalid choice, Try Again");
            break;
    }
    }
    
} // end main()
} // end class LinkList2App