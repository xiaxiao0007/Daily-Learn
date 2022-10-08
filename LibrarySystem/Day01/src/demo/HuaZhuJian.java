package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class HuaZhuJian extends JPanel implements KeyListener, ActionListener {
    //声明右侧蛇头
    ImageIcon right = new ImageIcon("image/body.png");
    ImageIcon leftBody = new ImageIcon("image/body.png");

    //声明上下左侧图片
    ImageIcon top = new ImageIcon("");
    ImageIcon bottom = new ImageIcon("");
    ImageIcon left = new ImageIcon("");


    //声明一个初始值，表示蛇的长度为3
    int len = 3;
    //声明两个数组分别存放在x和y坐标的位置
    int[] snakeX = new int[1008];//最大值 = 宽度格子*高度格子
    int[] snakeY = new int[1008];

    //声明一个枚举类型变量，标识蛇头的位置
    Direction direction = Direction.RIGHT;

    //声明一个变量，标记游戏是否开始，当值为true表示开始游戏，否则游戏未开始
    boolean isStart = false;

    //创建一个定时器对象,控制蛇多久时间来动一次
    Timer timer = new Timer(1000*2,this);

    //声明两个变量表示食物的坐标位置
    int foodX;
    int foodY;
    //声明一个随机变量random
    Random random = new Random();
    //声明食物图片
    ImageIcon foodImage = new ImageIcon("image/header.png");

    public HuaZhuJian(){
        //设定蛇的头部和身体的初始位置
        snakeX[0] = 100;
        snakeY[0] = 100;

        snakeX[1] = 75;
        snakeY[1] = 100;

        snakeX[2] = 50;
        snakeY[2] = 100;

        //获取键盘事件
        this.setFocusable(true);
        //添加监听,意思是监听键盘事件,敲击键盘
        this.addKeyListener(this);

        //启动定时器
        timer.start();

        //生成食物的坐标
        foodX = 25+25*random.nextInt(20);
        foodY = 25+25*random.nextInt(20);
    }

    //重写画组件的方法
    @Override
    protected void paintComponent(Graphics g) {
        //调用父类值的方法做一些基本工作，比如边框组件
        super.paintComponent(g);
        //设置背景颜色
        this.setBackground(Color.red);
        //在画布中添加游戏区域
        g.fillRect(0,0,700,900);

        //添加右侧蛇头
        //right.paintIcon(this,g,snakeX[0],snakeY[0]);
        //根据枚举变量方向值，进行判断，显示那个方向的蛇头
        switch (direction){
            case TOP:
                top.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case LEFT:
                left.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case RIGHT:
                right.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case BOTTOM:
                bottom.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
        }


        //添加蛇的两个身体
        /*
        leftBody.paintIcon(this,g,75,100);
        leftBody.paintIcon(this,g,50,100);
        * */
        for (int i = 0; i < len; i++) {
            leftBody.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //判断当前标记游戏是否开始的值isStart如果为false则显示提示信息
        if (!isStart){
            //放上开始提示信息，并设置字体颜色和字体
            g.setColor(Color.white);
            g.setFont(new Font("宋体", Font.BOLD,50));
            g.drawString("请按空格键表示游戏开始",50,500);
        }

        //添加食物
        foodImage.paintIcon(this,g,foodX,foodY);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //判断，当按空格键时数字值应该为32
        if(keyCode == 32){
            //标记游戏状态的值取反
            isStart = !isStart;
            //重新画组件
            repaint();
        }else if(keyCode == KeyEvent.VK_UP){
            direction = Direction.TOP;
        }else if(keyCode == KeyEvent.VK_DOWN){
            direction = Direction.BOTTOM;
        }else if (keyCode == KeyEvent.VK_LEFT){
            direction = Direction.LEFT;
        }else if (keyCode == KeyEvent.VK_RIGHT){
            direction = Direction.RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //当isStart值为true则表示游戏开始，因此移动蛇
        if(isStart) {
            //移动身体,蛇头在数组的 0 下标
            for (int i = len - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            //通过方向值direction进行判断。移动蛇头
            switch (direction) {
                case TOP:
                    //垂直向上移动
                    snakeY[0] -= 25;
                    if (snakeY[0] <= 0) {
                        snakeY[0] = 900;
                    }
                    break;
                case BOTTOM:
                    //垂直向下移动
                    snakeY[0] += 25;
                    if (snakeY[0] >= 900) {
                        snakeY[0] = 0;
                    }
                    break;
                case LEFT:
                    //水平向左移动
                    snakeX[0] -= 25;
                    if (snakeX[0] <= 0) {
                        snakeX[0] = 700;
                    }
                    break;
                case RIGHT:
                    //假如蛇是水平右移
                    snakeX[0] += 25;
                    //判断当前蛇头的值如果超出700.则x值再从0开始
                    if (snakeX[0] >= 700) {
                        snakeX[0] = 0;
                    }
                    break;
            }

            //判断，当蛇头x和食物坐标x一致，并且蛇头y和食物坐标y一致，则表示吃到食物
            if(snakeX[0] == foodX && snakeY[0] == foodY){
                //蛇的长度加1
                len++;
                //重新生成食物的坐标
                foodX = 25+25*random.nextInt(20);
                foodY = 25+25*random.nextInt(20);

            }
            //重新画组件方法
            repaint();
            //重新启动定时器，不断的向右移动
            timer.start();

        }
    }
}
