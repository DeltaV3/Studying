
public class Find_the_maximun {
    public int TheMaximunAchievable(int num, int t) {
        return num + 2*t;
    }
    public static void main(String[] args) {
        Find_the_maximun obj = new Find_the_maximun();
        int a = obj.TheMaximunAchievable(3, 2);
        System.out.println(a);
    }
}