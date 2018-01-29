public class MonkeyPeachProblem {
    public static void main(String...args){
        System.out.println(getCount(5));
    }

    public static double getCount(int monkey_num){
        return monkey_num == 1 ? 6 : getCount(monkey_num-1)*1.25 + 1;
    }
}
