import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
class dev extends JFrame implements ActionListener
{
  JPanel panel,qpp,qp,rp,pp,gp;
  JLabel label,l2;
  JTextArea ta;
  JButton bnext,bprev,next,b1,b2,description,exits;
  String s[]={ "What is the next number in the sequence :2,6,12,20,...?",
            "Which pattern comes next in the series:X,V,I,S,....?",
            "If a shirt costs $25and is on sale for 20% off,what is the sale price ?",
            "The sum of three consecutive odd numbers is 63.What is smallest of numbers?",
            "Jack is taller than John.John is shorter than Jill. Who is tallest among them ? ",
            "What is the old name of Java?",
            "Which of the following numbers is the odd one out: 3,7,11,14,19,23 ?",
            "How many bytes the 'char' datatype is in java?",
            "How is 'ORANGE' coded according to alphabets?",
            "Who invented java language ?"};
  String options[][]={{"24", "26", "30", "36"},
            {"N", "A", "O", "U"},
            {"$20","$22","$24","$30"},
            {"19","21","23","25"},
            {"Jack", "Jill", "John", "Jack and John"},
            {"oak", "pine", "script", "flask"},
            {"11", "14", "19", "23"},
            {"1","2","4","8"},
            {"15151485","151811475","15145515","14515195"},
            {"Dennis Ritchie","James Gosling","Berners-Lee","Guido Van Rossum"}
};
String des[]={
        "The sequence is increasing by 4,6,8 and so on.so,the next number is 20+16=36",
        "The series is the Roman numerals for 10,5,1 and 1000(X,V,I,S).The next numeral is 10 i.e., O",
        "Sale price=$25-(0.20*$25)\n Sale price=$25-$5=$20",
        "x + (x+2) + (x+4)=63 \n x=19",
        "JILL is taller",
        "OAK is the old name",
        "All other numbers are prime except 14",
        "2 becaue it contains UNICODE",
        "O->15,R->18,A->1,N->14,G->7,E->5",
        "James Gosling invents java"
    };
String correct[]={"36", "O", "$24", "21", "Jill", "oak", "14", "ILSO", "151811475", "James Gosling"};
static String enter[]={null,null,null,null,null,null,null,null,null,null};
JRadioButton j[][];
  ButtonGroup b[];
  Timer t;
  CardLayout card;
  Image img;
  int count=0,optno=0;
  static int marks=0;
  Font f=new Font("arial",Font.BOLD,100);
  Font ff=new Font(Font.DIALOG,Font.BOLD,20);
  dev()
  {
  setVisible(true);
  setTitle("QUIZ APPLICATION");
  setSize(1500,1500);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  panel=new JPanel();
  card=new CardLayout();
  panel.setLayout(card);
  JPanel introPanel=createIntroPanel();
  JPanel instructionPanel=createInstructionsPanel();
  JPanel quizPanel=createQuizPanel();
  JPanel resultPanel=createResultPanel();
  JPanel descriptionPanel=getDescriptionPanel();
  panel.add(introPanel,"Intro");
  panel.add(instructionPanel,"Instruction");
  panel.add(quizPanel,"Quiz");
  panel.add(resultPanel,"Result");
  panel.add(descriptionPanel,"Description");
  showPanel("Intro");
  this.getContentPane().add(panel);
  pack();
  setLocationRelativeTo(null);
  setVisible(true);
  }
 
private JPanel createIntroPanel() {
  JPanel ip=new JPanel();
  ip.setLayout(null);
   ip.setSize(1500,1500);
   ip.setOpaque(true);
   ip.setBackground(new Color(204,204,204));
  JLabel l1=new JLabel("QUIZ");
  JLabel l2=new JLabel("APPLICATION");
  Font fo=new Font(Font.SERIF,Font.BOLD,100);
  Font foo=new Font(Font.SERIF,Font.BOLD,100);
  l1.setFont(fo);
  l2.setFont(foo);
  l1.setBounds(500,50,300,300);
  l2.setBounds(300,200,800,300);
  ip.add(l1);
  ip.add(l2);
   next=new JButton("START");
    next.setOpaque(true);
    next.setEnabled(true);
    next.setBackground(Color.white);
    next.setForeground(new Color(0,0,0));
    next.setBounds(600,490,100,30);
    next.setFont(ff);
    next.addActionListener(e -> showPanel("Instruction"));
    ip.add(next);
    LineBorder l=new LineBorder(Color.black,8);
    ip.setBorder(l);
    return ip;
  }
private JPanel createInstructionsPanel() {
 JPanel p=new JPanel();
  p.setLayout(new BorderLayout());
  p.setSize(1500, 1500);
  p.setOpaque(true);
  p.setBackground(new Color(255,255,255));
 l2=new JLabel("<html><u>   ---Instructions---</u></html>");
 l2.setForeground(new Color(255,51,51));
 l2.setFont(f);
 p.add(l2,BorderLayout.NORTH);
 String s=new String("\n1.Welcome to Quiz application\n\n"+
                      "2.Click the 'START' button to begin\n\n"+
                      "3.Select any option\n\n"+
                      "4.To move the 'NEXT' or 'PREVIOUS' questions click the respective button\n\n"+
                      "5.After clicking the 'SUBMIT' you are redirected to RESULTS page\n\n"+
                      "6.Have a great time using our application!"
                      );
JTextArea ta=new JTextArea(s);
ta.setOpaque(false);
ta.setEditable(false); 
ta.setLineWrap(true);
ta.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
p.add(ta,BorderLayout.CENTER);
b1=new JButton("NEXT");
b2=new JButton("PREVIOUS");
b1.setForeground(new Color(102,51,0));
b2.setForeground(new Color(102,51,0));
b1.addActionListener(e -> showPanel("Quiz"));
b2.addActionListener(e -> showPanel("Intro"));
b1.setFont(ff);
b2.setFont(ff);
JPanel buttonPanel = new JPanel(new GridLayout(1,2));
buttonPanel.add(b2);
b2.setPreferredSize(new Dimension(50,50));
buttonPanel.add(b1);
b1.setPreferredSize(new Dimension(50,50));
p.add(buttonPanel,BorderLayout.SOUTH);
add(p);
return p;
  }
   private JPanel createQuizPanel() {
    qp = new JPanel();
    qp.setLayout(new BorderLayout());
    qp.setOpaque(true);
    qp.setBackground(new Color(0,0,153));
    label = new JLabel("1: " + s[count]);
    label.setFont(new Font("consolas ", Font.BOLD, 35));    
    label.setForeground(Color.white);
    j = new JRadioButton[s.length][4];
    b = new ButtonGroup[s.length];
    for(int i=0;i<s.length;i++)
    {
      b[i]=new ButtonGroup();
      for(int k=0;k<4;k++)
      {
        j[i][k]=new JRadioButton(options[i][k]);
        j[i][k].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 50));
        j[i][k].setOpaque(true);
        j[i][k].setForeground(Color.white);
        j[i][k].setBackground(new Color(0,0,153));
        b[i].add(j[i][k]);
      }
    }
    qpp=new JPanel(new GridLayout(5, 1));
    qpp.setOpaque(false);
    qpp.add(label);
    for(int i=0;i<4;i++)
    {
      qpp.add(j[count][i]);
    }
    
    bnext = new JButton("NEXT");
    bnext.setPreferredSize(new Dimension(50,50));
    bprev = new JButton("PREVIOUS");
    bprev.setPreferredSize(new Dimension(50,50));
    bprev.setSize(50,100);
    bnext.addActionListener(e -> showNextQuestion());
    bprev.addActionListener(e -> showPrevQuestion());
    bprev.setFont(ff);
    bnext.setFont(ff);
    bprev.setForeground(new Color(102,51,0));
    bnext.setForeground(new Color(102,51,0));
    qp.add(qpp, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel(new GridLayout(1,2));
    buttonPanel.add(bprev);
    buttonPanel.add(bnext);
    qp.add(buttonPanel, BorderLayout.SOUTH);
    return qp;
}
private void showNextQuestion() {
    if (count < s.length - 1) {
       for (int i = 0; i < 4; i++) {
            if (j[count][i].isSelected()) {
                enter[count] = options[count][i];
                break;
            }
        }
        count++;
        updateQuestionAndOptions(count);
    }
    if(count == s.length - 1 )
    {
      for (int i = 0; i < 4; i++) {
            if (j[count][i].isSelected()) {
                enter[count] = options[count][i];
                break;
            }
          }
      bnext.setText("SUBMIT");
      bnext.setEnabled(true);
      bnext.addActionListener(e->showPanel("Result")); 
      showResult();
       
    }
    bprev.setEnabled(true);
}
private void showPrevQuestion() {
    if (count > 0) {
       for (int i = 0; i < 4; i++) {
            if (j[count][i].isSelected()) {
                enter[count] = options[count][i];
                break;
            }
        }
        count--;
        updateQuestionAndOptions(count);
        bnext.setEnabled(true);
        
    }
    if (count == 0) {
        bprev.setEnabled(false);
    }
}
private void updateQuestionAndOptions(int count) {
    label.setText((count + 1) + ": " + s[count]);
    b[count].clearSelection();
    qpp.removeAll();
    qpp.add(label);
    for (int i = 0; i < 4; i++) {
        j[count][i].setText(options[count][i]);
        b[count].add(j[count][i]);
        qpp.add(j[count][i]);
    }
    for(int i=0;i<4;i++)
    {
     if (enter[count] != null && enter[count].equals(options[count][i])) {
            j[count][i].setSelected(true);
        }
     }
    qpp.revalidate(); 
    qpp.repaint();   
}
private void  showResult()
{
  int userMarks=calculateMarks();
  JLabel l=(JLabel)pp.getComponent(0);
  l.setText("Your marks: "+userMarks+" out of "+s.length);
}
private int calculateMarks() {
    marks = 0;
    for (int i = 0; i < s.length; i++) {
        if (enter[i] != null && enter[i].equals(correct[i])) {
            marks++;
        }
    }
    return marks;
  
}
    private JPanel createResultPanel() {
    pp = new JPanel();
    pp.setLayout(new BorderLayout());
    pp.setOpaque(true); // Set pp panel to be opaque
    pp.setBackground(new Color(255,255,255)); // Set background color for pp panel
    JLabel resultLabel = new JLabel("Your Score: ");
    resultLabel.setFont(new Font("consolas", Font.BOLD, 60));
    resultLabel.setForeground(new Color(0,204,0));
    resultLabel.setHorizontalAlignment(JLabel.CENTER);
    pp.add(resultLabel, BorderLayout.CENTER);
    description = new JButton("EXPLANATION");
    description.addActionListener(e -> showPanel("Description"));
    exits = new JButton("EXIT");
    exits.addActionListener(e -> System.exit(0));
    description.setPreferredSize(new Dimension(50, 50));
    exits.setPreferredSize(new Dimension(50, 50));
    description.setFont(ff);
    exits.setFont(ff);
    exits.setForeground(new Color(102, 51, 0));
    description.setForeground(new Color(102, 51, 0));
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
    buttonPanel.add(description);
    buttonPanel.add(exits);
    pp.add(buttonPanel, BorderLayout.SOUTH);
    add(pp); // Add pp directly to the frame

    return pp;
}
    
