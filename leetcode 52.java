class Solution {
    int count=0;
    public int totalNQueens(int n) {
        char[][] qu=new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(qu[i],'.');
        }
        help(qu,0,n);
        return count;
    }
    public void help(char[][] qu,int row ,int n){
        if(row==n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(check(qu,row,col,n)){
                qu[row][col]='Q';
                help(qu,row+1,n);
                qu[row][col]='.';
            }
        }
    }
    public boolean check(char[][] qu,int row,int col,int n){
         for(int i=0;i<row;i++){
            if(qu[i][col]=='Q'){
                return false;
            }
         }

         for(int i=row-1,j=col-1;i>=0&&j>=0;j--,i--){
            if(qu[i][j]=='Q'){
                return false;
            }
         }

         for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(qu[i][j]=='Q'){
                return false;
            }
         }
         return true;
    }
}