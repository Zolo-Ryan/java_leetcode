import java.util.ArrayList;
import java.util.List;

public class Q257BinaryTreePaths {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        binaryTreePaths_1(root,path,ans);
        List<String> finalans = new ArrayList<>();
        for(List<String> it: ans){
            StringBuilder builder = new StringBuilder();
            builder.append("\"");
            int i = 0;
            for(i = 0;i<it.size() - 1;i++){
                builder.append(it.get(i)+"->");
            }
            builder.append(it.get(it.size() -  1)+"\"");
            finalans.add(builder.toString());
        }
        return finalans;
    }
    private List<String> binaryTreePaths_1(TreeNode root, List<String> path, List<List<String>> ans){
        if(root.left == null && root.right == null){
            path.add(root.val+"");
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return path;
        }
        path.add(root.val+"");
        if(root.left != null){
            List<String> left = new ArrayList<>(path);
            binaryTreePaths_1(root.left,left,ans);
        }
        if(root.right != null){
            List<String> right = new ArrayList<>(path);
            binaryTreePaths_1(root.right,right,ans);
        }
        path.remove(path.size() - 1);
        return path;
    }
    public List<String> binaryTreePaths_2(TreeNode root){
        List<String> ans = new ArrayList<>();
        String path = "";
        binaryTreePaths_2(root,path,ans);
        return ans;
    }
    private void binaryTreePaths_2(TreeNode root,String path, List<String> ans){
        if(root == null)
            return;
        path += root.val+"";
        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }
        path+="->";
        binaryTreePaths_2(root.left,path,ans);
        binaryTreePaths_2(root.right,path,ans);
    }
}
