/**题目3:
设计- 一个股票模拟交易系统。假设我们有一一个很牛叉的AI系统，已经预测到未来一段时间内给定股票的价格，以数组来表示，它的第i个元素是一支给定的股票在第i天的价格。
假设:
1.如果你最多只允许完成两次交易(一次交易是指: 买入和卖出);
2.你有本金K单位(K>=1)，一单位本金可以购买1股票; 这意味着你寻找的是K单位本金条件下最大利润。
提示: K=1的时候最简单，可以先考虑。
设计一个算法来找出最大利润。
解体思路：
对数组进行遍历，求出某点之前的最大利益和某点之后的最大利益，当二者和最大时即为利润最大
*/

public class Test3 {
    public static void main(String[] args){
        int[] n= {1,2,3,7,6,1,77};

        System.out.println("最大利润为"+maxProfit(n));

    }

    public static int maxProfit(int[] n){
        if(n.length==0){
            return 0;
        }
        int i;
        int[] post=n;
        int[] pre=n;
        int minPrice=n[0];
        for (i=1;i<n.length;i++){
            minPrice=min(minPrice,n[i]);
            pre[i]=max(pre[i-1],n[i]-minPrice);
        }

        //计算第i点之后的最大利润post
        int maxPrice=n[n.length-1];
        for (i=n.length-2;i>=0;i--){
            maxPrice=max(maxPrice,n[i]);
            post[i]=max(post[i+1],maxPrice-n[i]);
        }
        int maxProfit=0;
        //计算第i点的，pre[i]与post[i]之和的最大值，赋值给maxProfit
        for (i=0;i<n.length;i++){
            maxProfit=max(maxProfit,pre[i]+post[i]);
        }
        return maxProfit;

    }
    public static int min(int a,int b){
        if(a>b)
            return b;
        if(a<b)
            return a;
        if(a==b)
            return a;
        return 0;
    }
    public static int max(int a,int b){
        if(a>b)
            return a;
        if(a<b)
            return b;
        if(a==b)
            return a;
        return 0;
    }
}
