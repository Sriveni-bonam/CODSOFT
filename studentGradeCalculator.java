import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
class result extends JFrame implements ActionListener
{
    static int sum=0,intc,intpython,intjava,val;
    float per=0.0f;
    Font f,f1,f2;
    JPanel panel,panel2;
    JLabel label1,label2,label3;
    JLabel lc,ljava,lpython;
    JLabel total,percentage,grade;
    JTextField jtotal,jpercentage,jgrade;
    JTextField tc,tjava,tpython;
    JButton marks,percent,grades,result,clear;
    result()
    {
      panel=new JPanel();
      label1=new JLabel("STUDENT  RESULT");
      label1.setBounds(500,50,300,30);
      label1.setForeground(Color.black);
      f=new Font(Font.SANS_SERIF,Font.BOLD,30);
      JPanel panel2=new JPanel();
      panel2.setLayout(null);
      panel2.setBounds(300,120,700,500);
      panel2.setBackground(Color.white);
      LineBorder l=new LineBorder(new Color(0,0,0),4);
      panel2.setBorder(l);
      label1.setFont(f);
      panel.add(label1);
      label3=new JLabel("------------------------");
      label3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,30));
      label3.setBounds(500,80,350,25);
      label3.setForeground(Color.black);
      panel.add(label3);
      this.setTitle("RESULTS");
      this.setSize(1500,1500);
      panel.setBackground(new Color(204,204,204));
      panel.setLayout(null);
      panel.setBounds(0,0,1500,1500);
      f1=new Font(Font.SERIF,Font.BOLD,20);
      f2=new Font("consolas",Font.CENTER_BASELINE,20);
      Font f3=new Font(Font.DIALOG,Font.BOLD,13);
      lc=new JLabel("C  LANG");
      lc.setForeground(Color.black);
      lc.setFont(f1);
      lc.setBounds(25,25,100,30);
      panel2.add(lc);
      tc=new JTextField();
      tc.setForeground(new Color(153,0,0));
      tc.setFont(f2);
      tc.setToolTipText("MARKS BETWEEN 0-100");
      tc.setBounds(120,25,100,30);
      panel2.add(tc);
      ljava=new JLabel("JAVA");
      ljava.setForeground(Color.black);
      ljava.setFont(f1);
      ljava.setBounds(260,25,100,30);
      panel2.add(ljava);
      tjava=new JTextField();
      tjava.setForeground(new Color(153,0,0));
      tjava.setFont(f2);
      tjava.setToolTipText("MARKS BETWEEN 0-100");
      tjava.setBounds(330,25,100,30);
      panel2.add(tjava);
      lpython=new JLabel("PYTHON");
      lpython.setForeground(Color.black);
      lpython.setFont(f1);
      lpython.setBounds(470,25,100,30);
      panel2.add(lpython);
      tpython=new JTextField();
      tpython.setForeground(new Color(153,0,0));
      tpython.setFont(f2);
      tpython.setToolTipText("MARKS BETWEEN 0-100");
      tpython.setBounds(570,25,100,30);
      panel2.add(tpython);
      total=new JLabel("TOTAL");
      total.setForeground(Color.black);
      total.setFont(f1);
      total.setBounds(200,130,120,30);
      panel2.add(total);
      jtotal=new JTextField();
      jtotal.setForeground(new Color(153,0,0));
      jtotal.setFont(f2);
      jtotal.setToolTipText("OUT OF 300");
      jtotal.setBounds(300,130,100,30);
      panel2.add(jtotal);
      percentage=new JLabel("PERCENTAGE");
      percentage.setForeground(Color.black);
      percentage.setFont(f1);
      percentage.setBounds(140,220,150,30);
      panel2.add(percentage);
      jpercentage=new JTextField();
      jpercentage.setForeground(new Color(153,0,0));
      jpercentage.setFont(f2);
      jpercentage.setToolTipText("OUT OF 100%");
      jpercentage.setBounds(300,220,100,30);
      panel2.add(jpercentage);
      grade=new JLabel("GRADE");
      grade.setForeground(Color.black);
      grade.setFont(f1);
      grade.setBounds(180,310,120,30);
      panel2.add(grade);
      jgrade=new JTextField();
      jgrade.setForeground(new Color(153,0,0));
      jgrade.setFont(f2);
      jgrade.setToolTipText("FROM A+ TO F");
      jgrade.setBounds(300,310,100,30);
      panel2.add(jgrade);
      marks=new JButton("MARKS");
      marks.setForeground(Color.black);
      marks.setToolTipText("ONLY GIVES MARKS");
      marks.setBounds(30,410,100,30);
      marks.setFont(f3);
      marks.setForeground(new Color(102,51,0));
      panel2.add(marks);
      marks.addActionListener(this);
      percent=new JButton("PERCENT");
      percent.setForeground(Color.black);
      percent.setToolTipText("ONLY GIVES PERCENTAGE");
      percent.setBounds(160,410,100,30);
      percent.setFont(f3);
      percent.setForeground(new Color(102,51,0));
      panel2.add(percent);
      percent.addActionListener(this);
      grades=new JButton("GRADE");
      grades.setForeground(Color.black);
      grades.setToolTipText("ONLY GIVES GRADES");
      grades.setBounds(290,410,100,30);
      grades.setFont(f3);
      grades.setForeground(new Color(102,51,0));
      panel2.add(grades);
      grades.addActionListener(this);
      result=new JButton("RESULT");
      result.setForeground(Color.black);
      result.setToolTipText("GIVES MARKS,PERCENTAGE AND GRADE");
      result.setBounds(430,410,100,30);
      result.setFont(f3);
      result.setForeground(new Color(102,51,0));
      panel2.add(result);
      result.addActionListener(this);
      clear=new JButton("CLEAR");
      clear.setForeground(Color.black);
      clear.setToolTipText("CLEAR ALL");
      clear.setBounds(570,410,100,30);
      clear.setFont(f3);
      clear.setForeground(new Color(102,51,0));
      panel2.add(clear);
      clear.addActionListener(this);
      label2=new JLabel("");
      label2.setBounds(300,410,500,30);
      panel2.add(label2);
      panel.add(panel2);
      this.add(panel);
      this.setVisible(true); 
    }
    public void actionPerformed(ActionEvent e)
    {
       intc=Integer.parseInt(tc.getText());
       intpython=Integer.parseInt(tpython.getText());
       intjava=Integer.parseInt(tjava.getText());
       if((intc>=0 && intc<=100) && (intpython>=0 && intpython<=100) && (intjava>=0 && intjava<=100))
       {
         sum=intc+intjava+intpython;
         per=sum/3;
         val=(int)per;
       if(e.getSource()==result)
       {
         jtotal.setText(Integer.toString(sum));
         jpercentage.setText(Float.toString(per));
         jgrade.setText(gradecalc());
         display();
       }
       if(e.getSource()==clear)
       {
        tc.setText("");
        tjava.setText("");
        tpython.setText("");
        jtotal.setText("");
        jpercentage.setText("");
        jgrade.setText("");
        display();
       }
       if(e.getSource()==marks)
       {
        jpercentage.setText("");
        jgrade.setText("");
         percentage.setEnabled(false);
         grade.setEnabled(false);
         jpercentage.setEnabled(false);
         jgrade.setEnabled(false);
         jtotal.setText(Integer.toString(sum));  
         jtotal.setEnabled(true);
         total.setEnabled(true);      
       }
       if(e.getSource()==percent)
       {
        jtotal.setText("");
        jgrade.setText("");
        total.setEnabled(false);
        jtotal.setEnabled(false);
        jgrade.setEnabled(false);
        grade.setEnabled(false);
        jpercentage.setText(Float.toString(per));
        percentage.setEnabled(true);
        jpercentage.setEnabled(true);
       }
       if(e.getSource()==grades)
       {
        jtotal.setText("");
        jpercentage.setText("");
        total.setEnabled(false);
        jtotal.setEnabled(false);
        percentage.setEnabled(false);
        jpercentage.setEnabled(false);
        jgrade.setText(gradecalc());
        grade.setEnabled(true);
        jgrade.setEnabled(true);
       }
      }
      else if(tc.getText()==null || tjava.getText()==null || tpython.getText()==null)
      {
        label2.setText("HEY MARKS FIELD ARE EMPTY");
        label2.setFont(f);
      }
      else
      {
        label2.setText("Your marks does not between 0 and 100");
        label2.setFont(f);
         if(e.getSource()==clear)
       {
        tc.setText("");
        tjava.setText("");
        tpython.setText("");
        label2.setText("");
       }
      }
    } public void display()
    {
         percentage.setEnabled(true);
         grade.setEnabled(true);
         total.setEnabled(true);
        jtotal.setEnabled(true);
         jpercentage.setEnabled(true);
         jgrade.setEnabled(true);
    }
    public String gradecalc()
    {
        if(val>90 && val<=100)
         {
           return "A+";
         }
         else if(val>80 && val<=90)
         {
           return "A";
         }
         else if(val>70 && val<=80)
         {
           return "B";
         }
         else if(val>60 && val<=70)
         {
           return "C";
         }
         else if(val>50 && val<=60)
         {
           return "D";
         }
         else if(val>40 && val<=50)
         {
           return "E";
         }
         else 
         {
          return "F";
         }
    }
}
public class studentGradeCalculator {
    public static void main(String args[])
    {
    new result();
    }
}