public class Queue{
		Node head;
		Node tail;
		public Queue(){
				head = null;
				tail = null;
		}
		public void enqueue(int x , int y, int input){
				Node toBeInserted = new Node(x, y, input);
				toBeInserted.next = head;
				if(head == null){
						tail = toBeInserted;
				}
				else{
						head.prev = toBeInserted;
				}
				head = toBeInserted;
		}
		public Node dequeue(){
				if(head == null){
						return null;
				}
				if(tail == null){
						return null;
				}
				Node output = tail;
				if(tail.prev != null){
						tail.prev.next = null;
				}
				tail = tail.prev;

				return output;
		}
}