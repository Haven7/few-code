
    import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

    public class calculate
    {
        // 窗体对象
        private static JFrame frame = null;
        // 面板对象
        private static JPanel pan1 = null;
        private static JPanel pan2 = null;
        private static JPanel pan3 = null;
        private static JPanel pan4 = null;
        private static JPanel pan5 = null;
        // 字体对象
        private static Font font = new Font("楷体", Font.BOLD, 18);
        private static Font font1 = new Font("楷体", Font.BOLD, 28);
        // 创建一个单行文本框
        private static JTextField result = new JTextField();
        //事件对象
        private static MyActionListener mal = new MyActionListener(result);

        static {
            // 初始化窗体。
            frame = new JFrame("计算器");
            // 表格布局7*3，水平和垂直间距为3
            frame.setLayout(new GridLayout(6, 3, 3, 3));
            // 设置关闭按钮
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 显示窗体
            frame.setVisible(true);
            // 大小固定
            frame.setResizable(false);
            // 设置窗体大小以内容大小决定
            frame.pack();
            // 设置文本框字体
            result.setFont(font1);
            // 设置颜色
            result.setDisabledTextColor(new Color(000000));
            // 禁用
            result.disable();
            // 添加单行文本框到窗体
            frame.add(result);
            // 创建pan1面板容器，指定为表格布局，1*4，水平垂直间距为3
            JPanel pan1 = new JPanel(new GridLayout(1, 4, 3, 3));
            // 创建pan2面板容器，指定为表格布局，1*4，水平垂直间距为3
            JPanel pan2 = new JPanel(new GridLayout(1, 4, 3, 3));
            // 创建pan3面板容器，指定为表格布局，1*4，水平垂直间距为3
            JPanel pan3 = new JPanel(new GridLayout(1, 4, 3, 3));
            // 创建pan4面板容器，指定为表格布局，1*4，水平垂直间距为3
            JPanel pan4 = new JPanel(new GridLayout(1, 4, 3, 3));
            // 创建pan4面板容器，指定为表格布局，1*4，水平垂直间距为3
            JPanel pan5 = new JPanel(new GridLayout(1, 4, 3, 3));
            // 定义数组str3数组，并初始化
            String str1[] = {"1", "2", "3", "+" };
            JButton btn1 = null;
            for (int i = 0; i < str1.length; i++) {
                btn1 = new JButton("" + str1[i]);
                // 添加事件
                btn1.addActionListener(mal);
                // 设置按钮字体
                btn1.setFont(font);
                // 把数组中的按钮添加到pan3容器中
                pan1.add(btn1);
            }

            // 定义数组str2数组，并初始化
            String str2[] = {"4", "5", "6", "-" };
            // 创建按钮模型
            JButton btn2 = null;
            for (int i = 0; i < str2.length; i++) {
                btn2 = new JButton("" + str2[i]);
                // 添加事件
                btn2.addActionListener(mal);
                // 设置按钮字体
                btn2.setFont(font);
                // 把数组中的按钮添加到pan2容器中
                pan2.add(btn2);
            }

            // 定义一个str3数组，并初始化
            String str3[] = {"7", "8", "9", "*", };
            // 创建一个空按钮模型btn3
            JButton btn3 = null;
            for (int i = 0; i < str3.length; i++) {
                btn3 = new JButton("" + str3[i]);
                // 添加事件
                btn3.addActionListener(mal);
                // 设置按钮字体
                btn3.setFont(font);
                // 利用循环逐个添加到pan1面板容器中
                pan3.add(btn3);
            }

            // 定义数组str4数组，并初始化
            String str4[] = {"0", "清空", "退格", "/" };
            JButton btn4 = null;
            for (int i = 0; i < str4.length; i++) {
                btn4 = new JButton("" + str4[i]);
                // 添加事件
                btn4.addActionListener(mal);
                // 设置按钮字体
                btn4.setFont(font);
                // 把数组中的按钮添加到pan4容器中
                pan4.add(btn4);
            }

            // 定义数组str5数组，并初始化
            String str5[] = {".", "=" };
            JButton btn5 = null;
            for (int i = 0; i < str5.length; i++) {
                btn5 = new JButton("" + str5[i]);
                // 添加事件
                btn5.addActionListener(mal);
                // 设置按钮字体
                btn5.setFont(font);
                // 把数组中的按钮添加到pan4容器中
                pan5.add(btn5);
            }

            // 添加pan1容器到窗体中
            frame.add(pan1);
            // 添加pan2容器到窗体中
            frame.add(pan2);
            // 添加pan3容器到窗体中
            frame.add(pan3);
            // 添加pan4容器到窗体中
            frame.add(pan4);
            // 添加pan5容器到窗体中
            frame.add(pan5);

        }

        public static void main(String[] args) {
            /**
             * 这里我不知道为什么，放在静态代码块中窗口大小就是无效设置。
             */
            // 窗口大小
            frame.setSize(350, 480);
        }
    }

    class MyActionListener implements ActionListener
    {
        // 上面类中的结果显示面板。
        JTextField result;
        // 对应结果显示面板中的显示内容。
        String show = "";

        // 构造方法，创建对象的时候需要传入，显示面板。
        public MyActionListener(JTextField result) {
            super();
            this.result = result;
        }

        // 监听方法
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取事件源。
            JButton btn = (JButton) e.getSource();
            // 获取事件源的文本信息。
            String text = btn.getText();

            switch (text) {
                case "清空":
                    // 清空操作。
                    show = "";
                    result.setText(show);
                    break;
                case "退格":
                    // 退格操作。
                    if (result.getText().length() != 0) {
                        show = show.substring(0, show.length() - 1);
                        result.setText(show);
                    }
                    break;
                default:
                    // 如果用户第一个输入的不是数字，就不让输入.
                    if (result.getText().length() == 0 && text.equals("+")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals("-")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals("*")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals("/")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals(".")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals("=")) {
                        return;
                    }
                    if (result.getText().length() == 0 && text.equals("0")) {
                        return;
                    }
                    // 如果第二次输入的内容和第一次输入一样都是非数字，就不让输入。
                    if (show.length() != 0) {
                        String substring = show.substring(show.length() - 1);
                        if (substring.equals("+") || substring.equals("-") || substring.equals("*") || substring.equals("/")
                                || substring.equals(".")) {
                            if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")
                                    || text.equals(".")) {
                                return;
                            }
                        }
                    }
                    // 如果输入的是 等于号，就调用方法，获取表达式的正确结果。
                    if (text.equals("=")) {
                        show = execute(show);
                        // 将结果设置到 结果显示面板上。
                        result.setText(show);
                        return;
                    }
                    // 否则就继续添加表达式。
                    else {
                        show += text;
                        result.setText(show);
                    }
                    break;
            }
        }

        // 表達式的結果处理。
        public String execute(String ex) {
            // 使用JS的eval方法计算表达式的结果。

            // 获取JavaScript执行引擎
            ScriptEngineManager m = new ScriptEngineManager();
            // 执行JavaScript代码
            ScriptEngine engine = m.getEngineByName("JavaScript");
            Object rs = null;
            try {
                rs = engine.eval(ex);
            }
            catch (ScriptException e) {
                e.printStackTrace();
            }
            // 当用户除以0 时， 结果为：Infinity 这里当除以0时，正确结果应该是：0
            if (rs.toString().equals("Infinity")) {
                return "0";
            }
            else {
                return rs.toString();
            }
        }

    }

