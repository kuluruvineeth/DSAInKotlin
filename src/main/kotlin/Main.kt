import LinkedList.LinkedList
import LinkedList.Node

fun main(args: Array<String>) {

        val node1 = Node<Int>(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)

        node1.next= node2
        node2.next = node3

        println(node1)

        val list = LinkedList<Int>()
        /*list.push(3)
        list.push(2)
        list.push(1)*/
        list.push(4).push(3).push(2)

        list.append(9).append(10).append(15)

        println(list)
        println("Before inserting: $list")
        var Node = list.nodeAt(1)!!
        for(i in 1..3){
                Node = list.insert(-1*i,Node)
        }
        println("After inserting: $list")

        println("Before popping list: $list")
        var poppedValue = list.pop()
        println("After popping list: $list")
        println("Popped value: $poppedValue")

        println("Before removing last node: $list")
        val removedValue = list.removeLast()

        println("After removing last node: $list")
        println("Removed value:$removedValue")

        println("Before removing at particular index: $list")
        val index = 1
        val node = list.nodeAt(index-1)!!
        val removedValue1 = list.removeAfter(node)

        println("After removing at index $index: $list")
        println("Removed value: $removedValue1")

        println("printing doubles")
        val listIterable = LinkedList<Int>()
        listIterable.push(10)
        listIterable.push(20).push(30)
        println("Iterable List: $listIterable")

        for(item in listIterable){
                println("Double: ${item * 2}")
        }

        println("Removing elements")
        val listCollection: MutableCollection<Int> = LinkedList<Int>()
        listCollection.add(3)
        listCollection.add(2)
        listCollection.add(1)

        println(listCollection)
        listCollection.remove(1)
        println(listCollection)

        println("Retaining elements")
        val listCollection1: MutableCollection<Int> = LinkedList<Int>()
        listCollection1.add(3)
        listCollection1.add(2)
        listCollection1.add(1)
        listCollection1.add(4)
        listCollection1.add(5)

        println(listCollection1)
        listCollection1.retainAll(listOf(3,4,5))
        println(list)

        println("Remove all elements")
        val listCollection2: MutableCollection<Int> = LinkedList<Int>()
        listCollection2.add(3)
        listCollection2.add(2)
        listCollection2.add(1)
        listCollection2.add(4)
        listCollection2.add(5)

        println(listCollection2)
        listCollection2.removeAll(listOf(3,4,5))
        println(listCollection2)

}