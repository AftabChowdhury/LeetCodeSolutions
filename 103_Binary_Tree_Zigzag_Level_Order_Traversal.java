/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        //Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        boolean leftToright = true;
        while (!list.isEmpty()) {
            int levelSize = list.size();
            List<Integer> level = new ArrayList<>();
            
            if(leftToright){
              for (int i = 0; i < levelSize; i++) {
                TreeNode node = list.remove(0);
                level.add(node.val);
                        
                if (node.left != null) {
                    list.add(node.left);
                }

                if (node.right != null) {
                    list.add(node.right);
                } 
                                         
              }     
            } else{
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = list.remove(list.size() - 1);
                    level.add(node.val);

                    if (node.right != null) {
                        list.add(0,node.right);
                    } 
                    if (node.left != null) {
                        list.add(0,node.left);
                    }

                }  
            }  
            
            result.add(level);
            leftToright=!leftToright;
        }
        
        return result;
    }
}