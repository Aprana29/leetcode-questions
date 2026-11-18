class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> s =new ArrayList<>();
        backtrack(result,s,candidates, target,0);
        return result;
        
    }
    public void backtrack(List<List<Integer>> result,List<Integer> s,int[] arr,int target ,int index){
        if(index==arr.length){
            if(target==0){
                result.add(new ArrayList<>(s));
                
            }
            return;
        }
        backtrack(result,s,arr,target,index+1);


        if(arr[index]<=target){
            s.add(arr[index]);
            backtrack(result,s,arr,target-arr[index],index);
            s.remove(s.size()-1);

        }

      

        }

}