import org.w3c.dom.NodeList

import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.collection.mutable.Stack

object ValidBinarySearchTree {

  private class Node(value: Int, nodes: List[Int]) {
    def nodeList = nodes
  }

  def main(args: Array[String]) {
    var buffer = ListBuffer[Node]()
    val numT = StdIn.readInt()
    for (x <- 1 to numT) {
      val numberOfNodes = StdIn.readInt()
      val nodesListStr = StdIn.readLine()
      val nodeList = nodesListStr.split(" ").toList.map(_.toString).map(_.toInt)
      buffer += new Node(numberOfNodes, nodeList)
    }
    for(node <- buffer.toList)
      println(if(checkValidBST(node)) "YES" else "NO")

  }

  def checkValidBST(node: Node): Boolean = {
    var root = Int.MinValue
    val stack = Stack[Int]()
    val preOrderArray:List[Int] = node.nodeList
    for(x :Int<- preOrderArray) {
      if (x < root)
        return false
      while (!stack.isEmpty && stack.top < x) {
        root = stack.top
        stack.pop
      }
      stack.push(x)
    }
    return true
  }
}