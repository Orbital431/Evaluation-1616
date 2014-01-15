public class Startup extends JFrame
{
    sleepSeconds = 2;
    public Startup()
    {
        setTitle("Evaluation 1616");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 275);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        Thread.sleep(sleepSeconds*1000);
        setVisible(false);
        dispose();
    }
}
