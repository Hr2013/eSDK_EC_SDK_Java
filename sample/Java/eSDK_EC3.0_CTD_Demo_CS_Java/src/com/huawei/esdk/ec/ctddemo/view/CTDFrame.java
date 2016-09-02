package com.huawei.esdk.ec.ctddemo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.LineMetrics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.huawei.esdk.ec.ctddemo.util.*;




public class CTDFrame extends JFrame
{
    private static final long serialVersionUID = -2831223779613689791L;

    private JLabel urlLabel = new JLabel("eSDK URL");

    private JLabel userLabel = new JLabel("用户名");

    private JLabel pwdLabel = new JLabel("密码");

    private JButton ctdBtn = new MyButton("点击呼叫");

    private JLabel accountLabel = new JLabel("操作者EC账号");

    private JLabel callerLabel = new JLabel("主叫号码");

    private JLabel calleeLabel = new JLabel("被叫号码");

    private JLabel retCodeLabel = new JLabel("返回码");

    private JLabel retDescLabel = new JLabel("返回信息");

    private JLabel errInfoLabel = new JLabel();

    private JTextField urlField = new JTextField(26);

    private JTextField userField = new JTextField(10);

    private JPasswordField pwdField = new JPasswordField(10);

    private JTextField accountField = new JTextField(20);

    private JTextField callerField = new JTextField(20);

    private JTextField calleeField = new JTextField(20);

    private JTextField retCodeField = new JTextField(20);

    private JTextArea retDescArea = new JTextArea(4, 20);

    private int timerCount = 0;

    private CTDFrame()
    {
        add(getPanels());

        init();
    }

    private JPanel getPanels()
    {
        // 主面板
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel(gridbag);

        buildPanel(panel, gridbag, c, new JComponent[] {urlLabel}, 0, 0, 10, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {urlField}, 1, 0, 100, 20, 2, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {userLabel}, 3, 0, 10, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {userField}, 4, 0, 100, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {pwdLabel}, 5, 0, 10, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {pwdField}, 6, 0, 100, 20, 1, 1);
        c.insets = new Insets(0, 150, 0, 0);
        buildPanel(panel, gridbag, c, new JComponent[] {new JLabel("输入参数")}, 2, 1, 50, 20, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);
        buildPanel(panel, gridbag, c, new JComponent[] {accountLabel}, 3, 2, 50, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {accountField}, 4, 2, 50, 20, 1, 1);

        buildPanel(panel, gridbag, c, new JComponent[] {callerLabel}, 3, 3, 50, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {callerField}, 4, 3, 50, 20, 1, 1);

        buildPanel(panel, gridbag, c, new JComponent[] {calleeLabel}, 3, 4, 50, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {calleeField}, 4, 4, 50, 20, 1, 1);

        buildPanel(panel, gridbag, c, new JComponent[] {ctdBtn}, 3, 5, 200, 80, 2, 1);

        c.insets = new Insets(0, 150, 0, 0);
        buildPanel(panel, gridbag, c, new JComponent[] {new JLabel("返回参数")}, 2, 6, 50, 20, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);

        buildPanel(panel, gridbag, c, new JComponent[] {retCodeLabel}, 3, 7, 50, 20, 1, 1);
        buildPanel(panel, gridbag, c, new JComponent[] {retCodeField}, 4, 7, 50, 20, 1, 1);

        buildPanel(panel, gridbag, c, new JComponent[] {retDescLabel}, 3, 8, 50, 80, 1, 1);
        retDescArea.setLineWrap(true);
        retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
        buildPanel(panel, gridbag, c, new JComponent[] {new JScrollPane(retDescArea)}, 4, 8, 50, 20, 1, 1);

        buildPanel(panel, gridbag, c, new JComponent[] {errInfoLabel}, 3, 9, 100, 5, 2, 1);

        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 15),
            "CTD呼叫",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new java.awt.Font("宋体", Font.BOLD, 20)));
        return panel;
    }

    private void buildPanel(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
        int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight)
    {
        //初始化面板
        JPanel subPanel = new JPanel();

        for (JComponent component : components)
        {
            component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
            subPanel.add(component);
        }

        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.WEST;

        c.gridx = gridx;
        c.gridy = gridy;
        c.ipadx = ipadx;
        c.ipady = ipady;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        gridbag.setConstraints(subPanel, c);
        panel.add(subPanel);
    }

    private void init()
{
        urlField.setText("http://172.22.9.42:8086");
        userField.setText("esdk_user");
        pwdField.setText("Huawei@123");

        this.ctdBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                showErrInfoWithColor("");
                retCodeField.setText("");
                retDescArea.setText("");

                boolean flag =
                    validateParams(new JTextField[] {urlField, userField, pwdField, accountField, callerField,
                        calleeField}, new String[] {"eSDK URL", "用户名", "密码", "操作者EC账号", "主叫号码", "被叫号码"});

                if (!flag)
                {
                    return;
                }
                begin();
                loading();

                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        call();
                    }
                }).start();
            }
        });

    }

    private void call()
    {
        Map<String, String> m = new HashMap<String, String>();
        m.put("account", accountField.getText());
        m.put("caller", callerField.getText());
        m.put("callee", calleeField.getText());
        try
        {
            Map<String, String> reponseMap =
                RestUtils.getInstance(urlField.getText(), userField.getText(), String.valueOf(pwdField.getPassword()))
                    .sendMessage(m, "/ec/appserver/ctd");
            finish();
            if (null == reponseMap)
            {
                retCodeField.setText("1");
                retDescArea.setText("失败");
                showErrInfoWithColor("操作失败");
            }
            else
            {
                retCodeField.setText(reponseMap.get("resultCode"));
                retDescArea.setText(reponseMap.get("resultContext"));

                if ("0".equals(reponseMap.get("resultCode")))
                {
                    showErrInfoWithColor("操作成功");
                }
                else
                {
                    showErrInfoWithColor("操作失败");
                }
            }
        }
        catch (Exception e)
        {
   finish();
            retCodeField.setText("1");
            retDescArea.setText("失败");
            showErrInfoWithColor("操作失败");
        }
    }

    private boolean validateParams(JTextField[] textFields, String[] errTexts)
    {
        for (int i = 0; i < textFields.length; i++)
        {
            if (null == textFields[i] || null == textFields[i].getText() || "".equals(textFields[i].getText()))
            {
                showErrInfoWithColor(errTexts[i] + "不能为空！");
                return false;
            }

            if (errTexts[i].contains("号码"))
            {
                if (!textFields[i].getText().matches("\\d+"))
                {
                    showErrInfoWithColor(errTexts[i] + "格式不对！");
                    return false;
                }
            }
        }

        return true;
    }

    private void showErrInfoWithColor(String errInfo)
    {
        if (errInfo == null)
        {
            return;
        }

        errInfoLabel.setForeground(Color.red);
        errInfoLabel.setText(errInfo);
    }

    private void begin()
    {
        timerCount = 0;
    }

    private void finish()
    {
        timerCount = -1;
    }

    private void loading()
    {
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                if (timerCount < 0)
                {
                    return;
                }

                if (timerCount < 5)
                {
                    timerCount++;
                }
                else
                {
                    timerCount = 0;
                }

                String temp = "";
                for (int i = 0; i < timerCount; i++)
                {
                    temp += ". ";
                }

                temp = "正在请求" + temp;
                showErrInfoWithColor(temp);

                loading();
            }
        }, 250);
    }

    private static void run(JFrame frame, int width, int height)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        frame.setTitle("CTD呼叫");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/" + "logo.png")));
    }

    public static void execute()
    {
        run(new CTDFrame(), 1240, 800);
    }

    public static void main(String[] args)
    {
        execute();
    }
}

