import java.util.Arrays;
/**
 *题目1:
 给定一组数字，一组有9个数字，将这9个数字填写到3*3的九宫格内; 使得横，竖,斜对角条线一上的三个数字之和相等; 如果无解则打印无解;
 算法解释：
 如下将9宫格视为一个二维数组，先将9个数字依次填入格中，然后查看是否满足横、竖、斜一条线之和相等。满足就输出，不满足则无解。
 [0][0] [0][1] [0][2]
 [1][0] [1][1] [1][2]
 [2][0] [2][1] [2][2]
 */
public class Test1 {

    public static void main(String[] args){

        int[] n={3,4,1,2,5,6,7,8,9};//例
        suduku(n);
    }

    public static void suduku(int[] n){
        Arrays.sort(n);//把数组从小到大排序
        int x=0,y=1;
        int[][] m = new int[3][3];//九宫格视为一个数组
        m[x][y]=n[0];//把数组第一个数放在九宫格第一行中间
        int i,a,b;
        for(i=1;i<9;i++){
            a=x-1;
            b=y+1;//依次斜填
            if(a<0){//上出框往下填
                a=2;
            }
            if(b>2){//右出框往左填
                b=0;
            }
            if (m[a][b]!=0){//排重在下格填，右上排重一样
                a=x+1;
                b=y;
            }
            m[a][b]=n[i];//赋值
            x=a;
            y=b;
        }
        //计算九宫格中每一行，列，斜对角线上的值
        int row1=m[0][0]+m[0][1]+m[0][2];
        int row2=m[1][0]+m[1][1]+m[1][2];
        int row3=m[2][0]+m[2][1]+m[2][2];
        int col1=m[0][0]+m[1][0]+m[2][0];
        int col2=m[0][1]+m[1][1]+m[2][1];
        int col3=m[0][2]+m[1][2]+m[2][2];
        int dig1=m[0][0]+m[1][1]+m[2][2];
        int dig2=m[2][0]+m[1][1]+m[0][2];
        //比较横竖斜方向上的的值是否相等
        if(row1==row2 && row1==row3&& row1==col1&&row1==col2&&row1==col3&&row1==dig1&&row1==dig2){
            for (i=0;i<3;i++)
                System.out.println ( Arrays.toString (m[i]));
        }else{
            System.out.println("无解");
        }

    }
}
