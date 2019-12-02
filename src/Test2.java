
/**题目2:
给定形如下面的矩阵，
111111
110001
100010
110111
010100
111111
上面矩阵的中的1代表海岸线，0代表小岛。求第二大小岛的面积(即被1中包围的0的
个数，如果只有一个小岛，输出最大小岛的面积)
注意
1.仅求这样的0,该0所在行中被两个1包围，该0所在列中被两个1包围;
2.输入矩阵中包含的小岛K >= 1;
样例输入:
111111
110001
100010
110111
010100
111111
样例输出:
8
解题思路：
 遍历所有的行和列，记录该行或列，最左面和最右面和最上面和最下面1的坐标，然后当遇到0，
 判断是否处于记录的值的中间，是，则是内陆，面积加1，否则不加。
*/
public class Test2 {

    public static void main(String[] args){

        int[] n1={1,1,1,1,1,1};
        int[] n2={1,1,0,0,0,1};
        int[] n3={1,0,0,0,1,0};
        int[] n4={1,1,0,1,1,1};
        int[] n5={0,1,0,1,0,0};
        int[] n6={1,1,1,1,1,1};

        int[][] area={n1,n2,n3,n4,n5,n6};

        index(area);

    }

    public static void index(int[][] area){
        int i,j,t,r,c,sum=0;
        int rowNum=area.length;//确定区域长
        int colNum=area[0].length;//确定区域宽
        for(i=1;i<rowNum;i++){//i=0或j=0肯定不满足，所以从1开始
            for(j=1;j<colNum;j++){
                if(area[i][j]==0){
                    t=0;
                    for(r=i+1;r<rowNum;r++){//下方有1
                        if(area[r][j]==1){
                            t++;
                            break;
                        }
                    }
                    for(r=i-1;r>=0;r--){//上方有1
                        if(area[r][j]==1){
                            t++;
                            break;
                        }
                    }
                    for(c=j+1;c<colNum;c++){//右方有1
                        if(area[i][c]==1){
                            t++;
                            break;
                        }
                    }
                    for(c=j-1;c>=0;c--){//左方有1
                        if(area[i][c]==1){
                            t++;
                            break;
                        }
                    }
                    if(t==4){//如果满足以上四个条件
                        sum++;
                    }
                }
            }
        }

        System.out.println("小岛面积为"+sum);
    }
}
