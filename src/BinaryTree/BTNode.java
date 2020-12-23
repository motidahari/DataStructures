package BinaryTree;

public class BTNode {
	public int data, size;
	public BTNode right, left, parent;

	public BTNode(int data) {
		this.data = data;
		right = parent = left = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
	public BTNode getParent() {
		return parent;
	}
	public void setParent(BTNode parent) {
		this.parent = parent;
	}
	public String toString() {
		return "" +  data;
	}
	public int getSize() {
		return size;
	}
	public int setSize(int size) {
		this.size = size;
		return 0;
	}
	public String getStringOfTree(BTNode root){

		if(root == null){
			return "";
		}

		String data = "" + root.getData();
		BTNode child = root.getLeft();
		boolean le = false;
		if(child != null){
			le = true;
			data += " ( L : " + child.getData();
		}
		child = root.getRight();
		if(child != null){
			if(le){
				data += " , R : " + child.getData();
			}else{
				data += " ( R : " + child.getData();
			}
			le = true;
		}
		if(le) {
			data += ")";
		}else{
			data += " : no children";
		}
		data += "\n";
		return data + "R : " + getStringOfTree(root.getRight()) + "L : " + getStringOfTree(root.getLeft());
	}


}
