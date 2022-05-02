public class Test {

    public static void main(String[] args) {
        BigNumber test = new BigNumber("1456898923728323223829362");
        BigNumber test2 = new BigNumber("1456898923728323223829");

        BigNumber test3= new BigNumber("1000000047892489724892");
        BigNumber test4 = new BigNumber("99997832367823671");

        BigNumber test5= new BigNumber("1000000");
        BigNumber test6 = new BigNumber("999978");

        BigNumber test7 = new BigNumber("145555");
        BigNumber test8 = new BigNumber("2555");

        BigNumber test9 = new BigNumber("255");
//        BigNumber test3 = new BigNumber(-123);

        System.out.println(test.toString());
        System.out.println(test2.toString());

        System.out.println(test.compareTo(test2));
        test.add(test2);
        System.out.println(test.toString());

        test3.add(test4);
        System.out.println(test3.toString());

        test5.add(test6);
        System.out.println(test5.toString());

//        test7.div(2);
//        System.out.println(test7.toString());

        System.out.println(test7.toString());
        test9.power(7);
        System.out.println(test9.toString());
        //        test3.sub(test4);
//        System.out.println(test3.toString());
//        System.out.println(test.toString().equals(test2));
    }
}
