import java.sql.Time;

public class Programlar {
    private String programAdı;
    private String programTipi;
   // private int programID;
    private int kacBolum;
    private String Zaman;

    public String getZaman() {
        return Zaman;
    }

    public void setZaman(String Zaman) {
        this.Zaman = Zaman;
    }

    

    public Programlar(String programAdı, String programTipi, int kacBolum, String Zaman) {
        this.programAdı = programAdı;
        this.programTipi = programTipi;
       // this.programID = programID;
        this.kacBolum = kacBolum;
        this.Zaman=Zaman;
    }

    public String getProgramAdı() {
        return programAdı;
    }

    public void setProgramAdı(String programAdı) {
        this.programAdı = programAdı;
    }

    public String getProgramTipi() {
        return programTipi;
    }

    public void setProgramTipi(String programTipi) {
        this.programTipi = programTipi;
    }

  

    public int getKacBolum() {
        return kacBolum;
    }

    public void setKacBolum(int kacBolum) {
        this.kacBolum = kacBolum;
    }

  
    
   
   

    
    
}
