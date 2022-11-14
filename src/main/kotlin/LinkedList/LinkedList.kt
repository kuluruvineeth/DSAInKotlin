package LinkedList

class LinkedList<T> : Iterable<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty(): Boolean{
        return size==0
    }

    /*fun push(value: T){
        head=Node(value=value, next = head)
        if(tail==null){
            tail = head
        }
        size++
    }*/

    fun push(value: T): LinkedList<T>{
        head=Node(value=value, next = head)
        if(tail==null){
            tail = head
        }
        size++
        return this
    }

    /*fun append(value: T){
        if(isEmpty()){
            push(value)
            return
        }
        tail?.next = Node(value=value)
        tail = tail?.next
        size++
    }*/

    fun append(value:T):LinkedList<T>{
        if(isEmpty()){
            push(value)
            return this
        }
        tail?.next = Node(value=value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index:Int):Node<T>?{
        var currentNode=head
        var currentIndex=0

        while(currentNode!=null && currentIndex<index){
            currentNode = currentNode.next
            currentIndex++;
        }
        return currentNode
    }

    fun insert(value:T,afterNode:Node<T>):Node<T>{
        if(tail==afterNode){
            append(value)
            return tail!!
        }
        val newNode = Node(value=value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop():T?{
        if(!isEmpty()) size--
        val result = head?.value
        head=head?.next
        if(isEmpty()){
            tail=null
        }
        return result
    }

    fun removeLast(): T?{
        val head = head ?: return null
        if(head.next==null) return pop()
        size--;

        var prev=head
        var current=head
        var next=current.next
        while(next!=null){
            prev=current
            current=next
            next=current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if(node.next == tail){
            tail = node
        }
        if(node.next != null){
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    override fun toString(): String {
        if(isEmpty()){
            return "Empty List"
        }else{
            return head.toString()
        }
    }
}

class LinkedListIterator<T>(
    private val list: LinkedList<T>
) : Iterator<T>{
    private var index = 0
    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        if(index >= list.size) throw IndexOutOfBoundsException()
        lastNode = if(index==0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }

}