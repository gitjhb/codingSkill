public class OrderProblemLintCode {

    /**
     *
     * Description
     There is now an order with demand for n items, and the demand for the i-th item is order[i].
     The factory has m production modes. Each production mode is shaped like [p[1],p[2],...p[n]],
     that is, produce p[1] first items, p[2] second items... You can use multiple production modes.
     Please tell me how many items do not meet the demand at least in the case of not exceeding the demand of any kind of items?

     Example
     Given order=[2,3,1], pattern=[[2,2,0],[0,1,1],[1,1,0]] , return 0.

     Explanation:
     Use [0,1,1] once, [1,1,0] twice, remaining [0,0,0].
     Given order=[2,3,1], pattern=[[2,2,0]] , return 2.

     Explanation:
     Use [2,2,0] once, remaining [0,1,1].
     */


    public static void main(String[] args) {
        int solution = new OrderProblemLintCode().getMinRemaining(new int[]{2,3,2},
new int[][]{{2,2,5},{0,0,0},{1,1,5}});
        System.out.print(solution);
    }

    int mMinValue=Integer.MAX_VALUE; //This is for tracking the min value

    public int getMinRemaining(int[] order, int[][] pattern) {
            for(int i=0;i<pattern.length;i++){
                int result= subtract(order,pattern[i]);
                if(result==0){ //This means remaining of the order is 0, so return 0
                    mMinValue=0;
                    return 0;
                } else if(result==-1){ //Order can't be over production {2,3,2} - {2,2,5} = {0,1,-3} then skip this pattern[i]
                    continue;
                } else {
                    //Order has been produced and total remain>0
                    mMinValue=Math.min(mMinValue,result);
                    if(getMinRemaining(order,pattern)==0){
                        return 0;
                    }
                    add(order,pattern[i]);
                }

            }

            return Math.min(mMinValue,totalRemain(order));
        }

        public int totalRemain(int[] orders){
            int remain=0;
            for(int i=0;i<orders.length;i++){
                remain+=orders[i];
            }

            return remain;
        }

        public int subtract(int[] orders, int[] p){
            int result=0;
            int numOfZeroP=0;
            for(int i=0;i<orders.length;i++){
                if(p[i]==0){
                    numOfZeroP++;
                }

                int remain=orders[i]-p[i];
                if(remain<0){
                    return -1;
                } else if(remain>0) {
                    result+=remain;
                }
            }

            if(numOfZeroP==p.length){
                return -1;
            }

            for(int i=0;i<orders.length;i++){
                orders[i]=orders[i]-p[i];
            }

            return result;
        }

        public void add(int[] orders, int[] p){
            for(int i=0;i<orders.length;i++){
                orders[i]=orders[i]+p[i];
            }
        }
}
