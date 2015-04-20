package LinkedIn;

/**
 * Created by Trace_route on 11/3/14.
 */
public class SysmeticalTree{
    public boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null && b ==null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return isSymmetric(a.left,b.right) && isSymmetric(a.right,b.left);
    }
}
