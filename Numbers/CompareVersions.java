package Numbers;

public class CompareVersions {

    public static void main(String[] args) {

        System.out.println(compareVersion( "0.1", "1.1"));
       // System.out.println(compareVersion( "1.0.1", "1"));
        //System.out.println(compareVersion( "7.5.2.4", "7.5.3"));
    }

    private static int compareVersion(String version1, String version2) {

        int value = 0;

        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;

        while (i < str1.length || i < str2.length) {

            int v1 = (i < str1.length? Integer.parseInt(str1[i]) : 0);
            int v2 = (i < str2.length? Integer.parseInt(str2[i]) : 0);
            System.out.println("v1: "+v1 + ", v2: "+v2);
            if(v1 < v2) return -1;
            else if(v2 < v1) return 1;
            i++;
        }

        return value;

    }
}
