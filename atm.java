import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
class Bank extends JFrame implements ActionListener
{ 
    JLabel loginLabel,picLabel;
    JButton button;
    JLabel atmnoLabel,pinLabel,optionLabel,balanceLabel,amountLabel;
    ImageIcon image;
    CardLayout card;
  JPanel panel,loginPanel,introPanel,operationsPanel,depositPanel,pinPanel,balancePanel,enquiryPanel;
  JPanel ip,lp,op,dp,pp,bp,ep;
  JTextField atmTextField;
  JPasswordField pinTextField;
  JButton introButton,pinCheckButton;
  JButton withdrawButton,enquiryButton,depositButton,balancecheckButton,pinchangeButton,exitButton;
  JButton one,two,three,four,five,six,seven,eight,nine,zero,enter,cancel,back,prev;
  JButton pinchanging;
  JLabel oldpinLabel,newpinLabel,pinchangeLabel;
  JPasswordField oldpinTextField,newpinTextField;
  JLabel depositandWithdrawLabel1,depositandWithdrawLabel2, depositandWithdrawLabel3;
  JTextField depositandWithdrawTextfield;
  TextArea ta;
  String pin="1234";
  Font f,ff,fff;
  int turns=0;
  int balance=1000;
  Bank()
  {
    setSize(1500,1500);
    setTitle("BANK INTERFACE");
    card=new CardLayout();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel=new JPanel();
    panel.setBounds(0,0,1500,1500);
    panel.setBackground(Color.gray);
    panel.setLayout(card);
     f=new Font("Arial",Font.BOLD,40);
     ff=new Font("consolas",Font.BOLD,30);
     fff=new Font("consolas",Font.BOLD,20);
    loginPanel=Login();
    introPanel=Intro();
    operationsPanel=Operation();
    depositPanel=DepositandWithdraw();
    pinPanel=Pinchange();
    balancePanel=Balancecheck();
    enquiryPanel=EnquiryCheck();
    panel.add(loginPanel,"LOGGING");
    panel.add(introPanel,"INTROS");
    panel.add(operationsPanel,"OPERATIONS");
    panel.add(depositPanel,"DEPOSITS");
    panel.add(pinPanel,"PIN CHANGE");
    panel.add(balancePanel,"BALANCE");
    panel.add(enquiryPanel,"ENQUIRIES");
    showPanel("INTROS");
    setLocationRelativeTo(null);
    this.getContentPane().add(panel);
    setVisible(true);
  }
  private JPanel Intro()
  {
    ip=new JPanel();
    ip.setLayout(null);
    ip.setSize(1500,1500);
    ip.setOpaque(true);
    ip.setBackground(new Color(255,255,204));
    Font font=new Font("ARIAL",Font.TYPE1_FONT,100);
    JLabel label=new JLabel("A T M");
    label.setFont(font);
    label.setBounds(550,200,300,100);
    label.setForeground(new Color(0,0,0));
    ip.add(label);
    introButton=new JButton("START");
    introButton.addActionListener(e-> showPanel("LOGGING")); 
    introButton.setBounds(630,450,100,50);
    introButton.setBackground(Color.WHITE);
    introButton.setForeground(new Color(153,0,0));
    introButton.setFont(fff);
    introButton.setFocusable(false);
    ip.add(introButton);
    LineBorder l=new LineBorder(Color.black,5);
    ip.setBorder(l);
    return ip;
  }
  private JPanel Login()
  {  
    lp=new JPanel();
    lp.setLayout(null);
    lp.setSize(1500,1500);
    lp.setBackground(Color.GRAY);
    JPanel llp=new JPanel();
    llp.setLayout(null);
    llp.setBounds(500,100,400,400);
    loginLabel=new JLabel("LOGIN");
    loginLabel.setBounds(150,10,200,100);
    loginLabel.setFont(f);
    atmnoLabel=new JLabel("ATM NO:");
    atmnoLabel.setBounds(50,120,150,100);
    atmnoLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
    atmTextField=new JTextField();
    atmTextField.setBounds(200,160,150,30);
    pinLabel=new JLabel("PIN:");
    pinLabel.setBounds(50,180,100,100);
    pinLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
    pinTextField=new JPasswordField();
    pinTextField.setBounds(200,210,150,30);
    pinCheckButton=new JButton("CHECK");
    pinCheckButton.setForeground(new Color(153,0,0));
    pinCheckButton.setFont(fff);
    pinCheckButton.addActionListener(this);
    pinCheckButton.setBounds(150,280,100,50);
    llp.add(loginLabel);
    llp.add(atmTextField);
    llp.add(atmnoLabel);
    llp.add(pinLabel);
    llp.add(pinTextField);
    llp.add(pinCheckButton);
    LineBorder line=new LineBorder(Color.black, 3);
    llp.setBorder(line);
    lp.add(llp);
    return lp;
  }
  private JPanel Operation()
  {
    JPanel p=new JPanel();
    p.setLayout(null);
    p.setSize(1500, 1500);
    p.setOpaque(true);
    p.setBackground(new Color(255,255,204));
    JPanel oop=new JPanel();
    oop.setLayout(null);
    oop.setBounds(500,250,400,230);
    optionLabel=new JLabel("--Select option--");
    optionLabel.setBounds(550,100,500,150);
    optionLabel.setFont(f);
    p.add(optionLabel);
    withdrawButton=new JButton("WITHDRAWAL"); depositButton=new JButton("DEPOSIT");
    balancecheckButton=new JButton("BANK BALANCE"); enquiryButton=new JButton("ENQUIRY");
    pinchangeButton=new JButton("CHANGE PIN"); exitButton=new JButton("EXIT");
    depositButton.setBounds(50,30,140,40);
    balancecheckButton.setBounds(50,90,140,40);
    enquiryButton.setBounds(220,90,140,40);
    withdrawButton.setBounds(220,30,140,40);
    pinchangeButton.setBounds(50,150,140,40);
    exitButton.setBounds(220,150,140,40);
    withdrawButton.setBackground(Color.black); balancecheckButton.setBackground(Color.black);
    depositButton.setBackground(Color.black); enquiryButton.setBackground(Color.black);
    pinchangeButton.setBackground(Color.black); exitButton.setBackground(Color.black);
    withdrawButton.setForeground(Color.white); balancecheckButton.setForeground(Color.white);
    depositButton.setForeground(Color.white);  enquiryButton.setForeground(Color.white);
    pinchangeButton.setForeground(Color.white);  exitButton.setForeground(Color.white);
    oop.add(withdrawButton);  oop.add(depositButton); oop.add(enquiryButton);
    oop.add(balancecheckButton); oop.add(pinchangeButton); oop.add(exitButton);
    LineBorder line=new LineBorder(Color.black, 3);
    oop.setBorder(line);
    withdrawButton.addActionListener(this);
    balancecheckButton.addActionListener(this);
    depositButton.addActionListener(this);
    enquiryButton.addActionListener(this);
    pinchangeButton.addActionListener(this);
    exitButton.addActionListener(e->System.exit(0));
    p.add(oop);
    return p;
  }
  private JPanel DepositandWithdraw()
  {
    dp=new JPanel();
    dp.setLayout(null);
    dp.setSize(1500,1500);
    JPanel dpp=new JPanel();
    dpp.setLayout(null);
    dpp.setBounds(550,100,350,200);
    dpp.setBackground(new Color(51,153,255));
    depositandWithdrawLabel1=new JLabel("ENTER AMOUNT");
    depositandWithdrawLabel1.setBounds(40,20,300,30);
    depositandWithdrawLabel1.setFont(fff);
    dpp.add(depositandWithdrawLabel1);
     depositandWithdrawLabel2=new JLabel("(in Rs.100,500,1000)");
      depositandWithdrawLabel2.setBounds(100,35,500,50);
     dpp.add( depositandWithdrawLabel2);
     depositandWithdrawTextfield=new JTextField();
     depositandWithdrawTextfield.setBounds(40,80,200,30);
     dpp.add(depositandWithdrawTextfield);
     LineBorder l=new LineBorder(Color.black,3);
     dpp.setBorder(l);
    JPanel ddpp=new JPanel();
    ddpp.setLayout(null);
    ddpp.setBounds(550,350,350,300);
    ddpp.setBackground(Color.gray);
    one=new JButton("1"); two=new JButton("2"); three=new JButton("3");four=new JButton("4");
    five=new JButton("5"); six=new JButton("6"); seven=new JButton("7"); eight=new JButton("8");
    nine=new JButton("9"); zero=new JButton("0"); enter=new JButton("ENTER");
    cancel=new JButton("CANCEL"); back=new JButton("BACK"); prev=new JButton("PREV");
    one.setBounds(20,20,50,50); two.setBounds(90,20,50,50);
    three.setBounds(160,20,50,50); four.setBounds(20,90,50,50);
    five.setBounds(90,90,50,50); six.setBounds(160,90,50,50);
    seven.setBounds(20,160,50,50); eight.setBounds(90,160,50,50);
    nine.setBounds(160,160,50,50); zero.setBounds(160,230,50,50);
    enter.setBounds(230,20,100,80); cancel.setBounds(230,115,100,80); 
    back.setBounds(230,210,100,80); prev.setBounds(20,230,120,50); 
    ddpp.add(one); ddpp.add(two); ddpp.add(three); ddpp.add(four);ddpp.add(five);ddpp.add(six);
    ddpp.add(seven);ddpp.add(eight);ddpp.add(nine); ddpp.add(zero); ddpp.add(enter); ddpp.add(cancel);
    ddpp.add(back); ddpp.add(prev);
    one.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"1"));
    two.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"2"));
    three.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"3"));
    four.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"4"));
    five.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"5"));
    six.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"6"));
    seven.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"7"));
    eight.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"8"));
    nine.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"9"));
    zero.addActionListener(e->depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText()+"0"));
    enter.addActionListener(this);
    cancel.addActionListener(e->depositandWithdrawTextfield.setText(""));
    prev.addActionListener(e->showPanel("OPERATIONS"));
    back.addActionListener(this);
    ddpp.setBorder(new LineBorder(Color.black,3));
    dp.add(ddpp);
    dp.add(dpp);
    return dp;
  }
  private String toString(char[] password) {
    String s=new String(password);
    return s;
  }
  private JPanel Pinchange()
  {
    pp=new JPanel();
    pp.setLayout(null);
    pp.setSize(1500,1500);
    JPanel ppp=new JPanel();
    ppp.setLayout(null);
    ppp.setBounds(500,100,400,400);
    ppp.setBackground(Color.white);
    pinchangeLabel=new JLabel("PIN CHANGE");
    pinchangeLabel.setBounds(150,10,200,100);
    pinchangeLabel.setFont(ff);
    oldpinLabel=new JLabel("OLD PIN:");
    oldpinLabel.setBounds(50,120,150,100);
    oldpinLabel.setFont(ff);
    oldpinTextField=new JPasswordField();
    oldpinTextField.setBounds(200,150,150,30);
    newpinLabel=new JLabel("NEW PIN:");
    newpinLabel.setBounds(50,180,150,100);
    newpinLabel.setFont(ff);
    newpinTextField=new JPasswordField();
    newpinTextField.setBounds(200,210,150,30);
    pinchanging=new JButton("CHANGE");
    pinchanging.addActionListener(this);
    pinchanging.setBounds(150,280,100,50);
    pinchanging.addActionListener(this);
    ppp.add(pinchangeLabel);
    ppp.add(oldpinLabel);
    ppp.add(oldpinTextField);
    ppp.add(newpinLabel);
    ppp.add(newpinTextField);
    ppp.add(pinchanging);
    LineBorder line=new LineBorder(Color.black, 3);
    ppp.setBorder(line);
    pp.add(ppp);
    return pp;
  }
  private JPanel Balancecheck()
  {
    bp=new JPanel();
    bp.setLayout(new BorderLayout());
    bp.setSize(1500,1500);
    JPanel p=new JPanel();
    p.setLayout(null);
    p.setSize(1400,1400);
    balanceLabel=new JLabel("YOUR BALANCE:");
    balanceLabel.setBounds(500,200,600,100);
    balanceLabel.setFont(new Font(Font.SERIF,Font.BOLD,50));
    p.add(balanceLabel);
    amountLabel=new JLabel(""+balance);
    amountLabel.setBounds(650,300,500,100);
    amountLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));
    p.add(amountLabel);
    p.setBackground(new Color(51,153,255));
    LineBorder line=new LineBorder(Color.black, 5);
    p.setBorder(line);
    JButton b=new JButton("EXIT");
    b.addActionListener(e->System.exit(0));
    JButton b1=new JButton("PROCEED");
    b1.addActionListener(e->showPanel("OPERATIONS"));
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
    buttonPanel.add(b1);
    buttonPanel.add(b);
    buttonPanel.setPreferredSize(new Dimension(50,50));
    bp.add(p,BorderLayout.CENTER);
    bp.add(buttonPanel,BorderLayout.SOUTH);
    return bp;
  }
  private JPanel EnquiryCheck()
  {
    ep=new JPanel();
    ep.setLayout(new BorderLayout());
    ep.setSize(1500,1500);
    ta=new TextArea(25,1);
    JLabel l=new JLabel("TRANSACTION HISTORY");
    l.setFont(new Font(Font.SERIF,Font.BOLD,50));
    ep.add(l,BorderLayout.NORTH);
    ta.setBackground(Color.white);
    ta.setFont(new Font("arial",Font.BOLD,20));
    JButton b=new JButton("EXIT");
    b.addActionListener(e->System.exit(0));
    JButton b1=new JButton("PROCEED");
    b1.addActionListener(e->showPanel("OPERATIONS"));
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
    buttonPanel.add(b1);
    buttonPanel.add(b);
    b1.setForeground(new Color(102,51,0));
    b.setForeground(new Color(102,51,0));
    buttonPanel.setPreferredSize(new Dimension(50,50));
    JScrollPane sc=new JScrollPane(ta);
    ep.add(sc,BorderLayout.CENTER);
    ep.add(buttonPanel,BorderLayout.SOUTH);
    return ep;
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==pinCheckButton)
    {
    if(toString(pinTextField.getPassword()).equals(pin))
    {
        showPanel("OPERATIONS");
    }
    else
    {
       turns++;
       if(turns<3)
       {
       JOptionPane.showMessageDialog(this,"WRONG PIN");
       }
       else
       {
        JOptionPane.showMessageDialog(this,"ATTEMPTS OVER!\n ...EXITING TRANSACTION...");
        System.exit(0);
       }
       atmTextField.setText("");
       pinTextField.setText("");
    }
  }  
      if (e.getSource() == depositButton && button != depositButton) {
        button = depositButton;
        depositandWithdrawLabel1.setText("ENTER DEPOSIT AMOUNT");
        showPanel("DEPOSITS");   
        }
  else if (e.getSource() == withdrawButton && button != withdrawButton) {
        button = withdrawButton;
        depositandWithdrawLabel1.setText("ENTER WITHDRAW AMOUNT");
        showPanel("DEPOSITS");
        }
   else if (e.getSource() == enter) {
    if(Integer.parseInt(depositandWithdrawTextfield.getText())%100==0)
        {
        int amount = Integer.parseInt(depositandWithdrawTextfield.getText());

        if (button == depositButton) {
            balance = deposit(amount);
            JOptionPane.showMessageDialog(this, "....SUCCESSFULLY DEPOSITED....");
        } else if (button == withdrawButton) {
          if(balance>amount)
          {
            balance = withdrawal(amount);
            JOptionPane.showMessageDialog(this, "....SUCCESSFULLY WITHDRAWN....");
          }
          else{
             JOptionPane.showMessageDialog(this, "....INSUFFICIENT BALANCE....");
          }
        }
      }
       else
        {
           JOptionPane.showMessageDialog(this,"ENTER RUPEES IN MULTIPLES OF 50,100,1000");
           depositandWithdrawTextfield.setText(""); 
          return; 
        }

        depositandWithdrawTextfield.setText("");
        showPanel("OPERATIONS");
    }

  if(e.getSource()==enquiryButton)
  {
    showPanel("ENQUIRIES");
  }
  if(e.getSource()==balancecheckButton)
  {
    ta.append("\n\nTotal BALANCE   -   ");
    ta.append(balance+"\n");
    showPanel("BALANCE");
  }
  if(e.getSource()==pinchangeButton)
  {
     showPanel("PIN CHANGE");
  } 
 
  if(e.getSource()==back)
  {
    depositandWithdrawTextfield.setText(depositandWithdrawTextfield.getText().substring(0,depositandWithdrawTextfield.getText().length()-1));
  }
  if(e.getSource()==pinchanging)
  {
    int sel=JOptionPane.showConfirmDialog(this,"Do you want to update your pin?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(sel==JOptionPane.YES_OPTION)
    {
      pin=newpinTextField.getText();
    }   
    else if(sel==JOptionPane.NO_OPTION)
    {

    }
    pinTextField.setText("");
    showPanel("LOGGING");
  }
}
 public int deposit(int deposits)
  {
    balance+=deposits;
    amountLabel.setText("" + balance);
    ta.append("\n\nDEPOSIT   -   ");
    ta.append(deposits+ "\tBalance   -   "+balance+"\n");
    return balance;
  }
   public int withdrawal(int drawal)
{
if(balance==0 || drawal>balance)
{
depositandWithdrawLabel1.setText("Insufficient balance"); 
depositandWithdrawTextfield.setText("");
}
else
{
  balance-=drawal;
  amountLabel.setText(balance+""); 
  ta.append("\n\nWITHDRAW     -   ");
  ta.append(drawal+"\tBalance   -   "+balance+"\n");
}
return balance;
}
  public class ImagePanel extends JPanel
{
  Image img;
  ImagePanel(String str)
  {
    try
    {
      img=ImageIO.read(getClass().getResource(str));
    }
    catch(Exception e)
    {
      System.out.println("Exception"+e.getMessage());
    }
  }
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(img,0,0,getWidth(),getHeight(),this);
  }
}
  private void showPanel(String string) {
  card.show(panel,string);
  }
}
public class atm{
    public static void main(String args[])
    {
        new Bank();
    }  
}
