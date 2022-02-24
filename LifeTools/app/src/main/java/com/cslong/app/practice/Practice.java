package com.cslong.app.practice;

import com.cslong.app.myutil.LogUtil;

public class Practice {

    public static void main(String[] arg){

        numDistince("babgbag","bag");
    }


  //https://www.cnblogs.com/huststl/p/8664608.html 动态规划参考
    public static int numDistince(String s,String t){
        LogUtil.LogTitle("不同的子序列-字符串-动态规划");

        int n1 = s.length();
        int n2 = t.length();

        int [][]dp = new int[n1+1][n2+1];

        for (int i=0;i<=n1;i++){
            dp[i][0] = 1;
        }

        LogUtil.LogI("dp初始化后的数组输出一下：");

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                System.out.print(dp[i][j]+",");
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }

            System.out.println("");

            System.out.println("每一行执行完毕后的结果");

            for(int it=0;it<dp.length;it++){
                for(int jt=0;jt<dp[it].length;jt++){
                    System.out.print(dp[it][jt]+",");
                }
                System.out.println();
            }

        }

        System.out.println("最后结果:");

        for(int it=0;it<dp.length;it++){
            for(int jt=0;jt<dp[it].length;jt++){
                System.out.print(dp[it][jt]+",");
            }
            System.out.println();
        }

        System.out.println("最后结果:"+dp[n1][n2]);
        return dp[n1][n2];


    }



}
