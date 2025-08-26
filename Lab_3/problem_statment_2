public class overload {
    public static void main(String[] args){
        Box one = new Box();
        one.length = 1;
        one.breath = 3;
        one.height = 5;

        System.out.println(one.area());
        one.area(10,20,8);
    }
}


class Box{
    int length;
    int breath;
    int height;

    void area(int length,int breath,int height){
        int all = length*breath*height;
        System.out.println("the area is " + all);
    }

    int area(){
        return length*breath*height;

    }

}
