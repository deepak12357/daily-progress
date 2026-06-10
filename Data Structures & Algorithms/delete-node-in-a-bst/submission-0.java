/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Boolean checkLeafNode(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    public void solve(TreeNode root,int key){
        if(root==null) return;

        if(root.left!=null && root.left.val==key){
            if(checkLeafNode(root.left)){
                root.left = null;
            }
            else{
                root.left = delRootNode(root.left);
            }
        }
        if(root.right!=null && root.right.val==key){
            if(checkLeafNode(root.right)){
                root.right = null;
            }
            else{
                root.right = delRootNode(root.right);
            }
        }
    }
    
    public TreeNode delRootNode(TreeNode root){
        TreeNode temp = root;
        if(temp.right==null){
            return root.left;
        }
        else if(temp.left==null){
            return root.right;
        }
        if(temp.right.left==null){
            temp=temp.right;
            root.val = temp.val;;
            root.right = temp.right;
            return root;
        }
        else{
            temp = findSmallestElementInRight(root.right);
            root.val = temp.left.val;
            temp.left = null;
            return root;
        }
    }
    public TreeNode findSmallestElementInRight(TreeNode root){
        while(root.left.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root.val==key){
            return delRootNode(root);
        }
        solve(root,key);
        return root;
    }
}