import java.util.Objects;

public class Star extends CelestialObject{
    private double magnitude;

    public Star(){
       super(); 
        this.magnitude = 0.0;
    }
      public Star(String name, double x, double y, double z, double magnitude,int mass) {
        super(name, x, y, z,mass); 
        this.magnitude = magnitude;
    }
    public double getMagnitude(){
        return magnitude;
    }
    public void setMagnitude(double newmag){
      this.magnitude=newmag;
    }
  @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;

        Star other = (Star) obj;
        
        return Double.compare(other.magnitude, magnitude) == 0 &&
               super.equals(other);
    }
     @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }
}