private JPanel getDescriptionPanel()
    {
        gp=new JPanel();
        gp.setLayout(new BorderLayout());
        gp.setOpaque(true);
        ta=new JTextArea(50,1);
        ta.setEditable(false);
        ta.setLineWrap(true);
        JScrollPane ss=new JScrollPane(ta);
        gp.add(ss,BorderLayout.CENTER);
        ta.setBackground(new Color(255,255,204));
        ta.setFont(new Font("arial",Font.BOLD,20));
        for(int i=0;i<10;i++)
        {
          ta.append((i+1)+". "+s[i]+"\n");
          ta.append("Correct Answer : "+correct[i]+"\n");
          ta.append("EXPLANATION : "+des[i]+"\n\n\n");
        }
        gp.add(ss,BorderLayout.CENTER);
        JButton b=new JButton("EXIT");
        b.setPreferredSize(new Dimension(50,50));
        b.setForeground(new Color(102,51,0));
        b.setFont(ff);
        b.addActionListener(e->System.exit(0));
        gp.add(b,BorderLayout.SOUTH);
        return gp;
    }
private void showPanel(String string) {
  card.show(panel,string);
  }
public void actionPerformed(ActionEvent e) {
  
}
}
public class quizApplication{
    public static void main(String args[])
  {
    new dev();
  }
}
