public class Point
{
  private int row;
  private int col;
  
  public Point(int row, int col)
  {
    this.row = row;
    this.col = col;
  }
  
  public int getRow()
  {
    return this.row;
  }
  
  public int getCol()
  {
    return this.col;
  }
  
  public String toString()
  {
    return this.row + " " + this.col;
  }
  
  public boolean equals(Object other)
  {
    if ((null == other) || (!(other instanceof Point))) {
      return false;
    }
    Point p = (Point)other;
    return (this.row == p.row) && (this.col == p.col);
  }
}
