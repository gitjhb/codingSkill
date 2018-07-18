public class OrderProblemLintCode {

    public static void main(String[] args) {


        int solution = new OrderProblemLintCode().getMinRemaining(new int[]{2,3,2},
new int[][]{{2,2,5},{0,0,0},{1,1,5}});
        System.out.print(solution);

    }

    int mMinValue=Integer.MAX_VALUE;
    public int getMinRemaining(int[] order, int[][] pattern) {
            // Write your code here
            for(int i=0;i<pattern.length;i++){
                int result= substruct(order,pattern[i]);
                if(result==0){
                    mMinValue=0;
                    return 0;
                } else if(result==-1){
                    continue;
                } else {
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

        public int substruct(int[] orders, int[] p){
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