class MyButton extends JButton
{
    private static final long serialVersionUID = -5091102180245292855L;

    private static final int NORMAL = 0;

    private static final int FOCUSED = 1;

    private static final int PRESSED = 2;

    private static final int RELEASED = 3;

    private String text;

    private int state = NORMAL;

    Shape shape;

    MyButton(String text)
    {
        super(text);
        this.text = text;
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (state == NORMAL)
        {
            Color[] colors = {new Color(255, 255, 255, 0), new Color(150, 150, 150, 255)};
            paintButton(g, colors);
        }
        else if (state == FOCUSED)
        {
            Color[] colors = {new Color(255, 255, 255, 0), new Color(12, 150, 150, 255)};
            paintButton(g, colors);
        }
        else if (state == PRESSED)
        {
            Color[] colors = {new Color(255, 255, 255, 0), new Color(150, 12, 150, 255)};
            paintButton(g, colors);
        }
        else if (state == RELEASED)
        {
            Color[] colors = {new Color(255, 255, 255, 0), new Color(150, 150, 12, 255)};
            paintButton(g, colors);
        }

        addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                state = FOCUSED;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                state = NORMAL;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                state = PRESSED;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                state = RELEASED;
                repaint();
            }

        });

    }

    private void paintButton(Graphics g, Color[] colors)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = this.getWidth();
        int height = this.getHeight();

        Point2D center = new Point2D.Float(width / 2, height / 2);
        float radius = width / 2;
        float[] dist = {0.0f, 0.8f};
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, dist, colors);
        g2.setPaint(paint);
        shape = new RoundRectangle2D.Double(0, 0, width, height, height, height);
        g2.fill(shape);

        Font defaultFont = getFont();
        g2.setFont(defaultFont);
        g2.setColor(Color.BLACK);
        Rectangle2D rect = defaultFont.getStringBounds(text, g2.getFontRenderContext());
        LineMetrics lineMetrics = defaultFont.getLineMetrics(text, g2.getFontRenderContext());
        g2.drawString(text,
            (float)(width / 2 - rect.getWidth() / 2),
            (float)((height / 2) + ((lineMetrics.getAscent() + lineMetrics.getDescent()) / 2 - lineMetrics.getDescent())));

    }

    @Override
    public boolean contains(int x, int y)
    {
        if (null == shape || !shape.contains(x, y))
        {
            return false;
        }

        return true;
    }
}