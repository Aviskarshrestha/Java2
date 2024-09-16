
public class ASum {

    public static long findNb(Double m) {
        if(m<=0){
            return -1;
        }
        return findNb(m,1.0,1.0).longValue();
    }
    private static Double findNb(Double m,Double n,Double sum) {
        System.out.println(n);
        sum+=pow(n+1);
        if(sum==m){
            return n+1;
        }
        if(sum>m){
            return -1.0;
        }

        return findNb(m,n+1,sum);
    }
    private static Double pow(Double n){
        return n*n*n;
    }
    public static void main(String[] args) {
        long x=ASum.findNb(91716553919377.0);
        System.out.println(x);
    }
}