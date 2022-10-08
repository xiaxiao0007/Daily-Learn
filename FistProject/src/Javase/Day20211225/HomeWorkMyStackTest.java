package Javase.Day20211225;

public class HomeWorkMyStackTest {
    public static void main(String[] args) {
        HomeworkArrayMyStack stack = new HomeworkArrayMyStack();
        stack.Push(new Object());
        stack.Push(new Object());
        System.out.println(stack.visit(0));
        System.out.println(stack.getTop());
        Object obj = stack.Pop();
        System.out.println(obj);
        stack.Pop();
        stack.Pop();
    }
}
