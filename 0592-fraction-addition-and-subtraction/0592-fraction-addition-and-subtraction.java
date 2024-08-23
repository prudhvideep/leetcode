class Solution {
    public String fractionAddition(String exp) {
        int n = exp.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder fs = new StringBuilder();

        int i = 0;
        fs.append(exp.charAt(i++));

        while(i < n){
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-'){
                StringBuilder ret = addFrac(sb,fs);
                sb.setLength(0);
                sb.append(ret);
                fs.setLength(0);
                fs.append(exp.charAt(i));
            }else{
                fs.append(exp.charAt(i));
            }

            i++;
        }

        StringBuilder ret = addFrac(sb,fs);
        sb.setLength(0);
        sb.append(ret); 
        

        return reducedFrac(sb);
    }

    public String reducedFrac(StringBuilder sb){
        StringBuilder ret = new StringBuilder();
        int sign = 0;

        if(sb.charAt(0) == '-'){
            sign = -1;
        }else{
            sign = 1;
        }

        String [] parts = sb.toString().split("/");
        int num = pruneString(parts[0]);
        int den = pruneString(parts[1]);

        int gcdRes = gcd(num,den);

        num = num/gcdRes;
        den = den/gcdRes;

        if(sign == -1){
            ret.append("-");
        }

        ret.append(num);
        ret.append("/");
        ret.append(den);

        return ret.toString();
    }

    public StringBuilder addFrac(StringBuilder a,StringBuilder b){
        StringBuilder res = new StringBuilder();

        if(a == null || a.length() == 0)
        {
            return b;
        }

        if(b == null || b.length() == 0){
            return a;
        }

        int signA,signB,numA,numB,denA,denB;

        if(a.charAt(0) == '-'){
            signA = -1;
        }else{
            signA = 1;
        }


        if(b.charAt(0) == '-'){
            signB = -1;
        }else{
            signB = 1;
        }

        
        String [] partsA = a.toString().split("/");
        numA = pruneString(partsA[0]);
        denA = pruneString(partsA[1]);

        String [] partsB = b.toString().split("/");
        numB = pruneString(partsB[0]);
        denB = pruneString(partsB[1]);
        
        int resA = (signA * numA * denB) + (signB * numB * denA);
        int resB = denA * denB;

        if(resA < 0){
            res.append("-");
            res.append(Math.abs(resA));
        }else{
            res.append("+");
            res.append(resA);
        }

        res.append("/");

        res.append(resB);

        return res;
    } 

    public int pruneString(String s){
        if(s.length() == 0)
            return 0;

        String res = "";

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                res += s.charAt(i);
            }
        }

        return Integer.parseInt(res);
    }

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}