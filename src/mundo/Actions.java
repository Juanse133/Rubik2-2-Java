package mundo;

/**
 *
 * @author giovanni-fajardo
 */
public class Actions 
{
  private int predecessor;
  private String action;
  private Rubik rubik;
  
  public Actions(int predecessor, String action, Rubik rubik)
  { this.predecessor = predecessor;
    this.action = action;
    this.rubik = rubik;
  } 
  
  public void setPredecessor(int predecessor) { this.predecessor = predecessor; }
  public void setAction(String action) { this.action = action; }
  public void setRubik(Rubik rubik) { this.rubik = rubik; }
  
  public int getPredecessor() { return this.predecessor; }
  public String getAction() { return this.action; }  
  public Rubik getRubik() { return rubik; }
  
  
}
