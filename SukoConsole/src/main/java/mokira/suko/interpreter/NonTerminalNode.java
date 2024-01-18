/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mokira.suko.interpreter;

import mokira.suko.interpreter.Node;

/**
 *
 * @author mokira3d48
 */
public abstract class NonTerminalNode implements Node {
  protected Node leftNode;
  protected Node rightNode;

  public NonTerminalNode(Node l, Node r) {
    this.leftNode = l;
    this.rightNode = r;
  }

  public void setLeftNode(Node node) {
    leftNode = node;
  }

  public void setRightNode(Node node) {
    rightNode = node;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

}
